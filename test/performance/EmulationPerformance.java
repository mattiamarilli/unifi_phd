package performance;


import didacticoffer.server.DidacticOfferService;
import multiuseremulation.DoUserThread;
import multiuseremulation.OcUserThread;
import multiuseremulation.PrUserThread;
import multiuseremulation.TaUserThread;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import organizationchart.server.OrganizationChartService;
import progressreport.server.ProgressReportService;
import thesisapprovation.server.ThesisApprovationService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class EmulationPerformance {

    public static void initializeExcel(String excelFilePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        for(int i = 0; i< 50; i++)
            sheet.createRow(i);

        workbook.close();
    }

    public static void updateExcel(long number, String excelFilePath, int numberRow, int numberColumn){

        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(numberRow);

            row.createCell(numberColumn).setCellValue(number);

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }

    public static void getLatenciesOc(OrganizationChartService ocService,String excelFilePath,int numberRow, int numberColumn) throws InterruptedException, SQLException {
        //organizationchart
        long start, end;

        Thread.sleep(1000);

        start = System.currentTimeMillis();
        ocService.insertStudent(9999999, "Name Test", "Surname Test", "test@test@unifi.it", "Password Test", "Topics Test", "XXVII" );
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateStudent(4728103, "Enrico (update)", "Meloni (update)", "enrico.meloni@unifi.it (update)", "topics update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateStudentPassword(3923920, "Password update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateStudentAdvisor(3920391, 5749249);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateStudentYear(9302912, 3);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.deleteStudent(7328102);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getAllStudents();
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getStudentByFreshman(102829);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getStudentsByYear(3);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getStudentsByCycle("XXVI");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getStudentsByAdvisor(281392);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.insertCycle("X", 2010, "Cycle test");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateCycle("XXVIII", 2021, "Automatic and Optimization (update)");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.deleteCycle("XXVI");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getAllCycles();
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.insertFacultyMember(1111111, "Name test", "Surname test", "test@test.it", "Password test", "Specialization test", "Institution test", "XXVI");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateFacultyMember(3840149, "Paolo (update)", "Fresconi (update)", "paolo.fresconi@unifi.it", "Machine Learning; Bioinformatics (update)", "University of Florence");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.updateFacultyMemberPassword(5849204, "Password update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.deleteFacultyMember(427190);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        ocService.getAllFacultyMembers();
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);
    }

    public static void getLatenciesPr(ProgressReportService prService,String excelFilePath,int numberRow, int numberColumn) throws InterruptedException, SQLException {
        //progressreport
        long start, end;

        Thread.sleep(1000);

        start = System.currentTimeMillis();
        prService.updateProgressReport(1, "Progress Report end first year (update)", "Description progress report", "url1_2.pdf");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.updateStateProgressReport(3820539, "Load");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.getProgressReportByStudent(3472126);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.getScientistsByStudent(3820539);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.insertSupervisoryCommittee(1, 7237583);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.insertScientist(4802402, "Guido", "Gagliardi", "Password", "guido.gagliardi@unifi.it", "Machine learning");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.updateScientist(7637585, "Alessio", "Vecchio", "alessio.vecchio@unipi.it", "Pervasive and mobile computing (update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.updatePasswordScientist(5894375, "Password (update)");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.getStudentBySupervisory(4029304);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.getProgressReportByScientistStudent(7237583, 3472126);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.deleteScientist(9237583);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        prService.deleteProgressReport(6);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

    }

    public static void getLatenciesDo(DidacticOfferService doService,String excelFilePath,int numberRow, int numberColumn) throws InterruptedException, SQLException {
        //didacticoffer
        long start, end;

        Thread.sleep(1000);
        start = System.currentTimeMillis();
        doService.insertProfessor(9999999,"Name Test","Surname Test","Test Specialization","Test University","test@unifi.it","testpassword");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateCodeCourseProfessor(9876583,"B184721");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateProfessor(1029371,"Franchesco (update)", "Chiti (update)","Statistical signal processing; Remote sensing (update)","University of Florence (update)","francesco.chiti@unifi.it (update)");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updatePasswordProfessor(1329371,"Password update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.deleteProfessor(1229371);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getProfessorByFreshman(9999999);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getAllProfessors();
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getAllStudentsByProfessor(1329371);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getAllCourses();
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.insertCourse("B00001", "Title Test", "Description Test", 2, 2022);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateCourse("B037592","Genetic Algorithms (update)", "Description course (Update)", 2, 2022);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.deleteCourse("B002352");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateStateStudyPlan("B032592","Attended");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        Date d = new Date(10000);
        Time t = new Time(1000);
        start = System.currentTimeMillis();
        doService.insertLesson(d, t, t, 002, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateLesson(1, d, t, t, 001, "Centro Didattico Morgagni", "University of Florence", "Presence", "B032592");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.deleteLesson(9);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.insertAppeal(d,t,002,"Centro Didattico Morgagni", "University of Florence","note", "Presence", "B032592");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateAppeal(1,d, t, 001, "Centro Didattico Morgagni", "University of Florence","note", "Presence", "B032592");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.deleteAppeal(9);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.acceptVoteByStudent(7028492,7);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.updateVote(9302912,6,"30 e lode");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getAppealParticipationByStudent(3820392);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.insertAppealParticipation(7028492,21);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.deleteAppealParticipationByStudent(102829,22);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.insertStudyPlan(7328102,"A009381", d);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.deleteStudyPlan(4728103,"A009381");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getCoursesByStudentFreshman(3820392);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getCoursesAccreditedByStudentFreshman(4728103);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        doService.getAppealParticipationByStudent(4728103);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);
    }

    public static void getLatenciesTa(ThesisApprovationService taService,String excelFilePath,int numberRow, int numberColumn) throws InterruptedException, SQLException {
        //thesis approvation
        long start, end;

        Thread.sleep(1000);



        start = System.currentTimeMillis();
        taService.updateThesis(1, "Analysis and comparison between the new file proposals of the different operating systems (update)", "Thesis description (update)", "thesisSystemOperativeUpdate.pdf", 102829);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.updateLoadedThesis(2, "Not_load");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.updateStateThesis(7028492, "Approved");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.getReviewersByStudent(7028492);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.getReviewByStudentReviewer(7028492, 3485395);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.getThesisById(5);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.deleteThesis(1);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.insertEvaluationCommittee(1, 8420391);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.getThesisByStudentReviewer(3923920, 3294503);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.insertReviewer(3920384, "Name Test", "Surname Test", "Password Test", "test@test.it", "Description reviewer test");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.deleteReviewer(8420391);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.updateReviewer(5940249, "Roberto update", "Giorgi update", "robaerto.giorgi@iid.unisi.it", "Computer Architecture; Parallel and Distributed Computing Update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.updatePasswordReviewer(7389203, "Password update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.insertReview(2, 	3485395,"test", "comment test");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.updateReview(2, 7389203, "Title update", "Comment update");
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

        start = System.currentTimeMillis();
        taService.deleteReview(7);
        end = System.currentTimeMillis();
        updateExcel(end-start,excelFilePath,numberRow++,numberColumn);

    }

    public static void runUsers(Integer ocUsersNumber,Integer doUsersNumber,Integer prUsersNumber, Integer taUsersNumber, OrganizationChartService ocService, ProgressReportService prService,DidacticOfferService doService,ThesisApprovationService taService) throws InterruptedException, SQLException {
        ArrayList<Thread> ocUsers = new ArrayList<Thread>();
        for(int i = 0;i<ocUsersNumber;i++)
            ocUsers.add(new Thread(new OcUserThread(ocService)));

        ArrayList<Thread> doUsers = new ArrayList<Thread>();
        for(int i = 0;i<doUsersNumber;i++)
            doUsers.add(new Thread(new DoUserThread(doService)));

        ArrayList<Thread> prUsers = new ArrayList<Thread>();
        for(int i = 0;i<prUsersNumber;i++)
            prUsers.add(new Thread(new PrUserThread(prService)));

        ArrayList<Thread> taUsers = new ArrayList<Thread>();
        for(int i = 0;i<taUsersNumber;i++)
            taUsers.add(new Thread(new TaUserThread(taService)));

        for(int i = 0; i<ocUsersNumber; i++)
            ocUsers.get(i).start();

        for(int i = 0; i<doUsersNumber; i++)
            doUsers.get(i).start();

        for(int i = 0; i<prUsersNumber; i++)
            prUsers.get(i).start();

        for(int i = 0; i<taUsersNumber; i++)
            taUsers.get(i).start();
    }

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        OrganizationChartService ocService = new OrganizationChartService();
        ProgressReportService prService = new ProgressReportService();
        DidacticOfferService doService = new DidacticOfferService();
        ThesisApprovationService taService = new ThesisApprovationService();

        runUsers(2,2,2,2,ocService,prService,doService,taService);

        Thread.sleep(1000);


        for(int i = 1; i<100; i++)
            getLatenciesOc(ocService,"/Users/mattiamarilli/Progetti/unifi_phd/documentation/Oc.xlsx",0,i);
    }

}

//        Thread threadLatency = new Thread(() -> {
//            try {
//                Thread.sleep(200);
//                getLatencies(ocService,prService,doService,taService);
//                System.out.println("bella");
//            } catch (InterruptedException | SQLException e) {
//                throw new RuntimeException(e);
//            }
//        });



//threadLatency.start();
