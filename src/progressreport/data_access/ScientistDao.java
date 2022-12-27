package progressreport.data_access;

import progressreport.Scientist;

import java.sql.SQLException;
import java.util.List;

//TODO: finish implementation
public class ScientistDao implements GenericProgressReportDao<Scientist, Integer> {

    @Override
    public List<Scientist> getAll() throws SQLException {
        return null;
    }

    @Override
    public Scientist findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void insert(Scientist scientist) throws SQLException {

    }

    @Override
    public void update(Scientist scientist) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }
}
