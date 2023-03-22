package organizationchart.server;
import organizationchart.Cycle;
import organizationchart.FacultyMember;
import organizationchart.Student;
import organizationchart.data_access.*;
import organizationchart.proxy.OrganizationChartProxy;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class OrganizationChartService {

    final int millisecondsDelay = 5000;
    private Boolean available = true;
    private StudentDao studentDao;
    private CycleDao cycleDao;
    private FacultyMemberDao facultyMemberDao;
    private OrganizationChartProxy ocProxy;
    public OrganizationChartService() {
        this.studentDao = new StudentDao();
        this.cycleDao = new CycleDao();
        this.facultyMemberDao = new FacultyMemberDao();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public static void emulateDelay() throws InterruptedException {
        Random random = new Random();
        int number = random.nextInt(100);

        if(number <= 95)
            Thread.sleep(random.nextInt(7) + 3);
        else
            Thread.sleep(random.nextInt(20) + 20);
    }


    //METODI DI StudentDao

    //inserimento student
    public Boolean insertStudent(Integer studentFreshman, String name, String surname, String email, String password, String topics, String numberCycle) throws SQLException{
        Cycle c = new Cycle(numberCycle);
        Student s = new Student(studentFreshman, name, surname, email, password, topics, c, 1);
        Boolean result = studentDao.insert(s);

        if(result) {
            this.ocProxy = new OrganizationChartProxy();
            //inserisco lo studente anche nel microservizio del progress report
            ocProxy.insertStudentToProgressReport(studentFreshman);
            //inserisco lo studente anche nel microservizio dell'offerta didattica
            ocProxy.insertStudentToDidacticOffer(studentFreshman);
        }

        return result;

    }

    //update student profile
    public Boolean updateStudent(Integer studentFreshman, String name, String surname, String email, String topics) throws SQLException{
        Student s = new Student(studentFreshman, name, surname, email, topics);
        return studentDao.update(s);
    }

    //update student password
    public Boolean updateStudentPassword(Integer studentFreshman, String password) throws SQLException{
        return studentDao.updatePassword(studentFreshman, password);
    }

    //update student advisor (utilizzato per assegnare l'dvisor allo studente)
    public Boolean updateStudentAdvisor(Integer studentFreshman, Integer advisorFreshman) throws SQLException{
        return studentDao.updateAdvisor(studentFreshman, advisorFreshman);
    }

    //update student year (usato quando lo studente viene passato all'anno successivo)
    public Boolean updateStudentYear(Integer studentFreshman, Integer year) throws SQLException{
        Boolean result = studentDao.updateYear(studentFreshman, year);
        if(year == 3 && result){ //inserisco lo studente nel microservizio delle tesi
            this.ocProxy = new OrganizationChartProxy();
            ocProxy.insertStudentToThesisApprovation(studentFreshman);
        }
        return result;
    }

    //delete student
    public Boolean deleteStudent(Integer studentFreshman) throws SQLException{
        Boolean result = studentDao.delete(studentFreshman);
        //elimino lo studente anche negli altri microservizi
        if(result) {
            this.ocProxy = new OrganizationChartProxy();
            ocProxy.deleteStudentDidacticOffer(studentFreshman);
            ocProxy.deleteStudentProgressReport(studentFreshman);
            ocProxy.deleteStudentThesisApprovation(studentFreshman);
        }

        return result;
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

    //get all students by cycle
    public List<Student> getStudentsByCycle(String cycleNumber) throws SQLException{
        return studentDao.getStudentsByCycle(cycleNumber);
    }

    //get students by advisor
    public List<Student> getStudentsByAdvisor(Integer advisorFreshman) throws SQLException{
        return studentDao.getStudentsByAdvisor(advisorFreshman);
    }


    //METODI DI CycleDao

    //insert cycle
    public Boolean insertCycle(String cycleNumber, Integer year, String description) throws SQLException{
        Cycle c = new Cycle(cycleNumber, year, description);
        return cycleDao.insert(c);
    }

    //update cycle
    public Boolean updateCycle(String cycleNumber, Integer year, String description) throws SQLException {
        Cycle c = new Cycle(cycleNumber, year, description);
        return cycleDao.update(c);
    }

    //delete cycle
    public Boolean deleteCycle(String cycleNumber) throws SQLException{
        List<Student> students = studentDao.getStudentsByCycle(cycleNumber);
        Boolean result = cycleDao.delete(cycleNumber);

        this.ocProxy = new OrganizationChartProxy();
        //elimino gli studenti del ciclo (eliminato) anche negli altri microservizi
        for(Student s : students){
            ocProxy.deleteStudentDidacticOffer(s.getFreshman());
            ocProxy.deleteStudentProgressReport(s.getFreshman());
            ocProxy.deleteStudentThesisApprovation(s.getFreshman());
        }

        return result;
    }

    //get all cycles
    public List<Cycle> getAllCycles() throws SQLException{
        return cycleDao.getAll();
    }

    //METODI DI FacultyMembersDao

    //insert faculty member
    public Boolean insertFacultyMember(Integer freshman, String name, String surname, String email, String password, String specialization, String institution, String cycleNumber) throws SQLException{
        Cycle c = new Cycle(cycleNumber);
        FacultyMember facultyMember = new FacultyMember(freshman, name, surname, email, password, specialization, institution, c);
        return facultyMemberDao.insert(facultyMember);
    }

    //update faculty member profile
    public Boolean updateFacultyMember(Integer freshman, String name, String surname, String email, String specialization, String institution) throws SQLException{
        FacultyMember facultyMember = new FacultyMember(freshman, name, surname, email, specialization, institution);
        return facultyMemberDao.update(facultyMember);
    }

    //update faculty member password
    public Boolean updateFacultyMemberPassword(Integer fmFreshman, String password) throws SQLException{
        return facultyMemberDao.updateFacultyMemberPassword(fmFreshman, password);
    }

    //delete faculty member
    public Boolean deleteFacultyMember(Integer fmFreshman) throws SQLException{
        return facultyMemberDao.delete(fmFreshman);
    }

    public FacultyMember getFacultyMember(Integer freshman) throws SQLException{
        return facultyMemberDao.findByKey(freshman);
    }

    //get all faculty members
    public List<FacultyMember> getAllFacultyMembers() throws SQLException{
        return facultyMemberDao.getAll();
    }

}
