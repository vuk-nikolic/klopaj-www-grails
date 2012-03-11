package com.klopaj

import grails.converters.JSON

class RestPoiController {

    def index() {
        List<Poi> poiList = Poi.findAll();
        render poiList as JSON;
    }
}
