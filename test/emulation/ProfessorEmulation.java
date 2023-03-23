package emulation;

import didacticoffer.Appeal;
import didacticoffer.AppealParticipation;
import didacticoffer.Lesson;
import organizationchart.Student;
import didacticoffer.server.*;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ProfessorEmulation {

    public static void main(String[] args) throws SQLException, InterruptedException {

        final int professorFreshman = 9033829;
        final String courseCode = "C003830";

        DidacticOfferService doService = new DidacticOfferService();

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        int variable, idLesson, idAppeal;
        Boolean result;
        Date date;
        List<Lesson> lessons;
        List<Appeal> appeals;
        String note;
        Integer room = null;
        String universityComplex = null;
        String university = null;

        do{
            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Edit profile");
            System.out.println("Case 2: Edit password");
            System.out.println("Case 3: Insert lesson");
            System.out.println("Case 4: View lessons");
            System.out.println("Case 5: Update lesson");
            System.out.println("Case 6: Delete lesson");
            System.out.println("Case 7: Insert appeal");
            System.out.println("Case 8: View appeals");
            System.out.println("Case 9: Update appeal");
            System.out.println("Case 10: Delete appeal");
            System.out.println("Case 11: Insert vote to student");
            System.out.println("Case 12: View students' profile");
            System.out.println("Case 13: Update course status");

            System.out.print("\nPlease enter the variable value: ");
            variable = sc.nextInt();

            switch (variable)
            {
                case 0:
                    System.out.println("\nExit program, goodbye");
                    break;
                case 1:
                    System.out.println("\nEdit profile");

                    System.out.println("\nProfessor before update: ");
                    System.out.println(doService.getProfessorByFreshman(professorFreshman));

                    System.out.print("\nName: ");
                    String name = sc.next();
                    System.out.print("Surname: ");
                    String surname = sc.next();
                    System.out.print("Specialization: ");
                    String specialization = sc.next();
                    System.out.print("University: ");
                    university = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();

                    result = doService.updateProfessor(professorFreshman, name, surname, specialization, university, email);

                    if(result){
                        System.out.println("\nProfessor after update:");
                        System.out.println(doService.getProfessorByFreshman(professorFreshman));
                    }
                    break;
                case 2:
                    System.out.println("\nEdit password");

                    System.out.println("\nProfessor before password update: ");
                    System.out.println(doService.getProfessorByFreshman(professorFreshman));

                    System.out.print("\nNew password: ");
                    String password = sc.next();

                    result = doService.updatePasswordProfessor(professorFreshman, password);

                    if(result){
                        System.out.println("\nProfessor after password update:");
                        System.out.println(doService.getProfessorByFreshman(professorFreshman));
                    }

                    break;
                case 3:
                    System.out.println("\nInsert lesson");

                    try {
                        System.out.print("Enter the Date (yyyy-MM-dd): ");
                        date = dateFormat.parse(sc.next());
                        java.sql.Date dateSql = new java.sql.Date(date.getTime());

                        System.out.print("Enter the start time (HH:mm): ");
                        Date startTime = timeFormat.parse(sc.next());
                        java.sql.Time startTimeSql = new java.sql.Time(startTime.getTime());

                        System.out.print("Enter the end time (HH:mm): ");
                        Date endTime = timeFormat.parse(sc.next());
                        java.sql.Time endTimeSql = new java.sql.Time(endTime.getTime());

                        System.out.println("Select mode: ");
                        System.out.println("1) Online");
                        System.out.println("2) Presence");

                        System.out.print("Insert the number of the chosen mode: ");
                        int modeNumber = sc.nextInt();
                        String mode;

                        switch(modeNumber){
                            case 1:
                                mode = "Online";
                                break;
                            case 2:
                                mode = "Presence";
                                System.out.print("Insert room: ");
                                room = sc.nextInt();
                                System.out.print("Insert university complex: ");
                                universityComplex = sc.next();
                                System.out.print("Insert university: ");
                                university = sc.next();
                                break;
                            default:
                                System.out.println("Error select mode");
                                return;
                        }

                        doService.insertLesson(dateSql, startTimeSql, endTimeSql, room, universityComplex, university, mode, courseCode);

                    } catch (ParseException e) {
                        System.out.println("Error insert date/time");
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("\nView lessons by course code");

                    lessons = doService.getLessonsByCourseCode(courseCode);

                    for(Lesson l : lessons)
                        System.out.println(l);
                    break;
                case 5:
                    System.out.println("\nUpdate lesson");

                    System.out.println("\nView id lessons: ");
                    lessons = doService.getLessonsByCourseCode(courseCode);

                    for(Lesson l : lessons)
                        System.out.println("- " + l.getId());

                    System.out.print("Insert the id of the lesson you want to edit: ");
                    idLesson = sc.nextInt();

                    try {
                        System.out.print("Enter the new date (yyyy-MM-dd): ");
                        date = dateFormat.parse(sc.next());
                        java.sql.Date dateSql = new java.sql.Date(date.getTime());

                        System.out.print("Enter the new start time (HH:mm): ");
                        Date startTime = timeFormat.parse(sc.next());
                        java.sql.Time startTimeSql = new java.sql.Time(startTime.getTime());

                        System.out.print("Enter the new end time (HH:mm): ");
                        Date endTime = timeFormat.parse(sc.next());
                        java.sql.Time endTimeSql = new java.sql.Time(endTime.getTime());

                        System.out.println("Select new mode: ");
                        System.out.println("1) Online");
                        System.out.println("2) Presence");

                        System.out.print("Insert the number of the chosen new mode: ");
                        int modeNumber = sc.nextInt();
                        String mode;

                        switch(modeNumber){
                            case 1:
                                mode = "Online";
                                break;
                            case 2:
                                mode = "Presence";
                                System.out.print("Insert new room: ");
                                room = sc.nextInt();
                                System.out.print("Insert new university complex: ");
                                universityComplex = sc.next();
                                System.out.print("Insert new university: ");
                                university = sc.next();
                                break;
                            default:
                                System.out.println("Error select mode");
                                return;
                        }

                        doService.updateLesson(idLesson, dateSql, startTimeSql, endTimeSql, room, universityComplex, university, mode, courseCode);

                        System.out.println("\nView lessons after update: ");

                        lessons = doService.getLessonsByCourseCode(courseCode);

                        for(Lesson l : lessons)
                            System.out.println(l);

                    } catch (ParseException e) {
                        System.out.println("Error insert date/time");
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("\nDelete lesson");

                    System.out.println("\nView id lessons: ");
                    lessons = doService.getLessonsByCourseCode(courseCode);

                    for(Lesson l : lessons)
                        System.out.println("- " + l.getId());

                    System.out.print("Insert the id of the lesson you want to delete: ");
                    idLesson = sc.nextInt();

                    doService.deleteLesson(idLesson);
                    break;
                case 7:
                    System.out.println("\nInsert appeal");

                    try{
                        System.out.print("Insert date (yyyy-MM-dd): ");
                        date = dateFormat.parse(sc.next());
                        java.sql.Date dateSql = new java.sql.Date(date.getTime());

                        System.out.print("Enter the start time (HH:mm): ");
                        Date startTime = timeFormat.parse(sc.next());
                        java.sql.Time startTimeSql = new java.sql.Time(startTime.getTime());

                        System.out.println("Select mode: ");
                        System.out.println("1) Online");
                        System.out.println("2) Presence");

                        System.out.print("Insert the number of the chosen mode: ");
                        int modeNumber = sc.nextInt();
                        String mode;

                        switch(modeNumber){
                            case 1:
                                mode = "Online";
                                break;
                            case 2:
                                mode = "Presence";
                                System.out.print("Insert room: ");
                                room = sc.nextInt();
                                System.out.print("Insert university complex: ");
                                universityComplex = sc.next();
                                System.out.print("Insert university: ");
                                university = sc.next();
                                break;
                            default:
                                System.out.println("Error select mode");
                                return;
                        }

                        System.out.print("Insert note: ");
                        note = sc.next();

                        doService.insertAppeal(dateSql, startTimeSql, room, universityComplex, university, note, mode, courseCode);

                    }catch (ParseException e){
                        System.out.println("Error insert date/time");
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.println("\nView appeals by course code");

                    appeals = doService.getAppealsByCourseCode(courseCode);

                    for(Appeal a : appeals)
                        System.out.println(a);

                    break;
                case 9:
                    System.out.println("\nUpdate appeal");

                    System.out.println("\nView appeals id: ");
                    appeals = doService.getAppealsByCourseCode(courseCode);

                    for(Appeal a : appeals)
                        System.out.println("- " + a.getId());

                    System.out.print("\nInsert the id of the appeal you want to edit: ");
                    idAppeal = sc.nextInt();

                    try{
                        System.out.print("Insert new date (yyyy-MM-dd): ");
                        date = dateFormat.parse(sc.next());
                        java.sql.Date dateSql = new java.sql.Date(date.getTime());

                        System.out.print("Enter the new start time (HH:mm): ");
                        Date startTime = timeFormat.parse(sc.next());
                        java.sql.Time startTimeSql = new java.sql.Time(startTime.getTime());

                        System.out.println("Select new mode: ");
                        System.out.println("1) Online");
                        System.out.println("2) Presence");

                        System.out.print("Insert the number of the chosen new mode: ");
                        int modeNumber = sc.nextInt();
                        String mode;

                        switch(modeNumber){
                            case 1:
                                mode = "Online";
                                break;
                            case 2:
                                mode = "Presence";
                                System.out.print("Insert new room: ");
                                room = sc.nextInt();
                                System.out.print("Insert new university complex: ");
                                universityComplex = sc.next();
                                System.out.print("Insert new university: ");
                                university = sc.next();
                                break;
                            default:
                                System.out.println("Error select new mode");
                                return;
                        }

                        System.out.print("Insert new note: ");
                        note = sc.next();

                        doService.updateAppeal(idAppeal, dateSql, startTimeSql, room, universityComplex, university, note, mode, courseCode);

                    }catch (ParseException e){
                        System.out.println("Error insert date/time");
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    System.out.println("\nDelete appeal");

                    System.out.println("\nView appeals id: ");
                    appeals = doService.getAppealsByCourseCode(courseCode);

                    for(Appeal a : appeals)
                        System.out.println("- " + a.getId());

                    System.out.print("\nInsert the id of the appeal you want to delete: ");
                    idAppeal = sc.nextInt();

                    doService.deleteAppeal(idAppeal);
                    break;
                case 11:
                    System.out.println("\nInsert vote to student");

                    System.out.println("\nView appeal participation without vote by course code: ");
                    List<AppealParticipation> appealParticipations = doService.getAppealParticipationWithoutVoteByCourseCode(courseCode);

                    for(AppealParticipation ap : appealParticipations)
                        System.out.println("-Student freshman: " + ap.getStudentCareer().getFreshmanStudent() + ", id appeal: " + ap.getAppeal().getId());

                    System.out.print("\nInsert student freshman: ");
                    int studentFreshman = sc.nextInt();
                    System.out.print("Insert appeal id: ");
                    idAppeal = sc.nextInt();

                    System.out.print("Insert vote: ");
                    String vote = sc.next();

                    doService.updateVote(studentFreshman, idAppeal, vote);


                    break;
                case 12:
                    System.out.println("\nView students' profile by professor:");

                    List<Student> students = doService.getAllStudentsByProfessor(professorFreshman);

                    for(Student s : students)
                        System.out.println(s);
                    break;
                case 13:
                    System.out.println("\nUpdate course status to Attended");

                    doService.updateStateStudyPlan(courseCode, "Attended");
                    break;
                default:
                    break;
            }


        }while(variable != 0);

    }


}
