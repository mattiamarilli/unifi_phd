package multiuseremulation;

import didacticoffer.server.DidacticOfferService;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Random;

public class DoUserThread implements Runnable{
    private DidacticOfferService doService;
    private final int millisecondsSleep = 3000;

    public DoUserThread(DidacticOfferService doService) {
        this.doService = doService;
    }

    @Override
    public void run() {
        int test = 0;
        int count = 1;
        do{
            try {
                Random random = new Random();
                test = random.nextInt(25) + 1;

                try {
                    switch (test) {
                        case 1:
                            doService.insertProfessor(9999999,"Name Test","Surname Test","Test Specialization","Test University","test@unifi.it","testpassword");
                            break;
                        case 2:
                            doService.updateCodeCourseProfessor(9876583,"B184721");
                            break;
                        case 3:
                            doService.updateProfessor(1029371,"Franchesco (update)", "Chiti (update)","Statistical signal processing; Remote sensing (update)","University of Florence (update)","francesco.chiti@unifi.it (update)");
                            break;
                        case 4:
                            doService.updatePasswordProfessor(1329371,"Password update");
                            break;
                        case 5:
                            doService.deleteProfessor(1229371);
                            break;
                        case 6:
                            doService.getProfessorByFreshman(9999999);
                            break;
                        case 7:
                            doService.getAllProfessors();
                            break;
                        case 8:
                            doService.getAllStudentsByProfessor(1329371);
                            break;
                        case 9:
                            doService.getAllCourses();
                            break;
                        case 10:
                            doService.insertCourse("B00001", "Title Test", "Description Test", 2, 2022);
                            break;
                        case 11:
                            doService.updateCourse("B037592","Genetic Algorithms (update)", "Description course (Update)", 2, 2022);
                            break;
                        case 12:
                            doService.deleteCourse("B002352");
                            break;
                        case 13:
                            doService.updateStateStudyPlan("B032592","Attended");
                            break;
                        case 14:
                            Date d = new Date(10000);
                            Time t = new Time(1000);
                            doService.insertLesson(d, t, t, 002, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592");
                            break;
                        case 15:
                            doService.deleteLesson(9);
                            break;
                        case 16:
                            doService.deleteAppeal(9);
                            break;
                        case 17:
                            doService.acceptVoteByStudent(7028492,7);
                            break;
                        case 18:
                            doService.updateVote(9302912,6,"30 e lode");
                            break;
                        case 19:
                            doService.getAppealParticipationByStudent(3820392);
                            break;
                        case 20:
                            doService.insertAppealParticipation(7028492,21);
                            break;
                        case 21:
                            doService.deleteStudyPlan(4728103,"A009381");
                            break;
                        case 22:
                            doService.getCoursesByStudentFreshman(3820392);
                            break;
                        case 23:
                            doService.getCoursesAccreditedByStudentFreshman(4728103);
                            break;
                        case 24:
                            doService.getAppealParticipationByStudent(4728103);
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
        }while (!Thread.currentThread().isInterrupted() && test != 25 && count != 25);
    }
}
