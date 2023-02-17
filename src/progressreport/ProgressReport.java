package progressreport;

public class ProgressReport {

    private enum State{
        Load,
        Not_load
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

    //utilizzato quando viene inserito la prima volta
    public ProgressReport(int fs){
        this.freshmanStudent = fs;
        this.state = State.Not_load;
    }

    //without id
    public ProgressReport(String t, String d, String ud, int fs ){
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.state = State.Not_load; //inizialmente non è consegnata ma è in bozza
        this.freshmanStudent = fs;
    }

    //utilizzato dal scientist quando desidere visualizzare il progress report di uno specifico studente
    public ProgressReport(int id, String t, String d, String ud, int fs ){
        this.id = id;
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.state = State.Load;
        this.freshmanStudent = fs;
    }

    //with id without state (utilizzato quando il progress report viene modificato dallo studente, il quale non può modificare lo stato)
    public ProgressReport(int id, String t, String d, String ud){
        this.id = id;
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
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
