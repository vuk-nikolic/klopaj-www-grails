package com.klopaj
/**
 * The CommentVote entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class CommentVote {
    static mapping = {
         table 'pe_comment_vote'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'COMMENT_VOTE_ID'
         voteValue column:'VALUE'
         user column:'USER_ID'
         comment column:'COMMENT_ID'
    }
    Integer version
    // Relation
    VoteValue voteValue
    // Relation
    User user
    // Relation
    Comment comment

    static constraints = {
        version(max: 2147483647)
        voteValue()
        user()
        comment()
    }
    String toString() {
        return "${id}"
    }
}
