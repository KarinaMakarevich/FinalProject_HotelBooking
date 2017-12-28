package by.epam.makarevich.dao;

import by.epam.makarevich.exception.DAOException;
import by.epam.makarevich.pool.ConnectionPool;
import by.epam.makarevich.pool.ProxyConnection;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class TransactionManager implements AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(TransactionManager.class);
    private ProxyConnection proxyConnection = ConnectionPool.getInstance().takeConnection();

    public void beginTransaction(AbstractDAO dao, AbstractDAO... daos) {
        try {
            proxyConnection.setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Can't do autoCommit: " + e);
        }
        dao.setConnection(proxyConnection);
        for (AbstractDAO d : daos) {
            d.setConnection(proxyConnection);
        }
    }

    public void endTransaction() {
        try {
            proxyConnection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Can't finish transaction", e);
        }
        LOGGER.log(Level.INFO, "Transaction has been end.");
        ConnectionPool.getInstance().returnConnection(proxyConnection);
    }

    public void rollback() {
        try {
            this.proxyConnection.rollback();
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Can't rollback transaction: " + e);
        }
    }

    public void commit() {
        try {
            proxyConnection.commit();
            LOGGER.log(Level.INFO, "Commit was successful");
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Error with commit");
        }
    }

    @Override
    public void close() throws DAOException {
        if (proxyConnection != null) {
            try {
                proxyConnection.close();
                LOGGER.log(Level.INFO, "Connection was closed successfully");
                proxyConnection = null;
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }
    }
}