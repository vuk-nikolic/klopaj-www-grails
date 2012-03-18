<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
<g:each in="${searchResult}" var="c">
    <p>${c.name}</p>
</g:each>

</body>
</html>