package by.epam.makarevich.command.common;

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

public class OpenMainPageCommand extends AbstractCommand {

    public OpenMainPageCommand(Receiver receiver) {
        super(receiver);
    }

    private static final Logger LOGGER = LogManager.getLogger(OpenMainPageCommand.class);

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.OPEN_MAIN_PAGE, requestContent);
            router.setPath(CommonPageConstant.MAIN_PAGE);
            router.setType(RouterType.FORWARD);
            requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, CommonPageConstant.MAIN_PAGE);
            LOGGER.log(Level.INFO, "Main page is opened successfully");
        } catch (ReceiverException e) {
            router.setPath(CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error with opening main page: " + e.getMessage());
        }
        return router;
    }
}
