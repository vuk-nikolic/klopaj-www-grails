<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>klopaj.com newsfeed</title>
</head>

<body>
<div class="row-fluid">

    <div class="span8 main-content">
        <div class="row-fluid newsfeed-header">
            Najnovija dešavanja
        </div>
       <g:render template="/layouts/newsfeed-template" bean="${activities}" />
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