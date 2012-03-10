package com.klopaj
/**
 * The PeVote entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class PeVote {
    static mapping = {
         table 'pe_vote'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'VOTE_ID'
         userIdRjUser column:'USER_ID'
         poiDataIdPePoiData column:'POI_DATA_ID'
         valuePeVoteValue column:'VALUE'
    }
    Date datetime
    Integer version
    // Relation
    User userIdRjUser
    // Relation
    Poi poiDataIdPePoiData
    // Relation
    PeVoteValue valuePeVoteValue

    static constraints = {
        datetime()
        version(max: 2147483647)
        userIdRjUser()
        poiDataIdPePoiData()
        valuePeVoteValue()
    }
    String toString() {
        return "${id}"
    }
}
