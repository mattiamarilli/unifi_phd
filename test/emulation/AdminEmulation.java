package emulation;
import didacticoffer.Course;
import didacticoffer.Professor;
import org.junit.jupiter.api.Test;
import organizationchart.Cycle;
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

        int variable, studentFreshman, fmFreshman, studentYear, cycleYear;
        String studentName, studentSurname, studentEmail, studentPassword, studentTopics, cycleNumber, cycleDescription;
        String fmName, fmSurname, fmEmail, fmPassword, fmSpecialization, fmInstitution;
        Boolean result;
        List<Student> students;
        List<FacultyMember> facultyMembers;
        List<Cycle> cycles;


        do{

            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Insert student");
            System.out.println("Case 2: View all students");
            System.out.println("Case 3: Delete student");
            System.out.println("Case 4: Assign advisor to student");
            System.out.println("Case 5: Promotes student next year");

            System.out.println("Case 6: Insert cycle");
            System.out.println("Case 7: View all cycles");
            System.out.println("Case 8: Update cycle");
            System.out.println("Case 9: Delete cycle");

            System.out.println("Case 10: Insert faculty member");
            System.out.println("Case 11: View all faculty members");
            System.out.println("Case 12: Delete faculty member");

            System.out.println("Case 13: Insert scientist");
            System.out.println("Case 14: Delete scientist");
            System.out.println("Case 15: Insert supervisory committee");

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
                case 6:
                    System.out.println("\nInsert cycle");

                    System.out.print("\nInsert cycle number: ");
                    cycleNumber = sc.next();
                    System.out.print("Insert cycle year: ");
                    cycleYear = sc.nextInt();
                    System.out.print("Insert cycle description: ");
                    cycleDescription = sc.next();

                    ocService.insertCycle(cycleNumber, cycleYear, cycleDescription);
                    break;
                case 7:
                    System.out.println("\nView all cycles:");

                    cycles = ocService.getAllCycles();
                    for(Cycle c : cycles)
                        System.out.println(c);
                    break;
                case 8:
                    System.out.println("\nUpdate cycle");

                    System.out.println("\nView all cycles numbers: ");
                    cycles = ocService.getAllCycles();
                    for(Cycle c : cycles)
                        System.out.println("- " + c.getNumber());

                    System.out.print("\nInsert cycle number you want edit: ");
                    cycleNumber = sc.next();
                    System.out.print("Insert new year: ");
                    cycleYear = sc.nextInt();
                    System.out.print("Insert new description: ");
                    cycleDescription = sc.next();
                    ocService.updateCycle(cycleNumber, cycleYear, cycleDescription);
                    break;
                case 9:
                    System.out.println("\nDelete cycle");

                    System.out.println("\nView all cycles numbers: ");
                    cycles = ocService.getAllCycles();
                    for(Cycle c : cycles)
                        System.out.println("- " + c.getNumber());
                    System.out.print("\nInsert cycle number you want delete: ");
                    cycleNumber = sc.next();
                    ocService.deleteCycle(cycleNumber);
                    break;
                case 10:
                    System.out.println("\nInsert faculty member");

                    System.out.print("\nInsert faculty member freshman: ");
                    fmFreshman = sc.nextInt();
                    System.out.print("Insert faculty member name: ");
                    fmName = sc.next();
                    System.out.print("Insert faculty member surname: ");
                    fmSurname = sc.next();
                    System.out.print("Insert faculty member email: ");
                    fmEmail = sc.next();
                    System.out.print("Insert faculty member password: ");
                    fmPassword = sc.next();
                    System.out.print("Insert faculty member specialization: ");
                    fmSpecialization = sc.next();
                    System.out.print("Insert faculty member institution: ");
                    fmInstitution = sc.next();
                    System.out.print("Insert faculty member cycle: ");
                    cycleNumber = sc.next();

                    ocService.insertFacultyMember(fmFreshman, fmName, fmSurname, fmEmail, fmPassword, fmSpecialization, fmInstitution, cycleNumber);
                    break;
                case 11:
                    System.out.println("\nView all faculty members: ");
                    facultyMembers = ocService.getAllFacultyMembers();
                    for(FacultyMember fm : facultyMembers)
                        System.out.println(fm);
                    break;
                case 12:
                    System.out.println("\nDelete faculty member");

                    System.out.println("\nView all faculty members freshmen: ");
                    facultyMembers = ocService.getAllFacultyMembers();
                    for(FacultyMember fm : facultyMembers)
                        System.out.println("- " + fm.getFreshman());

                    System.out.print("\nInsert faculty member freshman you want delete: ");
                    fmFreshman = sc.nextInt();
                    ocService.deleteFacultyMember(fmFreshman);
                    break;
                case 13:
                    System.out.println("\nInsert scientist");
                    break;
                case 14:
                    System.out.println("\nDelete scientist");
                    break;
                case 15:
                    System.out.println("\nInsert supervisory committee");
                    break;
                default:
                    break;
            }
        }while(variable != 0);
    }
}
