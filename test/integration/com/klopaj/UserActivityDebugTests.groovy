package com.klopaj

import org.junit.Before
import org.junit.Test

import static com.mongodb.util.MyAsserts.assertNotEquals

class UserActivityDebugTests extends GroovyTestCase {

    static transactional = false

    @Before
    void onSetUp () {
        UserActivity.withTransaction { status ->

            def list = UserActivity.list()

            for (activity in list) {
                activity.delete()
            }
        }
    }

    @Test
    void testFields() {

        def activity1 = new UserActivity()
        activity1.poiId = 2l
        activity1.userId = 3l
        activity1.username = "Pera"

        def activity2 = new UserActivity()
        activity2.poiId = 2l
        activity2.userId = 4l
        activity2.username = "Mika"

        UserActivity.withTransaction {  status ->
            activity1.save()
            activity2.save()
        }

        UserActivity.withTransaction {  status ->

            assert UserActivity.count() == 2
            def actual = UserActivity.findByUserId(4l)
            assertEquals(activity2, actual)

            actual = UserActivity.findByUserId(3l)
            assertEquals(activity1, actual)

            actual = UserActivity.findByUserId(2l)
            assertNotEquals(activity1, actual)

            actual = UserActivity.findByPoiId(2l)
            if (4.equals(actual.userId)) {
                log.info("User id= " + actual.userId + " found")
            } else if (3.equals(actual.userId)) {
                log.info("User id=" + actual.userId + " found")
            }
        }
    }
}
