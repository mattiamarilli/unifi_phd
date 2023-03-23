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
import java.util.Random;
import java.util.function.BiPredicate;

public class ThesisApprovationService {

    private final int millisecondsDelay = 5000;

    private Boolean available = true;
    private ThesisDao thesisDao;
    private ReviewDao reviewDao;
    private ReviewerDao reviewerDao;
    private ThesisApprovationProxy thesisApprovationProxy;
    public ThesisApprovationService(){
        this.thesisDao = new ThesisDao();
        this.reviewDao = new ReviewDao();
        this.reviewerDao = new ReviewerDao();
    }

    public static void emulateDelay() throws InterruptedException {
        Random random = new Random();
        int number = random.nextInt(100);

        if(number <= 95)
            Thread.sleep(random.nextInt(7) + 3);
        else
            Thread.sleep(random.nextInt(20) + 20);
    }

    //METODI PER ThesisDao

    //inserimento student into thesis approvation
    public Boolean insertStudentToThesisApprovation(Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            Thesis t = new Thesis(studentFreshman, "Not_approved");
            emulateDelay();
            return thesisDao.insert(t);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //inserimento/modifica thesis by student freshman in bozza
    public Boolean updateThesis(Integer id, String title, String description, String urlDocument, Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            Thesis t = new Thesis(id, title, description, urlDocument, studentFreshman);
            emulateDelay();
            return thesisDao.update(t);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //modifica state by id thesis
    public Boolean updateStateThesis(Integer idThesis, String state) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.updateStateThesis(idThesis, state);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //modifica loaded by student freshman (utlizzato quando viene consegnata la tesi oppure quando viene ritirata dalla consegna)
    public Boolean updateLoadedThesis(Integer studentFreshman, String loaded) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.updateLoadedThesis(studentFreshman, loaded);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //elimina thesis by id
    public Boolean deleteThesis(Integer id) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.delete(id);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //delete thesis by student
    public Boolean deleteThesisByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.deleteThesisByStudent(studentFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //get all theses
    public List<Thesis> getAllThesis() throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.getAll();
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //get all theses loaded and not approved
    public List<Thesis> getThesesLoadedNotApproved() throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.getThesesLoadedNotApproved();
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //visualizza reviewer della propria Evaluation Committee
    public List<Reviewer> getReviewersByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.getReviewersByStudent(studentFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //visualizza reviews by reviewer and student
    public Review getReviewByStudentReviewer(Integer studentFreshman, Integer freshmanReviewer) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.getReviewByStudentReviewer(studentFreshman, freshmanReviewer);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //visualizza thesis by id (utilizzato dallo studente per visualizzare la sua tesi)
    public Thesis getThesisById(Integer id) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.findByKey(id);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //inserimento evaluationCommittee
    public Boolean insertEvaluationCommittee(Integer idThesis, Integer reviewerFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.insertEvaluation(idThesis, reviewerFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //visualizza tesi by student
    public Thesis getThesisByStudentReviewer(Integer studentFreshman, Integer reviewerFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.getThesisByStudentReviewer(studentFreshman, reviewerFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    public Thesis getThesisByStudent(Integer studentFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return thesisDao.getThesisByStudent(studentFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //METODI PER ReviewerDao

    //Inserimento Reviewer
    public Boolean insertReviewer(Integer freshman, String name, String surname, String password, String email, String description) throws SQLException, InterruptedException {
        if(available){
            Reviewer r = new Reviewer(freshman, name, surname, password, email, description);
            emulateDelay();
            return reviewerDao.insert(r);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    public List<Reviewer> getAllReviewers() throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewerDao.getAll();
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //elimina reviewer
    public Boolean deleteReviewer(Integer freshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewerDao.delete(freshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //modifica reviewer
    public Boolean updateReviewer(Integer freshman, String name, String surname, String email, String description) throws SQLException, InterruptedException {
        if(available) {
            Reviewer r = new Reviewer(freshman, name, surname, email, description);
            emulateDelay();
            return reviewerDao.update(r);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //get reviewer by freshman
    public Reviewer getReviewerByFreshman(Integer reviewerFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewerDao.findByKey(reviewerFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    //modifica password reviewer
    public Boolean updatePasswordReviewer(Integer freshman, String password) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewerDao.updatePassword(freshman, password);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //visualizza tutti gli studenti by reviewer freshman
    public List<Student> getStudentsByReviewer(Integer reviewerFreshman) throws SQLException, InterruptedException {
        if (available) {
            List<Integer> studentFreshmen = reviewerDao.getStudentFreshmen(reviewerFreshman);
            List<Student> students = new ArrayList<Student>();

            this.thesisApprovationProxy = new ThesisApprovationProxy();
            for(Integer i : studentFreshmen){
                Student s = thesisApprovationProxy.getStudentsInformation(i);
                students.add(s);
            }
            emulateDelay();
            return students;
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

    public List<Thesis> getThesisLoadedNotApproved(Integer reviewerFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewerDao.getThesisLoadedNotApprovedByReviewer(reviewerFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }


    //METODI PER ReviewDao

    //inserimento review
    public Boolean insertReview(Integer idThesis, Integer reviewerFreshman, String title, String comment) throws SQLException, InterruptedException {
        if(available){
            Reviewer r = new Reviewer(reviewerFreshman);
            Thesis t = new Thesis(idThesis);
            EvaluationCommittee ec = new EvaluationCommittee(t, r);

            Review review = new Review(title, comment, ec);
            emulateDelay();
            return reviewDao.insert(review);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //modifica review
    public Boolean updateReview(Integer idReview, Integer reviewerFreshman, String title, String comment) throws SQLException, InterruptedException {
        if(available){
            Reviewer r = new Reviewer(reviewerFreshman);
            Thesis t = new Thesis();
            EvaluationCommittee ec = new EvaluationCommittee(t, r);

            Review review = new Review(idReview, title, comment, ec);
            emulateDelay();
            return reviewDao.update(review);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //elimina review
    public Boolean deleteReview(Integer idReview) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewDao.delete(idReview);
        }else{
            Thread.sleep(millisecondsDelay);
            return false;
        }
    }

    //get all reviews by reviewer freshman
    public List<Review> getAllReviewsByReviewer(Integer reviewerFreshman) throws SQLException, InterruptedException {
        if(available){
            emulateDelay();
            return reviewDao.getAllReviewsByReviewer(reviewerFreshman);
        }else{
            Thread.sleep(millisecondsDelay);
            return null;
        }
    }

}
