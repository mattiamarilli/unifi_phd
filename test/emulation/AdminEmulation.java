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
        ProgressReportService prService = new ProgressReportService();
        DidacticOfferService doService = new DidacticOfferService();
        ThesisApprovationService taService = new ThesisApprovationService();


        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int variable, studentFreshman, fmFreshman, studentYear, cycleYear, scientistFreshman, progressReportId, professorFreshman;
        int courseCfu, courseYear, reviewerFreshman, thesisId;
        String studentName, studentSurname, studentEmail, studentPassword, studentTopics, cycleNumber, cycleDescription;
        String fmName, fmSurname, fmEmail, fmPassword, fmSpecialization, fmInstitution, scientistName;
        String scientistSurname, scientistEmail, scientistPassword, scientistDescription, professorName, professorSurname;
        String professorSpecialization, professorUniversity, professorEmail, professorPassword, courseCode, courseTitle;
        String courseDescription, reviewerName, reviewerSurname, reviewerPassword, reviewerEmail, reviewerDescription;
        Boolean result;
        List<Student> students;
        List<FacultyMember> facultyMembers;
        List<Cycle> cycles;
        List<Scientist> scientists;
        List<ProgressReport> progressReports;
        List<Professor> professors;
        List<Course> courses;
        List<Thesis> theses;
        List<Reviewer> reviewers;


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

            System.out.println("Case 16: Insert professor");
            System.out.println("Case 17: View all professors");
            System.out.println("Case 18: Delete professor");

            System.out.println("Case 19: Insert course");
            System.out.println("Case 20: View all courses");
            System.out.println("Case 21: Update course");
            System.out.println("Case 22: Delete course");
            System.out.println("Case 23: Assign course to professor");

            System.out.println("Case 24: Insert reviewer");
            System.out.println("Case 25: Delete reviewer");
            System.out.println("Case 26: Insert evaluation committee");
            System.out.println("Case 27: Change the status of theses");

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

                    System.out.print("\nInsert scientist freshman: ");
                    scientistFreshman = sc.nextInt();
                    System.out.print("Insert scientist name: ");
                    scientistName = sc.next();
                    System.out.print("Insert scientist surname: ");
                    scientistSurname = sc.next();
                    System.out.print("Insert scientist email: ");
                    scientistEmail = sc.next();
                    System.out.print("Insert scientist password: ");
                    scientistPassword = sc.next();
                    System.out.print("Insert scientist description: ");
                    scientistDescription = sc.next();
                    prService.insertScientist(scientistFreshman, scientistName, scientistSurname, scientistPassword, scientistEmail, scientistDescription);
                    break;
                case 14:
                    System.out.println("\nDelete scientist");

                    System.out.println("\nView all scientists freshmen: ");
                    scientists = prService.getAllScientists();
                    for(Scientist s : scientists)
                        System.out.println("- " + s.getFreshman());

                    System.out.print("\nInsert scientist freshman you want delete: ");
                    scientistFreshman = sc.nextInt();
                    prService.deleteScientist(scientistFreshman);
                    break;
                case 15:
                    System.out.println("\nInsert supervisory committee");

                    System.out.println("\nView all progress reports id and student freshmen: ");
                    progressReports = prService.getAllProgressReports();
                    for(ProgressReport pr : progressReports)
                        System.out.println("- id: " + pr.getId() + ", student freshmen: " + pr.getFreshmanStudent());

                    System.out.print("\nInsert progress report id you want to insert in the Supervisory Committee: ");
                    progressReportId = sc.nextInt();

                    System.out.println("\nView all scientists freshmen: ");
                    scientists = prService.getAllScientists();
                    for(Scientist s : scientists)
                        System.out.println("- " + s.getFreshman());
                    System.out.print("\nInsert scientist freshman you want to insert in the Supervisory Committee: ");
                    scientistFreshman = sc.nextInt();
                    prService.insertSupervisoryCommittee(progressReportId, scientistFreshman);
                    break;
                case 16:
                    System.out.println("\nInsert professor");

                    System.out.print("\nInsert professor freshmen: ");
                    professorFreshman = sc.nextInt();
                    System.out.print("Insert professor name: ");
                    professorName = sc.next();
                    System.out.print("Insert professor surname: ");
                    professorSurname = sc.next();
                    System.out.print("Insert professor specialization: ");
                    professorSpecialization = sc.next();
                    System.out.print("Insert professor university: ");
                    professorUniversity = sc.next();
                    System.out.print("Insert professor email: ");
                    professorEmail = sc.next();
                    System.out.print("Insert professor password: ");
                    professorPassword = sc.next();
                    doService.insertProfessor(professorFreshman, professorName, professorSurname, professorSpecialization, professorUniversity, professorEmail, professorPassword);
                    break;
                case 17:
                    System.out.println("\nView all professors: ");
                    professors = doService.getAllProfessors();
                    for(Professor p : professors)
                        System.out.println(p);
                    break;
                case 18:
                    System.out.println("\nDelete professor");

                    System.out.println("\nView all professors freshmen: ");
                    professors = doService.getAllProfessors();
                    for(Professor p : professors)
                        System.out.println("- " + p.getFreshman());

                    System.out.print("\nInsert professor freshmen you want delete: ");
                    professorFreshman = sc.nextInt();
                    doService.deleteProfessor(professorFreshman);
                    break;
                case 19:
                    System.out.println("\nInsert course");

                    System.out.print("\nInsert course code: ");
                    courseCode = sc.next();
                    System.out.print("Insert course title: ");
                    courseTitle = sc.next();
                    System.out.print("Insert course description: ");
                    courseDescription = sc.next();
                    System.out.print("Insert course cfu: ");
                    courseCfu = sc.nextInt();
                    System.out.print("Insert course year: ");
                    courseYear = sc.nextInt();
                    doService.insertCourse(courseCode, courseTitle, courseDescription, courseCfu, courseYear);
                    break;
                case 20:
                    System.out.println("\nView all courses: ");

                    courses = doService.getAllCourses();
                    for(Course c : courses)
                        System.out.println(c);
                    break;
                case 21:
                    System.out.println("\nUpdate course");

                    System.out.println("\nView all courses code: ");

                    courses = doService.getAllCourses();
                    for(Course c : courses)
                        System.out.println("- " + c.getCode());

                    System.out.print("\nInsert course code you want to edit: ");
                    courseCode = sc.next();

                    System.out.print("Insert new title: ");
                    courseTitle = sc.next();
                    System.out.print("Insert new description: ");
                    courseDescription = sc.next();
                    System.out.print("Insert new cfu: ");
                    courseCfu = sc.nextInt();
                    System.out.print("Insert new year: ");
                    courseYear = sc.nextInt();
                    doService.updateCourse(courseCode, courseTitle, courseDescription, courseCfu, courseYear);
                    break;
                case 22:
                    System.out.println("\nDelete course");

                    System.out.println("\nView all courses code: ");

                    courses = doService.getAllCourses();
                    for(Course c : courses)
                        System.out.println("- " + c.getCode());

                    System.out.print("\nInsert course code you want to delete: ");
                    courseCode = sc.next();
                    doService.deleteCourse(courseCode);
                    break;
                case 23:
                    System.out.println("\nAssign course to professor");

                    System.out.println("\nView all professors freshmen without course");
                    professors = doService.getAllProfessorsWithoutCourse();
                    for(Professor p : professors)
                        System.out.println("- " + p.getFreshman());

                    System.out.print("\nInsert professor freshmen you want assign to course: ");
                    professorFreshman = sc.nextInt();

                    System.out.println("\nView all courses code and titles: ");
                    courses = doService.getAllCourses();
                    for(Course c : courses)
                        System.out.println("- Code: " + c.getCode() + ", Title: " + c.getTitle());

                    System.out.print("\nInsert course code you want assign to professor: ");
                    courseCode = sc.next();

                    doService.updateCodeCourseProfessor(professorFreshman, courseCode);
                case 24:
                    System.out.println("\nInsert reviewer");

                    System.out.print("\nInsert reviewer freshman: ");
                    reviewerFreshman = sc.nextInt();
                    System.out.print("Insert reviewer name: ");
                    reviewerName = sc.next();
                    System.out.print("Insert reviewer surname: ");
                    reviewerSurname = sc.next();
                    System.out.print("Insert reviewer password: ");
                    reviewerPassword = sc.next();
                    System.out.print("Insert reviewer email: ");
                    reviewerEmail = sc.next();
                    System.out.print("Insert reviewer description: ");
                    reviewerDescription = sc.next();

                    taService.insertReviewer(reviewerFreshman, reviewerName, reviewerSurname, reviewerPassword, reviewerEmail, reviewerDescription);
                    break;
                case 25:
                    System.out.println("\nDelete reviewer");

                    System.out.println("\nView all reviewers freshmen: ");
                    reviewers = taService.getAllReviewers();
                    for(Reviewer r : reviewers)
                        System.out.println("- " + r.getFreshman());

                    System.out.print("\nInsert reviewer freshman you want to delete: ");
                    reviewerFreshman = sc.nextInt();

                    taService.deleteReviewer(reviewerFreshman);
                    break;
                case 26:
                    System.out.println("\nInsert evaluation committee");

                    System.out.println("\nView all theses id and students freshmen: ");
                    theses = taService.getAllThesis();
                    for(Thesis t : theses)
                        System.out.println("- Id: " + t.getId() + ", student freshman: " + t.getStudentFreshman());

                    System.out.print("\nInsert theses id you want to insert in the evaluation committee: ");
                    thesisId = sc.nextInt();

                    System.out.println("\nView all reviewers freshmen:");
                    reviewers = taService.getAllReviewers();
                    for(Reviewer r : reviewers)
                        System.out.println("- " + r.getFreshman());

                    System.out.print("\nInsert reviewer freshmen you want to insert in the evaluation committee: ");
                    reviewerFreshman = sc.nextInt();

                    taService.insertEvaluationCommittee(thesisId, reviewerFreshman);
                    break;
                case 27:
                    System.out.println("\nChange the status of theses");

                    System.out.println("\nView all theses that aren't approved and loaded: ");
                    theses = taService.getThesesLoadedNotApproved();
                    for(Thesis t : theses)
                        System.out.println("- Title: " + t.getTitle() + ", student freshman: " + t.getStudentFreshman());

                    System.out.print("\nInsert student freshman you want to change status: ");
                    studentFreshman = sc.nextInt();
                    taService.updateStateThesis(studentFreshman, "Approved");
                    break;
                default:
                    break;
            }
        }while(variable != 0);
    }
}
