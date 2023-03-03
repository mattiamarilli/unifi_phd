package emulation;
import didacticoffer.Appeal;
import didacticoffer.Course;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentEmulation {

    public static void main(String[] args) throws SQLException{
        OrganizationChartService ocService = new OrganizationChartService();
        DidacticOfferService doService = new DidacticOfferService();

        final int studentFreshman = 3920391;

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int variable;
        String studentName, studentSurname, studentEmail, studentTopics, studentPassword;

        List<FacultyMember> facultyMembers;
        List<Appeal> appeals;

        do{

            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Edit profile");
            System.out.println("Case 2: Edit password");
            System.out.println("Case 3: View faculty members");

            System.out.println("Case 4: View all appeals");
            System.out.println("Case 5: Accept vote");
            System.out.println("Case 6: Appeal registration");


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

                    break;
                case 5:
                    System.out.println("\nAccept vote");
                    break;
                case 6:
                    System.out.println("\nAppeal registration");
                    break;
                default:
                    break;
            }

        }while (variable != 0);

    }

}
