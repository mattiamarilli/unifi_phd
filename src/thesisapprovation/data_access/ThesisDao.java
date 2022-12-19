package thesisapprovation.data_access;

import thesisapprovation.Thesis;

import java.sql.SQLException;
import java.util.List;

public interface ThesisDao {

    List<Thesis> getAllThesis() throws SQLException;

    Thesis getThesisById(int id) throws SQLException;

    void insertThesis(Thesis thesis) throws SQLException;

    void updateThesis(Thesis thesis) throws SQLException;

    void deleteThesisById(int id) throws SQLException;

}
