package com.klopaj

import grails.converters.deep.JSON

class PoiController {
    def poiService

    def index() {
        Poi poi = Poi.findById(params.int("id"))
        List<UserContent> activities = poiService.getLatestPoiActivities(poi, 0)
        List<Object[]> highestRatedPois = poiService.getHighestRatedPois(0)
        Set<Poi> featuredPois = poiService.getFeaturedPoiList()
        [poi: poi, activities: activities, highestRatedPois: highestRatedPois, featuredPois: featuredPois]
    }


    def moreActivities() {
        Poi poi = Poi.findById(params.int("id"))
        List<UserContent> activities = poiService.getLatestPoiActivities(poi, params.int("page"))
        render(template: "/layouts/newsfeed-template", model: [activities: activities])
    }

}
