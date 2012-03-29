/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.search

import com.klopaj.Poi
import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.grails.plugins.hibernate.search.HibernateSearchQueryBuilder

class SearchService {

    def serbian2LatinConverter

    def search(String queryString) {
        if (StringUtils.isBlank(queryString)) {
            return new ArrayList<Poi>()
        }

        queryString = serbian2LatinConverter.convertToLatin(queryString.trim().toLowerCase())

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
