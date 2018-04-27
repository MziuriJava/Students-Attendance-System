package ge.mziuri.servlet;

import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.util.db.DataBaseConnector;

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

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String course_name=request.getParameter("course_name");
        String course_status=request.getParameter("course_status");
        int course_length=Integer.parseInt(request.getParameter("course_length"));
        int course_lesson_time=Integer.parseInt(request.getParameter("course_lesson_time"));
        int lessons_per_week =Integer.parseInt(request.getParameter("lessons_per_week"));
        String description=request.getParameter("description");
        int price=Integer.parseInt(request.getParameter("price"));
        String leader_staff=request.getParameter("leader_staff");

        Course course=new Course();
        course.setCourseName(course_name);
        course.setCourseLength(course_length);
        course.setLessonsPerWeek(lessons_per_week);
        course.setCourseLessonTime(course_lesson_time);
        course.setDescription(description);
        course.setPrice(price);

        InputStream inputStream = null;

        Part filePart = request.getPart("Syllabus");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        //course.setSyllabus(IOUtils.toByteArray(inputStream));

        try {
            courseDAO.addCourse(course, DataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
