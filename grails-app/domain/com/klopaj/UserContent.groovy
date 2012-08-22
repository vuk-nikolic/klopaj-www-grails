/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

/**
 * UserContent is not a regular entity, because we do not have a id for it. It is <b>READ ONLY</b><br />
 * It is just a collection of user's activities, not a full blown entity, with all data (like user, poi etc).<br />
 * Only data required for the output is gather from a specific database view.<br /><br />
 * Data is gathered via pe_latest_activities_details_v view. This is just an implementation without using mongo.<br />
 * When we switch to mongo this entity should be removed :)
 *
 * It is used for the "news feed" or "dashboard" to show the latest content that user has create.
 */
class UserContent {

    static mapping = {
            table 'pe_latest_activities_details_v'
            // version is set to false, because this isn't available by default for legacy databases
            version false
            id column: 'id'
            type column: 'type'
            poiId column: 'poi_data_id'
            poiName column: 'poi_name'
            userId column: 'user_id'
            username column: 'username'
            email column: 'email'
            sex column: 'sex'
            usingGravatar column: 'using_gravatar'
            datetime column: 'datetime'
            value column: 'value'
            client column: 'client_id'
        }

    String id;
    String type;
    Integer poiId;
    String poiName;
    Long userId;
    String username;
    String email;
    char sex;
    boolean usingGravatar;
    Date datetime;
    String value;
    Client client

    static constraints = {
    }
}
