package emulation;

import org.junit.jupiter.api.Test;
import organizationchart.Student;
import organizationchart.server.*;
import thesisapprovation.Review;
import thesisapprovation.Thesis;
import thesisapprovation.server.*;
import progressreport.server.*;
import didacticoffer.server.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ReviewerEmulation {

    public static void main(String[] args) throws SQLException {

        final int reviewerFreshman = 5940249;

        ThesisApprovationService taService = new ThesisApprovationService();
        List<Review> reviews;
        int idReview;
        int studentFreshman;

        Scanner sc = new Scanner(System.in);
        int variable;
        Boolean result;

        do{

            System.out.println("\ncase 0: Exit program");
            System.out.println("Case 1: Edit profile");
            System.out.println("Case 2: Edit password");
            System.out.println("Case 3: Get students' profile");
            System.out.println("Case 4: Gets thesis by student freshman");
            System.out.println("Case 5: Insert review");
            System.out.println("Case 6: Update review");
            System.out.println("Case 7: Delete review");
            System.out.println("Case 8: View reviews");

            System.out.print("\nPlease enter the variable value: ");
            variable=sc.nextInt();

            switch (variable)
            {
                case 0:
                    System.out.println("\nExit program, goodbye");
                    break;
                case 1:
                    System.out.println("\nEdit profile");

                    System.out.println("\nReviewer before update:");
                    System.out.println(taService.getReviewerByFreshman(reviewerFreshman));

                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Surname: ");
                    String surname = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Description: ");
                    String description = sc.next();
                    result = taService.updateReviewer(reviewerFreshman, name, surname, email, description);

                    if(result) {
                        System.out.println("\nReviewer after update:");
                        System.out.println(taService.getReviewerByFreshman(reviewerFreshman));
                    }else
                        System.out.println("Error edit profile");
                    break;
                case 2:
                    System.out.println("\nEdit password");

                    System.out.println("Reviewer before password update:");
                    System.out.println(taService.getReviewerByFreshman(reviewerFreshman));

                    System.out.print("New password: ");
                    String password = sc.next();
                    result = taService.updatePasswordReviewer(reviewerFreshman, password);

                    if(result){
                        System.out.println("Reviewer after update:");
                        System.out.println(taService.getReviewerByFreshman(reviewerFreshman));
                    }else
                        System.out.println("Error edit password");
                    break;
                case 3:
                    System.out.println("\nGets students' profile");

                    List<Student> students = taService.getStudentsByReviewer(reviewerFreshman);
                    for(Student s : students)
                        System.out.println(s.toString());
                    break;
                case 4:
                    System.out.println("\nGets thesis by student freshman");

                    System.out.println("list of students of which you are Evaluation Committee:");
                    for(Student s : taService.getStudentsByReviewer(reviewerFreshman)){
                        System.out.println("- " + s.getFreshman());
                    }

                    System.out.print("Insert student freshman: ");
                    studentFreshman = sc.nextInt();

                    System.out.println(taService.getThesisByStudentReviewer(studentFreshman, reviewerFreshman));
                    break;
                case 5:
                    System.out.println("\nCase 5: Insert review");

                    System.out.println("Thesis list you can review:");

                    List<Thesis> thesisList = taService.getThesisLoadedNotApproved(reviewerFreshman);
                    for(Thesis t : thesisList){
                        System.out.println("- " + t.toString());
                    }

                    if(thesisList.size() > 0) {
                        System.out.print("Insert the thesis id that you can review:");
                        int idThesis = sc.nextInt();

                        System.out.print("Title review: ");
                        String title = sc.next();
                        System.out.println("Comment review: ");
                        String comment = sc.next();

                        taService.insertReview(idThesis, reviewerFreshman, title, comment);
                    }
                    break;
                case 6:
                    System.out.println("\nUpdate review");

                    System.out.println("\nGet reviews by reviewer freshman: ");
                    reviews = taService.getAllReviewsByReviewer(reviewerFreshman);
                    for(Review r : reviews)
                        System.out.println("- " + r.toString());

                    System.out.print("\nInsert id review: ");
                    idReview = sc.nextInt();
                    System.out.print("Insert new title: ");
                    String title = sc.next();
                    System.out.print("Insert new comment: ");
                    String comment = sc.next();

                    taService.updateReview(idReview, reviewerFreshman, title, comment);

                    System.out.println("\nReviews after update by reviewer freshman: ");
                    for(Review r : taService.getAllReviewsByReviewer(reviewerFreshman))
                        System.out.println("- " + r.toString());
                    break;
                case 7:
                    System.out.println("\nDelete review");

                    System.out.println("\nGet reviews by reviewer freshman: ");
                    reviews = taService.getAllReviewsByReviewer(reviewerFreshman);
                    for(Review r : reviews)
                        System.out.println("- " + r.toString());

                    System.out.print("\nInsert id review: ");
                    idReview = sc.nextInt();
                    taService.deleteReview(idReview);
                    break;
                case 8:
                    System.out.println("\nView reviews");

                    System.out.println("\nGet reviews by reviewer freshman: ");
                    reviews = taService.getAllReviewsByReviewer(reviewerFreshman);
                    for(Review r : reviews)
                        System.out.println("- " + r.toString());
                    break;
                default:
                    break;
            }

        }while (variable != 0);

    }
}
