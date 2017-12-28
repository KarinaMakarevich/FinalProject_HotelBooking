package by.epam.makarevich.dao;

import by.epam.makarevich.constant.SQLRequestConstant;
import by.epam.makarevich.entity.*;
import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.type.RoomType;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static by.epam.makarevich.constant.GeneralConstant.BusyDateSQLConstant.ARRIVAL_TIME;
import static by.epam.makarevich.constant.GeneralConstant.BusyDateSQLConstant.RELEASE_TIME;
import static by.epam.makarevich.constant.GeneralConstant.OrderSQLConstant.*;
import static by.epam.makarevich.constant.GeneralConstant.RoomSQLConstant.*;
import static by.epam.makarevich.constant.GeneralConstant.UserPageConstant.LOGIN;
import static by.epam.makarevich.constant.GeneralConstant.UserSQLConstant.BALANCE;
import static by.epam.makarevich.constant.GeneralConstant.UserSQLConstant.IS_BLOCKED;

public class AdminDAO extends AbstractDAO<Entity> {
    public ArrayList<ArrayList<Entity>> findIncomingApps() throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.FIND_INCOMING_APPS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return getIncomingAppsInfo(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public boolean approveOrder(String order_id) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.APPROVE_ORDER)) {
            preparedStatement.setString(1, order_id);
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public boolean deductFromBalance(String login, BigDecimal cost) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.DEDUCT_FROM_BALANCE)) {
            preparedStatement.setString(1, login);
            preparedStatement.setBigDecimal(2, cost);
            preparedStatement.setString(3, login);
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public boolean revokeOrder(String order_id) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.REVOKE_ORDER)) {
            preparedStatement.setString(1, order_id);
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public ArrayList<ArrayList<Entity>> findAllApps() throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.SHOW_ALL_APPS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return getAllAppsInfo(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public ArrayList<User> findAllUsers() throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.SHOW_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<User> list = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setLogin(resultSet.getString(LOGIN));
                user.setBalance(resultSet.getBigDecimal(BALANCE));
                user.setBlocked(resultSet.getBoolean(IS_BLOCKED));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public boolean blockUnblockUser(String login, boolean isToBlock) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.BLOCK_UNBLOCK_USER)) {
            preparedStatement.setBoolean(1, isToBlock);
            preparedStatement.setString(2, login);
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }


    public boolean createRoom(Room room) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.CREATE_ROOM)) {
            preparedStatement.setInt(1, room.getCapacity());
            preparedStatement.setBigDecimal(2, room.getPrice());
            preparedStatement.setBoolean(3, room.isWifi());
            preparedStatement.setInt(4, room.getStarCount());
            preparedStatement.setString(5, room.getDescription());
            preparedStatement.setString(6, room.getType().getName());
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public boolean deleteRoom(int id) throws DAOException {
        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(SQLRequestConstant.DELETE_ROOM)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == successfulNumber;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    private ArrayList<ArrayList<Entity>> getIncomingAppsInfo(ResultSet resultSet) throws SQLException {
        ArrayList<ArrayList<Entity>> list = new ArrayList<>();
        while (resultSet.next()) {
            ArrayList<Entity> entity = new ArrayList<>();
            Room room = new Room();
            room.setCapacity(resultSet.getInt(ROOM_CAPACITY));
            room.setType(RoomType.findByName(resultSet.getString(TYPE)));
            room.setDescription(resultSet.getString(DESCRIPTION));
            room.setPrice(resultSet.getBigDecimal(COST));
            room.setStarCount(resultSet.getInt(STAR_COUNT));
            room.setWifi(resultSet.getBoolean(WIFI));
            entity.add(room);
            BusyDate busyDate = new BusyDate();
            busyDate.setArrivalTime(resultSet.getDate(ARRIVAL_TIME));
            busyDate.setReleaseDate(resultSet.getDate(RELEASE_TIME));
            entity.add(busyDate);
            User user = new User();
            user.setLogin(resultSet.getString(LOGIN));
            user.setBalance(resultSet.getBigDecimal(BALANCE));
            entity.add(user);
            Order order = new Order();
            order.setId(resultSet.getInt(ORDER_ID));
            entity.add(order);
            list.add(entity);
        }
        return list;
    }

    private ArrayList<ArrayList<Entity>> getAllAppsInfo(ResultSet resultSet) throws SQLException {
        ArrayList<ArrayList<Entity>> list = new ArrayList<>();
        while (resultSet.next()) {
            ArrayList<Entity> entities = new ArrayList<>();
            Room room = new Room();
            room.setCapacity(resultSet.getInt(ROOM_CAPACITY));
            room.setType(RoomType.findByName(resultSet.getString(TYPE)));
            room.setDescription(resultSet.getString(DESCRIPTION));
            room.setPrice(resultSet.getBigDecimal(COST));
            room.setStarCount(resultSet.getInt(STAR_COUNT));
            room.setWifi(resultSet.getBoolean(WIFI));
            entities.add(room);
            BusyDate busyDate = new BusyDate();//1
            busyDate.setArrivalTime(resultSet.getDate(ARRIVAL_TIME));
            busyDate.setReleaseDate(resultSet.getDate(RELEASE_TIME));
            entities.add(busyDate);
            User user = new User();//2
            user.setLogin(resultSet.getString(LOGIN));
            user.setBalance(resultSet.getBigDecimal(BALANCE));
            entities.add(user);
            Order order = new Order();//3
            order.setApproved(resultSet.getBoolean(IS_APPROVED));
            order.setRejected(resultSet.getBoolean(IS_REJECTED));
            order.setId(resultSet.getInt(ORDER_ID));
            entities.add(order);
            list.add(entities);
        }
        return list;
    }
}
