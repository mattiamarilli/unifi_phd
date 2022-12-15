
import organizationchart.Student;
import organizationchart.data_access.*;
public class Main {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoImpl();
        studentDao.updateStudent(new Student(8222,"sssss","ssdsdsd","shshdhs"));
    }
}