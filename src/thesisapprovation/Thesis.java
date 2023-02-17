package thesisapprovation;

public class Thesis {
    private enum State{
        Approved,
        Not_approved
    }

    private enum Load{
        Load,
        Not_load
    }

    private int id;
    private String title;
    private String description;
    private String urlDocument;
    private int studentFreshman;
    private State state;
    private Load load;

    //usato per inserire/modificare la tesi in bozza (in quanto se la modifichi la tesi ancora non è stata approvata e nemmeno caricata)
    public Thesis(int id, String t, String d, String ud, int fs){
        this.id = id;
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.studentFreshman = fs;
        this.state = State.Not_approved;
        this.load = Load.Not_load;
    }

    //with id
    public Thesis(int id, String t, String d, String ud, int fs, String s, String l){
        this.id = id;
        this.title = t;
        this.description = d;
        this.urlDocument = ud;
        this.studentFreshman = fs;
        this.state = State.valueOf(s);
        this.load = Load.valueOf(l);
    }

    //usato per generare l'evaluation committee
    public Thesis(int fs){
        this.studentFreshman = fs;
        this.state = State.Not_approved;
        this.load = Load.Not_load;
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

    public int getStudentFreshman() {
        return studentFreshman;
    }

    public void setStudentFreshman(int studentFreshman) {
        this.studentFreshman = studentFreshman;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Thesis{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlDocument='" + urlDocument + '\'' +
                ", freshmanStudent=" + studentFreshman +
                ", state=" + state +
                '}';
    }

}
