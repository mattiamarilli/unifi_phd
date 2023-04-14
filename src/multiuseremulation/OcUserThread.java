package multiuseremulation;

import organizationchart.server.OrganizationChartService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class OcUserThread implements Runnable{

    private OrganizationChartService ocService;
    private final int millisecondsSleep = 1000;


    public OcUserThread(OrganizationChartService ocService) {
        this.ocService = ocService;
    }

    @Override
    public void run() {
        int test = 0;
        int count = 1;
        do {
            try {
                Random random = new Random();
                test = random.nextInt(21) + 1;
                System.out.println(Thread.currentThread().getName());

                try {
                    switch (test) {
                        case 1:
                            ocService.insertStudent(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Password Test", "Topics Test", "XXVII");
                            break;
                        case 2:
                            ocService.updateStudent(4728103, "Enrico (update)", "Meloni (update)", "enrico.meloni@unifi.it (update)", "topics update");
                            break;
                        case 3:
                            ocService.updateStudentPassword(3923920, "Password update");
                            break;
                        case 4:
                            ocService.updateStudentAdvisor(3920391, 5749249);
                            break;
                        case 5:
                            ocService.updateStudentYear(9302912, 3);
                            break;
                        case 6:
                            ocService.deleteStudent(7328102);
                            break;
                        case 7:
                            ocService.getAllStudents();
                            break;
                        case 8:
                            ocService.getStudentByFreshman(102829);
                            break;
                        case 9:
                            ocService.getStudentsByYear(3);
                            break;
                        case 10:
                            ocService.getStudentsByCycle("XXVI");
                            break;
                        case 11:
                            ocService.getStudentsByAdvisor(281392);
                            break;
                        case 12:
                            ocService.insertCycle("X", 2010, "Cycle test");
                            break;
                        case 13:
                            ocService.updateCycle("XXVIII", 2021, "Automatic and Optimization (update)");
                            break;
                        case 14:
                            ocService.deleteCycle("XXVI");
                            break;
                        case 15:
                            ocService.getAllCycles();
                            break;
                        case 16:
                            ocService.insertFacultyMember(1111111, "Name test", "Surname test", "test@test.it", "Password test", "Specialization test", "Institution test", "XXVI");
                            break;
                        case 17:
                            ocService.updateFacultyMember(3840149, "Paolo (update)", "Fresconi (update)", "paolo.fresconi@unifi.it", "Machine Learning; Bioinformatics (update)", "University of Florence");
                            break;
                        case 18:
                            ocService.updateFacultyMemberPassword(5849204, "Password update");
                            break;
                        case 19:
                            ocService.deleteFacultyMember(427190);
                            break;
                        case 20:
                            ocService.getAllFacultyMembers();
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
