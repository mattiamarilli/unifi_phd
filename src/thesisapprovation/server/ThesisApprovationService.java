package thesisapprovation.server;

import organizationchart.Student;
import thesisapprovation.EvaluationCommittee;
import thesisapprovation.Review;
import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;
import thesisapprovation.data_access.ReviewDao;
import thesisapprovation.data_access.ReviewerDao;
import thesisapprovation.data_access.ThesisDao;
import thesisapprovation.proxy.ThesisApprovationProxy;

import java.awt.desktop.SystemEventListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class ThesisApprovationService {

    private ThesisDao thesisDao;
    private ReviewDao reviewDao;
    private ReviewerDao reviewerDao;
    private ThesisApprovationProxy thesisApprovationProxy;
    public ThesisApprovationService(){
        this.thesisDao = new ThesisDao();
        this.reviewDao = new ReviewDao();
        this.reviewerDao = new ReviewerDao();
    }

    //METODI PER ThesisDao

    //inserimento student into thesis approvation
    public Boolean insertStudentToThesisApprovation(Integer studentFreshman) throws SQLException {
        Thesis t = new Thesis(studentFreshman, "Not_approved");
        return thesisDao.insert(t);
    }

    //inserimento/modifica thesis by student freshman in bozza
    public Boolean updateThesis(Integer id, String title, String description, String urlDocument, Integer studentFreshman) throws SQLException{
        Thesis t = new Thesis(id, title, description, urlDocument, studentFreshman);
        return thesisDao.update(t);
    }

    //modifica state by id thesis
    public Boolean updateStateThesis(Integer idThesis, String state) throws SQLException{
        return thesisDao.updateStateThesis(idThesis, state);
    }

    //modifica loaded by student freshman (utlizzato quando viene consegnata la tesi oppure quando viene ritirata dalla consegna)
    public Boolean updateLoadedThesis(Integer studentFreshman, String loaded) throws SQLException{
        return thesisDao.updateLoadedThesis(studentFreshman, loaded);
    }

    //elimina thesis by id
    public Boolean deleteThesis(Integer id) throws SQLException{
        return thesisDao.delete(id);
    }

    //delete thesis by student
    public Boolean deleteThesisByStudent(Integer studentFreshman) throws SQLException{
        return thesisDao.deleteThesisByStudent(studentFreshman);
    }

    //visualizza reviewer della propria Evaluation Committee
    public List<Reviewer> getReviewersByStudent(Integer studentFreshman) throws SQLException{
        return thesisDao.getReviewersByStudent(studentFreshman);
    }

    //visualizza reviews by reviewer and student
    public Review getReviewByStudentReviewer(Integer studentFreshman, Integer freshmanReviewer) throws SQLException{
        return thesisDao.getReviewByStudentReviewer(studentFreshman, freshmanReviewer);
    }

    //visualizza thesis by id (utilizzato dallo studente per visualizzare la sua tesi)
    public Thesis getThesisById(Integer id) throws SQLException{
        return thesisDao.findByKey(id);
    }

    //inserimento evaluationCommittee
    public Boolean insertEvaluationCommittee(Integer idThesis, Integer reviewerFreshman) throws SQLException{
        return thesisDao.insertEvaluation(idThesis, reviewerFreshman);
    }

    //visualizza tesi by student
    public Thesis getThesisByStudent(Integer studentFreshman) throws SQLException{
        return thesisDao.getThesisByStudent(studentFreshman);
    }

    //METODI PER ReviewerDao

    //Inserimento Reviewer
    public Boolean insertReviewer(Integer freshman, String name, String surname, String password, String email, String description) throws SQLException{
        Reviewer r = new Reviewer(freshman, name, surname, password, email, description);
        return reviewerDao.insert(r);
    }

    //elimina reviewer
    public Boolean deleteReviewer(Integer freshman) throws SQLException{
        return reviewerDao.delete(freshman);
    }

    //modifica reviewer
    public Boolean updateReviewer(Integer freshman, String name, String surname, String email, String description) throws SQLException{
        Reviewer r = new Reviewer(freshman, name, surname, email, description);
        return reviewerDao.update(r);
    }

    //get reviewer by freshman
    public Reviewer getReviewerByFreshman(Integer reviewerFreshman) throws SQLException{
        return reviewerDao.findByKey(reviewerFreshman);
    }

    //modifica password reviewer
    public Boolean updatePasswordReviewer(Integer freshman, String password) throws SQLException{
        return reviewerDao.updatePassword(freshman, password);
    }

    //visualizza tutti gli studenti by reviewer freshman
    public List<Student> getStudentsByReviewer(Integer reviewerFreshman) throws SQLException{
        List<Integer> studentFreshmen = reviewerDao.getStudentFreshmen(reviewerFreshman);
        List<Student> students = new ArrayList<Student>();

        this.thesisApprovationProxy = new ThesisApprovationProxy();
        for(Integer i : studentFreshmen){
            Student s = thesisApprovationProxy.getStudentsInformation(i);
            students.add(s);
        }

        return students;
    }

    public List<Thesis> getThesisLoadedNotApproved(Integer reviewerFreshman) throws SQLException{
        return reviewerDao.getThesisLoadedNotApprovedByReviewer(reviewerFreshman);
    }


    //METODI PER ReviewDao

    //inserimento review
    public Boolean insertReview(Integer idThesis, Integer reviewerFreshman, String title, String comment) throws SQLException{
        Reviewer r = new Reviewer(reviewerFreshman);
        Thesis t = new Thesis(idThesis);
        EvaluationCommittee ec = new EvaluationCommittee(t, r);

        Review review = new Review(title, comment, ec);

        return reviewDao.insert(review);
    }

    //modifica review
    public Boolean updateReview(Integer idReview, String title, String comment) throws SQLException{
        Reviewer r = new Reviewer();
        Thesis t = new Thesis();
        EvaluationCommittee ec = new EvaluationCommittee(t, r);

        Review review = new Review(idReview, title, comment, ec);
        return reviewDao.update(review);
    }

    //elimina review
    public Boolean deleteReview(Integer idReview) throws SQLException{
        return reviewDao.delete(idReview);
    }

    //get all reviews by reviewer freshman
    public List<Review> getAllReviewsByReviewer(Integer reviewerFreshman) throws SQLException{
        return reviewDao.getAllReviewsByReviewer(reviewerFreshman);
    }

}
