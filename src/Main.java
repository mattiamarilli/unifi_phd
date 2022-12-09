import organizationchart.data_access.StudentDaoImpl;
import testpackage.*;
import organizationchart.*;
public class Main {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.getAllStudent();

    }
}