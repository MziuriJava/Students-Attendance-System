package ge.mziuri.servlet.course;

import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.model.course.Course;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.util.List;

public class LoadCoursesServlet extends HttpServlet {
    private CourseDAO courseDAO = new CourseDAOImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Course> courses = courseDAO.getAllCourse(DataBaseConnector.getConnection());
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("courses.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO
        }
    }

    // TODO Remove
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Course> courses = courseDAO.getAllCourse(DataBaseConnector.getConnection());
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("courses.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO
        }
    }


}
