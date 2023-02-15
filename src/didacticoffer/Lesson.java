package didacticoffer;

import java.sql.Time;
import java.sql.Date;

public class Lesson {

    private enum Modality{
        Online,
        Presence
    }

    private int id;
    private Date date;
    private Time startTime;
    private Time endTime;
    private int room;
    private String universityComplex;
    private String university;
    private Modality mode;
    private Course course;

    //with id
    public Lesson(int id, Date d, Time st, Time et, int r, String uc, String u, String m, Course c){
        this.id = id;
        this.date = d;
        this.startTime = st;
        this.endTime = et;
        this.room = r;
        this.universityComplex = uc;
        this.university = u;
        this.mode = Modality.valueOf(m);
        this.course = c;
    }

    //without id (usato quando è inserita per la prima volta)
    public Lesson(Date d, Time st, Time et, int r, String uc, String u, String m, Course c){
        this.date = d;
        this.startTime = st;
        this.endTime = et;
        this.room = r;
        this.universityComplex = uc;
        this.university = u;
        this.mode = Modality.valueOf(m);
        this.course = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getUniversityComplex() {
        return universityComplex;
    }

    public void setUniversityComplex(String universityComplex) {
        this.universityComplex = universityComplex;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Modality getMode() {
        return mode;
    }

    public void setMode(Modality mode) {
        this.mode = mode;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", room=" + room +
                ", universityComplex='" + universityComplex + '\'' +
                ", university='" + university + '\'' +
                ", mode=" + mode +
                ", course=" + course +
                '}';
    }
}
