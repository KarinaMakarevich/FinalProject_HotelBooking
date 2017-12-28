<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'ru'}"/>
<fmt:setBundle basename="text" var="b"/>

<fmt:message bundle="${b}" key="common.addRoom" var="addRoom"/>
<fmt:message bundle="${b}" key="roomFinder.p" var="p"/>
<fmt:message bundle="${b}" key="roomFinder.wifi" var="wifi"/>
<fmt:message bundle="${b}" key="roomFinder.arrive" var="arrive"/>
<fmt:message bundle="${b}" key="roomFinder.leave" var="leave"/>

<html>
<head>
    <title>${addRoom}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/responsive.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/items/items.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/slider/input-slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/checkbox/checkbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/date/date.css">
</head>
<body>

<%@include file="header/clientAdminHeader.jsp" %>

<section class="content">

    <aside>
        <div class="card">
            <h2>${addRoom}</h2>
            <p>${p}</p>
            <hr>

            <form id="find-room-form" name="find-room-form"
                  action="${pageContext.request.contextPath}/mainController?command=add_room"
                  method="post">
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
                <div>
                    <input type="file" value = "choose file">
                </div>

                <hr>

                <button class="button add-room-button" id="add-room-button" type="submit">
                    ${addRoom}
                </button>
            </form>

        </div>
    </aside>
</section>

<%@include file="footer/footer.jsp" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/components/slider/slider.controller.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/components/checkbox/checkbox.controller.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/date/date.controller.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/main.js"></script>
</body>
</html>
