/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

class SearchController {

    def searchService

    def index() {
        [searchResult: searchService.search(params.query)]
    }
}