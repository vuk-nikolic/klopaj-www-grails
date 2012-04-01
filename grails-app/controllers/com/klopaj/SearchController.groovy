/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

import grails.converters.JSON

class SearchController {

    def searchService

    def index() {
        render searchService.search(params.query) as JSON
    }
}