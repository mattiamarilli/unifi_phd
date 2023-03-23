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
    public Boolean insertStudent(Integer studentFreshman, String name, String surname, String email, String password, String topics, String numberCycle) throws SQLException, InterruptedException {
        if(available){
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
            emulateDelay();
            return result;
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update student profile
    public Boolean updateStudent(Integer studentFreshman, String name, String surname, String email, String topics) throws SQLException, InterruptedException {
        if(available){
            Student s = new Student(studentFreshman, name, surname, email, topics);
            emulateDelay();
            return studentDao.update(s);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update student password
    public Boolean updateStudentPassword(Integer studentFreshman, String password) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.updatePassword(studentFreshman, password);
        }else {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update student advisor (utilizzato per assegnare l'dvisor allo studente)
    public Boolean updateStudentAdvisor(Integer studentFreshman, Integer advisorFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.updateAdvisor(studentFreshman, advisorFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update student year (usato quando lo studente viene passato all'anno successivo)
    public Boolean updateStudentYear(Integer studentFreshman, Integer year) throws SQLException, InterruptedException {
        if(available){
            Boolean result = studentDao.updateYear(studentFreshman, year);
            if(year == 3 && result){ //inserisco lo studente nel microservizio delle tesi
                this.ocProxy = new OrganizationChartProxy();
                ocProxy.insertStudentToThesisApprovation(studentFreshman);
            }
            emulateDelay();
            return result;
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //delete student
    public Boolean deleteStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            Boolean result = studentDao.delete(studentFreshman);
            //elimino lo studente anche negli altri microservizi
            if(result) {
                this.ocProxy = new OrganizationChartProxy();
                ocProxy.deleteStudentDidacticOffer(studentFreshman);
                ocProxy.deleteStudentProgressReport(studentFreshman);
                ocProxy.deleteStudentThesisApprovation(studentFreshman);
            }
            emulateDelay();
            return result;
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //get all students
    public List<Student> getAllStudents() throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.getAll();
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //gets student by freshman
    public Student getStudentByFreshman(Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.findByKey(studentFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get all students by year
    public List<Student> getStudentsByYear(Integer year) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.getStudentsByYear(year);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get all students by cycle
    public List<Student> getStudentsByCycle(String cycleNumber) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.getStudentsByCycle(cycleNumber);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get students by advisor
    public List<Student> getStudentsByAdvisor(Integer advisorFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return studentDao.getStudentsByAdvisor(advisorFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }


    //METODI DI CycleDao

    //insert cycle
    public Boolean insertCycle(String cycleNumber, Integer year, String description) throws SQLException, InterruptedException {
        if(available){
            Cycle c = new Cycle(cycleNumber, year, description);
            emulateDelay();
            return cycleDao.insert(c);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update cycle
    public Boolean updateCycle(String cycleNumber, Integer year, String description) throws SQLException, InterruptedException {
        if(available){
            Cycle c = new Cycle(cycleNumber, year, description);
            emulateDelay();
            return cycleDao.update(c);
        }else {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //delete cycle
    public Boolean deleteCycle(String cycleNumber) throws SQLException, InterruptedException {
        if(available){
            List<Student> students = studentDao.getStudentsByCycle(cycleNumber);
            Boolean result = cycleDao.delete(cycleNumber);

            this.ocProxy = new OrganizationChartProxy();
            //elimino gli studenti del ciclo (eliminato) anche negli altri microservizi
            for(Student s : students){
                ocProxy.deleteStudentDidacticOffer(s.getFreshman());
                ocProxy.deleteStudentProgressReport(s.getFreshman());
                ocProxy.deleteStudentThesisApprovation(s.getFreshman());
            }
            emulateDelay();
            return result;
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //get all cycles
    public List<Cycle> getAllCycles() throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return cycleDao.getAll();
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //METODI DI FacultyMembersDao

    //insert faculty member
    public Boolean insertFacultyMember(Integer freshman, String name, String surname, String email, String password, String specialization, String institution, String cycleNumber) throws SQLException, InterruptedException {
        if(available){
            Cycle c = new Cycle(cycleNumber);
            FacultyMember facultyMember = new FacultyMember(freshman, name, surname, email, password, specialization, institution, c);
            emulateDelay();
            return facultyMemberDao.insert(facultyMember);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update faculty member profile
    public Boolean updateFacultyMember(Integer freshman, String name, String surname, String email, String specialization, String institution) throws SQLException, InterruptedException {
        if(available){
            FacultyMember facultyMember = new FacultyMember(freshman, name, surname, email, specialization, institution);
            emulateDelay();
            return facultyMemberDao.update(facultyMember);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update faculty member password
    public Boolean updateFacultyMemberPassword(Integer fmFreshman, String password) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return facultyMemberDao.updateFacultyMemberPassword(fmFreshman, password);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //delete faculty member
    public Boolean deleteFacultyMember(Integer fmFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return facultyMemberDao.delete(fmFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    public FacultyMember getFacultyMember(Integer freshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return facultyMemberDao.findByKey(freshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get all faculty members
    public List<FacultyMember> getAllFacultyMembers() throws SQLException, InterruptedException {
        if(available) {
            emulateDelay();
            return facultyMemberDao.getAll();
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

}
