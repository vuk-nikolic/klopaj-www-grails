/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.services.sql

import com.klopaj.services.PoiService
import com.klopaj.Poi
import com.klopaj.Vote
import com.klopaj.Client
import com.klopaj.Favorite
import com.klopaj.Comment
import com.klopaj.Photo
import com.klopaj.VoteValue
import com.klopaj.User
import com.klopaj.UserContent

class SqlPoiService implements PoiService {
    def springSecurityService
    Integer PAGE_SIZE = 8

    User getCurrentUser() {
        return User.get(springSecurityService.principal.id)
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

    Vote voteUp(Poi poi, Client client) {
        Vote vote = new Vote()
        vote.poi = poi
        vote.client = client
        vote.user = getCurrentUser()

        VoteValue voteValue = VoteValue.findByVoteValueId((byte) 1)
        vote.voteValue = voteValue

        return vote.save()
    }

    Vote voteUp(int poiId, int clientId) {
        Vote vote = new Vote()
        vote.poi = Poi.findById(poiId)
        vote.client = Client.findById(clientId)
        vote.user = getCurrentUser()

        VoteValue voteValue = VoteValue.findByVoteValueId((byte) 1)
        vote.voteValue = voteValue

        return vote.save()
    }

    Vote voteDown(Poi poi, Client client) {
        Vote vote = new Vote()
        vote.poi = poi
        vote.client = client
        vote.user = getCurrentUser()

        VoteValue voteValue = VoteValue.findByVoteValueId((byte) -1)
        vote.voteValue = voteValue

        return vote.save()
    }

    Vote voteDown(int poiId, int clientId) {
        Vote vote = new Vote()
        vote.poi = Poi.findById(poiId)
        vote.client = Client.findById(clientId)
        vote.user = getCurrentUser()

        VoteValue voteValue = VoteValue.findByVoteValueId((byte) -1)
        vote.voteValue = voteValue

        return vote.save()
    }

    List<Vote> getVotes(Poi poi) {
        // TODO: Maybe we should add paging here
        return poi.getVotes()
    }

    List<Vote> getVotes(int poiId) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi.getVotes()
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

    List<Comment> getComments(Poi poi) {
        // TODO: Maybe we should add paging here
        return poi.getComments()
    }

    List<Comment> getComments(int poiId) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi?.getComments()
    }

    List<Favorite> getFavorites(Poi poi) {
        // TODO: Maybe we should add paging here
        return poi.getFavorites()
    }

    List<Favorite> getFavorites(int poiId) {
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

    List<Photo> getPhotos(Poi poi) {
        // TODO: Maybe we should add paging here
        return poi.getPhotos()
    }

    List<Photo> getPhotos(int poiId) {
        // TODO: Maybe we should add paging here
        Poi poi = Poi.findById(poiId)
        return poi.getPhotos()
    }

    def getLatestActivities(int page) {
        def offset = page * PAGE_SIZE
        return UserContent.list(offset: offset, max: PAGE_SIZE)
    }

    def getLatestPoiActivities(Poi poi, int page) {
        def offset = page * PAGE_SIZE
        return UserContent.findAll(poi.getId().toString(), [offset: offset, max: PAGE_SIZE]);
//        .list(offset: offset, max: PAGE_SIZE)
    }
}
