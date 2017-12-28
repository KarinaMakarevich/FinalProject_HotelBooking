<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:message bundle="${b}" key="profile.user" var="user"/>
<fmt:message bundle="${b}" key="user.isBlocked" var="isBlocked"/>
<fmt:message bundle="${b}" key="user.notIsBlocked" var="notIsBlocked"/>
<fmt:message bundle="${b}" key="admin.block" var="block"/>
<fmt:message bundle="${b}" key="admin.unblock" var="unblock"/>

<main class="items">
    <%--@elvariable id="allApps" type="java.util.List"--%>
    <c:forEach var="entity" items="${allUsers}">
        <form action="${pageContext.request.contextPath}/mainController" method="post">
            <article class="item card">
                <h1>${user}: ${entity.getLogin()}, ${balance}: ${entity.getBalance()}</h1>
                <input type="hidden" name="login" value="${entity.getLogin()}">
                <input type="hidden" class="command" name="command" value="">
                <c:choose>
                    <c:when test="${entity.isBlocked() == true}">
                        <h1>${isBlocked}</h1>
                        <button class="button book-button" name="book-button" type="submit" onclick="setUnblock()">
                            <span>${unblock}</span>
                        </button>
                    </c:when>
                    <c:otherwise>
                        <h1>${notIsBlocked}</h1>
                        <button class="button book-button" name="book-button" type="submit" onclick="setBlock()">
                            <span>${block}</span>
                        </button>
                    </c:otherwise>
                </c:choose>
            </article>
        </form>
    </c:forEach>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js"></script>
</main>