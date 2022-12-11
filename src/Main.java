
import organizationchart.data_access.*;
public class Main {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.getAllStudent();

    }
}