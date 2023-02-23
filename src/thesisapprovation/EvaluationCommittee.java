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

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof EvaluationCommittee))
            return false;
        EvaluationCommittee ec = (EvaluationCommittee) obj;
        return (this.thesis.equals(ec.getThesis())) && (this.reviewer.equals(ec.getReviewer()));
    }
}
