package ge.mziuri.dao;

import ge.mziuri.model.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDao {

    void addStudent(Student student, Connection con) throws Exception;

    void deleteStudent(Student  student, Connection con) throws Exception;

    void editStudent(Student student, Connection con) throws Exception;

    List<Student> getAllStudent (Connection con) throws Exception;

    Student loginStudent(String email, String password, Connection con) throws Exception;
}


