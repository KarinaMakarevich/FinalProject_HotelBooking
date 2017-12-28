package by.epam.makarevich.receiver.impl;

import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.dao.ClientDAO;
import by.epam.makarevich.dao.RoomDAO;
import by.epam.makarevich.dao.TransactionManager;
import by.epam.makarevich.entity.Entity;
import by.epam.makarevich.entity.Room;
import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.exception.ReceiverException;
import by.epam.makarevich.receiver.ClientReceiver;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.util.DateFormatter;
import by.epam.makarevich.util.RoleChecker;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ClientReceiverImpl implements ClientReceiver {
    private static final Logger LOGGER = LogManager.getLogger(ClientReceiverImpl.class);

    @Override
    public void openClientApplications(RequestContent requestContent) throws ReceiverException {
        new RoleChecker().checkRole(requestContent);
        String login = requestContent.getSessionAttributes().get(GeneralConstant.UserPageConstant.LOGIN).toString();
        TransactionManager transactionManager = new TransactionManager();
        try {
            ClientDAO clientDAO = new ClientDAO();
            transactionManager.beginTransaction(clientDAO);
            ArrayList<ArrayList<Entity>> list = clientDAO.findClientApps(login);
            requestContent.getRequestAttributes().put(GeneralConstant.ClientUserPageConstant.ALL_APPS, list);
        } catch (DAOException e) {
            transactionManager.rollback();
            throw new ReceiverException(e.getMessage());
        } finally {
            transactionManager.endTransaction();
        }
    }

    @Override
    public void bookRoom(RequestContent requestContent) throws ReceiverException {
        new RoleChecker().checkRole(requestContent);
        int id = Integer.parseInt(requestContent.getRequestParameters().get(GeneralConstant.RoomPageConstant.ID)[0]);
        String arrivalTime = requestContent.getRequestParameters().get(GeneralConstant.RoomPageConstant.ARRIVAL_TIME)[0];
        String leavingTime = requestContent.getRequestParameters().get(GeneralConstant.RoomPageConstant.LEAVING_TIME)[0];
        DateFormatter dateFormatter = new DateFormatter();
        Date arrivalDate = dateFormatter.getDate(arrivalTime);
        Date leavingDate = dateFormatter.getDate(leavingTime);
        String cost = requestContent.getRequestParameters().get(GeneralConstant.OrderSQLConstant.COST)[0];
        String login = requestContent.getSessionAttributes().get(GeneralConstant.UserPageConstant.LOGIN).toString();
        TransactionManager transactionManager = new TransactionManager();
        try {
            ClientDAO clientDAO = new ClientDAO();
            RoomDAO roomDAO = new RoomDAO();
            transactionManager.beginTransaction(clientDAO, roomDAO);
            if (clientDAO.createOrder(login, id, arrivalDate, leavingDate, new BigDecimal(cost))) {
                transactionManager.commit();
                List<Room> rooms = roomDAO.showAllRooms();
                transactionManager.commit();
                requestContent.getRequestAttributes().put(GeneralConstant.RoomSQLConstant.ALL_ROOMS, rooms);
                LOGGER.log(Level.INFO, "Order was created successfully");
            }
        } catch (DAOException e) {
            transactionManager.rollback();
            throw new ReceiverException(e.getMessage());
        } finally {
            transactionManager.endTransaction();
        }
    }


    @Override
    public void cancelRoom(RequestContent requestContent) throws ReceiverException {
        new RoleChecker().checkRole(requestContent);
        int id = Integer.parseInt(requestContent.getRequestParameters().get(GeneralConstant.RoomPageConstant.ID)[0]);
        String login = requestContent.getSessionAttributes().get(GeneralConstant.UserPageConstant.LOGIN).toString();
        TransactionManager transactionManager = new TransactionManager();
        try {
            ClientDAO clientDAO = new ClientDAO();
            transactionManager.beginTransaction(clientDAO);
            if (clientDAO.cancelRoom(id)) {
                ArrayList<ArrayList<Entity>> list = clientDAO.findClientApps(login);
                requestContent.getRequestAttributes().put(GeneralConstant.ClientUserPageConstant.ALL_APPS, list);
                transactionManager.commit();
                LOGGER.log(Level.INFO, "Room in order was deleted successfully");
            } else {
                transactionManager.rollback();
            }
        } catch (DAOException e) {
            throw new ReceiverException(e.getMessage());
        } finally {
            transactionManager.endTransaction();
        }
    }

    @Override
    public void openClientPendingApplications(RequestContent requestContent) throws ReceiverException {
        new RoleChecker().checkRole(requestContent);
        String login = requestContent.getSessionAttributes().get(GeneralConstant.UserPageConstant.LOGIN).toString();
        TransactionManager transactionManager = new TransactionManager();
        try {
            ClientDAO clientDAO = new ClientDAO();
            transactionManager.beginTransaction(clientDAO);
            ArrayList<ArrayList<Entity>> list = clientDAO.findPendingApps(login);
            transactionManager.commit();
            requestContent.getRequestAttributes().put(GeneralConstant.ClientUserPageConstant.PENDING_APPS, list);
        } catch (DAOException e) {
            transactionManager.rollback();
            throw new ReceiverException(e.getMessage());
        } finally {
            transactionManager.endTransaction();
        }
    }
}
