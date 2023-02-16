package organizationchart.server;
import organizationchart.Cycle;
import organizationchart.Student;
import organizationchart.data_access.*;

import java.sql.SQLException;
import java.util.List;

public class OrganizationChartService {

    private StudentDao studentDao;
    public OrganizationChartService() {
        studentDao = new StudentDao();
    }

    //METODI DI StudentDao

    //TODO: quando viene inserito o cancellato uno studente deve essere cancellato anche negli altri microservizi?

    //inserimento student
    public void insertStudent(Integer studentFreshman, String name, String surname, String email, String password, String topics, String numberCycle) throws SQLException{
        Cycle c = new Cycle(numberCycle);
        Student s = new Student(studentFreshman, name, surname, email, password, topics, c, 1);
        studentDao.insert(s);
    }

    //update student profile
    public void updateStudent(Integer studentFreshman, String name, String surname, String email, String topics) throws SQLException{
        Student s = new Student(studentFreshman, name, surname, email, topics);
        studentDao.update(s);
    }

    //update student password
    public void updateStudentPassword(Integer studentFreshman, String password) throws SQLException{
        studentDao.updatePassword(studentFreshman, password);
    }

    //update student advisor
    public void updateStudentAdvisor(Integer studentFreshman, Integer advisorFreshman) throws SQLException{
        studentDao.updateAdvisor(studentFreshman, advisorFreshman);
    }

    //update student year (usato quando lo studente viene passato all'anno successivo)
    public void updateStudentYear(Integer studentFreshman, Integer year) throws SQLException{
        studentDao.updateYear(studentFreshman, year);

        if(year == 3){
            //TODO: inserire nel microservizio della tesi
        }
    }

    //delete student
    public void deleteStudent(Integer studentFreshman) throws SQLException{
        studentDao.delete(studentFreshman);
    }

    //get all students
    public List<Student> getAllStudents() throws SQLException{
        return studentDao.getAll();
    }

    //gets student by freshman
    public Student getStudentByFreshman(Integer studentFreshman) throws SQLException {
        return studentDao.findByKey(studentFreshman);
    }

    //get all students by year
    public List<Student> getStudentsByYear(Integer year) throws SQLException{
        return studentDao.getStudentsByYear(year);
    }

}
