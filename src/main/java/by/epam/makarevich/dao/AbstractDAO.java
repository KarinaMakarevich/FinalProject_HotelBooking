package by.epam.makarevich.dao;

import by.epam.makarevich.entity.Entity;
import by.epam.makarevich.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDAO<T extends Entity> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);
    protected final int successfulNumber = 1;
    ProxyConnection proxyConnection;

    public void setConnection(ProxyConnection proxyConnection) {
        this.proxyConnection = proxyConnection;
    }

}
