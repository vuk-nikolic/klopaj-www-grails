package com.klopaj

import org.bson.types.ObjectId

/**
 * Generic event for a user.
 */
class Event {

    static mapWith = "mongo"

    static mapping = {

        userId index: true
    }

    static constraints = {
        userId(nullable: true)
    }

    ObjectId id

    Long userId

}
