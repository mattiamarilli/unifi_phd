package organizationchart.server;
import organizationchart.Student;
import organizationchart.data_access.*;

import java.sql.SQLException;

public class OrganizationChartService {

    private StudentDao studentDao;
    public OrganizationChartService() {
        studentDao = new StudentDao();
    }

    public Student getStudentById(Integer idStudent) throws SQLException {
        return studentDao.findByKey(idStudent);
    }


}
