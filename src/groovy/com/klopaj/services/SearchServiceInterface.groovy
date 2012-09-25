/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.services

/**
 * SearchServiceInterface implements all search-related action for the application such as query string search as well as a map-boundary search.
 */
interface SearchServiceInterface {

    def serbian2LatinConverter

    /**
     * Performs query string base search.<br />
     * Returns list of Poi items.
     *
     * @param queryString Term for search
     * @return List of Poi items
     */
    def search(String queryString);

    /**
     * Performs a search for the specified geo location area. Area is specified with min and max latitude and longitude. <br />
     * Returns list of Poi items.
     * @param minLat
     * @param maxLat
     * @param minLng
     * @param maxLng
     * @return List of Poi items in selected area
     */
    def boundaryMapSearch(double minLat, double maxLat, double minLng, double maxLng);
}
