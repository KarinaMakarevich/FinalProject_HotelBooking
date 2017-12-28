package by.epam.makarevich.factory;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.CommandType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
    public static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);
    public AbstractCommand initializeCommand(RequestContent requestContent){
        AbstractCommand command = null;
        try {
            String commandName = requestContent.getRequestParameters().get("command")[0];
            CommandType cmdEnum = CommandType.valueOf(commandName.toUpperCase());
            command = cmdEnum.getCommand();
            LOGGER.log(Level.INFO, "Command was gotten");
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.ERROR, "Illegal command type");
        }
        return command;
    }
}
