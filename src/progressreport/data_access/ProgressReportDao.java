package progressreport.data_access;

import progressreport.ProgressReport;

import java.sql.SQLException;
import java.util.List;

//TODO: finish implementation
public class ProgressReportDao implements GenericProgressReportDao<ProgressReport, Integer> {

    @Override
    public List<ProgressReport> getAll() throws SQLException {
        return null;
    }

    @Override
    public ProgressReport findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void insert(ProgressReport progressReport) throws SQLException {

    }

    @Override
    public void update(ProgressReport progressReport) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }
}
