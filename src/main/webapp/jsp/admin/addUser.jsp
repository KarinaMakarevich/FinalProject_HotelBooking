<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message bundle="${b}" key="common.signUp" var="signUp"/>

<fmt:message bundle="${b}" key="reg.name" var="name"/>
<fmt:message bundle="${b}" key="reg.surname" var="surname"/>
<fmt:message bundle="${b}" key="reg.country" var="country"/>
<fmt:message bundle="${b}" key="reg.age" var="age"/>
<fmt:message bundle="${b}" key="reg.mail" var="mail"/>
<fmt:message bundle="${b}" key="reg.login" var="login"/>
<fmt:message bundle="${b}" key="reg.password" var="password"/>
<fmt:message bundle="${b}" key="reg.repeatPassword" var="repPassword"/>
<fmt:message bundle="${b}" key="profile.client" var="client"/>
<fmt:message bundle="${b}" key="room.type" var="type"/>

<fmt:message bundle="${b}" key="wrong.name" var="wrName"/>
<fmt:message bundle="${b}" key="wrong.surname" var="wrSurname"/>
<fmt:message bundle="${b}" key="wrong.country" var="wrCountry"/>
<fmt:message bundle="${b}" key="wrong.age" var="wrAge"/>
<fmt:message bundle="${b}" key="wrong.email" var="wrEmail"/>
<fmt:message bundle="${b}" key="wrong.existingEmail" var="wrExEmail"/>
<fmt:message bundle="${b}" key="wrong.login" var="wrLogin"/>
<fmt:message bundle="${b}" key="wrong.existingLogin" var="wrExLogin"/>
<fmt:message bundle="${b}" key="wrong.password" var="wrPassword"/>
<fmt:message bundle="${b}" key="wrong.repeatPassword" var="wrRepPassword"/>
<section class="content register-content">

    <form class="card register-card" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/mainController" method="post"
          id="register-form">
        <div class="field">
            <input type="hidden" name="command" value="add_user">
        </div>
        <div class="field">
            <label class="required">${name}</label>
            <input type="text" id="name" name="name" placeholder="${name}" value="${requestScope.get("name")}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongName')}">
            <div>
                <label class="wrong-info" id="wrong-name">${wrName}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-name">${wrName}</label>
        </div>
        <div class="field">
            <label class="required">${surname}</label>
            <input type="text" id="surname" name="surname" placeholder="${surname}"
                   value="${requestScope.get("surname")}"
                   required>
        </div>
        <c:if test="${requestScope.containsKey('wrongSurname')}">
            <div>
                <label class="wrong-info" id="wrong-surname">${wrSurname}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-surname">${wrSurname}</label>
        </div>
        <div class="field">
            <label class="required">${country}</label>
            <input type="text" id="country" name="country" placeholder="${country}"
                   value="${requestScope.get("country")}"
                   required>
        </div>
        <c:if test="${requestScope.containsKey('wrongCountry')}">
            <div>
                <label class="wrong-info" id="wrong-country">${wrCountry}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-country">${wrCountry}</label>
        </div>
        <div class="field">
            <label class="required">${age}</label>
            <input type="text" name="age" placeholder="${age}" id="age" value="${requestScope.get("age")}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongAge')}">
            <div>
                <label class="wrong-info" id="wrong-age">${wrAge}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-age">${wrAge}</label>
        </div>
        <div class="field">
            <label class="required">${mail}</label>
            <input type="text" id="mail" name="mail" placeholder="${mail}"
                   value="${requestScope.get("mail")}" required>
            <input type=hidden name="wrong_mail" placeholder="${wrEmail}">
        </div>
        <c:if test="${requestScope.containsKey('wrongEmail')}">
            <div>
                <label class="wrong-info" id="wrong-email">${wrEmail}</label>
            </div>
        </c:if>
        <c:if test="${requestScope.containsKey('existingEmail')}">
            <div>
                <label class="wrong-info" id="existing-email">${wrExEmail}</label>
            </div>
        </c:if>
        <div>
            <label class="wrong-info" id="incorrect-email">${wrEmail}</label>
        </div>
        <div class="field">
            <label class="required">${login}</label>
            <input type="text" id="login" name="login" placeholder="${login}" value="${requestScope.get("login")}"
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
        <div class="field">
            <label class="required">${password}</label>
            <input type="password" id="password" name="password" placeholder="${password}"
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
            <label class="required">${repPassword}</label>
            <input type="password" id="repeat-password" name="repeat-password" placeholder="${repPassword}"
                   value="${requestScope.get("repeat-password")}" required>
        </div>
        <c:if test="${requestScope.containsKey('wrongPasswordRepetition')}">
            <div>
                <label class="wrong-info" id="wrong-password-repetition">${wrRepPassword}</label>
            </div>
        </c:if>
        <div class="inner-field" style="margin-bottom: 12px">
            <label class="required">${type}</label>
            <select name="selectRole">
                <option value="admin">${admin}</option>
                <option value="client">${client}</option>
            </select>
        </div>
        <div>
            <label class="wrong-info" id="incorrect-repeat-password">${wrRepPassword}</label>
        </div>
        <button class="button" type="submit">${addUser}</button>
    </form>

</section>
<script src="${pageContext.request.contextPath}/common/js/signUp.js"></script>