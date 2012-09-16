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
        $("#showHideMap").click(function () {
            offset = mapFullSize ? "-=140" : "+=140";
            $("#navGmap").animate({
                height:offset
            }, animationTime, function () {
                mapFullSize = !mapFullSize;
                $("#mapResizeImage").attr("src", mapFullSize ? "/img/arrow-up.png" : "/img/arrow-down.png")
            });

            return false;
        });

    });

    (function () {
        var loading = false;
        var page = 1;

        function nearBottomOfPage() {
            return $(window).scrollTop() > $(document).height() - $(window).height() - 200;
        }

        $(window).scroll(function () {
            if (loading) {
                return;
            }
            if (nearBottomOfPage()) {
                loading = true;
                $("#loadingContainer").show();
                page++;
                $.ajax({
                    type:"GET",
                    url:"/home/moreActivities",
                    data:"page=" + page
                }).done(function (msg) {
                            $("#loadingContainer").hide();
                            $(msg).insertBefore($("#loadingContainer"));
                            loading = false;
                        });
            }
        });
    }());
</g:javascript>
<div class="row-fluid navigation-header">
    <div class="span1"></div>
    <div class="span2 offset1">
        <a class="brand" href="${createLink(uri: '/')}"><img src="/img/logo.jpg"></a>
        <img class="logo-divider" src="/img/logo-divider.png" alt=""/>
    </div>
    <div class="span6">
        <div class="row-fluid">
            <div class="span2 offset8 nav-register"><a data-toggle="modal" href="#register-modal">Registruj se!</a></div>
            <div class="span2 nav-login"><a data-toggle="modal" href="#login-modal">Prijavi se!</a></div>
        </div>
    </div>

    <div class="span2"></div>
</div>


<div class="container mapContainer">

    <div class="row-fluid" style="position: relative;">
        <div class="mapOverlay">
            <div class="span1 map-nav-cuisine"><a href="#">Kuhinje</a></div>
            <div class="span1 map-nav-extra"><a href="#">Dodaci</a></div>
            <div class="span10">
                <form action="/search" id="searchForm" method="post" class="pull-right">
                    <input name="query" type="text" placeholder="NAĐI RESTORAN..." />
                </form>
            </div>
        </div>
        <div id="showHideMap"><a href="#"><img id="mapResizeImage" src="/img/arrow-up.png" alt="Smanji mapu"></a></div>

        <div id="navGmap"></div>
    </div>

</div>

