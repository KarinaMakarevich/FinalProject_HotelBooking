package by.epam.makarevich.util;

import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.request_content.RequestContent;

public class RoleChecker {
    public void checkRole(RequestContent requestContent) {
        String role = requestContent.getSessionAttributes().get(GeneralConstant.UserPageConstant.ROLE).toString();
        if (role == null) {
            requestContent.getRequestAttributes().put(GeneralConstant.ErrorConstant.ERROR, true);
        }
    }
}
