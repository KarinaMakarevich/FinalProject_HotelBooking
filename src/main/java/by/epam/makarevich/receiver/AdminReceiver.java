package by.epam.makarevich.receiver;

import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.request_content.RequestContent;

public interface AdminReceiver extends Receiver {

    void openIncomingApps(RequestContent requestContent) throws ReceiverException;

    void approveOrder(RequestContent requestContent) throws ReceiverException;

    void revokeOrder(RequestContent requestContent) throws ReceiverException;

    void addRoom(RequestContent requestContent) throws ReceiverException;

    void openAllApps(RequestContent requestContent) throws ReceiverException;

    void openAllUsers(RequestContent requestContent) throws ReceiverException;

    void blockUser(RequestContent requestContent) throws ReceiverException;

    void unblockUser(RequestContent requestContent) throws ReceiverException;

    void addRoomForm(RequestContent requestContent) throws ReceiverException;

    void openAddUserForm(RequestContent requestContent) throws ReceiverException;

    void addUser(RequestContent requestContent) throws ReceiverException;

    void openDeleteRoomForm(RequestContent requestContent) throws ReceiverException;

    void deleteRoom(RequestContent requestContent) throws ReceiverException;
}
