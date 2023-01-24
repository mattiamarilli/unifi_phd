package didacticoffer;

import java.time.Year;

public class Course {

    private String code;
    private String title;
    private String description;
    private int cfu;
    private int year;

    //with code
    public Course(String c, String t, String d, int cfu){
        this.code = c;
        this.title = t;
        this.description = d;
        this.cfu = cfu;
        this.year = Year.now().getValue();
    }

    //without code
    public Course(String t, String d, int cfu, int y){
        this.title = t;
        this.description = d;
        this.cfu = cfu;
        this.year = y;
    }

    //with code and year
    public Course(String c, String t, String d, int cfu, int y){
        this.code = c;
        this.title = t;
        this.description = d;
        this.cfu = cfu;
        this.year = y;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cfu=" + cfu +
                ", year=" + year +
                '}';
    }
}
