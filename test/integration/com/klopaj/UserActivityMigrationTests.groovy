package com.klopaj

import org.junit.Before
import org.junit.Test

/**
 *
 * User: markoc
 * Date: 22.5.12.
 * Time: 21.52
 */
class UserActivityMigrationTests extends GroovyTestCase {

    static transactional = false

    @Before
    void onSetUp() throws Exception {

    }

    @Test
    void migrateActivity() throws Exception {
        User.withTransaction { status ->

            def votes = Vote.findAll()
            def favorites = Favorite.findAll()
            def comments = Comment.findAll()
            def tags = Tag.findAll()

            def activitiesOrdered = votes.sort{it.datetime}

            activitiesOrdered.addAll(favorites)
            activitiesOrdered.addAll(comments)
            activitiesOrdered.addAll(tags)

            activitiesOrdered.sort{it.datetime}

            def activities = UserActivity.list()
            activities.addAll(activitiesOrdered)

            for (activity in activities) {
                UserActivity.save(activity)
            }
            UserActivity.saveAll(activities)
        }

        User.withTransaction { status ->
            def activitiesPersisted = UserActivity.findAll()

            log.info(activitiesPersisted)
        }

    }

}
