package progressreport;

import thesisapprovation.Reviewer;

public class Review {

    private int id;
    private String title;
    private String comment;
    private SupervisoryCommittee supervisoryCommittee;

    //with id
    public Review(int id, String t, String c, SupervisoryCommittee sc){
        this.id = id;
        this.title = t;
        this.comment = c;
        this.supervisoryCommittee = sc;
    }

    //without id
    public Review(String t, String c, SupervisoryCommittee sc){
        this.title = t;
        this.comment = c;
        this.supervisoryCommittee = sc;
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

    public SupervisoryCommittee getSupervisoryCommittee() {
        return supervisoryCommittee;
    }

    public void setSupervisoryCommittee(SupervisoryCommittee supervisoryCommittee) {
        this.supervisoryCommittee = supervisoryCommittee;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", supervisoryCommittee=" + supervisoryCommittee +
                '}';
    }
}
