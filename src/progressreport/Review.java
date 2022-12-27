package progressreport;

import thesisapprovation.Reviewer;

public class Review {

    private int id;
    private String title;
    private String comment;
    private int freshmanScientist;
    private int idProgressReport;


    //with id
    public Review(int id, String t, String c, int fs, int ip){
        this.id = id;
        this.title = t;
        this.comment = c;
        this.freshmanScientist = fs;
        this.idProgressReport = ip;
    }

    //without id
    public Review(String t, String c, int fs, int ip){
        this.title = t;
        this.comment = c;
        this.freshmanScientist = fs;
        this.idProgressReport = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFreshmanScientist() {
        return freshmanScientist;
    }

    public void setFreshmanScientist(int freshmanScientist) {
        this.freshmanScientist = freshmanScientist;
    }

    public int getIdProgressReport() {
        return idProgressReport;
    }

    public void setIdProgressReport(int idProgressReport) {
        this.idProgressReport = idProgressReport;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", freshmanScientist=" + freshmanScientist +
                ", idProgressReport=" + idProgressReport +
                '}';
    }

}
