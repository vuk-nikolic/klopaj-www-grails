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


    });

</g:javascript>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${createLink(uri: '/')}">klopaj!</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li><a data-toggle="modal" href="#login-modal">Prijavi se</a></li>
                    <li><a data-toggle="modal" href="#register-modal">Registruj se</a></li>
                </ul>

                <form action="/search" id="searchForm" method="post" class="navbar-search pull-right">
                    <input name="query" type="text" class="search-query span3" placeholder="Search"/>
                </form>
            </div><!-- /.nav-collapse -->
        </div>
    </div><!-- /navbar-inner -->
    <div id="navGmap"></div>
</div>

