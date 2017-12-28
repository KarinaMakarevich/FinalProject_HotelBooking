package by.epam.makarevich.receiver;

import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.request_content.RequestContent;

public interface CommonReceiver extends Receiver {
    void changeLocale(RequestContent requestContent) throws ReceiverException;
    void openMainPage(RequestContent requestContent) throws ReceiverException;
}
