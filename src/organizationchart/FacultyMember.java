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

    //without cycle
    public FacultyMember(int freshman, String name, String surname, String email, String specialization, String institution) {
        this.freshman = freshman;
        this.name = name;
        this.surname = surname;
        this.email= email;
        this.specialization = specialization;
        this.institution = institution;
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
    public String toString() {
        return "FacultyMember{" +
                "freshman=" + freshman +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", specialization='" + specialization + '\'' +
                ", institution='" + institution + '\'' +
                ", cycle=" + cycle +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof FacultyMember))
            return false;

        FacultyMember fm = (FacultyMember) obj;

        if(this.cycle == null && fm.getCycle() == null)
            return (Integer.compare(this.freshman, fm.getFreshman()) == 0) && (java.util.Objects.equals(this.name, fm.getName()))
                    && (java.util.Objects.equals(this.surname, fm.getSurname())) && (java.util.Objects.equals(this.email, fm.getEmail()))
                    && (java.util.Objects.equals(this.specialization, fm.getSpecialization())) && (java.util.Objects.equals(this.institution, fm.getInstitution()));

        return (Integer.compare(this.freshman, fm.getFreshman()) == 0) && (java.util.Objects.equals(this.name, fm.getName()))
                && (java.util.Objects.equals(this.surname, fm.getSurname())) && (java.util.Objects.equals(this.email, fm.getEmail()))
                && (java.util.Objects.equals(this.specialization, fm.getSpecialization())) && (java.util.Objects.equals(this.institution, fm.getInstitution()))
                && (this.cycle.equals(fm.cycle));
    }
}
