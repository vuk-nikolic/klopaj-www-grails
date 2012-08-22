package com.klopaj

import grails.converters.JSON

class RestPoiController {

    def poiService

    def index() {
        List<Poi> poiList = Poi.findAll();
        render poiList as JSON;
    }

    def activities() {
        List<UserContent> userContentList = poiService.getLatestActivities(params.page ? new Integer(params.page) : 0)
        render userContentList as JSON;
    }
}