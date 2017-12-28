<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:message bundle="${b}" key="profile.addRoom" var="addRoom"/>
<fmt:message bundle="${b}" key="room.balcony" var="balcony"/>
<fmt:message bundle="${b}" key="room.duplex" var="duplex"/>
<fmt:message bundle="${b}" key="room.standard" var="standard"/>
<fmt:message bundle="${b}" key="room.studio" var="studio"/>
<fmt:message bundle="${b}" key="room.suit" var="suit"/>
<fmt:message bundle="${b}" key="roomFinder.wifi" var="wifi"/>
<fmt:message bundle="${b}" key="room.miniSuit" var="miniSuit"/>
<fmt:message bundle="${b}" key="room.description" var="description"/>
<fmt:message bundle="${b}" key="room.type" var="type"/>
<main class="items">
    <div class="card">
        <form id="find-room-form" name="find-room-form"
              action="${pageContext.request.contextPath}/mainController?command=add_room" method="post">
            <div class="slider-group-container">
                <div class="slider-item slider-rooms-group" data-id="0">
                    <div class="slider-item-title"><i class="fa fa-bed" aria-hidden="true"></i></div>
                    <input class="slider-in" name="rooms-number" id="slider-rooms" type="range" min="1" max="5"
                           value="${requestScope.get("beds")}" step="1">
                    <output class="slider-out" for="slider-rooms">${requestScope.get("beds")}</output>
                </div>

                <div class="slider-item slider-class-group" data-id="1">
                    <div class="slider-item-title"><i class="fa fa-star" aria-hidden="true"></i></div>
                    <input class="slider-in" name="stars-number" id="slider-class" type="range" min="1" max="5"
                           value="${requestScope.get("stars")}" step="1">
                    <output class="slider-out" for="slider-class">${requestScope.get("stars")}</output>
                </div>

                <div class="slider-item slider-price-group" data-id="2">
                    <div class="slider-item-title"><i class="fa fa-money" aria-hidden="true"></i></div>
                    <input class="slider-in" name="price-number" id="slider-price" type="range" min="100"
                           max="1000" value="${requestScope.get("price")}" step="100">
                    <output class="slider-out" for="slider-price">${requestScope.get("price")}</output>
                </div>
            </div>

            <div class="wifi-group-container">
                <div class="wifi-title">${wifi}</div>
                <div class="checkbox-wifi">
                    <c:choose>
                        <c:when test="${requestScope.get('wifi')==null}">
                            <input type="checkbox" name="wifi-number" id="checkbox-wifi-input">
                        </c:when>
                        <c:when test="${requestScope.get('wifi')==false}">
                            <input type="checkbox" name="wifi-number" id="checkbox-wifi-input">
                        </c:when>
                        <c:when test="${requestScope.get('wifi')==true}">
                            <input type="checkbox" name="wifi-number" id="checkbox-wifi-input" checked>
                        </c:when>
                    </c:choose>
                    <label for="checkbox-wifi-input"></label>
                </div>
            </div>

            <div class="inner-field" style="margin-bottom: 12px;">
                <label>${type}</label>
                <select name="type">
                    <option value="Комната с балконом">${balcony}</option>
                    <option value="Дюплекс">${duplex}</option>
                    <option value="Стандарт">${standard}</option>
                    <option value="Студия">${studio}</option>
                    <option value="Номер повышенной комфортности">${suit}</option>
                    <option value="Номер улучшенной категории">${miniSuit}</option>
                </select>
            </div>
            <div class="inner-field">
                <label>${description}</label>
                <input type="text" maxlength="60" name="description" value="${requestScope.get("description")}"
                       required>
            </div>
            <hr>
            <button class="button find-room-button" id="find-room-button" type="submit">
                ${addRoom}
            </button>
        </form>
    </div>
</main>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/slider/slider.controller.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/components/checkbox/checkbox.controller.js"></script>
<script src="${pageContext.request.contextPath}/common/js/addRoom.js"></script>

