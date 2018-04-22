package ge.mziuri.servlet;

import ge.mziuri.dao.student.StudentDao;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.user.student.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet{

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StudentName = req.getParameter("StudentName");
        String StudentSurname = req.getParameter("StudentSurname");
        String StudentEmail = req.getParameter("StudentEmail");
        String StudentPhoneNumber = req.getParameter("StudentPhoneNumber");
        String StudentParentName = req.getParameter("StudentParentName");
        String StudentParentNumber = req.getParameter("StudentParentNumber");

        Student student = new Student();
        student.setFirstname(StudentName);
        student.setLastname(StudentSurname);
        student.setEmail(StudentEmail);
        student.setPhoneNumber(StudentPhoneNumber);
        student.setParentName(StudentParentName);
        student.setParentNumber(StudentParentNumber);
    }


}
