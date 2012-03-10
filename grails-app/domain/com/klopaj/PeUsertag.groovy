package com.klopaj
/**
 * The PeUsertag entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class PeUsertag {
    static mapping = {
         table 'pe_usertag'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'USERTAG_ID'
         userIdRjUser column:'USER_ID'
         poiDataIdPePoiData column:'POI_DATA_ID'
         tagIdPeTag column:'TAG_ID'
    }
    Integer approved
    Date datetime
    Integer version
    // Relation
    User userIdRjUser
    // Relation
    Poi poiDataIdPePoiData
    // Relation
    Tag tagIdPeTag

    static constraints = {
        approved(max: 2147483647)
        datetime()
        version(max: 2147483647)
        userIdRjUser()
        poiDataIdPePoiData()
        tagIdPeTag()
    }
    String toString() {
        return "${id}"
    }
}
