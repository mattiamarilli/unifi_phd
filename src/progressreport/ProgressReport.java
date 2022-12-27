package progressreport;

public class ProgressReport {

    private enum State{
        APPROVED,
        NOT_APPROVED
    }

    private int id;
    private String title;
    private String description;
    private String urlDocument;
    private State state;
    private int freshmanStudent;

    //with id
    public ProgressReport(int id, String t, String d, String ud, String s, int fs ){
        this.id = id;
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.state = State.valueOf(s);
        this.freshmanStudent = fs;
    }

    //without id
    public ProgressReport(String t, String d, String ud, String s, int fs ){
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.state = State.valueOf(s);
        this.freshmanStudent = fs;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getFreshmanStudent() {
        return freshmanStudent;
    }

    public void setFreshmanStudent(int freshmanStudent) {
        this.freshmanStudent = freshmanStudent;
    }

    @Override
    public String toString() {
        return "ProgressReport{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlDocument='" + urlDocument + '\'' +
                ", state=" + state +
                ", freshmanStudent=" + freshmanStudent +
                '}';
    }
}
