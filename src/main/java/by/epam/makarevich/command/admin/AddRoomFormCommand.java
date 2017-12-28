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

public class AddRoomFormCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddRoomFormCommand.class);

    public AddRoomFormCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.ADD_ROOM_FORM, requestContent);
            Set<String> set = requestContent.getRequestAttributes().keySet();
            if (!set.contains(GeneralConstant.ErrorConstant.ERROR)) {
                router.setPath(GeneralConstant.CommonPageConstant.ADMIN_PROFILE);
                router.setType(RouterType.FORWARD);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, GeneralConstant.CommonPageConstant.ADMIN_PROFILE);
                LOGGER.log(Level.INFO, "Open room form was successful");
            } else {
                router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
                router.setType(RouterType.REDIRECT);
            }
        } catch (ReceiverException e) {
            router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.REDIRECT);
            LOGGER.log(Level.ERROR, "Error with opening room form: " + e.getMessage());
        }
        return router;
    }
}
