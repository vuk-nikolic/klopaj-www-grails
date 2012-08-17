/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.services.sql

import grails.test.mixin.TestFor
import com.klopaj.Poi

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SqlPoiService)
class SqlPoiServiceTests {
    def poiService

    void testAddPoi() {
        int count = Poi.findAll().size();

        Poi newPoi = new Poi()
        newPoi.name = "Test"
        newPoi.address = "Address"
        newPoi.contactEmail = "email@klopaj.com"
        newPoi.contactFax = "fax number"
        newPoi.contactTel1 = "33333"
        newPoi.contactTel2 = "44444"
        newPoi.contactWww = "www.klopaj.com"

        // Check if saving passed
        assert poiService.addPoi(newPoi)

        // Check if number of pois increased
        int newCount = Poi.findAll().size()
        assert newCount == count

        // Check if we load it from db
        Poi fromDb = Poi.findByName(newPoi.name)
        assert fromDb.address == newPoi.address

        // Clean up
        fromDb.delete()
    }

    void testUpdatePoi() {

    }

    void testVoteUp() {

    }

    void testVoteDown() {

    }

    void testGetVotes() {

    }

    void testFollow() {

    }

    void testUnfollow() {

    }

    void testGetComments() {

    }

    void testGetFavorites() {

    }

    void testAddComment() {

    }

    void testGetPhotos() {

    }
}
