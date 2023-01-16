package didacticoffer;

public class Professor {
    private int freshman;
    private String name;
    private String surname;
    private String specialization;
    private String university;
    private String email;
    private String password;
    private Course course;

    //with id
    public Professor(int id, String n, String s, String specialization, String u, String e, String p, Course c){
        this.freshman = id;
        this.name = n;
        this.surname = s;
        this.specialization = specialization;
        this.university = u;
        this.email = e;
        this.password = p;
        this.course = c;
    }

    //without id
    public Professor(String n, String s, String specialization, String u, String e, String p, Course c){
        this.name = n;
        this.surname = s;
        this.specialization = specialization;
        this.university = u;
        this.email = e;
        this.password = p;
        this.course = c;
    }

    public int getFreshman() {
        return freshman;
    }

    public void setFreshman(int freshman) {
        this.freshman = freshman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "freshman=" + freshman +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialization='" + specialization + '\'' +
                ", university='" + university + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course=" + course +
                '}';
    }
}
