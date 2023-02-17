package organizationchart.data_access;

import organizationchart.Cycle;
import organizationchart.FacultyMember;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyMemberDao implements GenericDao<FacultyMember,Integer> {

    private Connection conn;
    @Override
    public List<FacultyMember> getAll() throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FacultyMembers.Freshman, FacultyMembers.Name, FacultyMembers.Surname, FacultyMembers.Email, FacultyMembers.Specialization, FacultyMembers.Institution, FacultyMembers.Cycle, Cycles.Year, Cycles.Description\n" +
                    "FROM FacultyMembers\n" +
                    "INNER JOIN Cycles ON Cycle = Number");

            List<FacultyMember> facultyMembers = new ArrayList<FacultyMember>();

            while (rs.next()) {
                Integer freshman = rs.getInt("Freshman");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String specialization = rs.getString("Specialization");
                String institution = rs.getString("Institution");

                String cycleNumber = rs.getString("Cycle");
                Integer cycleYear = rs.getInt("Year");
                String cycleDescription = rs.getString("Description");

                Cycle c = new Cycle(cycleNumber, cycleYear, cycleDescription);

                FacultyMember f = new FacultyMember(freshman, name, surname, email, specialization, institution, c);

                facultyMembers.add(f);
            }
            return facultyMembers;

        }catch (SQLException e){
            System.out.println("Error get all faculty members");
            e.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public FacultyMember findByKey(Integer fmFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT FacultyMembers.Freshman, FacultyMembers.Name, FacultyMembers.Surname, FacultyMembers.Email, FacultyMembers.Specialization, FacultyMembers.Institution, FacultyMembers.Cycle, Cycles.Year, Cycles.Description\n" +
                    "FROM FacultyMembers\n" +
                    "INNER JOIN Cycles ON Cycle = Number\n" +
                    "WHERE FacultyMembers.Freshman = ?");
            stmt.setInt(1, fmFreshman);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                String specialization = rs.getString("Specialization");
                String institution = rs.getString("Institution");

                String cycleNumber = rs.getString("Cycle");
                Integer cycleYear = rs.getInt("Year");
                String cycleDescription = rs.getString("Description");

                Cycle c = new Cycle(cycleNumber, cycleYear, cycleDescription);

                FacultyMember f = new FacultyMember(fmFreshman, name, surname, email, specialization, institution, c);

                return f;
            }else{
                System.out.println("Doesn't exist faculty member with freshman= " + fmFreshman);
                return null;
            }

        }catch (SQLException e){
            System.out.println("Error gets faculty member by number");
            e.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean insert(FacultyMember facultyMember) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setInt(1,facultyMember.getFreshman());
            stmt.setString(2, facultyMember.getName());
            stmt.setString(3, facultyMember.getSurname());
            stmt.setString(4, facultyMember.getEmail());
            stmt.setString(5, facultyMember.getPassword());
            stmt.setString(6, facultyMember.getSpecialization());
            stmt.setString(7,facultyMember.getInstitution());
            stmt.setString(8, facultyMember.getCycle().getNumber());

            if(stmt.executeUpdate() > 0) {
                System.out.println("Insert faculty member successful");
                return true;
            }else {
                System.out.println("Insert faculty member not successful");
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(FacultyMember facultyMember) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE FacultyMembers SET Name = ?, Surname = ?, Email= ?, Specialization = ?, Institution = ? WHERE Freshman = ?");
            stmt.setString(1, facultyMember.getName());
            stmt.setString(2, facultyMember.getSurname());
            stmt.setString(3, facultyMember.getEmail());
            stmt.setString(4, facultyMember.getSpecialization());
            stmt.setString(5, facultyMember.getInstitution());
            stmt.setInt(6, facultyMember.getFreshman());

            if(stmt.executeUpdate() > 0) {
                System.out.println("Update faculty member successful");
                return true;
            }else{
                System.out.println("Update faculty member not successful");
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean delete(Integer fmFreshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM FacultyMembers WHERE Freshman = ?");
            preparedStatement.setInt(1, fmFreshman);
            if(preparedStatement.executeUpdate() > 0)
                return true;
            else
                return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean updateFacultyMemberPassword(Integer fmFreshman, String password) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE FacultyMembers SET Password = ? WHERE Freshman = ?");
            stmt.setString(1, password);
            stmt.setInt(2, fmFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update faculty member password successful");
                return true;
            }else{
                System.out.println("Update faculty member password not successful");
                return false;
            }

        }catch (SQLException ex){
            System.out.println("Error update faculty member password");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

}
