<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:setBundle basename="text" var="b"/>

<fmt:message bundle="${b}" key="common.profile" var="profile"/>
<fmt:message bundle="${b}" key="profile.changeLogin" var="changeLogin"/>
<fmt:message bundle="${b}" key="profile.apps" var="apps"/>
<fmt:message bundle="${b}" key="profile.changePassword" var="changePass"/>
<fmt:message bundle="${b}" key="common.logOut" var="logOut"/>
<fmt:message bundle="${b}" key="empty.noApps" var="noApps"/>
<fmt:message bundle="${b}" key="empty.noPendingApps" var="noPendingApps"/>
<fmt:message bundle="${b}" key="common.cancel" var="cancel"/>
<fmt:message bundle="${b}" key="common.main" var="main"/>
<fmt:message bundle="${b}" key="roomFinder.isApproved" var="isApproved"/>
<fmt:message bundle="${b}" key="roomFinder.isInPending" var="isInPending"/>
<fmt:message bundle="${b}" key="roomFinder.isRejected" var="isRejected"/>
<fmt:message bundle="${b}" key="profile.info" var="info"/>
<fmt:message bundle="${b}" key="profile.pendingApps" var="pendApps"/>
<fmt:message bundle="${b}" key="profile.topUpBalance" var="topUpBalance"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>${profile}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/responsive.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/items/items.css">

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
            <li>
                <a href="${pageContext.request.contextPath}\mainController?command=Log_Out">${logOut}</a>
            </li>
        </ul>
    </nav>
</header>

<section class="content">
    <aside>
        <div class="card collection">
            <div class="collection-item">
                <form class="card client-order" action="/mainController?command=open_client_apps" method="post">
                    <button class="button common-button" type="submit">${apps}</button>
                </form>
            </div>
            <div class="collection-item">
                <form class="card client-order" action="/mainController?command=open_client_pending_apps" method="post">
                    <button class="button common-button" type="submit">${pendApps}</button>
                </form>
            </div>
            <div class="collection-item">
                <form class="card client-settings"
                      action="${pageContext.request.contextPath}/mainController?command=open_login_setting"
                      method="post">
                    <button class="button common-button" type="submit">${changeLogin}</button>
                </form>
            </div>
            <div class="collection-item">
                <form class="card client-settings"
                      action="${pageContext.request.contextPath}/mainController?command=open_password_setting"
                      method="post">
                    <button class="button common-button" type="submit">${changePass}</button>
                </form>
            </div>
            <div class="collection-item">
                <form class="card client-settings"
                      action="${pageContext.request.contextPath}/mainController?command=open_client_profile"
                      method="post">
                    <button class="button common-button" type="submit">${info}</button>
                </form>
            </div>
            <div class="collection-item">
                <form class="card client-settings"
                      action="${pageContext.request.contextPath}/mainController?command=open_balance_form"
                      method="post">
                    <button class="button common-button" type="submit">${topUpBalance}</button>
                </form>
            </div>
        </div>
    </aside>


    <main class="items">
        <%@include file="../user/userInfo.jsp" %>
        <c:if test="${openPass==true}">
            <%@include file="../user/changePassword.jsp" %>
        </c:if>
        <c:if test="${userLogin!=null}">
            <%@include file="../user/changeLogin.jsp" %>
        </c:if>
        <c:if test="${balanceForm==true}">
            <%@include file="../user/balance.jsp" %>
        </c:if>
        <c:choose>
            <c:when test="${allApps.size() == 0}">
                <ctg:image-tag title="${noApps}"
                               imagePath="${pageContext.request.contextPath}/common/images/sadness.jpg"/>
            </c:when>
            <c:when test="${pendingApps.size() == 0}">
                <ctg:image-tag title="${noPendingApps}"
                               imagePath="${pageContext.request.contextPath}/common/images/sadness.jpg"/>
            </c:when>
            <c:otherwise>
                <c:if test="${allApps.size() != 0}">
                    <%@include file="../client/allApps.jsp" %>
                </c:if>
                <c:if test="${pendingApps.size() != 0}">
                    <%@include file="../client/pendingApps.jsp" %>
                </c:if>
            </c:otherwise>
        </c:choose>
    </main>
</section>

<%@include file="../footer/footer.jsp" %>
</body>
</html>

