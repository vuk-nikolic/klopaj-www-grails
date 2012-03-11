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
         valuePeVoteValue column:'VALUE'
         userIdRjUser column:'USER_ID'
         commentIdPeComment column:'COMMENT_ID'
    }
    Integer version
    // Relation
    VoteValue valuePeVoteValue
    // Relation
    User userIdRjUser
    // Relation
    Comment commentIdPeComment

    static constraints = {
        version(max: 2147483647)
        valuePeVoteValue()
        userIdRjUser()
        commentIdPeComment()
    }
    String toString() {
        return "${id}"
    }
}
