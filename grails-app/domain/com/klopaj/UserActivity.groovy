package com.klopaj

class UserActivity {

    static mapWith = "mongo"

    static mapping = {
        id generator:'identity'
    }

    static constraints = {
        datetime()
        version(max: 2147483647)
        username(nullable: true)
        poi(nullable: true)
        userId(unique: true)
        poiId(unique: true)
    }

    Date datetime
    Integer version
    Long userId
    String username
    Long poiId
    String poi
}
