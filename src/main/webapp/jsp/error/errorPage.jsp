<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:setBundle basename="text" var="b"/>
<fmt:message bundle="${b}" key="common.error" var="error"/>
<fmt:message bundle="${b}" key="common.main" var="main"/>
<fmt:message bundle="${b}" key="wrong.error" var="errorMessage"/>
<fmt:message bundle="${b}" key="error.err" var="error"/>
<fmt:message bundle="${b}" key="error.statusCode" var="statusCode"/>
<fmt:message bundle="${b}" key="error.stackTrace" var="stackTrace"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>${error}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/responsive.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/items/items.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/slider/input-slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/checkbox/checkbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/date/date.css">
</head>
<body>
<header class="header">
    <nav>
        <ul>
            <li>
                <%@include file="../header/locale.jsp" %>
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
        <form class="card register-card">
            <div class="field">
                <label>${errorMessage}</label>
            </div>
            <div class="field">
                <label>${error}</label>
                <span>${pageContext.exception}</span>
            </div>
            <div class="field">
                <label>${statusCode}</label>
                <span>${pageContext.errorData.statusCode}</span>
            </div>
            <div class="field">
                <label>${stackTrace}</label>
                <span>${pageContext.exception.stackTrace}</span>
            </div>
        </form>
    </div>
</section>
<%@include file="../footer/footer.jsp" %>
</body>
</html>
