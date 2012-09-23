<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Service Support"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'img', file: 'favicon.ico')}" type="image/x-icon">
    <g:javascript library="jquery"/>
    <g:layoutHead/>
    <r:layoutResources/>
    <!-- Following stylesheet is for Din Display Pro Regular font -->
    <link rel="stylesheet" href="http://f.fontdeck.com/s/css/uH5+KWQnibDTJRYggGJ9XZLTAgw/localhost/23906.css" type="text/css" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
    <script type="text/javascript" src="${resource(dir: 'js', file: 'thirdparty/jquery/jquery.form.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'thirdparty/jquery/jquery.timeago.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'thirdparty/jquery/jquery.timeago.rs.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'domain/poi.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'application.js')}"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'thirdparty/modernizr-1.7.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'maps.js')}"></script>

</head>

<body>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'thirdparty/bootstrap.min.js')}"></script>
    <g:render template="/layouts/main-navigation"/>

    %{--<div id="searchResult"></div>--}%
    <div class="container">
        <g:layoutBody/>
    </div>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>

    <r:layoutResources/>

    <g:render template="/layouts/login-modal"/>
    <g:render template="/layouts/register-modal"/>
</body>
</html>