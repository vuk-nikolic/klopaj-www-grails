package com.klopaj

import org.junit.Test

/**
 *
 * User: markoc
 * Date: 13.8.12.
 * Time: 16.39
 */
class EventIntegrationTest extends GroovyTestCase {

    @Test
    void createBasicEvent() {

        final user = User.create()
        user.email = "ciric.marko@gmail.com"
        User.merge(user)

        final poi = Poi.create()
        poi.name = ""
        Poi.merge(poi)

        final event = new Event()
        event.setUserId(user.getId())
        event[""]
    }

}
