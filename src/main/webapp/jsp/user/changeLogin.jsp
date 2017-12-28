<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:message bundle="${b}" key="profile.changeLogin" var="changeLogin"/>
<fmt:message bundle="${b}" key="reg.yourLogin" var="yourLogin"/>
<fmt:message bundle="${b}" key="reg.newLogin" var="newLogin"/>
<fmt:message bundle="${b}" key="reg.login" var="login"/>
<fmt:message bundle="${b}" key="wrong.login" var="wrLogin"/>
<fmt:message bundle="${b}" key="wrong.existingLogin" var="wrExLogin"/>
<main class="items">
    <form class="card register-card" onsubmit="return validateLogin()"
          action="${pageContext.request.contextPath}/mainController?command=change_login" method="post">
        <div class="field">
            <label>${yourLogin}</label>
            <input type="text" name="oldLogin" value="${requestScope.get("userLogin")}"
                   disabled>
        </div>
        <div class="field">
            <label>${newLogin}</label>
            <input type="text" id="login" name="login" placeholder="${login}"
                   value="${requestScope.get("login")}"
                   required>
        </div>
        <c:if test="${requestScope.containsKey('wrongLogin')}">
            <div>
                <label class="wrong-info" id="wrong-login">${wrLogin}</label>
            </div>
        </c:if>
        <c:if test="${requestScope.containsKey('existingLogin')}">
            <div>
                <label class="wrong-info" id="login-exists">${wrExLogin}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-login">${wrLogin}</label>
        </div>
        <button class="button" type="submit">
            ${changeLogin}
        </button>
    </form>
</main>
<script src="${pageContext.request.contextPath}/common/js/loginSettings.js"></script>

