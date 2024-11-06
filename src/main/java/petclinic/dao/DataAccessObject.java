package petclinic.dao;

import java.sql.SQLException;

public interface DataAccessObject<T> {
    void add(T entity) throws SQLException;
    T get(int id) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}
