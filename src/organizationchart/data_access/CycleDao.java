package organizationchart.data_access;
import organizationchart.Cycle;

import java.util.List;

public interface CycleDao {
        List<Cycle> getAllCycle();
        Cycle getCycle(int id);
        void saveCycle(Cycle cycle);
        void updateCycle(Cycle cycle);
        void deleteCycle(Cycle cycle);
}
