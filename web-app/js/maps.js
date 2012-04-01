/*
 * Copyright (c) 2012. klopaj.com
 */

var map;


function centerMap(map, latitude, longitude) {
    map.setCenter(new google.maps.LatLng(latitude, longitude))
}

// get current location, using GEO API
var currentLatitude;
var currentLongitude;

function showMyLocation() {
    if (Modernizr.geolocation) {
        navigator.geolocation.getCurrentPosition(geoLocation, geoLocationError);
    }
}

function geoLocation(position) {
    currentLatitude = position.coords.latitude;
    currentLongitude = position.coords.longitude;
//    if (currentLatitude && currentLongitude) {
        centerMap(map, currentLatitude, currentLongitude);
//    }
}

// TODO: Implement some message that have meaning for the user (if it is necessary)
function geoLocationError(error) {
    switch (error.code) {
        case 0:
            // UNKNOWN_ERROR (0)
            break;
        case 1:
            // PERMISSION_DENIED (1): user clicked on "don't share location"
            break;
        case 2:
            // POSITION_UNAVAILABLE (2)
            break;
        case 3:
            // TIMEOUT (3)
            break;
            break;
    }
}