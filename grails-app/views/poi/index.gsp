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
            <g:if test="${!poi.photos.isEmpty()}">
                <div class="row-fluid image-placeholder" style="padding-bottom:10px">
                    <span class="span3">
                        <a href="http://www.gravatar.com/avatar/f93d4ba3c5de9f2f82074792c05366bc.jpg?s=512&d=identicon"
                           title="test 1" class="lightbox" rel="roadtrip">
                            <img
                                    src="http://www.gravatar.com/avatar/f93d4ba3c5de9f2f82074792c05366bc.jpg?s=64&d=identicon"
                                    alt="image placeholder">
                        </a>
                    </span>
                    <span class="span3">
                        <a href="http://www.gravatar.com/avatar/e93d4ba3c5de9f2f82074792c05366bc.jpg?s=512&d=identicon"
                           title="test 2" class="lightbox" rel="roadtrip">
                            <img
                                    src="http://www.gravatar.com/avatar/e93d4ba3c5de9f2f82074792c05366bc.jpg?s=64&d=identicon"
                                    alt="image placeholder">
                        </a>
                    </span>
                    <span class="span3">
                        <a href="http://www.gravatar.com/avatar/d93d4ba3c5de9f2f82074792c05366bc.jpg?s=512&d=identicon"
                           title="test 3" class="lightbox" rel="roadtrip">
                            <img
                                    src="http://www.gravatar.com/avatar/d93d4ba3c5de9f2f82074792c05366bc.jpg?s=64&d=identicon"
                                    alt="image placeholder">
                        </a>
                    </span>
                    <span class="span3">
                        <a href="http://www.gravatar.com/avatar/c93d4ba3c5de9f2f82074792c05366bc.jpg?s=512&d=identicon"
                           title="test 4" class="lightbox" rel="roadtrip">
                            <img
                                    src="http://www.gravatar.com/avatar/c93d4ba3c5de9f2f82074792c05366bc.jpg?s=64&d=identicon"
                                    alt="image placeholder">
                        </a>
                    </span>

                    <a href="http://www.gravatar.com/avatar/b93d4ba3c5de9f2f82074792c05366bc.jpg?s=512&d=identicon"
                                               title="test 5" class="lightbox" rel="roadtrip" style="display:none">
                                            </a>
                </div>
            </g:if>

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