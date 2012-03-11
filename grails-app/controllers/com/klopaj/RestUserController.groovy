package com.klopaj

import grails.converters.JSON

class RestUserController {

    def index() {
        List<User> poiList = User.findAll();
        render poiList as JSON;
    }
}
