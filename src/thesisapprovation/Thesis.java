package thesisapprovation;

public class Thesis {
    private enum State{
        APPROVED,
        NOT_APPROVED
    }


    private String title;
    private String description;
    private String urlDocument;
    private int freshmanStudent;
    private State state;

    public Thesis(String t, String d, String ud, int fs){
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.freshmanStudent = fs;
        this.state = State.NOT_APPROVED; //inizialmente la tesi caricata non è approvata
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public int getFreshmanStudent() {
        return freshmanStudent;
    }

    public void setFreshmanStudent(int freshmanStudent) {
        this.freshmanStudent = freshmanStudent;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
