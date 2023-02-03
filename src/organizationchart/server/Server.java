package organizationchart.server;
import organizationchart.Student;
import organizationchart.data_access.*;

import java.sql.SQLException;

public class Server {

    private StudentDaoImpl studentDao;
    public Server() {
        studentDao = new StudentDaoImpl();
    }

    public Student getStudentById(Integer idStudent) throws SQLException {
        return studentDao.findByKey(idStudent);
    }


}
