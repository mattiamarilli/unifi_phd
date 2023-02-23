package organizationchart;

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

    @Override
    public String toString() {
        return "Cycle{" +
                "number='" + number + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Cycle))
            return false;

        Cycle c = (Cycle) obj;
        return (java.util.Objects.equals(this.number, c.getNumber())) && (Integer.compare(this.year, c.getYear()) == 0)
                && (java.util.Objects.equals(this.description, c.getDescription()));
    }
}
