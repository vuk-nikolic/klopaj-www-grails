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
        <div id="loadingContainer"><img src="/img/loading_wheel_small.gif" title="Samo sekund, učitavamo"/></div>
        <div id="moreContainer"></div>
    </div>

    <div class="span4">
        <g:render template="/layouts/sidebar-template" model="['highestRatedPois': highestRatedPois, 'featuredPois': featuredPois]" />
    </div>
</div>
</body>
</html>