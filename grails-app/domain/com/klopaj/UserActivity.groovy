package com.klopaj

import org.bson.types.ObjectId

class UserActivity {

    static mapWith = "mongo"

    static mapping = {

        userId index: true
        poiId index: true
    }

    static constraints = {
        username(nullable: true)
    }

    ObjectId id

    Long userId

    String username

    Long poiId
}
