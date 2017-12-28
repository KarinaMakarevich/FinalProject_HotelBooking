package by.epam.makarevich.command.user;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.constant.GeneralConstant.CommonPageConstant;
import by.epam.makarevich.constant.GeneralConstant.UserPageConstant;
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

public class SignInCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(SignInCommand.class);

    public SignInCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.SIGN_IN, requestContent);
            Set<String> set = requestContent.getRequestAttributes().keySet();
            if (set.contains(UserPageConstant.NON_EXISTING_LOGIN) || set.contains(UserPageConstant.WRONG_PASSWORD) ||
                    set.contains(UserPageConstant.IS_BLOCKED) || set.contains(UserPageConstant.IS_NOT_AUTHORIZED)) {
                router.setPath(CommonPageConstant.SIGN_IN_PAGE);
                router.setType(RouterType.FORWARD);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, CommonPageConstant.SIGN_IN_PAGE);
            } else {
                router.setPath(CommonPageConstant.INDEX_PAGE);
                router.setType(RouterType.REDIRECT);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, CommonPageConstant.INDEX_PAGE);
                LOGGER.log(Level.INFO, "Sign in command was successful");
            }
        } catch (ReceiverException e) {
            router.setPath(CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error in sign in " + e.getMessage());
        }
        return router;
    }
}
