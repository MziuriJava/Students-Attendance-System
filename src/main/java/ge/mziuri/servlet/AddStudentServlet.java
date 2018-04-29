package ge.mziuri.servlet;

import ge.mziuri.dao.student.StudentDao;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet{

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        String studentSurname = req.getParameter("studentSurname");
        String studentEmail = req.getParameter("studentEmail");
        String studentPhoneNumber = req.getParameter("studentPhoneNumber");
        String studentParentName = req.getParameter("studentParentName");
        String studentParentNumber = req.getParameter("studentParentNumber");

        Student student = new Student();
        student.setFirstname(studentName);
        student.setLastname(studentSurname);
        student.setEmail(studentEmail);
        student.setPhoneNumber(studentPhoneNumber);
        student.setParentName(studentParentName);
        student.setParentNumber(studentParentNumber);

        try {
            studentDao.addStudent(student, DataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
