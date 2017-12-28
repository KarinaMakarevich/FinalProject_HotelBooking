<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message bundle="${b}" key="common.main" var="main"/>
<fmt:message bundle="${b}" key="common.language" var="lang"/>
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
                <a href="${pageContext.request.contextPath}/jsp/signIn.jsp">${signIn}</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/jsp/signUp.jsp">${signUp}</a>
            </li>
        </ul>
    </nav>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/footer.js"></script>
</header>

