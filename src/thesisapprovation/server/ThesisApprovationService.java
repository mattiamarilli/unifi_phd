package thesisapprovation.server;

import thesisapprovation.Reviewer;
import thesisapprovation.Thesis;
import thesisapprovation.data_access.ReviewDao;
import thesisapprovation.data_access.ReviewerDao;
import thesisapprovation.data_access.ThesisDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThesisApprovationService {

    private ThesisDao thesisDao;
    private ReviewDao reviewDao;
    private ReviewerDao reviewerDao;
    public ThesisApprovationService(){
        this.thesisDao = new ThesisDao();
        this.reviewDao = new ReviewDao();
        this.reviewerDao = new ReviewerDao();
    }

    //METODI PER ThesisDao

    //inserimento thesis
    public void insertThesis(String title, String description, String urlDocument, Integer studentFreshman) throws SQLException {
        Thesis t = new Thesis(title, description, urlDocument, studentFreshman);
        thesisDao.insert(t);
    }

    //modifica thesis by studentfreshman
    public void updateThesis(String title, String description, String urlDocument, Integer studentFreshman) throws SQLException{
        Thesis t = new Thesis(title, description, urlDocument, studentFreshman);
        thesisDao.update(t);
    }

    //modifica state by studentFresman
    public void updateStateThesis(Integer studentFreshman, String state) throws SQLException{
        thesisDao.updateState(studentFreshman, state);
    }

    //visualizza reviewer della propria Evaluation Committee
    public List<Reviewer> getReviewersByStudent(Integer studentFreshman) throws SQLException{
        return thesisDao.getReviewersByStudent(studentFreshman);
    }

}
