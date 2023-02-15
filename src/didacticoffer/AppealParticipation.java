package didacticoffer;

public class AppealParticipation {
    private StudentCareer studentCareer;
    private Appeal appeal;
    private String vote;

    public AppealParticipation(StudentCareer sc, Appeal a, String v){
        this.studentCareer = sc;
        this.appeal = a;
        this.vote = v;
    }

    //usato quando viene inserito la prima volta
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

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "AppealParticipation{" +
                "studentCareer=" + studentCareer +
                ", appeal=" + appeal +
                '}';
    }
}
