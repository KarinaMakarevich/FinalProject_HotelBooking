<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:message bundle="${b}" key="common.language" var="lang"/>
<fmt:message bundle="${b}" key="footer.copyRights" var="copy"/>

<footer class="footer">
    <div class="copyrights">
        <p>${copy}</p>
    </div>
</footer>