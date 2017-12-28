package by.epam.makarevich.receiver.impl;

import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.exception.ReceiverException;
import org.junit.Test;

public class UserReceiverImplTest {
    @Test(expected = NullPointerException.class)
    public void createNullSuitTest() throws DAOException, ReceiverException {
        new UserReceiverImpl().changePassword(null);
    }
}
