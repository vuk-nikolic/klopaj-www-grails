package com.klopaj

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.plugins.hibernate.search.HibernateSearchQueryBuilder

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SearchController)
class SearchControllerTests {

    void testSomething() {
        HibernateSearchQueryBuilder queryBuilder = Poi.search()
        def result = queryBuilder.list()

        print(result)
    }
}
