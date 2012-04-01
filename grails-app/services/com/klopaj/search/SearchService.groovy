/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.search

import com.klopaj.Poi
import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.grails.plugins.hibernate.search.HibernateSearchQueryBuilder

/**
 * SearchService implements all search-related action for the application such as query string search as well as a map-boundary search.
 */
class SearchService {

    def serbian2LatinConverter

    /**
     * Performs query string base search.<br />
     * Argument is checked is it blank, than stripped for whitespace and lower-cased. After that all chars are converted to latin (šđčćž).<br />
     * <br />
     * Actual query is performed with hibernate-search. Searching for fields name, tags.name, description and address. Keyword is treated as it has a wildcard (*) at the end.<br />
     * Boosting for keywords is defined during index time.
     * @param queryString Term for search
     * @return List of Poi items
     */
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

    /**
     * Performs a search for the specified geo location area. Area is specified with min and max latitude and longitude. <br />
     * Returns list of Poi items.
     * @param minLat
     * @param maxLat
     * @param minLng
     * @param maxLng
     * @return List of Poi items in selected area
     */
    def boundaryMapSearch(double minLat, double maxLat, double minLng, double maxLng) {
        return Poi.findAll {
            latitude >= minLat && latitude <= maxLat && longitude >= minLng && longitude <= maxLng
        }
    }

}
