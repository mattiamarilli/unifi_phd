package organizationchart;

public class Student {

    private Integer freshman;
    private String name;
    private String surname;



    private String email;
    private String password;
    private String topics;

    public Student(Integer freshman, String name, String surname, String email, String password, String topics) {
        this.freshman = freshman;
        this.name = name;
        this.surname = surname;
        this.email= email;
        this.password =password;
        this.topics = topics;
    }

    public Integer getFreshman() {
        return freshman;
    }

    public void setFreshman(Integer freshman) {
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
    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
