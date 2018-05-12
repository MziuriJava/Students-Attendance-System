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
            String searchName = req.getParameter("searchName");
            String searchLastName = req.getParameter("searchLastName");
            String searchPersonalId = req.getParameter( "searchPersonalId");
            String searchEmail = req.getParameter("searchEmail");
            List<Student> students = studentDao.searchStudent(searchName, searchLastName, searchPersonalId, searchEmail, DataBaseConnector.getConnection());
            req.setAttribute("students", students);
            req.setAttribute("searchName", searchName);
            req.getRequestDispatcher("students.jsp").forward(req, resp);
        } catch (Exception e) {
            //TODO
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {

        } catch (Exception e) {
            //TODO
        }
    }
}
