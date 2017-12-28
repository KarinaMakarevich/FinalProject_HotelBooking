package by.epam.makarevich.command.user;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.constant.GeneralConstant.CommonPageConstant;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.Receiver;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.CommandType;
import by.epam.makarevich.type.RouterType;
import by.epam.makarevich.util.Router;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogOutCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(LogOutCommand.class);

    public LogOutCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.LOG_OUT, requestContent);
            router.setPath(CommonPageConstant.INDEX_PAGE);
            router.setType(RouterType.REDIRECT);
            requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, CommonPageConstant.INDEX_PAGE);
            LOGGER.log(Level.INFO, "Log out command was successful");
        } catch (ReceiverException e) {
            router.setPath(CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error in log out command: " + e.getMessage());
        }
        return router;
    }
}
