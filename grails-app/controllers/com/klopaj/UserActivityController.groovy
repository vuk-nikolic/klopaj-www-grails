package com.klopaj

class UserActivityController {

    def index() {
        final userActivities = UserActivity.findByUserId(params.id)
    }
}
