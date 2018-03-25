package ge.mziuri.dao.student;

import ge.mziuri.dao.student.StudentDao;
import ge.mziuri.model.user.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoimpl implements StudentDao {

    @Override
    public void addStudent(Student student, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO student (firstname , lastname, email , phone_number ,  password, parent_name, parent_number) VALUES (?,?,?,?,?,?,?)");
        pstm.setString(1, student.getFirstname());
        pstm.setString(2, student.getLastname());
        pstm.setString(3, student.getEmail());
        pstm.setString(4, student.getPhoneNumber());
        pstm.setString(5, student.getPassword());
        pstm.setString(6, student.getParentName());
        pstm.setString(7, student.getParentNumber());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }
    @Override
      public void deleteStudent(Student student, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("DELETE  FROM student where id=?");
        pstmt.setInt(1, student.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public void editStudent(Student student, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("Update student SET firstname=?, lastname=?, email=?, phone_number=?, password=?, parent_name=?, parent_number WHERE id=?");
        pstm.setString(1, student.getFirstname());
        pstm.setString(2, student.getLastname());
        pstm.setString(3, student.getEmail());
        pstm.setString(4, student.getPhoneNumber());
        pstm.setString(5, student.getPassword());
        pstm.setString(6, student.getParentName());
        pstm.setString(7, student.getParentNumber());
        pstm.setInt(8,student.getId());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public List<Student> getAllStudent(Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student");
        ResultSet rs = pstmt.executeQuery();
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            students.add(getStudent(rs));
        }
        pstmt.close();
        con.close();
        return students;
    }



    private Student getStudent(ResultSet rs) throws SQLException {
        int ID = rs.getInt("id");
        String name = rs.getString("firstname");
        String surname = rs.getString("lastname");
        String mainPhoneNumber = rs.getString("phone_number");
        String mail = rs.getString("email");
        String password = rs.getString("password");
        String parent_name = rs.getString("parent_name");
        String parent_number = rs.getString("parent_number");

        Student student = new Student();
        student.setId(ID);
        student.setEmail(mail);
        student.setFirstname(name);
        student.setLastname(surname);
        student.setPassword(password);
        student.setPhoneNumber(mainPhoneNumber);
        student.setParentName(parent_name);
        student.setParentNumber(parent_number);

        return student;
    }
}

