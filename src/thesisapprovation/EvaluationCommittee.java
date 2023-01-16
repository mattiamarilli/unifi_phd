package thesisapprovation;

public class EvaluationCommittee {

    private Thesis thesis;
    private Reviewer reviewer;

    public EvaluationCommittee(Thesis t, Reviewer r){
        this.thesis = t;
        this.reviewer = r;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "EvaluationCommittee{" +
                "thesis=" + thesis +
                ", reviewer=" + reviewer +
                '}';
    }
}
