/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

class HomeController {

    def poiService

    def index() {
        List<UserContent> activities = poiService.getLatestActivities(0)
        List<Object[]> highestRatedPois = poiService.getHighestRatedPois(0)
        Set<Poi> featuredPois = poiService.getFeaturedPoiList()
        [activities: activities, highestRatedPois: highestRatedPois, featuredPois:featuredPois]
    }
}
