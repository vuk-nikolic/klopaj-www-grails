/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

import org.codehaus.groovy.grails.plugins.hibernate.search.HibernateSearchQueryBuilder

class SearchController {

    def serbian2LatinConverter

    def index() {
        def queryString = serbian2LatinConverter.convertToLatin(params.query)

        HibernateSearchQueryBuilder queryBuilder = Poi.search()
        def result = queryBuilder.list({
            wildcard "name", queryString + "*"
        })

        print(result)
        [searchResult: result]
    }
}