package ge.mziuri.dao.student;

import ge.mziuri.model.user.student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void addStudent(Student student, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO student (firstname, lastname, email, phone_number, password, parent_name, parent_number, school, birth_date, personal_id) VALUES (?,?,?,?,?,?,?,?,?,?)");
        pstm.setString(1, student.getFirstname());
        pstm.setString(2, student.getLastname());
        pstm.setString(3, student.getEmail());
        pstm.setString(4, student.getPhoneNumber());
        pstm.setString(5, student.getPassword());
        pstm.setString(6, student.getParentName());
        pstm.setString(7, student.getParentNumber());
        pstm.setString(8, student.getSchool());
        pstm.setDate(9, new Date(student.getBirthDate().getTime()));
        pstm.setString(10,student.getPersonalID());
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
        PreparedStatement pstm = con.prepareStatement("UPDATE student SET firstname=?, lastname=?, email=?, phone_number=?, password=?, parent_name=?, parent_number=?, birth_date=?, school=?, personal_id=? WHERE id=?");
        pstm.setString(1, student.getFirstname());
        pstm.setString(2, student.getLastname());
        pstm.setString(3, student.getEmail());
        pstm.setString(4, student.getPhoneNumber());
        pstm.setString(5, student.getPassword());
        pstm.setString(6, student.getParentName());
        pstm.setString(7, student.getParentNumber());
        pstm.setString(8,student.getSchool());
        pstm.setDate(9,new Date(student.getBirthDate().getTime()));
        pstm.setString(10,student.getPersonalID());
        pstm.setInt(11,student.getId());
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
        String school =rs.getString("school");
        Date birth_date = rs.getDate("birth_date");
        String personal_ID = rs.getString("personal_id");

        Student student = new Student();
        student.setId(ID);
        student.setEmail(mail);
        student.setFirstname(name);
        student.setLastname(surname);
        student.setPassword(password);
        student.setPhoneNumber(mainPhoneNumber);
        student.setParentName(parent_name);
        student.setParentNumber(parent_number);
        student.setSchool(school);
        student.setBirthDate(birth_date);
        student.setPersonalID(personal_ID);
        return student;
    }

    @Override
    public List<Student> searchStudent(int id,String name,String surname,String email,String school, Connection con) throws Exception {
        String sql ="SELECT * FROM student WHERE 1=1 ";
        if(id==0) {} else sql=sql+"AND id="+Integer.toString(id)+" ";
        if(name.isEmpty()) {} else sql=sql+"AND firstname LIKE "+"'%"+name+"%' ";
        if(surname.isEmpty()) {} else sql=sql+"AND lastname LIKE "+"'%"+surname+"%' ";
        if(email.isEmpty()) {} else sql=sql+"AND email LIKE "+"'%"+email+"%' ";
        if(school.isEmpty()) {} else sql=sql+"AND school Like "+"'%"+school+"%' ";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs=pstm.executeQuery();
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            students.add(getStudent(rs));
        }
        pstm.close();
        con.close();
        return students;
    }
}

