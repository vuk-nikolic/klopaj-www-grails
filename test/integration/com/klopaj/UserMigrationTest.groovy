package com.klopaj

import org.junit.Before
import org.junit.Test

/**
 *
 * User: markoc
 * Date: 15.5.12.
 * Time: 20.03
 */
class UserMigrationTest extends GroovyTestCase {

    @Before
    void setUp () {

    }

    @Test
    void testDoubleConnection() {

        def legacyUsers = User.list()

        assert legacyUsers.size() != 0   /

        legacyUsers.each {User user ->
            log.info("User found with the id " + user.id)
            log.info("This user has to move down: " + user.id)
            assert user.id != null
            user.mongo.save()
        }
        assertEquals(legacyUsers != 0, "Somethind bad happened. Users should be alive!")

    }

}
