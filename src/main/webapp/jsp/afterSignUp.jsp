<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:setBundle basename="text" var="b"/>

<fmt:message bundle="${b}" key="common.confirmation" var="confirm"/>
<fmt:message bundle="${b}" key="confirm.confirmLabel" var="confirmLabel"/>
<fmt:message bundle="${b}" key="common.continue" var="continueLabel"/>
<fmt:message bundle="${b}" key="confirm.inputField" var="inputField"/>
<fmt:message bundle="${b}" key="wrong.key" var="wrongKey"/>
<fmt:message bundle="${b}" key="common.main" var="main"/>

<html>
<head>
    <title>${confirm}</title>
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
<section class="content after-sign-up-content">
    <form id="sign-up" class="card login-card after-sign-up-card" action="${pageContext.request.contextPath}/mainController"
          method="post">
        <div class="field">
            <input type="hidden" name="command" value="CONFIRM_MAIL">
        </div>
        <div class="field">
            <label>${confirmLabel}</label>
        </div>
        <div class="field">
            <input type="text" name="confirm-mail" placeholder="${inputField}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongKey')}">
            <div>
                <label class="wrong-info" id="wrong-age">${wrongKey}</label>
            </div>
        </c:if>
        <button type="submit" class="button">${continueLabel}</button>
    </form>
</section>
<%@include file="footer/footer.jsp" %>
</body>
</html>
