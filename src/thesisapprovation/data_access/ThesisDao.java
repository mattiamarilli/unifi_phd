package thesisapprovation.data_access;

import thesisapprovation.Thesis;

import java.sql.SQLException;
import java.util.List;

public interface ThesisDao {

    List<Thesis> getAllThesis() throws SQLException;

    Thesis getThesisById(int id);

    void insertThesis(Thesis thesis);

    void updateThesis(Thesis thesis);

    void deleteThesisById(int id);

}
