package thesisapprovation.data_access;

import thesisapprovation.EvaluationCommittee;
import thesisapprovation.Thesis;

import java.sql.SQLException;
import java.util.List;


//TODO: lo lascio vuoto in attesa di capire se implementarlo o meno

public class EvaluationCommitteeDao implements GenericDao<EvaluationCommittee, Integer> {
    @Override
    public List<EvaluationCommittee> getAll() throws SQLException {
        return null;
    }

    @Override
    public EvaluationCommittee findByKey(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public Boolean insert(EvaluationCommittee evaluationCommittee) throws SQLException {
        return null;
    }

    @Override
    public Boolean update(EvaluationCommittee evaluationCommittee) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return null;
    }
}
