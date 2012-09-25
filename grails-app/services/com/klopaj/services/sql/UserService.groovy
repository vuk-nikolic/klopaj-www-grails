/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.services.sql

import com.klopaj.services.UserServiceInterface
import com.klopaj.User
import com.klopaj.Favorite
import com.klopaj.Vote
import com.klopaj.FollowingUser

class UserService implements UserServiceInterface {
    def springSecurityService

    User getCurrentUser() {
        return User.get(springSecurityService.principal.id)
    }


    User getById(int userId) {
        return User.findById(userId)
    }

    User getByUsername(String username) {
        return User.findByUsername(username)
    }

    User getByEmail(String email) {
        return User.findByEmail(email)
    }

    List<Favorite> getFavorites(User user) {
        // TODO: Maybe we should add paging here
        return user.getFavorites()
    }

    List<Favorite> getFavorites(int userId) {
        // TODO: Maybe we should add paging here
        User user = User.findById(userId)
        return user.getFavorites()
    }

    List<Vote> getVotesUp(User u) {
        // TODO: Maybe we should add paging here
        return Vote.findAll(user == u && voteValue.voteValueId == 1)
    }

    List<Vote> getVotesUp(int userId) {
        // TODO: Maybe we should add paging here
        return Vote.findAll(user.id == userId && voteValue.voteValueId == 1)
    }

    List<Vote> getVotesDown(User user) {
        // TODO: Maybe we should add paging here
        return Vote.findAll(user == u && voteValue.voteValueId == -1)
    }

    List<Vote> getVotesDown(int userId) {
        // TODO: Maybe we should add paging here
        return Vote.findAll(user.id == userId && voteValue.voteValueId == -1)
    }


    List<FollowingUser> getFollowing(User u) {
        // TODO: Maybe we should add paging here
        return FollowingUser.findAll(user = u)
    }

    List<FollowingUser> getFollowing(int userId) {
        // TODO: Maybe we should add paging here
        return FollowingUser.findAll(user.id = userId)
    }

    List<FollowingUser> getFollowedBy(User user) {
        // TODO: Maybe we should add paging here
        return FollowingUser.findAll(followedUser = u)
    }

    List<FollowingUser> getFollowedBy(int userId) {
        // TODO: Maybe we should add paging here
        return FollowingUser.findAll(followedUser.id = userId)
    }

    FollowingUser followUser(User userToFollow) {
        FollowingUser followingUser = new FollowingUser()
        followingUser.user = getCurrentUser()
        followingUser.followedUser = userToFollow

        return followingUser.save()
    }

    FollowingUser followUser(int userToFollowId) {
        FollowingUser followingUser = new FollowingUser()
        followingUser.user = getCurrentUser()
        followingUser.followedUser = User.findById(userToFollowId)

        return followingUser.save()
    }

    FollowingUser unfollowUser(User uf) {
        // TODO: Check if syntax is ok
        FollowingUser followingUser = FollowingUser.findAll(userToFollow = uf && user == getCurrentUser()).first()
        return followingUser.delete()
    }

    FollowingUser unfollowUser(int userToFollowId) {
        // TODO: Check if syntax is ok
        FollowingUser followingUser = FollowingUser.findAll(userToFollow.id = userToFollowId && user == getCurrentUser()).first()
        return followingUser.delete()
    }
}
