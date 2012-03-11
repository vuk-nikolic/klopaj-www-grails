package com.klopaj
/**
 * The Usertag entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Usertag {
    static mapping = {
         table 'pe_usertag'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'USERTAG_ID'
         user column:'USER_ID'
         poi column:'POI_DATA_ID'
         tag column:'TAG_ID'
    }
    Integer approved
    Date datetime
    Integer version
    // Relation
    User user
    // Relation
    Poi poi
    // Relation
    Tag tag

    static constraints = {
        approved(max: 2147483647)
        datetime()
        version(max: 2147483647)
        user()
        poi()
        tag()
    }
    String toString() {
        return "${id}"
    }
}
