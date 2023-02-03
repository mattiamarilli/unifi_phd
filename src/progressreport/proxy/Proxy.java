package progressreport.proxy;
import organizationchart.Student;
import organizationchart.server.Server;
import thesisapprovation.server.*;
import didacticoffer.server.*;
import organizationchart.server.*;

import java.sql.SQLException;

public class Proxy {

    private Server server;
    public Proxy() {
       server = new Server();
    }

    public Student getStudentsInformation(Integer idStudent) throws SQLException {
        return server.getStudentById(idStudent);
    }

}
