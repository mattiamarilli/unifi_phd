package progressreport;

public class Scientist {

    private int freshman;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String description;

    public Scientist(int f, String n, String s, String p, String e, String d){
        this.freshman = f;
        this.name = n;
        this.surname = s;
        this.password = p;
        this.email = e;
        this.description = d;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Scientist{" +
                "freshman=" + freshman +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
