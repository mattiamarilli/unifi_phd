package organizationchart;


//TODO: perché year è String ? è uguale
public class Cycle {

    private String number;
    private int year;
    private String description;

    public Cycle(String number, int year, String description) {
        this.number = number;
        this.year = year;
        this.description = description;
    }

    public Cycle(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
