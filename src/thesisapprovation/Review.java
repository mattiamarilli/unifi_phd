package thesisapprovation;

public class Review {

    private String title, comment;
    int id, idReviewer, idThesis;

    //with id
    public Review(int id, String t, String c, int idR, int idT){
        this.idReviewer = idR;
        this.idThesis = idT;
        this.id = id;
        this.title = t;
        this.comment = c;
    }

    //without id
    public Review(String t, String c, int idR, int idT){
        this.title = t;
        this.comment = c;
        this.idReviewer = idR;
        this.idThesis = idT;
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

    public int getIdReviewer() {
        return idReviewer;
    }

    public void setIdReviewer(int idReviewer) {
        this.idReviewer = idReviewer;
    }

    public int getIdThesis() {
        return idThesis;
    }

    public void setIdThesis(int idThesis) {
        this.idThesis = idThesis;
    }

    @Override
    public String toString() {
        return "Review{" +
                "title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", id=" + id +
                ", idReviewer=" + idReviewer +
                ", idThesis=" + idThesis +
                '}';
    }

}
