package com.klopaj
/**
 * The Favorite entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Favorite {
    static mapping = {
         table 'pe_favorite'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'FAVORITE_ID'
         userIdRjUser column:'USER_ID'
         poiDataIdPePoiData column:'POI_DATA_ID'
    }
    Date datetime
    Integer version
    // Relation
    User userIdRjUser
    // Relation
    Poi poiDataIdPePoiData

    static constraints = {
        datetime()
        version(max: 2147483647)
        userIdRjUser()
        poiDataIdPePoiData()
    }
    String toString() {
        return "${id}"
    }
}
