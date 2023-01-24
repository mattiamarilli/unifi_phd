package didacticoffer;

public class AppealParticipation {
    private StudentCareer studentCareer;
    private Appeal appeal;

    public AppealParticipation(StudentCareer sc, Appeal a){
        this.studentCareer = sc;
        this.appeal = a;
    }

    public StudentCareer getStudentCareer() {
        return studentCareer;
    }

    public void setStudentCareer(StudentCareer studentCareer) {
        this.studentCareer = studentCareer;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    @Override
    public String toString() {
        return "AppealParticipation{" +
                "studentCareer=" + studentCareer +
                ", appeal=" + appeal +
                '}';
    }
}
