<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>klopaj.com newsfeed</title>
</head>

<body>
<div class="row-fluid">

    <div class="span8">
        <div class="row-fluid newsfeed-header">
            Najnovija dešavanja
        </div>
        <g:each var="activity" in="${activities}">
            <div class="row-fluid newsfeed-row">
                <span class="span2">
                    <div class="row-fluid">
                        <g:link controller="user" action="show" id="${activity.poiId}">${activity.username}</g:link>
                    </div>
                    <div class="row-fluid">
                        <img src="http://www.gravatar.com/avatar/f93d4ba3c5de9f2f82074792c05366bc.jpg?s=48&d=identicon" alt="${activity.username}">
                    </div>
                </span>
                <span class="span10">
                    <g:if test="${activity.type == 'comment'}">
                        <div class="row-fluid newsfeed-row-action">
                            <g:if test="${activity.sex == 'M'}">
                                Komentarisao
                            </g:if>
                            <g:else>
                                Komentarisala
                            </g:else>
                            restoran <g:link controller="poi" action="show" id="${activity.poiId}">${activity.poiName}</g:link>
                        </div>
                        <div class="row-fluid newsfeed-row-comment">
                                ${activity.value}
                        </div>
                    </g:if>
                    <g:elseif test="${activity.type == 'vote'}">
                        vote: ${activity.value}
                    </g:elseif>
                    <g:elseif test="${activity.type == 'photo'}">
                        <span class="span10">
                            <g:if test="${activity.sex == 'M'}">
                                Poslao
                            </g:if>
                            <g:else>
                                Poslala
                            </g:else>
                            sliku za restoran <g:link controller="poi" action="show" id="${activity.poiId}">${activity.poiName}</g:link>
                        </span>
                        <span class="span2 newsfeed-row-image">
                            <img src="/img/plus-12px.png" class="newsfeed-row-image-plus-overlay">
                            <img src="http://www.gravatar.com/avatar/f93d4ba3c5de9f2f82074792c05466bc.jpg?s=64&d=identicon" alt="${activity.username}">
                        </span>
                    </g:elseif>
                    <g:elseif test="${activity.type == 'poi'}">
                        <g:if test="${activity.sex == 'M'}">
                            Promenio
                        </g:if>
                        <g:else>
                            Promenila
                        </g:else>
                        restoran <g:link controller="poi" action="show" id="${activity.poiId}">${activity.poiName}</g:link>
                    </g:elseif>
                </span>
            </div>
        </g:each>
    </div>

    <div class="span4">
        <div class="well">
            <div class="row-fluid sidebar-header">
                Omiljeni restorani
            </div>
            <g:each var="highRatedPoi" in="${highestRatedPois}">
                <div class="row-fluid sidebar-row">
                    <span class="span2 sidebar-row-image"><img src="/img/poi-type-national.png" alt="Nacionalni"></span>
                    <span class="span10 sidebar-row-text-content">
                        <span class="row-fluid sidebar-row-title">
                            ${highRatedPoi[0].name}
                        </span>
                        <span class="row-fluid sidebar-row-detail">
                            ${highRatedPoi[0].address}
                        </span>
                    </span>
                </div>
            </g:each>

            <div class="row-fluid sidebar-header">
                Izdvajamo...
            </div>
            <g:each var="featuredPoi" in="${featuredPois}">
                <div class="row-fluid sidebar-row">
                    <span class="span2 sidebar-row-image"><img src="/img/poi-type-national.png" alt="Nacionalni"></span>
                    <span class="span10 sidebar-row-text-content">
                        <span class="row-fluid sidebar-row-title">
                            ${featuredPoi.name}
                        </span>
                        <span class="row-fluid sidebar-row-detail">
                            ${featuredPoi.address}
                        </span>
                    </span>
                </div>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>