package AcademiaGestaoWebApi.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import AcademiaGestaoWebApi.Config.ConnectionConfig;

public abstract class Repository<T> {

    protected PreparedStatement stmt = null;

    public T select(int id) throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        try {
            List<T> objects = select(id, connection);
            ConnectionConfig.closeConnection(connection, stmt);

            if(objects == null || objects.size() <= 0){
                return null;
            }

            T object = objects.get(0);

            return object;
        } catch (Exception ex) {
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
        
    public List<T> select() throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        try {
            int id = 0;
            List<T> object = select(id, connection);
            ConnectionConfig.closeConnection(connection, stmt);
            return object;
        } catch (Exception ex) {
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    public abstract List<T> select(int id, Connection connection) throws Exception;

    public int insert(T object) throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        connection.setAutoCommit(false);

        try {
            int id = insert(object, connection);
            connection.commit();
            ConnectionConfig.closeConnection(connection, stmt);
            return id;
        } catch (Exception ex) {

            connection.rollback();
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();            
            throw new Exception(ex);
        }
    }
    
    public abstract int insert(T object, Connection connection) throws Exception;

    public boolean update(T object) throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        connection.setAutoCommit(false);

        try {
            boolean update = update(object, connection);
            connection.commit();
            ConnectionConfig.closeConnection(connection, stmt);
            return update;
        } catch (Exception ex) {

            connection.rollback();
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();            
            throw new Exception(ex);
        }
    }

    public abstract boolean update(T object, Connection connection) throws Exception;

    public boolean delete(int id) throws Exception {
        Connection connection = ConnectionConfig.getConnection();
        connection.setAutoCommit(false);
        try {
            Boolean delete = delete(id, connection);
            connection.commit();
            ConnectionConfig.closeConnection(connection, stmt);
            return delete;
        } catch (Exception ex) {
            connection.rollback();
            ConnectionConfig.closeConnection(connection, stmt);
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    public abstract boolean delete(int id, Connection connection) throws Exception;
}