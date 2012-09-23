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
                <li class="contact address">${poi.address}</li>
                <li class="contact email">${poi.contactEmail}</li>
                <li class="contact phone">${poi.contactTel1}</li>
                <li class="contact phone">${poi.contactTel2}</li>
                <li class="contact phone">${poi.contactFax}</li>
                <li class="contact email"><a href="${poi.contactWww}" target="_blank">${poi.contactWww}</a></li>
            </ul>
            <g:if test="${!poi.tags.isEmpty()}">
                <b>Tagovi</b>
                <ul class="unstyled">
                    <g:each var="tag" in="${poi.tags}">
                        <li class="contact tag"><g:link controller="tag" action="index"
                                                        id="${tag.id}">${tag.name}</g:link></li>
                    </g:each>
                </ul>
            </g:if>
            <div class="row-fluid">
                <span class="span4 like-inactive">
                    <img src="/img/like.png" alt="like"/>
                </span>
                <span class="span2 like-text">0</span>
                <span class="span4 unlike-inactive">
                    <img src="/img/unlike.png" alt="like"/>
                </span>
                <span class="span2 unlike-text">0</span>
            </div>

        </div>

        <div class="span8 middle-content">
            <div class="row-fluid newsfeed-header">
                Najnovija dešavanja
            </div>

            <g:render template="/layouts/newsfeed-empty" bean="${activities}"/>
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