package by.epam.makarevich.command.admin;

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

public class UnblockUserCommand extends AbstractCommand {

    private static final Logger LOGGER = LogManager.getLogger(UnblockUserCommand.class);

    public UnblockUserCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.UNBLOCK_USER, requestContent);
            Set<String> set = requestContent.getRequestAttributes().keySet();
            if (!set.contains(GeneralConstant.ErrorConstant.ERROR)) {
                router.setPath(GeneralConstant.CommandConstant.OPEN_ALL_USERS);
                router.setType(RouterType.REDIRECT);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, GeneralConstant.CommonPageConstant.ADMIN_PROFILE);
                LOGGER.log(Level.INFO, "Unblock user command was successful");
            } else {
                router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
                router.setType(RouterType.REDIRECT);
            }
        } catch (ReceiverException e) {
            router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error with unblock user command: " + e.getMessage());
        }
        return router;
    }
}
