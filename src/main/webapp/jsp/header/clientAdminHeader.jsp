<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message bundle="${b}" key="common.logOut" var="logOut"/>
<fmt:message bundle="${b}" key="common.profile" var="profile"/>
<fmt:message bundle="${b}" key="common.main" var="main"/>
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
            <li>
                <c:set var="role" value="${sessionScope.role}"/>
                <c:choose>
                    <c:when test="${role=='CLIENT'}">
                        <a href="${pageContext.request.contextPath}\mainController?command=Open_Client_Profile">${profile}</a>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${role=='ADMIN'}">
                            <a href="${pageContext.request.contextPath}\mainController?command=Open_Admin_Profile">${profile}</a>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </nav>
</header>
