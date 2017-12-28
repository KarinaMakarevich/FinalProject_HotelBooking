<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="items">
    <c:forEach var="entity" items="${pendingApps}">
        <form action="/mainController" method="post">
            <article class="item card" data-id=${entity.get(0).getId()}>
                <input type="hidden" name="id" value="${entity.get(0).getId()}">
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
                            <span class="value">${entity.get(0).getPrice()}</span>
                        </li>
                    </ul>
                </main>
                <h1>${entity.get(1).getArrivalTime()} - ${entity.get(1).getReleaseDate()}</h1>
                <h1>${isInPending}</h1>
                <footer class="item-footer">
                    <input type="hidden" name="command" value="Cancel_Room">
                    <button class="button book-button" name="book-button" type="submit">
                        <span>${cancel}</span>
                    </button>
                </footer>
            </article>
        </form>
    </c:forEach>
</main>
