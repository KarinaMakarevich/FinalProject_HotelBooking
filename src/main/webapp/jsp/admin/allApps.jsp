<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message bundle="${b}" key="profile.user" var="user"/>
<main class="items">
    <%--@elvariable id="allApps" type="java.util.List"--%>
    <c:forEach var="entity" items="${allApps}">
        <form action="${pageContext.request.contextPath}/mainController" onsubmit="return disableButtons()"
              method="post">
            <article class="item card" data-id=${entity.get(3).getId()}>
                <input type="hidden" name="order_id" value="${entity.get(3).getId()}">
                <header class="item-header">
                    <img src="https://placeimg.com/640/480/nature)">
                    <h2 class="item-title">${entity.get(0).getType().getName()}</h2>
                    <p class="item-description">${entity.get(0).getDescription()}</p>
                </header>
                <main class="item-content">
                    <ul class="item-table">
                        <li class="item-cell beds">
                            <c:forEach var="bed" begin="1" end="${entity.get(0).getCapacity()}">
                                <i class="class icon fa fa-bed" aria-hidden="true"></i>
                            </c:forEach>
                        </li>
                        <li class="item-cell class">
                            <c:forEach var="star" begin="1" end="${entity.get(0).getStarCount()}">
                                <i class="class icon fa fa-star" aria-hidden="true"></i>
                            </c:forEach>
                        </li>
                        <c:if test="${entity.get(0).isWifi() == true}">
                            <li class="item-cell wifi yes">
                                <i class="icon fa fa-wifi" aria-hidden="true"></i>
                                <span class="value">${yes}</span>
                            </li>
                        </c:if>
                        <c:if test="${entity.get(0).isWifi() == false}">
                            <li class="item-cell wifi no">
                                <i class="icon fa fa-wifi" aria-hidden="true"></i>
                                <span class="value">${no}</span>
                            </li>
                        </c:if>
                        <li class="item-cell price">
                            <i class="icon fa fa-money" aria-hidden="true"></i>
                            <span class="value" name="cost">${entity.get(0).getPrice()}</span>
                        </li>
                    </ul>
                </main>
                <h1>${entity.get(1).getArrivalTime()} - ${entity.get(1).getReleaseDate()}</h1>

                <h1> ${user}: ${entity.get(2).getLogin()}, ${balance}: ${entity.get(2).getBalance()}</h1>
                <c:choose>
                    <c:when test="${entity.get(3).getIsApproved() == false && entity.get(3).getIsRejected() == false}">
                        <input type="hidden" name="login" value="${entity.get(2).getLogin()}">
                        <input type="hidden" name="cost" value="${entity.get(0).getPrice()}">
                        <footer class="item-footer">
                            <input type="hidden" class="command" name="command" value="">
                            <button class="button book-button" name="book-button" type="submit"
                                    onclick="setRevoke()">
                                <span>${reject}</span>
                            </button>
                            <button class="button book-button" name="book-button" type="submit"
                                    onclick="setApprove()">
                                <span>${approve}</span>
                            </button>
                        </footer>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${entity.get(3).getIsApproved() == true}">
                                <h1>${isApproved}</h1>
                            </c:when>
                            <c:when test="${entity.get(3).getIsRejected()==true}">
                                <h1>${isRejected}</h1>
                            </c:when>
                            <c:otherwise>
                                <h1>${isInPending}</h1>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </article>
        </form>
    </c:forEach>
</main>
