package emulation;
import org.junit.jupiter.api.Test;
import organizationchart.Cycle;
import organizationchart.Student;
import organizationchart.server.*;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacultyMemberEmulation {

    public static void main(String[] args) throws SQLException, InterruptedException {

        final int fmFreshman = 593183;

        OrganizationChartService ocService = new OrganizationChartService();

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int variable;
        List<Student> students;
        List<Cycle> cycles;

        do{
            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Edit profile");
            System.out.println("Case 2: Edit password");
            System.out.println("Case 3: View all students");
            System.out.println("Case 4: View all cycles");
            System.out.println("Case 5: View students by year");
            System.out.println("Case 6: View students by cycle");
            System.out.println("Case 7: View students by advisor");
            System.out.println("Case 8: Views student by freshman");

            System.out.print("\nPlease enter the variable value: ");
            variable = sc.nextInt();

            switch (variable)
            {
                case 0:
                    System.out.println("Exit program, goodbye");
                    break;
                case 1:
                    System.out.println("Edit profile");

                    System.out.println("\nFaculty member before update:");
                    System.out.println(ocService.getFacultyMember(fmFreshman));

                    System.out.print("\nName: ");
                    String name = sc.next();
                    System.out.print("Surname: ");
                    String surname = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Specialization: ");
                    String specialization = sc.next();
                    System.out.print("Institution: ");
                    String institution = sc.next();

                    ocService.updateFacultyMember(fmFreshman, name, surname, email, specialization, institution);

                    System.out.println("\nFaculty member after update:");
                    System.out.println(ocService.getFacultyMember(fmFreshman));
                    break;
                case 2:
                    System.out.println("Edit password");

                    System.out.print("\nNew password: ");
                    String password = sc.next();

                    ocService.updateFacultyMemberPassword(fmFreshman, password);
                    break;
                case 3:
                    System.out.println("View all students");

                    students = ocService.getAllStudents();

                    for(Student s : students)
                        System.out.println(s);
                    break;
                case 4:
                    System.out.println("View all cycles");

                    cycles = ocService.getAllCycles();

                    for(Cycle c : cycles)
                        System.out.println(c);
                    break;
                case 5:
                    System.out.println("View students by year");

                    System.out.println("\nChoose the year of students you want to view:");
                    System.out.println("1) First year students");
                    System.out.println("2) Second year students");
                    System.out.println("3) Third year students");
                    System.out.println("4) Ex students");

                    System.out.print("\nInsert number: ");
                    int studentYear = sc.nextInt();

                    if(studentYear < 1 || studentYear > 4)
                        System.out.println("Error number");
                    else{
                        students = ocService.getStudentsByYear(studentYear);

                        for(Student s : students)
                            System.out.println(s);
                    }
                    break;
                case 6:
                    System.out.println("View students by cycle");

                    System.out.println("\nView all cycles number");
                    cycles = ocService.getAllCycles();

                    for(Cycle c : cycles)
                        System.out.println("- " + c.getNumber());

                    System.out.print("\nInsert cycle number: ");
                    String cycleNumber = sc.next();

                    students = ocService.getStudentsByCycle(cycleNumber);

                    for(Student s : students)
                        System.out.println(s);
                    break;
                case 7:
                    System.out.println("View students by advisor:");

                    students = ocService.getStudentsByAdvisor(fmFreshman);

                    for(Student s : students)
                        System.out.println(s);
                    break;
                case 8:
                    System.out.println("Views student by freshman");

                    System.out.println("View all students freshmen:");
                    students = ocService.getAllStudents();

                    for(Student s : students)
                        System.out.println("- " + s.getFreshman());

                    System.out.print("\nInsert student freshman: ");
                    int studentFreshman = sc.nextInt();

                    System.out.println(ocService.getStudentByFreshman(studentFreshman));
                    break;
                default:
                    break;
            }


        }while (variable != 0);

    }


}
