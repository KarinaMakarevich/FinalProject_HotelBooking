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

public class BookRoomCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(BookRoomCommand.class);

    public BookRoomCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        Router router = new Router();
        try {
            receiver.doAction(CommandType.BOOK_ROOM, requestContent);
            Set<String> set = requestContent.getRequestAttributes().keySet();
            if (!set.contains(GeneralConstant.ErrorConstant.ERROR)) {
                router.setPath(GeneralConstant.CommonPageConstant.INDEX_PAGE);
                router.setType(RouterType.REDIRECT);
                requestContent.insertSessionAttributes(GeneralConstant.CommonConstant.PREVIOUS_PAGE, GeneralConstant.CommonPageConstant.MAIN_PAGE);
                LOGGER.log(Level.INFO, "Book room command was successful");
            }
            else{
                router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
                router.setType(RouterType.REDIRECT);
            }
        } catch (ReceiverException e) {
            router.setPath(GeneralConstant.CommonPageConstant.ERROR_PAGE);
            router.setType(RouterType.FORWARD);
            LOGGER.log(Level.ERROR, "Error with book room command: " + e.getMessage());
        }
        return router;
    }
}
