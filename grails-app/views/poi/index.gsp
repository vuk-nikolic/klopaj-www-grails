<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>klopaj.com ${poi.name}</title>
</head>
<g:javascript>
    function getMoreActivitiesUrl() {
        // poi index.gsp
        return "/poi/moreActivities"
    }

    function getMoreActivitiesParams() {
        return "page=" + page + "&id=" + ${poi.id}
    }
</g:javascript>
<body>
<div class="row-fluid">

    <div class="span8 main-content">

        <div class="span4">
            <b>${poi.name}</b>
            <ul class="unstyled">
                <li>${poi.address}</li>
                <li>${poi.contactEmail}</li>
                <li>${poi.contactTel1}</li>
                <li>${poi.contactTel2}</li>
                <li>${poi.contactFax}</li>
                <li>${poi.contactWww}</li>
            </ul>
        </div>
        <div class="span8">
            <div class="row-fluid newsfeed-header">
                Najnovija dešavanja
            </div>
            <g:render template="/layouts/newsfeed-template" bean="${activities}"/>
            <div id="loadingContainer"><img src="/img/loading_wheel_small.gif" title="Samo sekund, učitavamo"/></div>

            <div id="moreContainer"></div>
        </div>
    </div>

    <div class="span4">
        <g:render template="/layouts/sidebar-template"
                  model="['highestRatedPois': highestRatedPois, 'featuredPois': featuredPois]"/>
    </div>
</div>
</body>
</html>