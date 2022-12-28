package progressreport.data_access;

import progressreport.Scientist;

import java.sql.SQLException;
import java.util.List;

//TODO: finish implementation
public class ScientistDao implements GenericDao<Scientist, Integer> {

    @Override
    public List<Scientist> getAll() throws SQLException {
        return null;
    }

    @Override
    public Scientist findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public Boolean insert(Scientist scientist) throws SQLException {
        return false;
    }

    @Override
    public Boolean update(Scientist scientist) throws SQLException {
        return false;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return false;
    }
}
