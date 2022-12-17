package thesisapprovation.data_access;

import thesisapprovation.Thesis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThesisDaoImpl implements ThesisDao{

    private Connection conn;
    @Override
    public List<Thesis> getAllThesis() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Thesis");

            //create empty list
            List<Thesis> thesisList = new ArrayList<Thesis>();

            while(rs.next()){
                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String url = rs.getString("UrlDocument");
                int studentFreshman = rs.getInt("StudentFreshman");
                String state = rs.getString("State");

                Thesis t = new Thesis(id, title, description, url, studentFreshman, state);

                thesisList.add(t);

                //output only testing
                System.out.println(t.toString());

            }

            if(thesisList.isEmpty())
                System.out.println("Don't exist thesis");

        }catch(SQLException ex){
            System.out.println("Error get all thesis");
            ex.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
    //TODO: finish thesis data access
    @Override
    public Thesis getThesisById(int id) {
        return null;
    }

    @Override
    public void insertThesis(Thesis thesis) {

    }

    @Override
    public void updateThesis(Thesis thesis) {

    }

    @Override
    public void deleteThesisById(int id) {

    }
}
