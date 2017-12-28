<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message bundle="${b}" key="admin.deleteRoom" var="deleteRoom"/>
<main class="items">
    <%--@elvariable id="allApps" type="java.util.List"--%>
    <c:forEach var="entity" items="${allRooms}">
        <form action="${pageContext.request.contextPath}/mainController?command=delete_room"
              method="post">
            <article class="item card">
                <input type="hidden" name="room_id" value="${entity.getId()}">
                <input type="hidden" name="order_id">
                <header class="item-header">
                    <img src="https://placeimg.com/640/480/nature)">
                    <h2 class="item-title">${entity.getType().getName()}</h2>
                    <p class="item-description">${entity.getDescription()}</p>
                </header>
                <main class="item-content">
                    <ul class="item-table">
                        <li class="item-cell beds">
                            <c:forEach var="bed" begin="1" end="${entity.getCapacity()}">
                                <i class="class icon fa fa-bed" aria-hidden="true"></i>
                            </c:forEach>
                        </li>
                        <li class="item-cell class">
                            <c:forEach var="star" begin="1" end="${entity.getStarCount()}">
                                <i class="class icon fa fa-star" aria-hidden="true"></i>
                            </c:forEach>
                        </li>
                        <c:if test="${entity.isWifi() == true}">
                            <li class="item-cell wifi yes">
                                <i class="icon fa fa-wifi" aria-hidden="true"></i>
                                <span class="value">${yes}</span>
                            </li>
                        </c:if>
                        <c:if test="${entity.isWifi() == false}">
                            <li class="item-cell wifi no">
                                <i class="icon fa fa-wifi" aria-hidden="true"></i>
                                <span class="value">${no}</span>
                            </li>
                        </c:if>
                    </ul>
                </main>
                <footer class="item-footer">
                    <button class="button book-button" name="book-button" type="submit">${deleteRoom}
                    </button>
                </footer>
            </article>
        </form>
    </c:forEach>
</main>

