package ge.mziuri.servlet;

import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.course.CourseStatus;
import ge.mziuri.util.db.DataBaseConnector;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig(maxFileSize = 16177215)
public class AddCourseServlet extends HttpServlet {
    private CourseDAO courseDAO=new CourseDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        int courseLength = Integer.parseInt(request.getParameter("courseLength"));
        double courseLessonTime = Double.parseDouble(request.getParameter("courseLessonTime"));
        int lessonsPerWeek = Integer.parseInt(request.getParameter("lessonsPerWeek"));
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        // TODO add founder

        Course course=new Course();
        course.setCourseName(courseName);
        course.setCourseStatus(CourseStatus.ACTIVE);
        course.setCourseLength(courseLength);
        course.setLessonsPerWeek(lessonsPerWeek);
        course.setCourseLessonTime(courseLessonTime);
        course.setDescription(description);
        course.setPrice(price);

        InputStream inputStream = null;

        Part filePart = request.getPart("syllabus");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
        course.setSyllabus(IOUtils.toByteArray(inputStream));

        try {
            courseDAO.addCourse(course, DataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        int courseLength = Integer.parseInt(request.getParameter("courseLength"));
        double courseLessonTime = Double.parseDouble(request.getParameter("courseLessonTime"));
        int lessonsPerWeek = Integer.parseInt(request.getParameter("lessonsPerWeek"));
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        // TODO add founder

        Course course=new Course();
        course.setCourseName(courseName);
        course.setCourseStatus(CourseStatus.ACTIVE);
        course.setCourseLength(courseLength);
        course.setLessonsPerWeek(lessonsPerWeek);
        course.setCourseLessonTime(courseLessonTime);
        course.setDescription(description);
        course.setPrice(price);

        InputStream inputStream = null;

        Part filePart = request.getPart("syllabus");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
        course.setSyllabus(IOUtils.toByteArray(inputStream));

        try {
            courseDAO.addCourse(course, DataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
