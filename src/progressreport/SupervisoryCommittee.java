package progressreport;

public class SupervisoryCommittee {

    private Scientist scientist;
    private ProgressReport progressReport;

    public SupervisoryCommittee(Scientist s, ProgressReport pr){
        this.scientist = s;
        this.progressReport = pr;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public ProgressReport getProgressReport() {
        return progressReport;
    }

    public void setProgressReport(ProgressReport progressReport) {
        this.progressReport = progressReport;
    }

    @Override
    public String toString() {
        return "SupervisoryCommittee{" +
                "scientist=" + scientist +
                ", progressReport=" + progressReport +
                '}';
    }
}
