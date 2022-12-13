package thesisapprovation.data_access;

import thesisapprovation.Thesis;

import java.util.List;

public interface ThesisDao {

    List<Thesis> getAllThesis();

    Thesis getThesis(int id);

    void insertThesis(Thesis thesis);

    void updateThesis(Thesis thesis);

    void deleteThesis(Thesis thesis);

}
