<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:message bundle="${b}" key="profile.changePassword" var="changePassword"/>
<fmt:message bundle="${b}" key="reg.yourPassword" var="yourPassword"/>
<fmt:message bundle="${b}" key="reg.newPassword" var="newPassword"/>
<fmt:message bundle="${b}" key="wrong.password" var="wrPassword"/>
<fmt:message bundle="${b}" key="wrong.oldPass" var="wrOldPassword"/>
<fmt:message bundle="${b}" key="wrong.repeatPassword" var="wrRepPassword"/>
<fmt:message bundle="${b}" key="reg.repeatPassword" var="repPassword"/>
<main class="items">
    <form class="card register-card" onsubmit="return validatePassword()"
          action="${pageContext.request.contextPath}/mainController?command=change_password" method="post">
        <div class="field">
            <label>${yourPassword}</label>
            <input type="password" id="password" name="password" placeholder="${yourPassword}"
                   value="${requestScope.get("password")}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongOldPassword')}">
            <div>
                <label class="wrong-info">${wrOldPassword}</label>
            </div>
        </c:if>
        <div class="field">
            <label>${newPassword}</label>
            <input type="password" id="newPassword" name="newPassword" placeholder="${newPassword}"
                   value="${requestScope.get("password")}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongPassword')}">
            <div>
                <label class="wrong-info" id="wrong-password">${wrPassword}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-password">${wrPassword}</label>
        </div>
        <div class="field">
            <label>${repPassword}</label>
            <input type="password" id="repeat-password" name="repeat-password" placeholder="${repPassword}"
                   value="${requestScope.get("repeat-password")}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongPasswordRepetition')}">
            <div>
                <label class="wrong-info" id="wrong-password-repetition">${wrRepPassword}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-repeat-password">${wrRepPassword}</label>
        </div>
        <button class="button" type="submit">
            ${changePassword}
        </button>
    </form>
</main>
<script src="${pageContext.request.contextPath}/common/js/passwordSettings.js"></script>

