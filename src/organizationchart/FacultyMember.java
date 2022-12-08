package organizationchart;

public class FacultyMember {

    private int id;
    private String name;
    private String surname;
    private String specialization;
    private String institution;

    public FacultyMember(int id, String name, String surname, String specialization, String institution) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.institution = institution;
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

    public String getSpecialization() {
        return specialization;
    }

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
