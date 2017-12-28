package by.epam.makarevich.receiver;

import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.request_content.RequestContent;

public interface ClientReceiver extends Receiver {
    void openClientApplications(RequestContent requestContent) throws ReceiverException;

    void bookRoom(RequestContent requestContent) throws ReceiverException;

    void cancelRoom(RequestContent requestContent) throws ReceiverException;

    void openClientPendingApplications(RequestContent requestContent) throws ReceiverException;
}
