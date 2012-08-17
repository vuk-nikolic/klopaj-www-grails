package com.klopaj.services

import com.klopaj.*

interface PoiService {

    // ---- Poi CRUD (without D :))
    Poi getById(int id)
    boolean addPoi(Poi poi)
    boolean updatePoi(Poi poi)

    // ----- Vote up/down
    Vote voteUp(Poi poi, Client client)
    Vote voteUp(int poiId, int clientId)

    Vote voteDown(Poi poi, Client client)
    Vote voteDown(int poiId, int clientId)

    // ----- Follow/unfollow poi
    Favorite follow(Poi poi, Client client)
    Favorite follow(int poiId, int clientId)

    Favorite unfollow(Poi poi, Client client)
    Favorite unfollow(int poiId, int clientId)

    // ------ Comment related (CRUD)
    List<Comment> getComments(Poi poi);
    List<Comment> getComments(int poiId);

    Comment addComment(Poi poi, String text, Client client)
    Comment addComment(int poiId, String text, int clientId)


    // ------ Photo and upload related
    def upload() // TODO: We should see how is this implemented in grails :)
    List<Photo> getPhotos(Poi poi)
    List<Photo> getPhotos(int poiId)

    // ------- Activities
    // TODO: This should be defined, because there are different approaches for "mongo" and "sql" implementations
}
