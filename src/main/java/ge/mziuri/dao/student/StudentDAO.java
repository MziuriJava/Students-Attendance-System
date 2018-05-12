package ge.mziuri.dao.student;

import ge.mziuri.model.user.student.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDAO {

    void addStudent(Student student, Connection con) throws Exception;

    void deleteStudent(Student student, Connection con) throws Exception;

    void editStudent(Student student, Connection con) throws Exception;

    List<Student> getAllStudent(Connection con) throws Exception;

    List<Student> searchStudent(String name,String lastname,String personalId, String email, Connection con) throws Exception;

    Student getStudentById(int id, Connection con) throws Exception;
}


