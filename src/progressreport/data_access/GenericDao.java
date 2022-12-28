package progressreport.data_access;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T, K> {

    List<T> getAll() throws SQLException;

    T findByKey(K k) throws SQLException;

    Boolean insert(T t) throws SQLException;

    Boolean update(T t) throws SQLException;

    Boolean delete(K k) throws SQLException;

}
