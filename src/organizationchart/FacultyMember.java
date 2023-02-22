package organizationchart;

public class FacultyMember {

    private int freshman;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String specialization;
    private String institution;

    private Cycle cycle;

    //with password
    public FacultyMember(int freshman, String name, String surname, String email, String password, String specialization, String institution, Cycle cycle) {
        this.freshman = freshman;
        this.name = name;
        this.surname = surname;
        this.email= email;
        this.password =password;
        this.specialization = specialization;
        this.institution = institution;
        this.cycle = cycle;
    }

    //without password
    public FacultyMember(int freshman, String name, String surname, String email, String specialization, String institution, Cycle cycle) {
        this.freshman = freshman;
        this.name = name;
        this.surname = surname;
        this.email= email;
        this.specialization = specialization;
        this.institution = institution;
        this.cycle = cycle;
    }

    public FacultyMember(int freshman){
        this.freshman = freshman;
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

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }



    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof FacultyMember))
            return false;

        FacultyMember fm = (FacultyMember) obj;

        return (Integer.compare(this.freshman, fm.freshman) == 0) && (this.name.equals(fm.name)) && (this.surname.equals(fm.surname)) && (this.email.equals(fm.email))
                && (this.specialization.equals(fm.specialization)) && (this.institution.equals(fm.institution)) && (this.cycle.equals(fm.cycle));
    }
}
