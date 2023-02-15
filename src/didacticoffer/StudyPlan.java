package didacticoffer;

import java.sql.Date;

public class StudyPlan {

    private enum State{
        Registered, //iscritto
        Attended, //frequentato
        Accredited //accreditato
    }

    private StudentCareer studentCareer;
    private Course course;
    private State state;
    private Date registrationDate;

    //utilizzato quando è inserito la prima volta
    public StudyPlan(StudentCareer sc, Course c, Date rd){
        this.studentCareer = sc;
        this.course = c;
        this.state = State.Registered; //la prima volta è iscritto (registered)
        this.registrationDate = rd;
    }

    public StudyPlan(StudentCareer sc, Course c, String s, Date rd){
        this.studentCareer = sc;
        this.course = c;
        this.state = State.valueOf(s);
        this.registrationDate = rd;
    }


    public StudentCareer getStudentCareer() {
        return studentCareer;
    }

    public void setStudentCareer(StudentCareer studentCareer) {
        this.studentCareer = studentCareer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "StudyPlan{" +
                "studentCareer=" + studentCareer +
                ", course=" + course +
                ", state=" + state +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
