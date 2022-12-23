package organizationchart;

public class FacultyMember {

    private int freshman;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String specialization;
    private String institution;

    public FacultyMember(int freshman, String name, String surname,String email, String password, String specialization, String institution) {
        this.freshman = freshman;
        this.name = name;
        this.surname = surname;
        this.email= email;
        this.password =password;
        this.specialization = specialization;
        this.institution = institution;
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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password;}

    public String getSpecialization() {return specialization;}

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
