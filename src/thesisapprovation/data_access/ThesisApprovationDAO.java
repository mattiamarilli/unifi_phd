package thesisapprovation.data_access;

import java.sql.SQLException;
import java.util.List;

public interface ThesisApprovationDAO<T, K>{

    List<T> getAll() throws SQLException;

    T findByKey(K k) throws SQLException;

    void insert(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(K k) throws SQLException;


}
