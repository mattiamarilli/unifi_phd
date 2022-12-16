package thesisapprovation;

public class Review {

    private String title, comment;

    public Review(String t, String c){
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

    @Override
    public String toString() {
        return "Review{" +
                "title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
