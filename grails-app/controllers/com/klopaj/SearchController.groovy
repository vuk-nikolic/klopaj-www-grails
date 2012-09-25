/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

import grails.converters.JSON
import com.klopaj.rest.ResponseMessage

class SearchController {
    static allowedMethods = [boundaryMapSearch: 'POST']

    def searchService

    /**
     * Searches for "params.query" string in database (lucene). It uses SearchServiceInterface internally.<br />
     * Searches by name, description, tag and address. Boosting included.
     * @return List of Poi items render as json (@see BootStrap.groovy how is Poi rendered JSON.registerObjectMarshaller(Poi))
     */
    def index() {
        render searchService.search(params.query) as JSON
    }

    /**
     * Searches for Poi items in defined area (boundary). Area is defined with min/max latitude and longitude. <br />
     * This is a <b>POST</b> request (defined in static allowedMethods)
     * @return List of Poi items render as json (@see BootStrap.groovy how is Poi rendered JSON.registerObjectMarshaller(Poi))
     */
    def boundaryMapSearch() {
        def json = request.JSON
        def minLat = json.minLat
        def maxLat = json.maxLat
        def minLng = json.minLng
        def maxLng = json.maxLng

        if (!minLat || !maxLat || !minLng || !maxLng) {
            render new ResponseMessage("code": 500, "message": "min/max Lat/Lng not defined") as JSON
        }
        render searchService.boundaryMapSearch(minLat, maxLat, minLng, maxLng) as JSON
    }
}