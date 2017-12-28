package by.epam.makarevich.receiver.impl;

import by.epam.makarevich.constant.GeneralConstant.RoomPageConstant;
import by.epam.makarevich.constant.GeneralConstant.RoomSQLConstant;
import by.epam.makarevich.dao.RoomDAO;
import by.epam.makarevich.dao.TransactionManager;
import by.epam.makarevich.entity.Room;
import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.RoomReceiver;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.util.DateFormatter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class RoomReceiverImpl implements RoomReceiver {
    private static final Logger LOGGER = LogManager.getLogger(RoomReceiverImpl.class);

    @Override
    public void findRooms(RequestContent requestContent) throws ReceiverException {
        TransactionManager transactionManager = new TransactionManager();
        try {
            int beds = Integer.valueOf(requestContent.getRequestParameters().get(RoomPageConstant.BED_NUMBER)[0]);
            int stars = Integer.valueOf(requestContent.getRequestParameters().get(RoomPageConstant.STAR_NUMBER)[0]);
            int price = Integer.valueOf(requestContent.getRequestParameters().get(RoomPageConstant.PRICE_NUMBER)[0]);
            boolean wifi = requestContent.getRequestParameters().get(RoomPageConstant.WIFI) != null;
            String arrivalTime = requestContent.getRequestParameters().get(RoomPageConstant.ARRIVING_DATE)[0];
            String leavingTime = requestContent.getRequestParameters().get(RoomPageConstant.LEAVING_DATE)[0];
            DateFormatter dateFormatter = new DateFormatter();
            Date arrivalDate = dateFormatter.getDate(arrivalTime);
            Date leavingDate = dateFormatter.getDate(leavingTime);
            RoomDAO roomDAO = new RoomDAO();
            transactionManager.beginTransaction(roomDAO);
            List<Room> rooms = roomDAO.findRooms(beds, stars, price, wifi, arrivalDate, leavingDate);
            requestContent.getRequestAttributes().put(RoomPageConstant.BED, beds);
            requestContent.getRequestAttributes().put(RoomPageConstant.STAR, stars);
            requestContent.getRequestAttributes().put(RoomPageConstant.PRICE, price);
            requestContent.getRequestAttributes().put(RoomPageConstant.WIFI_LABEL, wifi);
            requestContent.getRequestAttributes().put(RoomPageConstant.ARRIVE, arrivalTime);
            requestContent.getRequestAttributes().put(RoomPageConstant.LEAVE, leavingTime);
            requestContent.getRequestAttributes().put(RoomPageConstant.BED_NUMBER, beds);
            requestContent.getRequestAttributes().put(RoomPageConstant.STAR_NUMBER, stars);
            requestContent.getRequestAttributes().put(RoomPageConstant.PRICE_NUMBER, price);
            requestContent.getRequestAttributes().put(RoomPageConstant.ARRIVING_DATE, arrivalTime);
            requestContent.getRequestAttributes().put(RoomPageConstant.LEAVING_DATE, leavingTime);
            requestContent.getRequestAttributes().put(RoomSQLConstant.ALL_ROOMS, rooms);
            requestContent.getRequestAttributes().put(RoomPageConstant.ARRIVAL_TIME, arrivalDate);
            requestContent.getRequestAttributes().put(RoomPageConstant.LEAVING_TIME, leavingDate);
            transactionManager.commit();
            LOGGER.log(Level.INFO, "Rooms were found successfully");
        } catch (DAOException e) {
            transactionManager.rollback();
            throw new ReceiverException(e.getMessage());
        } finally {
            transactionManager.endTransaction();
        }
    }

}
