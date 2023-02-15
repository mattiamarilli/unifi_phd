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

public class DidacticOfferService {
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
        this.didacticOfferProxy = new DidacticOfferProxy();
    }

    //METODI PER ProfessorDao

    //inserimento professor
    public void insertProfessor(Integer freshman, String name, String surname, String specialization, String university, String email, String password) throws SQLException {
        Professor p = new Professor(freshman, name, surname, specialization, university, email, password);
        professorDao.insert(p);
    }

    //course assignment to the professor
    public void updateCodeCourseProfessor(Integer professorFreshman, String codeCourse) throws SQLException{
        professorDao.updateCodeCourseProfessor(professorFreshman, codeCourse);
    }

    //modifica professor by freshman
    public void updateProfessor(Integer freshman, String name, String surname, String specialization, String university, String email, String codeCourse) throws SQLException{
        Course course = new Course(codeCourse);
        Professor p = new Professor(freshman, name, surname, specialization, university, email, course);
        professorDao.update(p);
    }

    //modifica password professor by freshman
    public void updatePasswordProfessor(Integer freshman, String password) throws SQLException{
        professorDao.updatePasswordProfessor(freshman, password);
    }

    //elimina professor
    public void deleteProfessor(Integer freshman) throws SQLException{
        professorDao.delete(freshman);
    }

    //get all professors
    public List<Professor> getAllProfessors() throws SQLException{
        return professorDao.getAll();
    }

    //get students enrolled in the professor's course
    public List<Student> getAllStudentsByProfessor(Integer professorFreshman) throws SQLException{
        List<Integer> studentFreshmen = professorDao.getStudentFreshmenByProfessor(professorFreshman);
        List<Student> students = new ArrayList<Student>();

        for(Integer i : studentFreshmen){
            Student s = didacticOfferProxy.getStudentsInformation(i);
            students.add(s);
        }

        return students;
    }

    //METODI DI CourseDao

    //inserimento course
    public void insertCourse(String code, String title, String description, Integer cfu) throws SQLException{
        Course c = new Course(code, title, description, cfu);
        courseDao.insert(c);
    }

    //modifica course
    public void updateCourse(String code, String title, String description, Integer cfu, Integer year) throws SQLException{
        Course c = new Course(code, title, description, cfu, year);
        courseDao.update(c);
    }

    //elimina course
    public void deleteCourse(String code) throws SQLException{
        courseDao.delete(code);
    }

    //update course status (usato quando il professore ha terminato il corso ed definisce il corso "frequentato")
    public void updateStateStudyPlan(String courseCode, String state) throws SQLException{
        courseDao.updateStateStudyPlan(courseCode, state);
    }


    //METODI DI LessonDao

    //inserimento lesson
    public void insertLesson(Date date, Time startTime, Time endTime, Integer room, String universityComplex, String university, String mode, String codeCourse) throws SQLException{
        Course c = new Course(codeCourse);
        Lesson lesson = new Lesson(date, startTime, endTime, room, universityComplex, university, mode, c);
        lessonDao.insert(lesson);
    }

    //modifica lesson
    public void updateLesson(Integer id, Date date, Time startTime, Time endTime, Integer room, String universityComplex, String university, String mode, String codeCourse) throws SQLException {
        Course c = new Course(codeCourse);
        Lesson lesson = new Lesson(id, date, startTime, endTime, room, universityComplex, university, mode, c);
        lessonDao.update(lesson);
    }

    //elimina lesson
    public void deleteLesson(Integer idLesson) throws SQLException{
        lessonDao.delete(idLesson);
    }


    //METODI DI AppealDao

    //inserimento appeal
    public void insertAppeal(Date date, Time startTime, Integer room, String universityComplex, String university, String note, String mode, String codeCourse) throws SQLException{
        Course c = new Course(codeCourse);
        Appeal appeal = new Appeal(date, startTime, room, universityComplex, university, note, mode, c);
        appealDao.insert(appeal);
    }

    //modifico appeal
    public void updateAppeal(Integer id, Date date, Time startTime, Integer room, String universityComplex, String university, String note, String mode, String codeCourse) throws SQLException{
        Course c = new Course(codeCourse);
        Appeal appeal = new Appeal(id, date, startTime, room, universityComplex, university, note, mode, c);
        appealDao.update(appeal);
    }

    //elimina appeal
    public void deleteAppeal(Integer idAppeal) throws SQLException{
        appealDao.delete(idAppeal);
    }

    //accept vote by student
    public void acceptVoteByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException{
        Appeal a = appealDao.findByKey(idAppeal);
        appealDao.updateStateStudentStudyPlan(studentFreshman, a.getCourse().getCode(), "Accredited");
    }

    //visualizza appelli in base al course code
    public List<Appeal> getAppealsByCourseCode(String courseCode) throws SQLException{
        return appealDao.getAppealsByCourseCode(courseCode);
    }

    //METODI DI StudentCareerDao

    //inserimento student career
    public void insertStudentCareer(Integer studentFreshman) throws SQLException{
        StudentCareer sc = new StudentCareer(studentFreshman);
        studentCareerDao.insert(sc);
    }

    //elimina student career
    public void deleteStudentCareer(Integer studentFreshman) throws SQLException{
        studentCareerDao.delete(studentFreshman);
    }

    //insert appeal participation
    public void insertAppealParticipation(Integer studentFreshman, Integer idAppeal) throws SQLException{
        Appeal a = new Appeal(idAppeal);
        StudentCareer sc = new StudentCareer(studentFreshman);

        AppealParticipation ap = new AppealParticipation(sc, a);

        studentCareerDao.insertAppealParticipation(ap);
    }

    //delete appeal participation by student freshman
    public void deleteAppealParticipationByStudent(Integer studentFreshman, Integer idAppeal) throws SQLException{
        studentCareerDao.deleteAppealParticipationByStudent(studentFreshman, idAppeal);
    }

    //insert study plan by student freshman and course code
    public void insertStudyPlan(Integer studentFreshman, String courseCode, Date date) throws SQLException{
        StudentCareer sc = new StudentCareer(studentFreshman);
        Course c = new Course(courseCode);
        StudyPlan studyPlan = new StudyPlan(sc, c, date);
        studentCareerDao.insertStudyPlan(studyPlan);
    }

    //delete study plan by student and course code
    public void deleteStudyPlan(Integer studentFreshman, String courseCode) throws SQLException{
        studentCareerDao.deleteStudyPlan(studentFreshman, courseCode);
    }

    //visualizza corsi iscritti
    public List<Course> getCoursesByStudentFreshman(Integer studentFreshman) throws SQLException{
        return studentCareerDao.getCoursesByStudentFreshman(studentFreshman);
    }

    //visualizza corsi superati
    public List<Course> getCoursesAccreditedByStudentFreshman(Integer studentFreshman) throws SQLException{
        return studentCareerDao.getCoursesAccreditedByStudentFreshman(studentFreshman);
    }

}
