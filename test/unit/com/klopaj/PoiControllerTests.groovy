package com.klopaj

import grails.test.mixin.*

@TestFor(PoiController)
@Mock(Poi)
class PoiControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pePoiData/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pePoiDataInstanceList.size() == 0
        assert model.pePoiDataInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.pePoiDataInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pePoiDataInstance != null
        assert view == '/pePoiData/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pePoiData/show/1'
        assert controller.flash.message != null
        assert Poi.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pePoiData/list'


        populateValidParams(params)
        def pePoiData = new Poi(params)

        assert pePoiData.save() != null

        params.id = pePoiData.id

        def model = controller.show()

        assert model.pePoiDataInstance == pePoiData
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pePoiData/list'


        populateValidParams(params)
        def pePoiData = new Poi(params)

        assert pePoiData.save() != null

        params.id = pePoiData.id

        def model = controller.edit()

        assert model.pePoiDataInstance == pePoiData
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pePoiData/list'

        response.reset()


        populateValidParams(params)
        def pePoiData = new Poi(params)

        assert pePoiData.save() != null

        // test invalid parameters in update
        params.id = pePoiData.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pePoiData/edit"
        assert model.pePoiDataInstance != null

        pePoiData.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pePoiData/show/$pePoiData.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pePoiData.clearErrors()

        populateValidParams(params)
        params.id = pePoiData.id
        params.version = -1
        controller.update()

        assert view == "/pePoiData/edit"
        assert model.pePoiDataInstance != null
        assert model.pePoiDataInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pePoiData/list'

        response.reset()

        populateValidParams(params)
        def pePoiData = new Poi(params)

        assert pePoiData.save() != null
        assert Poi.count() == 1

        params.id = pePoiData.id

        controller.delete()

        assert Poi.count() == 0
        assert Poi.get(pePoiData.id) == null
        assert response.redirectedUrl == '/pePoiData/list'
    }
}
