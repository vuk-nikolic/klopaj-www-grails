package com.klopaj

import grails.converters.deep.JSON
import grails.converters.deep.XML
import grails.plugins.springsecurity.Secured

class PoiController {
    def poiService

    def index() {
        Poi poi = Poi.findById(params.int("id"))

        List<UserContent> activities = poiService.getLatestPoiActivities(poi, 0)
        List<Object[]> highestRatedPois = poiService.getHighestRatedPois(0) as List<Object[]>
        Set<Poi> featuredPois = poiService.getFeaturedPoiList()

        int ratePlus = poiService.calcVotes(poi.id.intValue(), true)
        int rateMinus = poiService.calcVotes(poi.id.intValue(), false)

        Vote vote = Vote.findByPoiAndUser(poi, poiService.currentUser);
        [poi: poi,
                activities: activities,
                highestRatedPois: highestRatedPois,
                featuredPois: featuredPois,
                rateMinus: rateMinus,
                ratePlus: ratePlus,
                vote: vote]
    }


    def moreActivities() {
        Poi poi = Poi.findById(params.int("id"))
        List<UserContent> activities = poiService.getLatestPoiActivities(poi, params.int("page"))
        render(template: "/layouts/newsfeed-template", model: [activities: activities])
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def vote() {
        int poiId = params.int("id")
        int clientId = params.get("clientId") ? params.int("clientId") : Client.findByName(Client.CLIENT_WEB_APP).id
        int value = params.get("value") ? params.int("value") : 0
        if (value == 0) {
            return
        }

        Vote vote = poiService.vote(poiId, clientId, value)

        int ratePlus = poiService.calcVotes(poiId, true)
        int rateMinus = poiService.calcVotes(poiId, true)

        withFormat {
            html { render(template: "/layouts/vote", model: [poiId: poiId, vote: vote, ratePlus: ratePlus, rateMinus: rateMinus]) }
            js { render vote as JSON }
            xml { render vote as XML }
        }
    }

}
