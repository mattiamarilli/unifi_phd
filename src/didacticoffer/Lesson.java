package didacticoffer;

import java.sql.Time;
import java.util.Date;

public class Lesson {

    private enum Modality{
        Online,
        Presence
    }

    private int id;
    private Date date;
    private Time startTime;
    private Time endTime;
    private int room;
    private String universityComplex;
    private String university;
    private Modality mode;
    private Course course;

    //TODO: finire



}
