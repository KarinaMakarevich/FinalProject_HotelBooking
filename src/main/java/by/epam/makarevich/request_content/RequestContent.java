package by.epam.makarevich.request_content;

import by.epam.makarevich.constant.GeneralConstant.CommonConstant;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;

public class RequestContent {
    private static final Logger LOGGER = LogManager.getLogger(RequestContent.class);
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    private JsonObject jsonObject;

    public RequestContent() {
        this.requestAttributes = new HashMap<>();
        this.requestParameters = new HashMap<>();
        this.sessionAttributes = new HashMap<>();
    }

    public HashMap<String, Object> getRequestAttributes() {
        return this.requestAttributes;
    }

    public HashMap<String, String[]> getRequestParameters() {
        return this.requestParameters;
    }

    public HashMap<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public String getUrl() {
        return this.sessionAttributes.get(CommonConstant.URL).toString();
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void extractValues(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        Enumeration<String> parameterNames = request.getParameterNames();
        Enumeration<String> sessionAttributeNames = request.getSession().getAttributeNames();
        String name;
        while (attributeNames.hasMoreElements()) {
            name = attributeNames.nextElement();
            Object attributeValue = request.getAttribute(name);
            requestAttributes.put(name, attributeValue);
        }
        LOGGER.log(Level.INFO, "Request attributes were extracted successfully");
        while (parameterNames.hasMoreElements()) {
            name = parameterNames.nextElement();
            String[] parameterValue = request.getParameterValues(name);
            requestParameters.put(name, parameterValue);
        }
        LOGGER.log(Level.INFO, "Request parameters were extracted successfully");
        while (sessionAttributeNames.hasMoreElements()) {
            name = sessionAttributeNames.nextElement();
            Object sessionAttributeValue = request.getSession().getAttribute(name);
            sessionAttributes.put(name, sessionAttributeValue);
        }
        LOGGER.log(Level.INFO, "Session attributes were extracted successfully");
    }

    public void insertValues(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration<String> sessionAttributeNames = session.getAttributeNames();
        Enumeration<String> requestAttributeNames = request.getAttributeNames();
        String name;
        while (sessionAttributeNames.hasMoreElements()) {
            name = sessionAttributeNames.nextElement();
            session.removeAttribute(name);
        }
        while (requestAttributeNames.hasMoreElements()) {
            name = requestAttributeNames.nextElement();
            request.removeAttribute(name);
        }
        requestAttributes.forEach(request::setAttribute);
        sessionAttributes.forEach((key, value) -> request.getSession().setAttribute(key, value));
    }

    public void insertSessionAttributes(String key, Object value) {
        this.sessionAttributes.put(key, value);
    }
}
