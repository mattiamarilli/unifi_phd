package didacticoffer.server;

import didacticoffer.*;
import didacticoffer.data_access.*;
import didacticoffer.proxy.DidacticOfferProxy;
import organizationchart.Student;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DidacticOfferService {

    final int millisecondsDelay = 5000;
    private  Boolean available = true;
    private ProfessorDao professorDao;
    private CourseDao courseDao;
    private LessonDao lessonDao;
    private AppealDao appealDao;
    private StudentCareerDao studentCareerDao;
    private DidacticOfferProxy didacticOfferProxy;

    public DidacticOfferService(){
        this.professorDao = new ProfessorDao();
        this.courseDao = new CourseDao();
        this.lessonDao = new LessonDao();
        this.appealDao = new AppealDao();
        this.studentCareerDao = new StudentCareerDao();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void emulateDelay() throws InterruptedException {
        Random random = new Random();
        int number = random.nextInt(100);
        if (number <= 95)
            Thread.sleep(random.nextInt(7)+3);
        else
            Thread.sleep(random.nextInt(20)+20);
    }
    //METODI PER ProfessorDao

    //inserimento professor
    public Boolean insertProfessor(Integer freshman, String name, String surname, String specialization, String university, String email, String password) throws SQLException, InterruptedException {

        if (available) {
            Professor p = new Professor(freshman, name, surname, specialization, university, email, password);
            emulateDelay();
            return professorDao.insert(p);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //course assignment to the professor
    public Boolean updateCodeCourseProfessor(Integer professorFreshman, String codeCourse) throws SQLException{
        return professorDao.updateCodeCourseProfessor(professorFreshman, codeCourse);
    }

    //modifica professor by freshman
    public Boolean updateProfessor(Integer freshman, String name, String surname, String specialization, String university, String email) throws SQLException{
        Professor p = new Professor(freshman, name, surname, specialization, university, email);
        return professorDao.update(p);
    }

    //modifica password professor by freshman
    public Boolean updatePasswordProfessor(Integer freshman, String password) throws SQLException{
        return professorDao.updatePasswordProfessor(freshman, password);
    }

    //elimina professor
    public Boolean deleteProfessor(Integer freshman) throws SQLException{
        return professorDao.delete(freshman);
    }

    //gets professor by freshman
    public Professor getProfessorByFreshman(Integer professorFreshman) throws SQLException{
        return professorDao.findByKey(professorFreshman);
    }

    //get all professors
    public List<Professor> getAllProfessors() throws SQLException{
        return professorDao.getAll();
    }

    //get all professors without course
    public List<Professor> getAllProfessorsWithoutCourse() throws SQLException{
        return professorDao.getProfessorsWithoutCourse();
    }

    //get students enrolled in the professor's course
    public List<Student> getAllStudentsByProfessor(Integer professorFreshman) throws SQLException{
        List<Integer> studentFreshmen = professorDao.getStudentFreshmenByProfessor(professorFreshman);
        List<Student> students = new ArrayList<Student>();

        this.didacticOfferProxy = new DidacticOfferProxy();
        for(Integer i : studentFreshmen){
            Student s = didacticOfferProxy.getStudentsInformation(i);
            students.add(s);
        }

        return students;
    }

    //METODI DI CourseDao

    public List<Course> getAllCourses() throws SQLException {
        return courseDao.getAll();
    }

    public List<Course> getCoursesNotRegisteredByStudent(Integer studentFreshman) throws SQLException{
        return courseDao.getCoursesNotRegisteredByStudent(studentFreshman);
    }

    //inserimento course
    public Boolean insertCourse(String code, String title, String description, Integer cfu, Integer year) throws SQLException{
        Course c = new Course(code, title, description, cfu,year);
        return courseDao.insert(c);
    }

    //modifica course
    public Boolean updateCourse(String code, String title, String description, Integer cfu, Integer year) throws SQLException{
        Course c = new Course(code, title, description, cfu, year);
        return courseDao.update(c);
    }

    //elimina course
    public Boolean deleteCourse(String code) throws SQLException{
        return courseDao.delete(code);
    }

    //update course status (usato quando il professore ha terminato il corso ed definisce il corso "frequentato")
    public Boolean updateStateStudyPlan(String courseCode, String state) throws SQLException{
        return courseDao.updateStateStudyPlan(courseCode, state);
    }


    //METODI DI LessonDao

    //inserimento lesson
    public Boolean insertLesson(Date date, Time startTime, Time endTime, Integer room, String universityComplex, String university, String mode, String codeCourse) throws SQLException{
        Course c = new Course(codeCourse);
        Lesson lesson = new Lesson(date, startTime, endTime, room, universityComplex, university, mode, c);
        return lessonDao.insert(lesson);
    }

    //modifica lesson
    public Boolean updateLesson(Integer id, Date date, Time startTime, Time endTime, Integer room, String universityComplex, String university, String mode, String codeCourse) throws SQLException {
        Course c = new Course(codeCourse);
        Lesson lesson = new Lesson(id, date, startTime, endTime, room, universityComplex, university, mode, c);
        return lessonDao.update(lesson);
    }

    //elimina lesson
    public Boolean deleteLesson(Integer idLesson) throws SQLException{
        return lessonDao.delete(idLesson);
    }

    //get lessons by courseCode
    public List<Lesson> getLessonsByCourseCode(String courseCode) throws SQLException{
        return lessonDao.getLessonsByCourseCode(courseCode);
    }



    //METODI DI AppealDao

    //inserimento appeal
    public Boolean insertAppeal(Date date, Time startTime, Integer room, String universityComplex, String university, String note, String mode, String codeCourse) throws SQLException{
        Course c = new Course(codeCourse);
        Appeal appeal = new Appeal(date, startTime, room, universityComplex, university, note, mode, c);
        return appealDao.insert(appeal);
    }

    //modifico appeal
    public Boolean updateAppeal(Integer id, Date date, Time startTime, Integer room, String universityComplex, String university, String note, String mode, String codeCourse) throws SQLException{
        Course c = new Course(codeCourse);
        Appeal appeal = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
        return appealDao.update(appeal);
    }

    //elimina appeal
    public Boolean deleteAppeal(Integer idAppeal) throws SQLException{
       return appealDao.delete(idAppeal);
    }

    //accept vote by student
    public Boolean acceptVoteByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException{
        if(appealDao.findByKey(idAppeal) == null)
            return false;
        Appeal a = appealDao.findByKey(idAppeal);
        return appealDao.updateStateStudentStudyPlan(studentFreshman, a.getCourse().getCode(), "Accredited");
    }

    //inserimento voto
    public Boolean updateVote(Integer studentFreshman, Integer idAppeal, String vote) throws SQLException{
        return appealDao.insertVote(studentFreshman, idAppeal, vote);
    }

    //get students without vote in appeal participation by code course
    public List<AppealParticipation> getAppealParticipationWithoutVoteByCourseCode(String courseCode) throws SQLException{
        return appealDao.getAppealParticipationWithoutVoteByCourseCode(courseCode);
    }

    //visualizza appelli in base al course code
    public List<Appeal> getAppealsByCourseCode(String courseCode) throws SQLException{
        return appealDao.getAppealsByCourseCode(courseCode);
    }

    public List<Appeal> getAppealsByStudentFreshman(Integer studentFreshman) throws SQLException{
        return appealDao.getAppealsByStudentFreshman(studentFreshman);
    }

    public List<Appeal> getAppealsToAccept(Integer studentFreshman) throws SQLException{
        return appealDao.getAppealsToAccept(studentFreshman);
    }

    public List<Appeal> getAppealsToRegister(Integer studentFreshman) throws SQLException{
        return appealDao.getAppealsToRegister(studentFreshman);
    }

    //METODI DI StudentCareerDao

    //inserimento student career
    public Boolean insertStudentCareer(Integer studentFreshman) throws SQLException{
        StudentCareer sc = new StudentCareer(studentFreshman);
        return studentCareerDao.insert(sc);
    }

    //elimina student career
    public Boolean deleteStudentCareer(Integer studentFreshman) throws SQLException{
        return studentCareerDao.delete(studentFreshman);
    }

    //insert appeal participation
    public Boolean insertAppealParticipation(Integer studentFreshman, Integer idAppeal) throws SQLException{
        Appeal a = new Appeal(idAppeal);
        StudentCareer sc = new StudentCareer(studentFreshman);

        AppealParticipation ap = new AppealParticipation(sc, a);

        return studentCareerDao.insertAppealParticipation(ap);
    }

    //delete appeal participation by student freshman
    public Boolean deleteAppealParticipationByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException{
        return studentCareerDao.deleteAppealParticipationByStudent(studentFreshman, idAppeal);
    }

    //insert study plan by student freshman and course code
    public Boolean insertStudyPlan(Integer studentFreshman, String courseCode, Date date) throws SQLException{
        StudentCareer sc = new StudentCareer(studentFreshman);
        Course c = new Course(courseCode);
        StudyPlan studyPlan = new StudyPlan(sc, c, date);
        return studentCareerDao.insertStudyPlan(studyPlan);
    }

    //delete study plan by student and course code
    public Boolean deleteStudyPlan(Integer studentFreshman, String courseCode) throws SQLException{
        return studentCareerDao.deleteStudyPlan(studentFreshman, courseCode);
    }

    //visualizza corsi iscritti
    public List<Course> getCoursesByStudentFreshman(Integer studentFreshman) throws SQLException{
        return studentCareerDao.getCoursesByStudentFreshman(studentFreshman);
    }

    //visualizza corsi superati
    public List<Course> getCoursesAccreditedByStudentFreshman(Integer studentFreshman) throws SQLException{
        return studentCareerDao.getCoursesAccreditedByStudentFreshman(studentFreshman);
    }


    //visualizza corsi registrati

    //visualizza partecipazione appelli by student
    public List<AppealParticipation> getAppealParticipationByStudent(Integer studentFreshman) throws SQLException{
        return studentCareerDao.getAppealParticipationByStudent(studentFreshman);
    }

    //get study plans by student
    public List<StudyPlan> getStudyPlansByStudent(Integer studentFreshman) throws SQLException{
        return studentCareerDao.getStudyPlansByStudent(studentFreshman);
    }

}
