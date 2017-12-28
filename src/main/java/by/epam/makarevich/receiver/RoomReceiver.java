package by.epam.makarevich.receiver;

import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.request_content.RequestContent;

public interface RoomReceiver extends Receiver {
    void findRooms(RequestContent requestContent) throws ReceiverException;
}
