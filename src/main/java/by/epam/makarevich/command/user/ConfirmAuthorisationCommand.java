package by.epam.makarevich.command.user;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.Receiver;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.CommandType;
import by.epam.makarevich.type.RouterType;
import by.epam.makarevich.util.Router;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ConfirmAuthorisationCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(ConfirmAuthorisationCommand.class);

    public ConfirmAuthorisationCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.CONFIRM_AUTHORISATION, requestContent);
            Set<String> set = requestContent.getRequestAttributes().keySet();
            if (set.contains(GeneralConstant.UserPageConstant.NON_EXISTING_EMAIL)) {
                router.setPath(GeneralConstant.CommonPageConstant.AUTHORISATION);
                router.setType(RouterType.FORWARD);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, GeneralConstant.CommonPageConstant.AUTHORISATION);
            } else {
                router.setPath(GeneralConstant.CommonPageConstant.AFTER_SIGN_UP_PAGE);
                router.setType(RouterType.REDIRECT);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, GeneralConstant.CommonPageConstant.AFTER_SIGN_UP_PAGE);
                LOGGER.log(Level.INFO, "Confirm authorisation command was successful");
            }
        } catch (ReceiverException e) {
            router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error in confirm mail command: " + e.getMessage());
        }
        return router;
    }
}
