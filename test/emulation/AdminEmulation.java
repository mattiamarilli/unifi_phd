package emulation;
import didacticoffer.Course;
import didacticoffer.Professor;
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
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdminEmulation {

    public static void main(String[] args) throws SQLException{
        OrganizationChartService ocService = new OrganizationChartService();


        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int variable, studentFreshman, fmFreshman, studentYear;
        String studentName, studentSurname, studentEmail, studentPassword, studentTopics, cycleNumber;
        Boolean result;
        List<Student> students;
        List<FacultyMember> facultyMembers;


        do{

            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Insert student");
            System.out.println("Case 2: View all students");
            System.out.println("Case 3: Delete student");
            System.out.println("Case 4: Assign advisor to student");
            System.out.println("Case 5: Promotes student next year");

            System.out.print("\nEnter value the variable: ");
            variable = sc.nextInt();

            switch (variable)
            {
                case 0:
                    System.out.println("\nExit program, goodbye");
                    break;
                case 1:
                    System.out.println("\nInsert student");

                    System.out.print("\nInsert student freshman: ");
                    studentFreshman = sc.nextInt();
                    System.out.print("Insert student name: ");
                    studentName = sc.next();
                    System.out.print("Insert student surname: ");
                    studentSurname = sc.next();
                    System.out.print("Insert student email: ");
                    studentEmail = sc.next();
                    System.out.print("Insert student password: ");
                    studentPassword = sc.next();
                    System.out.print("Insert student topics: ");
                    studentTopics = sc.next();
                    System.out.print("Insert cycle number: ");
                    cycleNumber = sc.next();
                    ocService.insertStudent(studentFreshman, studentName, studentSurname, studentEmail, studentPassword, studentTopics, cycleNumber);

                    break;
                case 2:
                    System.out.println("\nView all students:");

                    students = ocService.getAllStudents();

                    for(Student s : students)
                        System.out.println(s);
                    break;
                case 3:
                    System.out.println("\nDelete student");

                    System.out.println("\nView all student freshmen: ");
                    students = ocService.getAllStudents();

                    for(Student s : students)
                        System.out.println("- " + s.getFreshman());

                    System.out.print("\nInsert student freshman that you want delete: ");
                    studentFreshman = sc.nextInt();

                    result = ocService.deleteStudent(studentFreshman);
                    if(result)
                        System.out.println("\nDelete successful");
                    else
                        System.out.println("\nDelete not successful");
                    break;
                case 4:
                    System.out.println("\nAssign advisor to student");

                    System.out.println("\nView all student freshmen: ");
                    students = ocService.getAllStudents();

                    for(Student s : students)
                        System.out.println("- " + s.getFreshman());

                    System.out.print("\nInsert student freshman: ");
                    studentFreshman = sc.nextInt();

                    System.out.println("\nView all faculty members freshmen: ");
                    facultyMembers = ocService.getAllFacultyMembers();

                    for(FacultyMember fm : facultyMembers)
                        System.out.println("- " + fm.getFreshman());

                    System.out.print("\nInsert faculty member freshman: ");
                    fmFreshman = sc.nextInt();

                    result = ocService.updateStudentAdvisor(studentFreshman, fmFreshman);

                    if(result)
                        System.out.println("Assigned advisor " + fmFreshman + " to student " + studentFreshman);
                    break;
                case 5:
                    System.out.println("\nPromotes student next year");

                    System.out.println("\nView all student freshmen: ");
                    students = ocService.getAllStudents();

                    for(Student s : students)
                        System.out.println("- " + s.getFreshman());

                    System.out.print("\nInsert student freshman you want to promote: ");
                    studentFreshman = sc.nextInt();

                    studentYear = ocService.getStudentByFreshman(studentFreshman).getYear();
                    result = ocService.updateStudentYear(studentFreshman, studentYear + 1);

                    if(result)
                        System.out.println("\nStudent promotion successful");
                    else
                        System.out.println("\nStudent promotion not successful");
                    break;
                default:
                    break;
            }


        }while(variable != 0);
    }
}
