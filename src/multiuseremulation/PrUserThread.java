package multiuseremulation;

import didacticoffer.server.DidacticOfferService;
import progressreport.server.ProgressReportService;

import java.sql.SQLException;
import java.util.Random;

public class PrUserThread implements Runnable{
    private ProgressReportService prService;
    private final int millisecondsSleep = 300;

    public PrUserThread(ProgressReportService prService) {
        this.prService = prService;
    }

    @Override
    public void run() {
        int test = 0;
        int count = 1;
        do {
            try {
                Random random = new Random();
                test = random.nextInt(13) + 1;
                System.out.println(Thread.currentThread().getName());

                try {
                    switch (test) {
                        case 1:
                            prService.updateProgressReport(1, "Progress Report end first year (update)", "Description progress report", "url1_2.pdf");
                            break;
                        case 2:
                            prService.updateStateProgressReport(3820539, "Load");
                            break;
                        case 3:
                            prService.getProgressReportByStudent(3472126);
                            break;
                        case 4:
                            prService.getScientistsByStudent(3820539);
                            break;
                        case 5:
                            prService.insertSupervisoryCommittee(1, 7237583);
                            break;
                        case 6:
                            prService.insertScientist(4802402, "Guido", "Gagliardi", "Password", "guido.gagliardi@unifi.it", "Machine learning");
                            break;
                        case 7:
                            prService.updateScientist(7637585, "Alessio", "Vecchio", "alessio.vecchio@unipi.it", "Pervasive and mobile computing (update");
                            break;
                        case 8:
                            prService.updatePasswordScientist(5894375, "Password (update)");
                            break;
                        case 9:
                            prService.getStudentBySupervisory(4029304);
                            break;
                        case 10:
                            prService.getProgressReportByScientistStudent(7237583, 3472126);
                            break;
                        case 11:
                            prService.deleteScientist(9237583);
                            break;
                        case 12:
                            prService.deleteProgressReport(6);
                            break;
                        default:
                            break;
                    }
                    Thread.sleep(millisecondsSleep);
                    count++;
                } catch (SQLException e) { throw new RuntimeException(e);}
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }while (!Thread.currentThread().isInterrupted());
    }
}
