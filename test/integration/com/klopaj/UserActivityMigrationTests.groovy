package com.klopaj

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.junit.Test
import org.springframework.context.ApplicationContext

/**
 *
 * User: markoc
 * Date: 22.5.12.
 * Time: 21.52
 */
class UserActivityMigrationTests extends GroovyTestCase implements GrailsApplicationAware {

    static transactional = false

    static ApplicationContext context

    GrailsApplication app

    @Test
    void migrateActivity() throws Exception {

        UserActivity.withTransaction { status ->

            transactional = true

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

            UserActivity.saveAll(activities.toArray())

            final activities2 = UserActivity.list()

            println activities2
        }

        UserActivity.withTransaction { status ->

            def activitiesPersisted = UserActivity.findAll()

            assert activitiesPersisted.size() > 0

            log.info(activitiesPersisted)
        }

    }

    @Override
    void setGrailsApplication(GrailsApplication grailsApplication) {

        app = grailsApplication
    }
}
