/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.services.sql

import com.klopaj.Client
import com.klopaj.Comment
import com.klopaj.Favorite
import com.klopaj.Photo
import com.klopaj.Poi
import com.klopaj.Tag
import com.klopaj.User
import com.klopaj.UserContent
import com.klopaj.Vote
import com.klopaj.VoteValue
import com.klopaj.services.PoiServiceInterface

class PoiService implements PoiServiceInterface {
    static transactional = true
    def springSecurityService
    Integer PAGE_SIZE = 8

    User getCurrentUser() {
        return springSecurityService.currentUser as User
    }

    Poi getById(int id) {
        return Poi.findById(id)
    }

    boolean addPoi(Poi poi) {
        // TODO: Folder for this poi should be added in "db" directory, where all XML where, and where all photos are stored
        return poi.save() != null
    }

    boolean updatePoi(Poi poi) {
        return poi.save() != null
    }

    Vote vote(int poiId, int clientId, int value) {
        Poi poi = Poi.findById(poiId)

        Vote vote = findOrCreateVote(poiId, getCurrentUser())
        vote.client = Client.findById(clientId)

        VoteValue voteValue = VoteValue.findByVoteValueId((byte) value)
        vote.voteValue = voteValue

        poi.addToVotes(vote)
        poi.save()
        if (!vote.save(flush: true)) {
            println vote.errors
        }
        return vote
    }

    List<Vote> getVotes(Poi poi, int page) {
        // TODO: Maybe we should add paging here
        return poi.getVotes()
    }

    List<Vote> getVotes(int poiId, int page) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi.getVotes()
    }

    /**
     * Calculates all votes.
     */
    public int calcVotes(int poiId, boolean positive) {
        int voteValueId = positive ? 1 : -1;
        Poi poi = Poi.findById(poiId);
        VoteValue voteValue = VoteValue.findByVoteValueId(voteValueId.byteValue());
        def count = Vote.countByVoteValueAndPoi(voteValue, poi);
        return count.intValue();
    }

    Vote findOrCreateVote(int poiId, User user) {
        Poi poi = Poi.findById(poiId)
        Vote vote = (Vote) Vote.findByPoiAndUser(poi, user);
        if (vote == null) {
            vote = new Vote([poi:poi, user:user, datetime: new Date()]);
        }
        return vote;
    }

    Favorite follow(Poi poi, Client client) {
        Favorite favorite = new Favorite()

        favorite.poi = poi
        favorite.client = client
        favorite.user = getCurrentUser()

        return favorite.save()
    }

    Favorite follow(int poiId, int clientId) {
        Favorite favorite = new Favorite()

        favorite.poi = Poi.findById(poiId)
        favorite.client = Client.findById(clientId)
        favorite.user = getCurrentUser()

        return favorite.save()
    }

    Favorite unfollow(Poi p, Client c) {
        // TODO: Check if syntax is ok
        Favorite favorite = Favorite.findAll(poi == p && user == getCurrentUser()).first()
        return favorite.delete()
    }

    Favorite unfollow(int poiId, int clientId) {
        // TODO: Check if syntax is ok
        Favorite favorite = Favorite.findAll(poi.id == p && user == getCurrentUser()).first()
        return favorite.delete()
    }

    List<Comment> getComments(Poi poi, int page) {
        // TODO: Maybe we should add paging here
        return poi.getComments()
    }

    List<Comment> getComments(int poiId, int page) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi?.getComments()
    }

    List<Favorite> getFavorites(Poi poi, int page) {
        // TODO: Maybe we should add paging here
        return poi.getFavorites()
    }

    List<Favorite> getFavorites(int poiId, int page) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi.getFavorites()
    }

    Comment addComment(Poi poi, String text, Client client) {
        Comment comment = new Comment()
        comment.poi = poi
        comment.text = text
        comment.client = client
        comment.user = getCurrentUser()

        return comment
    }

    Comment addComment(int poiId, String text, int clientId) {
        Comment comment = new Comment()
        comment.poi = Poi.findById(poiId)
        comment.text = text
        comment.client = Client.findById(clientId)
        comment.user = getCurrentUser()

        return comment
    }

    def upload() {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    List<Photo> getPhotos(Poi poi, int page) {
        // TODO: Maybe we should add paging here
        return poi.getPhotos()
    }

    List<Photo> getPhotos(int poiId, int page) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi.getPhotos()
    }

    def getLatestActivities(int page) {
        return UserContent.list(offset: calculateOffset(page), max: PAGE_SIZE)
    }

    def getLatestPoiActivities(Poi poi, int page) {
        return UserContent.findAllByPoiId(poi.getId().intValue(), [offset: calculateOffset(page), max: PAGE_SIZE]);
    }

    /**
     * Returns most commented pois.
     */
    def getMostCommentedPois(int count) {
        return Poi.executeQuery("select comm.poi, count(comm.user) from Comment comm group by comm.poi order by count(comm.user) desc")
    }


    def getHighestRatedPois(int page) {
        return Poi.executeQuery("select v.poi, count(*) from Vote v where v.voteValue.voteValueId=1 group by v.poi.id order by count(*) desc")
    }

    def getSimilarPoiList(Poi poi, int page) {
        // TODO: Implement :)
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    def getFeaturedPoiList() {
        List<Tag> tags = Tag.executeQuery("from Tag order by rand()", [max: Tag.count()])
        Tag tag = tags.first();
        Set poiSet = tag.getPois()

        return tag.getPois().asList().subList(0, poiSet.size() > PAGE_SIZE ? PAGE_SIZE : poiSet.size())  //To change body of implemented methods use File | Settings | File Templates.
    }

    def getFeaturedPoiListForPoi(Poi poi) {
        // TODO: Implement :)
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }
// ---- Private methods:
    private int calculateOffset(int page) {
        page * PAGE_SIZE
    }
}
