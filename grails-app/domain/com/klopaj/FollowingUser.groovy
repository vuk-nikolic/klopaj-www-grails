package com.klopaj
/**
 * The FollowingUser entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class FollowingUser {
    static mapping = {
         table 'pe_following_user'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'FOLLOWING_USER_ID'
         userIdRjUser column:'USER_ID'
         followedUserIdRjUser column:'FOLLOWED_USER_ID'
    }
    Date datetime
    Integer version
    // Relation
    User userIdRjUser
    // Relation
    User followedUserIdRjUser

    static constraints = {
        datetime()
        version(max: 2147483647)
        userIdRjUser()
        followedUserIdRjUser()
    }
    String toString() {
        return "${id}"
    }
}
