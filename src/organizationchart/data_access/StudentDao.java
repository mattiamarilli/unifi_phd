package organizationchart.data_access;

import organizationchart.Cycle;
import organizationchart.FacultyMember;
import organizationchart.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements GenericDao<Student,Integer> {

    private Connection conn;
    
    @Override
    public List<Student> getAll() throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Students.Freshman AS StudentFreshman, Students.Name AS StudentName, Students.Surname AS StudentSurname, Students.Email AS StudentEmail, \n" +
                    "Students.Topics AS StudentTopics, Students.Year AS StudentYear, Advisor,  \n" +
                    "Number AS CycleNumber, Cycles.Year AS CycleYear, Cycles.Description AS DescriptionCycle, FacultyMembers.Name AS AdvisorName, FacultyMembers.Surname AS AdvisorSurname,\n" +
                    "FacultyMembers.Email AS AdvisorEmail, FacultyMembers.Specialization AS AdvisorSpecialization, FacultyMembers.Institution AS AdvisorInstitution\n" +
                    "FROM Students\n" +
                    "INNER JOIN Cycles ON Cycle = Number\n" +
                    "LEFT JOIN FacultyMembers ON Advisor = FacultyMembers.Freshman");

            List<Student> students = new ArrayList<Student>();

            while (rs.next()) {
                Integer studentFreshman = rs.getInt("StudentFreshman");
                String studentName = rs.getString("StudentName");
                String studentSurname = rs.getString("StudentSurname");
                String studentEmail = rs.getString("StudentEmail");
                String studentTopics = rs.getString("StudentTopics");
                int studentYear = rs.getInt("StudentYear");

                String cycleNumber = rs.getString("CycleNumber");
                Integer cycleYear = rs.getInt("CycleYear");
                String descriptionCycle = rs.getString("DescriptionCycle");
                Cycle cycle = new Cycle(cycleNumber, cycleYear, descriptionCycle);

                Integer advisorFreshman = rs.getInt("Advisor");
                Student s;
                if(advisorFreshman == 0){
                     s = new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, null);
                }else{
                    String advisorName = rs.getString("AdvisorName");
                    String advisorSurname = rs.getString("AdvisorSurname");
                    String advisorEmail = rs.getString("AdvisorEmail");
                    String advisorSpecialization = rs.getString("AdvisorSpecialization");
                    String advisorInstitution = rs.getString("AdvisorInstitution");
                    FacultyMember advisor = new FacultyMember(advisorFreshman, advisorName, advisorSurname, advisorEmail, advisorSpecialization, advisorInstitution, cycle);
                    s = new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, advisor);
                }

                students.add(s);
            }
            return students;

        }catch (SQLException e){
            System.out.println("Error get all students");
            e.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Student findByKey(Integer studentFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Students.Freshman AS StudentFreshman, Students.Name AS StudentName, Students.Surname AS StudentSurname, Students.Email AS StudentEmail, \n" +
                    "Students.Topics AS StudentTopics, Students.Year AS StudentYear, Advisor,  \n" +
                    "Number AS CycleNumber, Cycles.Year AS CycleYear, Cycles.Description AS DescriptionCycle, FacultyMembers.Name AS AdvisorName, FacultyMembers.Surname AS AdvisorSurname,\n" +
                    "FacultyMembers.Email AS AdvisorEmail, FacultyMembers.Specialization AS AdvisorSpecialization, FacultyMembers.Institution AS AdvisorInstitution\n" +
                    "FROM Students\n" +
                    "INNER JOIN Cycles ON Cycle = Number\n" +
                    "LEFT JOIN FacultyMembers ON Advisor = FacultyMembers.Freshman\n" +
                    "WHERE Students.Freshman = ?");
            stmt.setInt(1, studentFreshman);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String studentName = rs.getString("StudentName");
                String studentSurname = rs.getString("StudentSurname");
                String studentEmail = rs.getString("StudentEmail");
                String studentTopics = rs.getString("StudentTopics");
                int studentYear = rs.getInt("StudentYear");

                String cycleNumber = rs.getString("CycleNumber");
                Integer cycleYear = rs.getInt("CycleYear");
                String descriptionCycle = rs.getString("DescriptionCycle");

                Cycle cycle = new Cycle(cycleNumber, cycleYear, descriptionCycle);

                Student s;

                Integer advisorFreshman = rs.getInt("Advisor");
                if(advisorFreshman == 0){
                    s = new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, null);
                }else{
                    String advisorName = rs.getString("AdvisorName");
                    String advisorSurname = rs.getString("AdvisorSurname");
                    String advisorEmail = rs.getString("AdvisorEmail");
                    String advisorSpecialization = rs.getString("AdvisorSpecialization");
                    String advisorInstitution = rs.getString("AdvisorInstitution");

                    FacultyMember advisor = new FacultyMember(advisorFreshman, advisorName, advisorSurname, advisorEmail, advisorSpecialization, advisorInstitution, cycle);

                    s = new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, advisor);
                }

                return s;
            }else{
                System.out.println("Doesn't exist student with freshman= " + studentFreshman);
                return null;
            }

        }catch (SQLException e){
            System.out.println("Error gets student by freshman");
            e.printStackTrace();
            return null;
        }finally {
            conn.close();
        }

    }

    @Override
    public Boolean insert(Student student) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1,student.getFreshman());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getSurname());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getPassword());
            stmt.setString(6, student.getTopics());
            stmt.setString(7, student.getCycle().getNumber());
            stmt.setInt(8, student.getYear());

            if(stmt.executeUpdate() > 0) {
                System.out.println("Insert student successful");
                return true;
            }else {
                System.out.println("Insert student not successful");
                return false;
            }

        }catch (SQLException e){
            System.out.println("Error insert student");
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    @Override
    public Boolean update(Student student) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Students SET Name = ?, Surname = ?, Email= ?, Topics = ? WHERE Freshman = ?");
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getTopics());
            stmt.setInt(5, student.getFreshman());

            if(stmt.executeUpdate() > 0) {
                System.out.println("Update student successful");
                return true;
            }else {
                System.out.println("Update student not successful");
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
    public Boolean delete(Integer freshman) throws SQLException {
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Students WHERE Freshman = ?");
            stmt.setInt(1, freshman);

            if(stmt.executeUpdate() > 0) {
                System.out.println("Delete student successful");
                return true;
            }else {
                System.out.println("Delete student not successful");
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean updatePassword(Integer studentFreshman, String password) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Students SET Password = ? WHERE Freshman = ?");
            stmt.setString(1, password);
            stmt.setInt(2, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update student password successful");
                return true;
            }else{
                System.out.println("Update student password not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update student password");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean updateAdvisor(Integer studentFreshman, Integer advisorFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Students SET Advisor = ? WHERE Freshman = ?");
            stmt.setInt(1, advisorFreshman);
            stmt.setInt(2, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update student advisor successful");
                return true;
            }else{
                System.out.println("Update student advisor not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update student advisor");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public Boolean updateYear(Integer studentFreshman, Integer year) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Students SET Year = ? WHERE Freshman = ?");
            stmt.setInt(1, year);
            stmt.setInt(2, studentFreshman);

            if(stmt.executeUpdate() > 0){
                System.out.println("Update student year successful");
                return true;
            }else{
                System.out.println("Update student year not successful");
                return false;
            }

        }catch(SQLException ex){
            System.out.println("Error update student year");
            ex.printStackTrace();
            return false;
        }finally {
            conn.close();
        }
    }

    public List<Student> getStudentsByYear(Integer year) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Students.Freshman AS StudentFreshman, Students.Name AS StudentName, Students.Surname AS StudentSurname, Students.Email AS StudentEmail, \n" +
                    "Students.Topics AS StudentTopics, Students.Year AS StudentYear, Advisor,  \n" +
                    "Number AS CycleNumber, Cycles.Year AS CycleYear, Cycles.Description AS DescriptionCycle, FacultyMembers.Name AS AdvisorName, FacultyMembers.Surname AS AdvisorSurname,\n" +
                    "FacultyMembers.Email AS AdvisorEmail, FacultyMembers.Specialization AS AdvisorSpecialization, FacultyMembers.Institution AS AdvisorInstitution\n" +
                    "FROM Students\n" +
                    "INNER JOIN Cycles ON Cycle = Number\n" +
                    "LEFT JOIN FacultyMembers ON Advisor = FacultyMembers.Freshman\n" +
                    "WHERE Students.Year = ?");
            stmt.setInt(1, year);
            ResultSet rs = stmt.executeQuery();

            List<Student> students = new ArrayList<Student>();

            while(rs.next()) {
                Integer studentFreshman = rs.getInt("StudentFreshman");
                String studentName = rs.getString("StudentName");
                String studentSurname = rs.getString("StudentSurname");
                String studentEmail = rs.getString("StudentEmail");
                String studentTopics = rs.getString("StudentTopics");
                int studentYear = rs.getInt("StudentYear");

                String cycleNumber = rs.getString("CycleNumber");
                Integer cycleYear = rs.getInt("CycleYear");
                String descriptionCycle = rs.getString("DescriptionCycle");
                Cycle cycle = new Cycle(cycleNumber, cycleYear, descriptionCycle);

                Integer advisorFreshman = rs.getInt("Advisor");

                if(advisorFreshman == 0){
                    students.add(new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, null));
                }else{
                    String advisorName = rs.getString("AdvisorName");
                    String advisorSurname = rs.getString("AdvisorSurname");
                    String advisorEmail = rs.getString("AdvisorEmail");
                    String advisorSpecialization = rs.getString("AdvisorSpecialization");
                    String advisorInstitution = rs.getString("AdvisorInstitution");
                    FacultyMember advisor = new FacultyMember(advisorFreshman, advisorName, advisorSurname, advisorEmail, advisorSpecialization, advisorInstitution, cycle);

                    students.add(new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, advisor));
                }
            }

            return students;

        }catch(SQLException ex){
            System.out.println("Error get students by year");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Student> getStudentsByCycle(String cycleNumber) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Students.Freshman AS StudentFreshman, Students.Name AS StudentName, Students.Surname AS StudentSurname, Students.Email AS StudentEmail, \n" +
                    "Students.Topics AS StudentTopics, Students.Year AS StudentYear, Advisor,  \n" +
                    "Number AS CycleNumber, Cycles.Year AS CycleYear, Cycles.Description AS DescriptionCycle, FacultyMembers.Name AS AdvisorName, FacultyMembers.Surname AS AdvisorSurname,\n" +
                    "FacultyMembers.Email AS AdvisorEmail, FacultyMembers.Specialization AS AdvisorSpecialization, FacultyMembers.Institution AS AdvisorInstitution\n" +
                    "FROM Students\n" +
                    "INNER JOIN Cycles ON Cycle = Number\n" +
                    "LEFT JOIN FacultyMembers ON Advisor = FacultyMembers.Freshman\n" +
                    "WHERE Cycles.Number = ?");
            stmt.setString(1, cycleNumber);
            ResultSet rs = stmt.executeQuery();

            List<Student> students = new ArrayList<Student>();

            while(rs.next()) {
                Integer studentFreshman = rs.getInt("StudentFreshman");
                String studentName = rs.getString("StudentName");
                String studentSurname = rs.getString("StudentSurname");
                String studentEmail = rs.getString("StudentEmail");
                String studentTopics = rs.getString("StudentTopics");
                int studentYear = rs.getInt("StudentYear");

                Integer cycleYear = rs.getInt("CycleYear");
                String descriptionCycle = rs.getString("DescriptionCycle");
                Cycle cycle = new Cycle(cycleNumber, cycleYear, descriptionCycle);

                Integer advisorFreshman = rs.getInt("Advisor");
                String advisorName = rs.getString("AdvisorName");
                String advisorSurname = rs.getString("AdvisorSurname");
                String advisorEmail = rs.getString("AdvisorEmail");
                String advisorSpecialization = rs.getString("AdvisorSpecialization");
                String advisorInstitution = rs.getString("AdvisorInstitution");
                FacultyMember advisor = new FacultyMember(advisorFreshman, advisorName, advisorSurname, advisorEmail, advisorSpecialization, advisorInstitution, cycle);

                students.add(new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, advisor));
            }

            return students;

        }catch (SQLException ex){
            System.out.println("Error get students by cycle");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

    public List<Student> getStudentsByAdvisor(Integer advisorFreshman) throws SQLException{
        try{
            conn = ConnectionDao.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Freshman, Name, Surname, Email, Topics, Cycle, Year\n" +
                    "FROM Students\n" +
                    "WHERE Advisor = ?");
            stmt.setInt(1, advisorFreshman);
            ResultSet rs = stmt.executeQuery();

            List<Student> students = new ArrayList<Student>();

            while(rs.next()){
                Integer studentFreshman = rs.getInt("Freshman");
                String studentName = rs.getString("Name");
                String studentSurname = rs.getString("Surname");
                String studentEmail = rs.getString("Email");
                String studentTopics = rs.getString("Topics");
                Integer studentYear = rs.getInt("Year");

                String cycleNumber = rs.getString("Cycle");
                Cycle cycle = new Cycle(cycleNumber);

                FacultyMember advisor = new FacultyMember(advisorFreshman);

                students.add(new Student(studentFreshman, studentName, studentSurname, studentEmail, studentTopics, cycle, studentYear, advisor));
            }

            return students;

        }catch (SQLException ex){
            System.out.println("Error get students by advisor freshman");
            ex.printStackTrace();
            return null;
        }finally {
            conn.close();
        }
    }

}
