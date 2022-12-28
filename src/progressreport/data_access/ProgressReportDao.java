package progressreport.data_access;

import progressreport.ProgressReport;

import java.sql.SQLException;
import java.util.List;

//TODO: finish implementation
public class ProgressReportDao implements GenericDao<ProgressReport, Integer> {

    @Override
    public List<ProgressReport> getAll() throws SQLException {
        return null;
    }

    @Override
    public ProgressReport findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public Boolean insert(ProgressReport progressReport) throws SQLException {
        return false;
    }

    @Override
    public Boolean update(ProgressReport progressReport) throws SQLException {
        return false;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return false;
    }
}
