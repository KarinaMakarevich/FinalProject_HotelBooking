<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:message bundle="${b}" key="profile.sum" var="sum"/>
<fmt:message bundle="${b}" key="wrong.money" var="wrMoney"/>
<fmt:message bundle="${b}" key="profile.topUpBalance" var="topUpBalance"/>
<fmt:message bundle="${b}" key="profile.card" var="card"/>

<main class="items">
    <form class="card register-card" onsubmit="return validateBalance()"
          action="${pageContext.request.contextPath}/mainController?command=top_up_balance" method="post">
        <div class="inner-field" style="margin-bottom: 16px">
            <label>${sum}</label>
            <input type="text" id="balance" name="balance" required>
        </div>
        <div>
            <label class="wrong-info" id="incorrect-balance">${wrMoney}</label>
        </div>
        <div class="inner-field" style="margin-bottom: 16px">
            <label>${card}</label>
            <select>
                <option value="Visa">Visa</option>
                <option value="MasterCard">MasterCard</option>
                <option value="Priorbank">Priorbank</option>
            </select>
        </div>
        <button class="button" type="submit">
            ${topUpBalance}
        </button>
    </form>
</main>
<script src="${pageContext.request.contextPath}/common/js/balanceSetting.js"></script>
