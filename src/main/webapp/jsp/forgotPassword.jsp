<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:setBundle basename="text" var="b"/>

<fmt:message bundle="${b}" key="reg.sendPass" var="sendPass"/>
<fmt:message bundle="${b}" key="wrong.email" var="wrEmail"/>
<fmt:message bundle="${b}" key="wrong.nonExistingEmail" var="wrNonExEmail"/>
<fmt:message bundle="${b}" key="common.main" var="main"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>${resPass}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/responsive.css">
</head>
<body>

<header class="header">
    <nav>
        <ul>
            <li>
                <%@include file="header/locale.jsp" %>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}\mainController?command=Open_Main_Page">${main}</a>
            </li>
            <li class="logo">Logo</li>
        </ul>
    </nav>
</header>

<section class="content login-content">
    <div class="field">
        <form class="card login-card" onsubmit="return validateEmail()"
              action="${pageContext.request.contextPath}/mainController?command=reset_password"
              method="post">
            <div class="field">
                <input type="text" id="mail" placeholder="input mail" name="mail" value="${requestScope.get("mail")}"
                       required>
            </div>
            <c:if test="${requestScope.containsKey('wrongEmail')}">
                <div>
                    <label class="wrong-info" id="wrong-email">${wrEmail}</label>
                </div>
            </c:if>
            <c:if test="${requestScope.containsKey('nonExistingEmail')}">
                <div>
                    <label class="wrong-info" id="non-existing-email">${wrNonExEmail}</label>
                </div>
            </c:if>
            <div>
                <label class="wrong-info" id="incorrect-email">${wrEmail}</label>
            </div>
            <button class="button" id="reset-password-button" type="submit">
                ${sendPass}
            </button>
        </form>
    </div>
</section>

<script src="${pageContext.request.contextPath}/common/js/authorisation.js"></script>
<%@include file="footer/footer.jsp" %>
</body>
</html>
