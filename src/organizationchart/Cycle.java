package organizationchart;


//TODO: perché year è String ? è uguale
public class Cycle {

    private int number;
    private String year;
    private String description;

    public Cycle(int number, String year, String description) {
        this.number = number;
        this.year = year;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
