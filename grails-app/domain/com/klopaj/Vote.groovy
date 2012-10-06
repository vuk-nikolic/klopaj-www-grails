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
        version true
        id generator: 'identity', column: 'VOTE_ID'
        user column: 'USER_ID'
        poi column: 'POI_DATA_ID'
        client column: 'client_id'
        voteValue column: 'VALUE'
    }
    Date datetime
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
        user()
        poi()
        client()
        voteValue()
    }

    String toString() {
        return "${id}"
    }
}
