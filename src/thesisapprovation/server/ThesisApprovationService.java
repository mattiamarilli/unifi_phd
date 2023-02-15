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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThesisApprovationService {

    private ThesisDao thesisDao;
    private ReviewDao reviewDao;
    private ReviewerDao reviewerDao;

    private ThesisApprovationProxy thesisApprovationProxy;
    public ThesisApprovationService(){
        this.thesisDao = new ThesisDao();
        this.reviewDao = new ReviewDao();
        this.reviewerDao = new ReviewerDao();
        this.thesisApprovationProxy = new ThesisApprovationProxy();
    }

    //METODI PER ThesisDao

    //inserimento thesis (ovvero carica la tesi)
    public void insertThesis(String title, String description, String urlDocument, Integer studentFreshman) throws SQLException {
        Thesis t = new Thesis(title, description, urlDocument, studentFreshman);
        thesisDao.insert(t);
    }

    //modifica thesis by studentfreshman
    public void updateThesis(String title, String description, String urlDocument, Integer studentFreshman) throws SQLException{
        Thesis t = new Thesis(title, description, urlDocument, studentFreshman);
        thesisDao.update(t);
    }

    //modifica state by studentFreshman
    public void updateStateThesis(Integer studentFreshman, String state) throws SQLException{
        thesisDao.updateStateThesis(studentFreshman, state);
    }

    //modifica loaded by student freshman (utlizzato quando viene consegnata la tesi oppure quando viene ritirata dalla consegna)
    public void updateLoadedThesis(Integer studentFreshman, String loaded) throws SQLException{
        thesisDao.updateLoadedThesis(studentFreshman, loaded);
    }

    //elimina thesis
    public void deleteThesis(Integer id) throws SQLException{
        thesisDao.delete(id);
    }

    //visualizza reviewer della propria Evaluation Committee
    public List<Reviewer> getReviewersByStudent(Integer studentFreshman) throws SQLException{
        return thesisDao.getReviewersByStudent(studentFreshman);
    }

    //visualizza reviews by reviewer and student
    public Review getReviewByStudentReviewer(Integer studentFreshman, Integer freshmanReviewer) throws SQLException{
        return thesisDao.getReviewsByStudentReviewer(studentFreshman, freshmanReviewer);
    }

    //visualizza thesis by id (utilizzato dallo studente per visualizzare la sua tesi)
    public Thesis getThesisById(Integer id) throws SQLException{
        return thesisDao.findByKey(id);
    }

    //inserimento evaluationCommittee
    public void insertEvaluationCommittee(Integer idThesis, Integer reviewerFreshman) throws SQLException{
        thesisDao.insertEvaluation(idThesis, reviewerFreshman);
    }

    //visualizza tesi by student
    public Thesis getThesisByStudent(Integer studentFreshman) throws SQLException{
        Thesis t = thesisDao.getThesisByStudent(studentFreshman);
        return t;
    }

    //METODI PER ReviewerDao

    //Inserimento Reviewer
    public void insertReviewer(Integer freshman, String name, String surname, String password, String email, String description) throws SQLException{
        Reviewer r = new Reviewer(freshman, name, surname, password, email, description);
        reviewerDao.insert(r);
    }

    //elimina reviewer
    public void deleteReviewer(Integer freshman) throws SQLException{
        reviewDao.delete(freshman);
    }

    //modifica reviewer
    public void updateReviewer(Integer freshman, String name, String surname, String email, String description) throws SQLException{
        Reviewer r = new Reviewer(freshman, name, surname, email, description);
        reviewerDao.update(r);
    }

    //modifica password reviewer
    public void updatePasswordReviewer(Integer freshman, String password) throws SQLException{
        reviewerDao.updatePassword(freshman, password);
    }

    //visualizza tutti gli studenti by reviewer freshman
    public List<Student> getStudentsByReviewer(Integer reviewerFreshman) throws SQLException{
        List<Integer> studentFreshmen = reviewerDao.getStudentFreshmen(reviewerFreshman);
        List<Student> students = new ArrayList<Student>();

        for(Integer i : studentFreshmen){
            Student s = thesisApprovationProxy.getStudentsInformation(i);
            students.add(s);
        }

        return students;
    }


    //METODI PER ReviewDao

    //inserimento review
    public void insertReview(Integer idThesis, Integer reviewerFreshman, String title, String comment) throws SQLException{
        Reviewer r = new Reviewer(reviewerFreshman);
        Thesis t = new Thesis(idThesis);
        EvaluationCommittee ec = new EvaluationCommittee(t, r);

        Review review = new Review(title, comment, ec);

        reviewDao.insert(review);
    }

    //modifica review
    public void updateReview(Integer idThesis, Integer reviewerFreshman, Integer idReview, String title, String comment) throws SQLException{
        Reviewer r = new Reviewer(reviewerFreshman);
        Thesis t = new Thesis(idThesis);
        EvaluationCommittee ec = new EvaluationCommittee(t, r);

        Review review = new Review(idReview, title, comment, ec);
        reviewDao.update(review);
    }

    //elimina review
    public void deleteReview(Integer idReview) throws SQLException{
        reviewDao.delete(idReview);
    }


}
