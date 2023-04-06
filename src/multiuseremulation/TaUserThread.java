package multiuseremulation;

import didacticoffer.server.DidacticOfferService;
import thesisapprovation.server.ThesisApprovationService;

import java.sql.SQLException;
import java.util.Random;

public class TaUserThread implements Runnable{
    private ThesisApprovationService taService;

    public TaUserThread(ThesisApprovationService taService) {
        this.taService = taService;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Random random = new Random();
                Integer test = random.nextInt(19) + 1;

                try {
                    switch (test) {
                        case 1:
                            taService.updateThesis(1, "Analysis and comparison between the new file proposals of the different operating systems (update)", "Thesis description (update)", "thesisSystemOperativeUpdate.pdf", 102829);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        case 10:
                            break;
                        case 11:
                            break;
                        case 12:
                            break;
                        case 13:
                            break;
                        case 14:
                            break;
                        case 15:
                            break;
                        case 16:
                            break;
                        case 17:
                            break;
                        case 18:
                            break;
                        case 19:
                            break;
                        case 20:
                            break;
                    }
                } catch (SQLException e) { throw new RuntimeException(e);}
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
