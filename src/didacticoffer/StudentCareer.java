package didacticoffer;

public class StudentCareer {

    private int freshmanStudent;

    public StudentCareer(int fs){
        this.freshmanStudent = fs;
    }

    public int getFreshmanStudent() {
        return freshmanStudent;
    }

    public void setFreshmanStudent(int freshmanStudent) {
        this.freshmanStudent = freshmanStudent;
    }

    @Override
    public String toString() {
        return "StudentCareer{" +
                "freshmanStudent=" + freshmanStudent +
                '}';
    }
}
