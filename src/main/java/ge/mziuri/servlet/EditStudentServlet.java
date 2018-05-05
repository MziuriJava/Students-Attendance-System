package ge.mziuri.servlet;

import ge.mziuri.dao.student.StudentDao;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditStudentServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        try {
            Student student = studentDao.getStudentById(studentId, DataBaseConnector.getConnection());
            req.setAttribute("student", student);
            req.getRequestDispatcher("sas/addStudent.jsp").forward(req, resp);
        } catch (Exception ex) {
            // TODO
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        try {
            Student student = studentDao.getStudentById(studentId, DataBaseConnector.getConnection());
            req.setAttribute("student", student);
            req.getRequestDispatcher("sas/addStudent.jsp").forward(req, resp);
        } catch (Exception ex) {
            // TODO
        }
    }
}
