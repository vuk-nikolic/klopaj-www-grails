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
         user column:'USER_ID'
         poi column:'POI_DATA_ID'
    }
    String text
    Integer vote
    Date datetime
    Integer version
    // Relation
    User user
    // Relation
    Poi poi

    static constraints = {
        text(size: 1..2000, blank: false)
        vote(max: 2147483647)
        datetime()
        version(max: 2147483647)
        user()
        poi()
    }
    String toString() {
        return "${id}"
    }
}
