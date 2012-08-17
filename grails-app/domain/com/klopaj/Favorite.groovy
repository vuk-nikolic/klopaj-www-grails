package com.klopaj
/**
 * The Favorite entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class Favorite {
    static mapping = {
        table 'pe_favorite'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id generator: 'identity', column: 'FAVORITE_ID'
        user column: 'USER_ID'
        poi column: 'POI_DATA_ID'
        client column: 'client_id'
    }
    Date datetime
    Integer version
    // Relation
    User user
    // Relation
    Poi poi
    // Relation
    Client client

    static constraints = {
        datetime()
        version(max: 2147483647)
        user()
        poi()
        client()
    }

    String toString() {
        return "${id}"
    }
}
