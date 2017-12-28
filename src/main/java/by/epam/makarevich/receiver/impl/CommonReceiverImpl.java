package by.epam.makarevich.receiver.impl;

import by.epam.makarevich.dao.RoomDAO;
import by.epam.makarevich.dao.TransactionManager;
import by.epam.makarevich.entity.Room;
import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.CommonReceiver;
import by.epam.makarevich.request_content.RequestContent;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.epam.makarevich.constant.GeneralConstant.FooterConstant;
import static by.epam.makarevich.constant.GeneralConstant.RoomSQLConstant;

public class CommonReceiverImpl implements CommonReceiver {
    private static final Logger LOGGER = LogManager.getLogger(CommonReceiverImpl.class);

    @Override
    public void openMainPage(RequestContent requestContent) throws ReceiverException {
        TransactionManager transactionManager = new TransactionManager();
        try {
            RoomDAO roomDAO = new RoomDAO();
            transactionManager.beginTransaction(roomDAO);
            List<Room> rooms = roomDAO.showAllRooms();
            requestContent.getRequestAttributes().put(RoomSQLConstant.ALL_ROOMS, rooms);
            transactionManager.commit();
            LOGGER.log(Level.INFO, "Rooms were found successfully");
        } catch (DAOException e) {
            transactionManager.rollback();
            throw new ReceiverException(e.getMessage());
        }
    }

    @Override
    public void changeLocale(RequestContent requestContent) throws ReceiverException {
        String locale = requestContent.getRequestParameters().get(FooterConstant.LOCALE)[0];
        if (FooterConstant.EN.equals(locale)) {
            requestContent.insertSessionAttributes(FooterConstant.LOCALE, FooterConstant.EN.toLowerCase());
        } else {
            requestContent.insertSessionAttributes(FooterConstant.LOCALE, FooterConstant.RU.toLowerCase());
        }
        JsonObject object = new JsonObject();
        requestContent.setJsonObject(object);
    }
}
