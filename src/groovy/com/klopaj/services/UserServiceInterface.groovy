package com.klopaj.services

import com.klopaj.Favorite
import com.klopaj.User
import com.klopaj.Vote
import com.klopaj.FollowingUser

interface UserServiceInterface {

    User getById(int userId)
    User getByUsername(String username)
    User getByEmail(String email)

    List<Favorite> getFavorites(User user)
    List<Favorite> getFavorites(int userId)

    List<Vote> getVotesUp(User user)
    List<Vote> getVotesUp(int userId)
    List<Vote> getVotesDown(User user)
    List<Vote> getVotesDown(int userId)

    List<FollowingUser> getFollowing(User user)
    List<FollowingUser> getFollowing(int userId)

    List<FollowingUser> getFollowedBy(User user)
    List<FollowingUser> getFollowedBy(int userId)

    FollowingUser followUser(User userToFollow)
    FollowingUser followUser(int userToFollowId)

    FollowingUser unfollowUser(User userToFollow)
    FollowingUser unfollowUser(int userToFollowId)

     // ------- Activities
    // TODO: This should be defined, because there are different approaches for "mongo" and "sql" implementations

}
