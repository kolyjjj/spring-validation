<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>my spring</title>
</head>
<body>
<h1>Welcome to my spring webapp</h1><strong>${firstName} ${lastName}</strong>

<c:url value="userSubmit" var="userInfoUrl"/>

<form:form commandName="user" action="${userInfoUrl}">
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="firstName" ></form:errors></td>
        </tr>

        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName" /></td>
            <td><form:errors path="lastName" /></td>
        </tr>

        <tr>
            <td>password:</td>
            <td><form:password path="password" value="^76525dfjs" showPassword="false" /></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td><form:radiobuttons path="sex" items="${user.sexOptions}"/></td>
        </tr>

        <tr>
            <td>isRich:</td>
            <td><form:checkbox path="isRich" /></td>
        </tr>
        <tr>
            <td>Skills:</td>
            <td>
                <form:select path="skills" multiple="false" items="${skills}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes" />
            </td>
        </tr>

    </table>
</form:form>

<a href="<c:url value="hello"/>">hello</a>

</body>
</html>