package by.epam.makarevich.command.common;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.Receiver;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.CommandType;
import by.epam.makarevich.util.Router;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeLocaleCommand extends AbstractCommand {
    private static final Logger LOGGER = LogManager.getLogger(ChangeLocaleCommand.class);

    public ChangeLocaleCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Router execute(RequestContent requestContent) {
        try {
            receiver.doAction(CommandType.CHANGE_LOCALE, requestContent);
            LOGGER.log(Level.INFO, "Changing locale command was successful");
        } catch (ReceiverException e) {
            LOGGER.log(Level.ERROR, "Error in change locale command: " + e.getMessage());
        }
        return new Router();
    }
}
