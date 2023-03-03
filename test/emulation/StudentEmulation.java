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

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int variable;

        do{
            System.out.print("\nPlease enter the variable value:");
            variable = sc.nextInt();

            switch (variable)
            {
                case 0:
                    System.out.println("\nExit program, goodbye");
                    break;
                default:
                    break;
            }

        }while (variable != 0);

    }

}
