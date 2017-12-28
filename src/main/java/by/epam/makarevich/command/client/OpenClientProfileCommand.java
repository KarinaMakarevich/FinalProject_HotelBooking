package by.epam.makarevich.command.client;

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

import static by.epam.makarevich.constant.GeneralConstant.CommonPageConstant;

public class OpenClientProfileCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenClientProfileCommand.class);

    public OpenClientProfileCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.OPEN_CLIENT_PROFILE, requestContent);
            Set<String> set = requestContent.getRequestAttributes().keySet();
            if (!set.contains(GeneralConstant.ErrorConstant.ERROR)) {
                router.setPath(CommonPageConstant.USER_PROFILE);
                router.setType(RouterType.FORWARD);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, CommonPageConstant.USER_PROFILE);
                LOGGER.log(Level.INFO, "Open client profile command was successful");
            } else {
                router.setPath(CommonPageConstant.ERROR_PAGE);
                router.setType(RouterType.REDIRECT);
            }
        } catch (ReceiverException e) {
            router.setPath(CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error with opening client profile: " + e.getMessage());
        }
        return router;
    }
}
