package com.klopaj
/**
 * The Comment entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Comment {
    static mapping = {
         table 'pe_comment'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'COMMENT_ID'
         userIdRjUser column:'USER_ID'
         poiDataIdPePoiData column:'POI_DATA_ID'
    }
    String text
    Integer vote
    Date datetime
    Integer version
    // Relation
    User userIdRjUser
    // Relation
    Poi poiDataIdPePoiData

    static constraints = {
        text(size: 1..2000, blank: false)
        vote(max: 2147483647)
        datetime()
        version(max: 2147483647)
        userIdRjUser()
        poiDataIdPePoiData()
    }
    String toString() {
        return "${id}"
    }
}
