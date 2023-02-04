package organizationchart.server;
import organizationchart.Student;
import organizationchart.data_access.*;

import java.sql.SQLException;

public class OrganizationChartService {

    private StudentDaoImpl studentDao;
    public OrganizationChartService() {
        studentDao = new StudentDaoImpl();
    }

    public Student getStudentById(Integer idStudent) throws SQLException {
        return studentDao.findByKey(idStudent);
    }


}
