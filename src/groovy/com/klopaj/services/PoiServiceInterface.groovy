package com.klopaj.services

import com.klopaj.*

interface PoiServiceInterface {

    // ---- Poi CRUD (without D :))
    Poi getById(int id)

    boolean addPoi(Poi poi)

    boolean updatePoi(Poi poi)

    // ----- Vote up/down
    Vote voteUp(Poi poi, Client client)

    Vote voteUp(int poiId, int clientId)

    Vote voteDown(Poi poi, Client client)

    Vote voteDown(int poiId, int clientId)

    List<Vote> getVotes(Poi poi, int page)

    List<Vote> getVotes(int poiId, int page)

    // ----- Follow/unfollow poi
    Favorite follow(Poi poi, Client client)

    Favorite follow(int poiId, int clientId)

    Favorite unfollow(Poi poi, Client client)

    Favorite unfollow(int poiId, int clientId)

    List<Favorite> getFavorites(Poi poi, int page)

    List<Favorite> getFavorites(int poiId, int page)

    // ------ Comment related (CRUD)
    List<Comment> getComments(Poi poi, int page);

    List<Comment> getComments(int poiId, int page);

    Comment addComment(Poi poi, String text, Client client)

    Comment addComment(int poiId, String text, int clientId)

    // ------ Photo and upload related
    def upload() // TODO: We should see how is this implemented in grails :)
    List<Photo> getPhotos(Poi poi, int page)

    List<Photo> getPhotos(int poiId, int page)

    // ------- Activities
    // TODO: This should be defined, because there are different approaches for "mongo" and "sql" implementations

    /**
     * Returns activities on "global" level, so for every poi, user etc
     * @param page number of the page is requested
     * @return
     */
    def getLatestActivities(int page)

    /**
     * Returns latest activities for selected poi, and page
     * @param poi
     * @param page
     * @return
     */
    def getLatestPoiActivities(Poi poi, int page)

    /**
     * Returns a list of highest rated pois (mostly used in the side bar)
     * @return
     */
    def getHighestRatedPois(int page)

    /**
     * Returns the most similar pois for the specified poi
     * @param poi
     * @param page
     * @return
     */
    def getSimilarPoiList(Poi poi, int page)

    /**
     * Returns most commented pois
     * @param page
     * @return
     */
    def getMostCommentedPois(int page)

    /**
     * Returns list of "featured" pois. Depends on algorithm, or it's hand picked
     * @return
     */
    def getFeaturedPoiList()

    /**
     * Returns featured pois for provided poi. It could depend on provided poi's tags, comments or some other property.<br />
     * Probably we can have several implementations of this
     * @param poi
     * @return
     */
    def getFeaturedPoiListForPoi(Poi poi)

}
