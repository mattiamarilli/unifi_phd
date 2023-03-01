package emulation;

import didacticoffer.AppealParticipation;
import didacticoffer.Professor;
import org.junit.jupiter.api.Test;
import organizationchart.Student;
import organizationchart.server.*;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProfessorEmulation {

    public static void main(String[] args) throws SQLException{

        final int professorFreshman = 9033829;
        final String courseCode = "C003830";

        DidacticOfferService doService = new DidacticOfferService();

        Scanner sc = new Scanner(System.in);

        int variable;
        Boolean result;

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
                    String university = sc.next();
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
                    break;
                case 4:
                    System.out.println("\nView lessons");
                    break;
                case 5:
                    System.out.println("\nUpdate lesson");
                    break;
                case 6:
                    System.out.println("\nDelete lesson");
                    break;
                case 7:
                    System.out.println("\nInsert appeal");
                    break;
                case 8:
                    System.out.println("\nView appeals");
                    break;
                case 9:
                    System.out.println("\nUpdate appeal");
                    break;
                case 10:
                    System.out.println("\nDelete appeal");
                    break;
                case 11:
                    System.out.println("\nInsert vote to student");
                    break;
                case 12:
                    System.out.println("\nView students' profile");
                    break;
                case 13:
                    System.out.println("\nUpdate course status");
                    break;
                default:
                    break;
            }


        }while(variable != 0);

    }


}
