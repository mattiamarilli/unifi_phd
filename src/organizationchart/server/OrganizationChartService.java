package organizationchart.server;
import organizationchart.Cycle;
import organizationchart.FacultyMember;
import organizationchart.Student;
import organizationchart.data_access.*;
import organizationchart.proxy.OrganizationChartProxy;

import java.sql.SQLException;
import java.util.List;

public class OrganizationChartService {

    private StudentDao studentDao;
    private CycleDao cycleDao;
    private FacultyMemberDao facultyMemberDao;
    private OrganizationChartProxy ocProxy;
    public OrganizationChartService() {
        this.studentDao = new StudentDao();
        this.cycleDao = new CycleDao();
        this.facultyMemberDao = new FacultyMemberDao();
        this.ocProxy = new OrganizationChartProxy();
    }

    //METODI DI StudentDao

    //TODO: quando viene inserito o cancellato uno studente deve essere cancellato anche negli altri microservizi?

    //inserimento student
    public void insertStudent(Integer studentFreshman, String name, String surname, String email, String password, String topics, String numberCycle) throws SQLException{
        Cycle c = new Cycle(numberCycle);
        Student s = new Student(studentFreshman, name, surname, email, password, topics, c, 1);
        studentDao.insert(s);
        //inserisco lo studente anche nel microservizio del progress report
        ocProxy.insertStudentToProgressReport(studentFreshman);
        //inserisco lo studente anche nel microservizio dell'offerta didattica
        ocProxy.insertStudentToDidacticOffer(studentFreshman);

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

    //update student advisor (utilizzato per assegnare l'dvisor allo studente)
    public void updateStudentAdvisor(Integer studentFreshman, Integer advisorFreshman) throws SQLException{
        studentDao.updateAdvisor(studentFreshman, advisorFreshman);
    }

    //update student year (usato quando lo studente viene passato all'anno successivo)
    public void updateStudentYear(Integer studentFreshman, Integer year) throws SQLException{
        studentDao.updateYear(studentFreshman, year);
        if(year == 3){ //inserisco lo studente nel microservizio delle tesi
            ocProxy.insertStudentToThesisApprovation(studentFreshman);
        }
    }

    //delete student
    public void deleteStudent(Integer studentFreshman) throws SQLException{
        studentDao.delete(studentFreshman);
        //elimino lo studente anche negli altri microservizi
        ocProxy.deleteStudentDidacticOffer(studentFreshman);
        ocProxy.deleteStudentProgressReport(studentFreshman);
        ocProxy.deleteStudentThesisApprovation(studentFreshman);
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
    public void insertCycle(String cycleNumber, Integer year, String description) throws SQLException{
        Cycle c = new Cycle(cycleNumber, year, description);
        cycleDao.insert(c);
    }

    //update cycle
    public void updateCycle(String cycleNumber, Integer year, String description) throws SQLException {
        Cycle c = new Cycle(cycleNumber, year, description);
        cycleDao.update(c);
    }

    //delete cycle
    public void deleteCycle(String cycleNumber) throws SQLException{
        List<Student> students = studentDao.getStudentsByCycle(cycleNumber);
        cycleDao.delete(cycleNumber);
        //elimino gli studenti del ciclo (eliminato) anche negli altri microservizi
        for(Student s : students){
            ocProxy.deleteStudentDidacticOffer(s.getFreshman());
            ocProxy.deleteStudentProgressReport(s.getFreshman());
            ocProxy.deleteStudentThesisApprovation(s.getFreshman());
        }
    }

    //get all cycles
    public List<Cycle> getAllCycles() throws SQLException{
        return cycleDao.getAll();
    }

    //METODI DI FacultyMembersDao

    //insert faculty member
    public void insertFacultyMember(Integer freshman, String name, String surname, String email, String password, String specialization, String institution, String cycleNumber) throws SQLException{
        Cycle c = new Cycle(cycleNumber);
        FacultyMember facultyMember = new FacultyMember(freshman, name, surname, email, password, specialization, institution, c);
        facultyMemberDao.insert(facultyMember);
    }

    //update faculty member profile
    public void updateFacultyMember(Integer freshman, String name, String surname, String email, String specialization, String institution, String cycleNumber) throws SQLException{
        Cycle c = new Cycle(cycleNumber);
        FacultyMember facultyMember = new FacultyMember(freshman, name, surname, email, specialization, institution, c);
        facultyMemberDao.update(facultyMember);
    }

    //update faculty member password
    public void updateFacultyMemberPassword(Integer fmFreshman, String password) throws SQLException{
        facultyMemberDao.updateFacultyMemberPassword(fmFreshman, password);
    }

    //delete faculty member
    public void deleteFacultyMember(Integer fmFreshman) throws SQLException{
        facultyMemberDao.delete(fmFreshman);
    }

    //get all faculty members
    public List<FacultyMember> getAllFacultyMembers() throws SQLException{
        return facultyMemberDao.getAll();
    }

}
