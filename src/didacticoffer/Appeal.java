package didacticoffer;

import java.sql.Time;
import java.sql.Date;

public class Appeal {

    private enum Modality{
        Online,
        Presence
    }

    private int id;
    private Date date;
    private Time startTime;
    private Integer room;
    private String universityComplex;
    private String university;
    private String note;
    private Modality mode;
    private Course course;

    //with id
    public Appeal(int id, Date d, Time st, Integer r, String uc, String u, String n, String m, Course c){
        this.id = id;
        this.date = d;
        this.startTime = st;
        this.room = r;
        this.universityComplex = uc;
        this.university = u;
        this.note = n;
        this.mode = Modality.valueOf(m);
        this.course = c;
    }

    //without id (usato quando è inserito per la prima volta)
    public Appeal(Date d, Time st, Integer r, String uc, String u, String n, String m, Course c){
        this.date = d;
        this.startTime = st;
        this.room = r;
        this.universityComplex = uc;
        this.university = u;
        this.note = n;
        this.mode = Modality.valueOf(m);
        this.course = c;
    }

    public Appeal(Integer id){
        this.id = id;
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

    public int getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        return "Appeal{" +
                "id=" + id +
                ", date=" + date +
                ", startTime=" + startTime +
                ", room=" + room +
                ", universityComplex='" + universityComplex + '\'' +
                ", university='" + university + '\'' +
                ", note='" + note + '\'' +
                ", mode=" + mode +
                ", course=" + course +
                '}';
    }
}
