<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message bundle="${b}" key="common.language" var="lang"/>
<div class="field">
    <input type="hidden" id="locale" name="locale" value= ${lang}>
</div>
<a href="#" onclick="changeLanguage(document.querySelector('#locale'))">${lang}</a>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footer.js"></script>

