<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Pretraga :)</title>
</head>

<body>
<div class="container">
    <dl>
        <g:each in="${searchResult}" var="c">
            <dt>${c.name}</dt>
            <dd>${c.address}</dd>
        </g:each>

    </dl>
</div>

</body>
</html>