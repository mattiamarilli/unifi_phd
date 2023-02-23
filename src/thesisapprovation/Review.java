package thesisapprovation;

public class Review {
    int id;
    private String title, comment;
    private EvaluationCommittee ec;

    //with id
    public Review(int id, String t, String c, EvaluationCommittee ec){
        this.ec = ec;
        this.id = id;
        this.title = t;
        this.comment = c;
    }

    //without id (usata quando viene caricata per la prima volta)
    public Review(String t, String c, EvaluationCommittee ec){
        this.ec = ec;
        this.title = t;
        this.comment = c;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EvaluationCommittee getEc() {
        return ec;
    }

    public void setEc(EvaluationCommittee ec) {
        this.ec = ec;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", ec=" + ec +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Review))
            return false;

        Review r = (Review) obj;
        return (Integer.compare(this.id, r.getId()) == 0) && (java.util.Objects.equals(this.title, r.getTitle()))
                && (java.util.Objects.equals(this.comment, r.getComment())) && (this.ec.equals(r.getEc()));
    }
}
