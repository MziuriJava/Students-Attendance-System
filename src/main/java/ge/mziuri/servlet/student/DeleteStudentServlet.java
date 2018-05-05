package ge.mziuri.servlet.student;

import ge.mziuri.dao.student.StudentDAO;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {

    private StudentDAO studentDao = new StudentDaoImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        try {
            Student student = new Student();
            student.setId(studentId);
            studentDao.deleteStudent(student, DataBaseConnector.getConnection());
            resp.sendRedirect("/loadStudents");
        } catch (Exception ex) {
            // TODO
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        try {
            Student student = new Student();
            student.setId(studentId);
            studentDao.deleteStudent(student, DataBaseConnector.getConnection());
            resp.sendRedirect("/loadStudents");
        } catch (Exception ex) {
            // TODO
        }
    }
}