package by.sistech.tasksApp.utility;

import by.sistech.tasksApp.dao.DAOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connector {

    private Connection connection = null;

    public Connection getConnection() throws DAOException {
        if (connection == null) {
            try {
                Context initContext = new InitialContext();
                DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/Users");
                connection = ds.getConnection();
            } catch (NamingException | SQLException e) {
                throw new DAOException(e);
            }
        }
        return connection;
    }
}
