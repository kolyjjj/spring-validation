<html>
<head>
<title>user info</title>
</head>
<body>
<h1>Hello ${user.firstName} ${user.lastName}</h1>
<h2>Are you rich?</h2>

<c:choose>
    <c:when test="${user.isRich}">
        YES
    </c:when>
    <c:otherwise>
        NO
    </c:otherwise>
</c:choose>

<p>sex is: ${user.sex}</p>
<p>password is: ${user.password}</p>

</body>
</html>