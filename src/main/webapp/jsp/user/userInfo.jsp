<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:message bundle="${b}" key="reg.name" var="name"/>
<fmt:message bundle="${b}" key="reg.surname" var="surname"/>
<fmt:message bundle="${b}" key="reg.country" var="country"/>
<fmt:message bundle="${b}" key="reg.age" var="age"/>
<fmt:message bundle="${b}" key="reg.login" var="login"/>
<fmt:message bundle="${b}" key="profile.balance" var="balance"/>

<main class="items">
        <c:forEach var="user" items="${userInfo}">
            <form class="card register-card">
                <div class="field">
                    <label>${name}</label>
                    <input name="name" value="${user.getName()}" disabled>
                </div>
                <div class="field">
                    <label>${surname}</label>
                    <input name="surname" value="${user.getSurname()}" disabled>
                </div>
                <div class="field">
                    <label>${country}</label>
                    <input name="surname" value="${user.getCountry()}" disabled>
                </div>
                <div class="field">
                    <label>${balance}</label>
                    <input name="surname" value="${user.getBalance()}" disabled>
                </div>
                <div class="field">
                    <label>${age}</label>
                    <input name="surname" value="${user.getAge()}" disabled>
                </div>
            </form>
        </c:forEach>
</main>