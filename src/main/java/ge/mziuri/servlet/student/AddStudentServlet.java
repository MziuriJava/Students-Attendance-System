package ge.mziuri.servlet;

import ge.mziuri.dao.student.StudentDAO;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class AddStudentServlet extends HttpServlet {

    private StudentDAO studentDao = new StudentDaoImpl();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        String studentSurname = req.getParameter("studentSurname");
        String studentEmail = req.getParameter("studentEmail");
        String studentBirthDate = req.getParameter("studentBirthDate");
        String studentPhoneNumber = req.getParameter("studentPhoneNumber");
        String studentParentName = req.getParameter("studentParentName");
        String studentParentNumber = req.getParameter("studentParentNumber");

        try {
            Student student = new Student();
            student.setFirstname(studentName);
            student.setLastname(studentSurname);
            student.setEmail(studentEmail);
            student.setBirthDate(sdf.parse(studentBirthDate));
            student.setPhoneNumber(studentPhoneNumber);
            student.setParentName(studentParentName);
            student.setParentNumber(studentParentNumber);

            studentDao.addStudent(student, DataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}