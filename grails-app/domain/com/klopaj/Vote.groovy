package com.klopaj
/**
 * The Vote entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class Vote {

    static mapping = {
        table 'pe_vote'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id generator: 'identity', column: 'VOTE_ID'
        user column: 'USER_ID'
        poi column: 'POI_DATA_ID'
        client column: 'client_id'
        voteValue column: 'VALUE'
    }
    Date datetime
    Integer version
    // Relation
    User user
    // Relation
    Poi poi
    // Relation
    Client client
    // Relation
    VoteValue voteValue

    static constraints = {
        datetime()
        version(max: 2147483647)
        user()
        poi()
        client()
        voteValue()
    }

    String toString() {
        return "${id}"
    }
}
