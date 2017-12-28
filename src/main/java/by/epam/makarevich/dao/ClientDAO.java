package by.epam.makarevich.dao;

import by.epam.makarevich.constant.GeneralConstant;
import by.epam.makarevich.constant.SQLRequestConstant;
import by.epam.makarevich.entity.BusyDate;
import by.epam.makarevich.entity.Entity;
import by.epam.makarevich.entity.Order;
import by.epam.makarevich.entity.Room;
import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.type.RoomType;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO extends AbstractDAO<Entity> {
    public ArrayList<ArrayList<Entity>> findClientApps(String login) throws DAOException {
        ArrayList<ArrayList<Entity>> list;
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.FIND_CLIENT_APPS)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = getAppsInfo(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return list;
    }

    public boolean createOrder(String login, int id, Date arrivalDate, Date leavingDate, BigDecimal cost) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.CREATE_ORDER)) {
            preparedStatement.setBigDecimal(1, cost);
            preparedStatement.setDate(2, arrivalDate);
            preparedStatement.setDate(3, leavingDate);
            preparedStatement.setString(4, login);
            preparedStatement.setInt(5, id);
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public boolean cancelRoom(int id) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.CANCEL_ROOM_IN_ORDER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public ArrayList<ArrayList<Entity>> findPendingApps(String login) throws DAOException {
        ArrayList<ArrayList<Entity>> list;
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.SHOW_PENDING_APPS)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = getPendingAppsInfo(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return list;
    }

    private ArrayList<ArrayList<Entity>> getPendingAppsInfo(ResultSet resultSet) throws SQLException {
        ArrayList<ArrayList<Entity>> list = new ArrayList<>();
        while (resultSet.next()) {
            ArrayList<Entity> entity = new ArrayList<>();
            Room room = new Room();
            BusyDate busyDate = new BusyDate();
            room.setCapacity(resultSet.getInt(GeneralConstant.RoomSQLConstant.ROOM_CAPACITY));
            room.setId(resultSet.getInt(GeneralConstant.OrderSQLConstant.ORDER_ID));
            room.setPrice(resultSet.getBigDecimal(GeneralConstant.OrderSQLConstant.COST));
            room.setStarCount(resultSet.getInt(GeneralConstant.RoomSQLConstant.STAR_COUNT));
            room.setType(RoomType.findByName(resultSet.getString(GeneralConstant.RoomSQLConstant.TYPE)));
            room.setWifi(resultSet.getBoolean(GeneralConstant.RoomSQLConstant.WIFI));
            room.setDescription(resultSet.getString(GeneralConstant.RoomSQLConstant.DESCRIPTION));
            entity.add(room);
            busyDate.setArrivalTime(resultSet.getDate(GeneralConstant.BusyDateSQLConstant.ARRIVAL_TIME));
            busyDate.setReleaseDate(resultSet.getDate(GeneralConstant.BusyDateSQLConstant.RELEASE_TIME));
            entity.add(busyDate);
            list.add(entity);
        }
        return list;
    }

    private ArrayList<ArrayList<Entity>> getAppsInfo(ResultSet resultSet) throws SQLException {
        ArrayList<ArrayList<Entity>> list = new ArrayList<>();
        while (resultSet.next()) {
            ArrayList<Entity> entity = new ArrayList<>();
            Room room = new Room();
            BusyDate busyDate = new BusyDate();
            Order order = new Order();
            room.setCapacity(resultSet.getInt(GeneralConstant.RoomSQLConstant.ROOM_CAPACITY));
            room.setId(resultSet.getInt(GeneralConstant.OrderSQLConstant.ORDER_ID));
            room.setPrice(resultSet.getBigDecimal(GeneralConstant.OrderSQLConstant.COST));
            room.setStarCount(resultSet.getInt(GeneralConstant.RoomSQLConstant.STAR_COUNT));
            room.setType(RoomType.findByName(resultSet.getString(GeneralConstant.RoomSQLConstant.TYPE)));
            room.setWifi(resultSet.getBoolean(GeneralConstant.RoomSQLConstant.WIFI));
            room.setDescription(resultSet.getString(GeneralConstant.RoomSQLConstant.DESCRIPTION));
            entity.add(room);
            busyDate.setArrivalTime(resultSet.getDate(GeneralConstant.BusyDateSQLConstant.ARRIVAL_TIME));
            busyDate.setReleaseDate(resultSet.getDate(GeneralConstant.BusyDateSQLConstant.RELEASE_TIME));
            entity.add(busyDate);
            order.setApproved(resultSet.getBoolean(GeneralConstant.OrderSQLConstant.IS_APPROVED));
            order.setRejected(resultSet.getBoolean(GeneralConstant.OrderSQLConstant.IS_REJECTED));
            entity.add(order);
            list.add(entity);
        }
        return list;
    }
}
