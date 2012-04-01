/*
 * Copyright (c) 2012. klopaj.com
 */
function pleaseWait(waiting) {
}


function Mapper(nameOfDiv, mapOptions) {
    var map = new google.maps.Map($(nameOfDiv)[0], mapOptions);
    var thisClass = this;

    var markers = [];
    var defaultIcon = '/images/marker_default.png';
    var inactiveIcon = '/images/marker_inactive.png';
    var activeInfoWindow;

    this.createMarker = function createMarker(poi) {
        var id = poi.id;
        var name = poi.name;
        var latitude = poi.latitude;
        var longitude = poi.longitude;
        var actref = poi.actref;

        var marker = new google.maps.Marker({
            position:new google.maps.LatLng(latitude, longitude),
            map:map,
            title:name,
            icon:actref == 0 ? defaultIcon : inactiveIcon
        });

        markers[id] = marker;

        var info = new google.maps.InfoWindow({
            content:poi.name
        });
        google.maps.event.addListener(marker, 'click', function () {
            if (activeInfoWindow) {
                activeInfoWindow.close()
            }
            info.open(this.map, marker);
            activeInfoWindow = info;
        });

    };

    this.removeAllMarkers = function removeAllMarkers() {
        for (i in markers) {
            markers[i].setMap(null);
        }
        markers = [];
    };

    this.boundarySearch = function boundarySearch() {
        if (!map) {
            return;
        }

        google.maps.event.addListenerOnce(map, 'idle', function () {
            var southWest = map.getBounds().getSouthWest();
            var northEast = map.getBounds().getNorthEast();
            $.ajax({
                type:'POST',
                url:'/search/boundaryMapSearch',
                contentType:'application/json',
                data:'{"minLat":' + southWest.lat() + ',"maxLat":' + northEast.lat() + ',"minLng":' + southWest.lng() + ',"maxLng":' + northEast.lng() + "}",
                beforeSend:function () {
                    pleaseWait(true);
                },
                success:function (result) {
                    pleaseWait(false);
                    thisClass.showSearchResults(result);
                }
            });
        });
    };

    this.showSearchResults = function showSearchResult(fromServer) {
        console.log("showSearchResult");
        var jsonResponse = $(fromServer);
        if (jsonResponse) {
            thisClass.removeAllMarkers(); // if we have some response remove all current markers
            activeInfoWindow = null; // and also we have no active info window
        }
        jsonResponse.each(function () {
            var poi = new Poi();
            poi.id = $(this).attr("id");
            poi.name = $(this).attr("name");
            poi.actref = $(this).attr("actref");
            poi.latitude = $(this).attr("latitude");
            poi.longitude = $(this).attr("longitude");

            thisClass.createMarker(poi);
        });

    };

    this.centerMap = function centerMap(latitude, longitude) {
        map.setCenter(new google.maps.LatLng(latitude, longitude))
    };
}