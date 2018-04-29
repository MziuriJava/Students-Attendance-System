package ge.mziuri.servlet;

import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.model.course.Course;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCourseServlet extends HttpServlet {
    private CourseDAO courseDAO = new CourseDAOImpl();
    

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        try {
            Course course = new Course();
            course.setID(courseId);
            courseDAO.deleteCourse(course, DataBaseConnector.getConnection());
            resp.sendRedirect("/loadCourses");
        } catch (Exception ex) {
            // TODO
        }
    }
}