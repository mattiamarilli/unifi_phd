package organizationchart.data_access;
import organizationchart.Cycle;

import java.sql.SQLException;
import java.util.List;

public interface CycleDao {
        List<Cycle> getAllCycle() throws SQLException;
        Cycle getCycle(Integer number) throws SQLException;
        Boolean insertCycle(Cycle cycle) throws SQLException;
        Boolean updateCycle(Cycle cycle) throws SQLException;
        Boolean deleteCycle(Integer number) throws SQLException;
}
