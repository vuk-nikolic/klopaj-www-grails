<g:javascript>

    var zoomSize = 18; // default zoom size for maps

    /**
     * Shows all poi items (fromServer) on google map
     * @param fromServer
     */

    // prepare the form when the DOM is ready
    $(document).ready(function () {
        var mapOptions = {
            center:new google.maps.LatLng(44.816413, 20.460158),
            zoom:zoomSize,
            mapTypeId:google.maps.MapTypeId.ROADMAP
        };
        var mapper = new Mapper("#navGmap", mapOptions);

        // bind form using ajaxForm
        $('#searchForm').ajaxForm({
            // dataType identifies the expected content type of the server response
            dataType:'json',

            // success identifies the function to invoke when the server response
            // has been received
            success:mapper.showSearchResults
        });

        // create map after a small delay, so other parts of the page can be loaded
        setTimer(500, function () {
            mapper.boundarySearch();
        });

        var mapFullSize = true;
        var offset;
        var animationTime = 600;
        $("#showHideMap").click(function (){
            offset = mapFullSize ? "-=140" : "+=140";
            $("#navGmap").animate({
                height: offset
            }, animationTime, function() {
                mapFullSize = !mapFullSize;
                $("#mapResizeImage").attr("src", mapFullSize ? "/img/arrow-up.png" : "/img/arrow-down.png")
            });

            return false;
        });

    });

</g:javascript>
    <div class="row-fluid">
        <div class="span1 offset2">
            <a class="brand" href="${createLink(uri: '/')}"><img src="/img/logo.jpg"> </a>

        </div>
        <ul class="span2 offset5 nav nav-tabs">
            <li><a data-toggle="modal" href="#login-modal">PRIJAVI SE!</a></li>
            <li><a data-toggle="modal" href="#register-modal">REGISTRUJ SE!</a></li>
        </ul>
        <div class="span2"></div>
    </div>



<div class="container mapContainer">

    <div class="row-fluid" style="position: relative;">
        <!-- TODO: Add a floating div above gmap -->
        %{--<div style="position: absolute; z-index: 999; top: -20px; left: 80px; width: 840px;background-color: #fff">--}%
                %{--<form action="/search" id="searchForm" method="post" class="pull-right">--}%
                    %{--<input name="query" type="text" class="search-query" placeholder="Search"/>--}%
                %{--</form>--}%
            %{--</div>--}%
        <div id="showHideMap"><a href="#"><img id="mapResizeImage" src="/img/arrow-up.png" alt="Smanji mapu"></a></div>
        <div id="navGmap"></div>
    </div>


</div>

