package by.epam.makarevich.receiver;

import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.CommandType;

public interface Receiver {
    default void doAction(CommandType commandType, RequestContent requestContent) throws ReceiverException {
        commandType.doReceiver(requestContent);
    }
}
