package ge.mziuri.dao.course;

import ge.mziuri.model.course.Course;

import java.sql.Connection;
import java.util.List;

public interface CourseDAO {

    void addCourse(Course course, Connection con) throws Exception;

    void deleteCourse(Course course, Connection con) throws Exception;

    List<Course> getAllCourse(Connection con) throws Exception;

    void editCourse (Course course , Connection con) throws Exception;
}
