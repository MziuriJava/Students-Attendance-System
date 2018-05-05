package ge.mziuri.servlet.student;

import ge.mziuri.dao.student.StudentDAO;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoadStudentsServlet extends HttpServlet {

    private StudentDAO studentDao = new StudentDaoImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Student> students = studentDao.getAllStudent(DataBaseConnector.getConnection());
            req.setAttribute("students", students);
            req.getRequestDispatcher("students.jsp").forward(req, resp);
        } catch (Exception e) {
            //TODO
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Student> students = studentDao.getAllStudent(DataBaseConnector.getConnection());
            req.setAttribute("students", students);
            req.getRequestDispatcher("students.jsp").forward(req, resp);
        } catch (Exception e) {
            //TODO
        }
    }
}
