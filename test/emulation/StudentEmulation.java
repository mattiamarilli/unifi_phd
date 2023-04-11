package emulation;
import didacticoffer.Appeal;
import didacticoffer.AppealParticipation;
import didacticoffer.Course;
import didacticoffer.StudyPlan;
import org.junit.jupiter.api.Test;
import organizationchart.FacultyMember;
import organizationchart.Student;
import organizationchart.server.*;
import progressreport.ProgressReport;
import progressreport.Scientist;
import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.text.ParseException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentEmulation {

    public static void main(String[] args) throws SQLException, ParseException, InterruptedException {
        OrganizationChartService ocService = OrganizationChartService.getInstance();
        DidacticOfferService doService = DidacticOfferService.getInstance();

        final int studentFreshman = 3920391;

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int variable, appealId;
        String studentName, studentSurname, studentEmail, studentTopics, studentPassword, courseCode;

        List<FacultyMember> facultyMembers;
        List<Appeal> appeals;
        List<AppealParticipation> appealParticipations;
        List<Course> courses;
        List<StudyPlan> studyPlans;

        Boolean result;

        do{

            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Edit profile");
            System.out.println("Case 2: Edit password");
            System.out.println("Case 3: View faculty members");

            System.out.println("Case 4: View all appeals");
            System.out.println("Case 5: Accept vote");
            System.out.println("Case 6: Appeal registration");
            System.out.println("Case 7: Delete appeal participation");
            System.out.println("Case 8: View appeals participation");

            System.out.println("Case 9: Course registration");
            System.out.println("Case 10: Delete course registration");
            System.out.println("Case 11: View enrolled courses");
            System.out.println("Case 12: View accredited courses");

            System.out.print("\nPlease enter the variable value:");
            variable = sc.nextInt();

            switch (variable)
            {
                case 0:
                    System.out.println("\nExit program, goodbye");
                    break;
                case 1:
                    System.out.println("\nEdit profile");

                    System.out.print("\nInsert new name: ");
                    studentName = sc.next();
                    System.out.print("Insert new surname: ");
                    studentSurname = sc.next();
                    System.out.print("Insert new email: ");
                    studentEmail = sc.next();
                    System.out.print("Insert new topics: ");
                    studentTopics = sc.next();

                    ocService.updateStudent(studentFreshman, studentName, studentSurname, studentEmail, studentTopics);
                    break;
                case 2:
                    System.out.println("\nEdit password");

                    System.out.print("\nInsert new password: ");
                    studentPassword = sc.next();

                    ocService.updateStudentPassword(studentFreshman, studentPassword);
                    break;
                case 3:
                    System.out.println("\nView faculty members: ");

                    facultyMembers = ocService.getAllFacultyMembers();
                    for(FacultyMember fm : facultyMembers)
                        System.out.println(fm);
                    break;
                case 4:
                    System.out.println("\nView appeals by student freshman: ");

                    appeals = doService.getAppealsByStudentFreshman(studentFreshman);
                    for(Appeal a : appeals)
                        System.out.println(a);
                    break;
                case 5:
                    System.out.println("\nAccept vote");

                    System.out.println("\nView appeals that you want to accept: ");
                    appeals = doService.getAppealsToAccept(studentFreshman);
                    for(Appeal a : appeals)
                        System.out.println(a);

                    System.out.print("\nInsert id appeal you want to accept: ");
                    appealId = sc.nextInt();

                    result = doService.acceptVoteByStudent(studentFreshman, appealId);

                    if(result)
                        System.out.println("Accept vote successful");
                    break;
                case 6:
                    System.out.println("\nAppeal registration");

                    System.out.println("\nView appeals you can register: ");
                    appeals = doService.getAppealsToRegister(studentFreshman);
                    for(Appeal a : appeals)
                        System.out.println(a);

                    System.out.print("\nInsert the appeal id you want to register: ");
                    appealId = sc.nextInt();

                    doService.insertAppealParticipation(studentFreshman, appealId);
                    break;
                case 7:
                    System.out.println("\nDelete appeal participation");

                    System.out.println("\nView appeals participation: ");
                    appealParticipations = doService.getAppealParticipationByStudent(studentFreshman);
                    for(AppealParticipation ap : appealParticipations)
                        System.out.println("- "+ ap.getAppeal());

                    System.out.print("\nInsert the appeal id you want delete: ");
                    appealId = sc.nextInt();

                    doService.deleteAppealParticipationByStudent(studentFreshman, appealId);
                    break;
                case 8:
                    System.out.println("\nView appeals participation: ");
                    appealParticipations = doService.getAppealParticipationByStudent(studentFreshman);
                    for(AppealParticipation ap : appealParticipations)
                        System.out.println("- "+ ap.getAppeal());
                    break;
                case 9:
                    System.out.println("\nCourse registration");

                    System.out.println("\nView courses you aren't registered: ");
                    courses = doService.getCoursesNotRegisteredByStudent(studentFreshman);
                    for(Course c : courses)
                        System.out.println(c);

                    System.out.print("\nInsert code course: ");
                    courseCode = sc.next();

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(formatter.format(date));
                    java.sql.Date dateSql = new java.sql.Date(date1.getTime());
                    doService.insertStudyPlan(studentFreshman, courseCode, dateSql);
                    break;
                case 10:
                    System.out.println("\nDelete course registration");

                    System.out.println("\nView study plans: ");
                    studyPlans = doService.getStudyPlansByStudent(studentFreshman);
                    for(StudyPlan sp : studyPlans)
                        System.out.println("- Code course: " + sp.getCourse().getCode());

                    System.out.print("\nInsert course code you want delete: ");
                    courseCode = sc.next();

                    doService.deleteStudyPlan(studentFreshman, courseCode);
                    break;
                case 11:
                    System.out.println("\nView registered courses:");

                    courses = doService.getCoursesByStudentFreshman(studentFreshman);
                    for(Course c : courses)
                        System.out.println(c);
                    break;
                case 12:
                    System.out.println("\nView accredited courses:");

                    courses = doService.getCoursesAccreditedByStudentFreshman(studentFreshman);
                    for(Course c : courses)
                        System.out.println(c);
                    break;
                default:
                    break;
            }

        }while (variable != 0);

    }

}
