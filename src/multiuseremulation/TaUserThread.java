package multiuseremulation;

import didacticoffer.server.DidacticOfferService;
import thesisapprovation.server.ThesisApprovationService;

import java.sql.SQLException;
import java.util.Random;

public class TaUserThread implements Runnable{
    private ThesisApprovationService taService;
    private final int millisecondsSleep = 300;

    public TaUserThread(ThesisApprovationService taService) {
        this.taService = taService;
    }

    @Override
    public void run() {
        int test = 0;
        int count = 1;
        do {
            try {
                Random random = new Random();
                test = random.nextInt(17) + 1;
                System.out.println(Thread.currentThread().getName());

                try {
                    switch (test) {
                        case 1:
                            taService.updateThesis(1, "Analysis and comparison between the new file proposals of the different operating systems (update)", "Thesis description (update)", "thesisSystemOperativeUpdate.pdf", 102829);
                            break;
                        case 2:
                            taService.updateLoadedThesis(2, "Not_load");
                            break;
                        case 3:
                            taService.updateStateThesis(7028492, "Approved");
                            break;
                        case 4:
                            taService.getReviewersByStudent(7028492);
                            break;
                        case 5:
                            taService.getReviewByStudentReviewer(7028492, 3485395);
                            break;
                        case 6:
                            taService.getThesisById(5);
                            break;
                        case 7:
                            taService.deleteThesis(1);
                            break;
                        case 8:
                            taService.insertEvaluationCommittee(1, 8420391);
                            break;
                        case 9:
                            taService.getThesisByStudentReviewer(3923920, 3294503);
                            break;
                        case 10:
                            taService.insertReviewer(3920384, "Name Test", "Surname Test", "Password Test", "test@test.it", "Description reviewer test");
                            break;
                        case 11:
                            taService.deleteReviewer(8420391);
                            break;
                        case 12:
                            taService.updateReviewer(5940249, "Roberto update", "Giorgi update", "robaerto.giorgi@iid.unisi.it", "Computer Architecture; Parallel and Distributed Computing Update");
                            break;
                        case 13:
                            taService.updatePasswordReviewer(7389203, "Password update");
                            break;
                        case 14:
                            taService.insertReview(2, 	3485395,"test", "comment test");
                            break;
                        case 15:
                            taService.updateReview(2, 7389203, "Title update", "Comment update");
                            break;
                        case 16:
                            taService.deleteReview(7);
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
