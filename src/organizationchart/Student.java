package organizationchart;

public class Student {

    private Integer id;
    private String name;
    private String surname;
    private String topics;

    public Student(){}
    public Student(String name, String surname, String topics) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.topics = topics;
    }

    public Student(Integer id, String name, String surname, String topics) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.topics = topics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
