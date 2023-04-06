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
    public synchronized Boolean insertProfessor(Integer freshman, String name, String surname, String specialization, String university, String email, String password) throws SQLException, InterruptedException {

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
    public synchronized Boolean updateCodeCourseProfessor(Integer professorFreshman, String codeCourse) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return professorDao.updateCodeCourseProfessor(professorFreshman, codeCourse);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //modifica professor by freshman
    public synchronized Boolean updateProfessor(Integer freshman, String name, String surname, String specialization, String university, String email) throws SQLException, InterruptedException {
        if (available) {
            Professor p = new Professor(freshman, name, surname, specialization, university, email);
            emulateDelay();
            return professorDao.update(p);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }


    }

    //modifica password professor by freshman
    public synchronized Boolean updatePasswordProfessor(Integer freshman, String password) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return professorDao.updatePasswordProfessor(freshman, password);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //elimina professor
    public synchronized Boolean deleteProfessor(Integer freshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return professorDao.delete(freshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //gets professor by freshman
    public synchronized Professor getProfessorByFreshman(Integer professorFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return professorDao.findByKey(professorFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get all professors
    public synchronized List<Professor> getAllProfessors() throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return professorDao.getAll();
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get all professors without course
    public synchronized List<Professor> getAllProfessorsWithoutCourse() throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return professorDao.getProfessorsWithoutCourse();
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //get students enrolled in the professor's course
    public synchronized List<Student> getAllStudentsByProfessor(Integer professorFreshman) throws SQLException, InterruptedException {
        if (available) {
            List<Integer> studentFreshmen = professorDao.getStudentFreshmenByProfessor(professorFreshman);
            List<Student> students = new ArrayList<Student>();

            this.didacticOfferProxy = new DidacticOfferProxy();
            for(Integer i : studentFreshmen){
                Student s = didacticOfferProxy.getStudentsInformation(i);
                students.add(s);
            }
            emulateDelay();
            return students;
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //METODI DI CourseDao

    public synchronized List<Course> getAllCourses() throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return courseDao.getAll();
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    public synchronized List<Course> getCoursesNotRegisteredByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return courseDao.getCoursesNotRegisteredByStudent(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //inserimento course
    public synchronized Boolean insertCourse(String code, String title, String description, Integer cfu, Integer year) throws SQLException, InterruptedException {
        if (available) {
            Course c = new Course(code, title, description, cfu,year);
            emulateDelay();
            return courseDao.insert(c);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //modifica course
    public synchronized Boolean updateCourse(String code, String title, String description, Integer cfu, Integer year) throws SQLException, InterruptedException {
        if (available) {
            Course c = new Course(code, title, description, cfu, year);
            emulateDelay();
            return courseDao.update(c);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //elimina course
    public synchronized Boolean deleteCourse(String code) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return courseDao.delete(code);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //update course status (usato quando il professore ha terminato il corso ed definisce il corso "frequentato")
    public synchronized Boolean updateStateStudyPlan(String courseCode, String state) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return courseDao.updateStateStudyPlan(courseCode, state);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }


    //METODI DI LessonDao

    //inserimento lesson
    public synchronized Boolean insertLesson(Date date, Time startTime, Time endTime, Integer room, String universityComplex, String university, String mode, String codeCourse) throws SQLException, InterruptedException {
        if (available) {
            Course c = new Course(codeCourse);
            Lesson lesson = new Lesson(date, startTime, endTime, room, universityComplex, university, mode, c);
            emulateDelay();
            return lessonDao.insert(lesson);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //modifica lesson
    public synchronized Boolean updateLesson(Integer id, Date date, Time startTime, Time endTime, Integer room, String universityComplex, String university, String mode, String codeCourse) throws SQLException, InterruptedException {
        if (available) {
            Course c = new Course(codeCourse);
            Lesson lesson = new Lesson(id, date, startTime, endTime, room, universityComplex, university, mode, c);
            emulateDelay();
            return lessonDao.update(lesson);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //elimina lesson
    public synchronized Boolean deleteLesson(Integer idLesson) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return lessonDao.delete(idLesson);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //get lessons by courseCode
    public synchronized List<Lesson> getLessonsByCourseCode(String courseCode) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return lessonDao.getLessonsByCourseCode(courseCode);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }



    //METODI DI AppealDao

    //inserimento appeal
    public synchronized Boolean insertAppeal(Date date, Time startTime, Integer room, String universityComplex, String university, String note, String mode, String codeCourse) throws SQLException, InterruptedException {
        if (available) {
            Course c = new Course(codeCourse);
            Appeal appeal = new Appeal(date, startTime, room, universityComplex, university, note, mode, c);
            emulateDelay();
            return appealDao.insert(appeal);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //modifico appeal
    public synchronized Boolean updateAppeal(Integer id, Date date, Time startTime, Integer room, String universityComplex, String university, String note, String mode, String codeCourse) throws SQLException, InterruptedException {
        if (available) {
            Course c = new Course(codeCourse);
            Appeal appeal = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
            emulateDelay();
            return appealDao.update(appeal);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //elimina appeal
    public synchronized Boolean deleteAppeal(Integer idAppeal) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.delete(idAppeal);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //accept vote by student
    public synchronized Boolean acceptVoteByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException, InterruptedException {
        if (available) {
            if(appealDao.findByKey(idAppeal) == null)
                return false;
            Appeal a = appealDao.findByKey(idAppeal);
            emulateDelay();
            return appealDao.updateStateStudentStudyPlan(studentFreshman, a.getCourse().getCode(), "Accredited");
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //inserimento voto
    public synchronized Boolean updateVote(Integer studentFreshman, Integer idAppeal, String vote) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.insertVote(studentFreshman, idAppeal, vote);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //get students without vote in appeal participation by code course
    public synchronized List<AppealParticipation> getAppealParticipationWithoutVoteByCourseCode(String courseCode) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.getAppealParticipationWithoutVoteByCourseCode(courseCode);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //visualizza appelli in base al course code
    public synchronized List<Appeal> getAppealsByCourseCode(String courseCode) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.getAppealsByCourseCode(courseCode);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    public synchronized List<Appeal> getAppealsByStudentFreshman(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.getAppealsByStudentFreshman(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    public synchronized List<Appeal> getAppealsToAccept(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.getAppealsToAccept(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    public synchronized List<Appeal> getAppealsToRegister(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return appealDao.getAppealsToRegister(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //METODI DI StudentCareerDao

    //inserimento student career
    public synchronized Boolean insertStudentCareer(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            StudentCareer sc = new StudentCareer(studentFreshman);
            emulateDelay();
            return studentCareerDao.insert(sc);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }

    }

    //elimina student career
    public synchronized Boolean deleteStudentCareer(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return studentCareerDao.delete(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //insert appeal participation
    public synchronized Boolean insertAppealParticipation(Integer studentFreshman, Integer idAppeal) throws SQLException, InterruptedException {
        if (available) {
            Appeal a = new Appeal(idAppeal);
            StudentCareer sc = new StudentCareer(studentFreshman);
            AppealParticipation ap = new AppealParticipation(sc, a);
            emulateDelay();
            return studentCareerDao.insertAppealParticipation(ap);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //delete appeal participation by student freshman
    public synchronized Boolean deleteAppealParticipationByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return studentCareerDao.deleteAppealParticipationByStudent(studentFreshman, idAppeal);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //insert study plan by student freshman and course code
    public synchronized Boolean insertStudyPlan(Integer studentFreshman, String courseCode, Date date) throws SQLException, InterruptedException {
        if (available) {
            StudentCareer sc = new StudentCareer(studentFreshman);
            Course c = new Course(courseCode);
            StudyPlan studyPlan = new StudyPlan(sc, c, date);
            emulateDelay();
            return studentCareerDao.insertStudyPlan(studyPlan);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //delete study plan by student and course code
    public synchronized Boolean deleteStudyPlan(Integer studentFreshman, String courseCode) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return studentCareerDao.deleteStudyPlan(studentFreshman, courseCode);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return false;
        }

    }

    //visualizza corsi iscritti
    public synchronized List<Course> getCoursesByStudentFreshman(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return studentCareerDao.getCoursesByStudentFreshman(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //visualizza corsi superati
    public synchronized List<Course> getCoursesAccreditedByStudentFreshman(Integer studentFreshman) throws SQLException, InterruptedException {

        if (available) {
            emulateDelay();
            return studentCareerDao.getCoursesAccreditedByStudentFreshman(studentFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //visualizza partecipazione appelli by student
    public synchronized List<AppealParticipation> getAppealParticipationByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return studentCareerDao.getAppealParticipationByStudent(studentFreshman);
        }
        else
        {
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get study plans by student
    public synchronized List<StudyPlan> getStudyPlansByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if (available) {
            emulateDelay();
            return studentCareerDao.getStudyPlansByStudent(studentFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }
}
