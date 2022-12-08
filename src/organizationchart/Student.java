package organizationchart;

public class Student {

    private int id;
    private String name;
    private String surname;
    private String topics;

    public Student(int id, String name, String surname, String topics) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.topics = topics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
