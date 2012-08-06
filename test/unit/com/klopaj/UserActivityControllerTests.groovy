package com.klopaj

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(UserActivityController)
@Mock(UserActivity)
class UserActivityControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/userActivity/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.userActivityInstanceList.size() == 0
        assert model.userActivityInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.userActivityInstance != null
    }

    void testSave() {
        controller.save()

        assert model.userActivityInstance != null
        assert view == '/userActivity/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/userActivity/show/1'
        assert controller.flash.message != null
        assert UserActivity.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/userActivity/list'


        populateValidParams(params)
        def userActivity = new UserActivity(params)

        assert userActivity.save() != null

        params.id = userActivity.id

        def model = controller.show()

        assert model.userActivityInstance == userActivity
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/userActivity/list'


        populateValidParams(params)
        def userActivity = new UserActivity(params)

        assert userActivity.save() != null

        params.id = userActivity.id

        def model = controller.edit()

        assert model.userActivityInstance == userActivity
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/userActivity/list'

        response.reset()


        populateValidParams(params)
        def userActivity = new UserActivity(params)

        assert userActivity.save() != null

        // test invalid parameters in update
        params.id = userActivity.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/userActivity/edit"
        assert model.userActivityInstance != null

        userActivity.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/userActivity/show/$userActivity.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        userActivity.clearErrors()

        populateValidParams(params)
        params.id = userActivity.id
        params.version = -1
        controller.update()

        assert view == "/userActivity/edit"
        assert model.userActivityInstance != null
        assert model.userActivityInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/userActivity/list'

        response.reset()

        populateValidParams(params)
        def userActivity = new UserActivity(params)

        assert userActivity.save() != null
        assert UserActivity.count() == 1

        params.id = userActivity.id

        controller.delete()

        assert UserActivity.count() == 0
        assert UserActivity.get(userActivity.id) == null
        assert response.redirectedUrl == '/userActivity/list'
    }
}
