/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

import org.codehaus.groovy.grails.plugins.hibernate.search.HibernateSearchQueryBuilder

class SearchController {

    def index() {
        HibernateSearchQueryBuilder queryBuilder = Poi.search()
        def result = queryBuilder.list({
            wildcard "name", "bul*"
        })

        print(result)
        [searchResult: result]
    }
}