package emulation;

import org.junit.jupiter.api.Test;
import organizationchart.server.*;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.sql.SQLException;
import java.util.Scanner;

public class ScientistEmulation {

    public static void main(String[] args) throws SQLException {
        final int scientistFreshman = 7237583;

        ProgressReportService prService = new ProgressReportService();

        Scanner sc = new Scanner(System.in);
        int variable;
        Boolean result;

        do{

            System.out.println("\nCase 0: Exit program");
            System.out.println("Case 1: Edit profile");
            System.out.println("Case 2: Edit password");
            System.out.println("Case 3: Get students' profile");
            System.out.println("Case 4: View progress report");

            System.out.print("\nPlease enter the variable value: ");
            variable = sc.nextInt();

            switch(variable){
                case 0:
                    System.out.println("\nExit program, goodbye");
                    break;
                case 1:
                    System.out.println("\nEdit profile");

                    System.out.println("\nScientist before update:");
                    System.out.println(prService.getScientistByFreshman(scientistFreshman));

                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Surname: ");
                    String surname = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Description: ");
                    String description = sc.next();
                    result = prService.updateScientist(scientistFreshman, name, surname, email, description);

                    if(result) {
                        System.out.println("\nScientist after update:");
                        System.out.println(prService.getScientistByFreshman(scientistFreshman));
                    }else
                        System.out.println("Error edit profile");

                    break;
                case 2:
                    System.out.println("\nEdit password");

                    System.out.println("\nScientist before password update:");
                    System.out.println(prService.getScientistByFreshman(scientistFreshman));

                    System.out.print("New password: ");
                    String password = sc.next();
                    result = prService.updatePasswordScientist(scientistFreshman, password);

                    if(result) {
                        System.out.println("\nScientist after password update:");
                        System.out.println(prService.getScientistByFreshman(scientistFreshman));
                    }else
                        System.out.println("Error edit password");
                    break;
                case 3:
                    System.out.println("\nGet students' profile");
                    break;
                case 4:
                    System.out.println("\nView progress report by id");
                    break;
                default:
                    break;
            }

        }while(variable != 0);

    }
}