package ge.mziuri.dao.student;

import ge.mziuri.model.user.student.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDao {

    void addStudent(Student student, Connection con) throws Exception;

    void deleteStudent(Student student, Connection con) throws Exception;

    void editStudent(Student student, Connection con) throws Exception;

    List<Student> getAllStudent(Connection con) throws Exception;

    List<Student> searchStudent(int id,String name,String lastname,String email, Connection con) throws Exception;

}


