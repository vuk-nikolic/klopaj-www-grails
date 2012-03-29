/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.search

import org.codehaus.groovy.grails.plugins.hibernate.search.HibernateSearchQueryBuilder
import com.klopaj.Poi

class SearchService {

    def serbian2LatinConverter

    def search(String queryString) {
        if (queryString?.isEmpty()) {
            return new ArrayList<Poi>();
        }
        queryString = serbian2LatinConverter.convertToLatin(queryString)

        HibernateSearchQueryBuilder queryBuilder = Poi.search()
        def result = queryBuilder.list({
            should {
                wildcard("name", queryString + "*")
                wildcard("tags.name", queryString + "*")
                wildcard("description", queryString + "*")
                wildcard("address", queryString + "*")
            }
        })

        return result
    }

}
