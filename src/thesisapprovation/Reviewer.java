package thesisapprovation;

public class Reviewer {

    private int freshman;
    private String name, surname, password, email, description;

    public Reviewer(int f, String n, String s, String p, String e, String d){
        this.freshman = f;
        this.name = n;
        this.surname = s;
        this.password = p;
        this.email = e;
        this.description = d;
    }

    //without password
    public Reviewer(int f, String n, String s, String e, String d){
        this.freshman = f;
        this.name = n;
        this.surname = s;
        this.email = e;
        this.description = d;
    }

    //utilizzato per generare l'evaluation committee
    public Reviewer(int f){
        this.freshman = f;
    }

    public Reviewer(){}

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
        return "Reviewer{" +
                "freshman=" + freshman +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Reviewer))
            return false;
        Reviewer r = (Reviewer) obj;

        return (Integer.compare(this.freshman, r.getFreshman()) == 0) && (java.util.Objects.equals(this.name, r.getName())) && (java.util.Objects.equals(this.surname, r.getSurname()))
                && (java.util.Objects.equals(this.password, r.getPassword())) && (java.util.Objects.equals(this.email, r.getEmail())) && (java.util.Objects.equals(this.description, r.getDescription()));
    }
}
