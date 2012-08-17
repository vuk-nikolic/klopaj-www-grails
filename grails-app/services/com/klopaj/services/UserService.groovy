package com.klopaj.services

import com.klopaj.Favorite
import com.klopaj.User
import com.klopaj.Vote

interface UserService {

    User getById(int userId)
    User getByUsername(String username)
    User getByEmail(String email)

    List<Favorite> getFavorites(User user)
    List<Favorite> getFavorites(int userId)

    List<Vote> getVotesUp(User user)
    List<Vote> getVotesUp(int userId)
    List<Vote> getVotesDown(User user)
    List<Vote> getVotesDown(int userId)

    List<User> getFollowing(User user)
    List<User> getFollowing(int userId)

    List<User> getFollowedBy(User user)
    List<User> getFollowedBy(int userId)

    User followUser(User userToFollow)
    User followUser(int userToFollowId)

    User unfollowUser(User userToFollow)
    User unfollowUser(int userToFollowId)

     // ------- Activities
    // TODO: This should be defined, because there are different approaches for "mongo" and "sql" implementations

}
