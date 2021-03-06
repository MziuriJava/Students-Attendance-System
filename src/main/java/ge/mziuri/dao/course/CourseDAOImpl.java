package ge.mziuri.dao.course;

import ge.mziuri.model.course.Course;
import ge.mziuri.model.course.CourseStatus;
import ge.mziuri.model.user.staff.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void addCourse(Course course, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO course (course_name, course_status, course_length, course_lesson_time, lessons_per_week, description, leader_staff, price, syllabus) VALUES (?,?,?,?,?,?,?,?,?)");
        pstm.setString(1, course.getCourseName());
        pstm.setString(2, course.getCourseStatus().toString());
        pstm.setInt(3, course.getCourseLength());
        pstm.setDouble(4, course.getCourseLessonTime());
        pstm.setInt(5, course.getLessonsPerWeek());
        pstm.setString(6, course.getDescription());
        pstm.setInt(7, course.getFounder().getId());
        pstm.setInt(8, course.getPrice());
        pstm.setBytes(9, course.getSyllabus());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteCourse(Course course, Connection con) throws Exception {

    }

    @Override
    public List<Course> getAllCourse(Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM course");
        ResultSet rs = pstm.executeQuery();
        List <Course> courses = new ArrayList<>();
        while(rs.next()){
            courses.add(getCourse(rs));
        }
        return courses;
    }

    @Override
    public void editCourse(Course course, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("Update course SET course_name=?, course_status=?, course_length=?, course_lesson_time=?, lessons_per_week=?, description=?, leader_staff=?, price=?, syllabus=? WHERE id=? ");
        pstm.setString(1, course.getCourseName());
        pstm.setString(2, course.getCourseStatus().toString());
        pstm.setInt(3, course.getCourseLength());
        pstm.setDouble(4, course.getCourseLessonTime());
        pstm.setInt(5, course.getLessonsPerWeek());
        pstm.setString(6, course.getDescription());
        pstm.setInt(7, course.getFounder().getId());
        pstm.setBytes(8, course.getSyllabus());
        pstm.setInt(9, course.getPrice());
        pstm.setInt(10, course.getId());
        pstm.executeUpdate();
        pstm.close();
        con.close();

    }

    public Course getCourse(ResultSet rs) throws Exception {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setCourseLength(rs.getInt("course_length"));
        course.setCourseLessonTime(rs.getDouble("course_lesson_time"));
        course.setPrice(rs.getInt("price"));
        course.setCourseName(rs.getString("course_name"));
        course.setDescription(rs.getString("description"));
        course.setLessonsPerWeek(rs.getInt("lessons_per_week"));
        String status = rs.getString("course_status");
        course.setCourseStatus(CourseStatus.valueOf(status));
        Staff staff = new Staff();
        staff.setId(rs.getInt("leader_staff"));
        course.setFounder(staff);
        course.setSyllabus(rs.getBytes("syllabus"));
        return course;
    }
}