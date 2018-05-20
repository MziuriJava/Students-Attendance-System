package ge.mziuri.dao.student;

import ge.mziuri.dao.student_group_relation.StudentGroupDAO;
import ge.mziuri.dao.student_group_relation.StudentGroupDAOimpl;
import ge.mziuri.model.user.student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDAO {

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
        pstm.setString(10, student.getPersonalId());
        pstm.executeUpdate();
        pstm.close();
        if(student.getGroups()!=null){
        int i=0;
        StudentGroupDAO studentGroupDAO = new StudentGroupDAOimpl();
        for(i=0;i<student.getGroups().size();i++) {
            studentGroupDAO.addRelation(student.getId(),student.getGroups().get(i).getId(),con);

        }}
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
        pstm.setString(10,student.getPersonalId());
        pstm.setInt(11,student.getId());
        pstm.executeUpdate();
        int i=0;
        StudentGroupDAO studentGroupDAO = new StudentGroupDAOimpl();
        studentGroupDAO.deleteRelation(student.getId(),con);

        for(i=0;i<student.getGroups().size();i++) {
            studentGroupDAO.addRelation(student.getId(),student.getGroups().get(i).getId(),con);
        }

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
        student.setPersonalId(personal_ID);
        return student;
    }

    @Override
    public List<Student> searchStudent(String name,String surname,String personalId, String email, Connection con) throws Exception {
        String sql ="SELECT * FROM student WHERE 1=1 ";
        if(name != null && !name.isEmpty()) {
            sql += "AND firstname LIKE " + "'%" + name + "%' ";
        }
        if(surname != null && !surname.isEmpty()) {
            sql += "AND lastname LIKE " + "'%" + surname + "%' ";
        }
        if(personalId != null && !personalId.isEmpty()) {
            sql += "AND personal_id LIKE " + "'%" + personalId + "%' ";
        }
        if(email != null && !email.isEmpty()) {
            sql += "AND email Like " + "'%" + email + "%' ";
        }
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

    @Override
    public Student getStudentById(int id, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Student student = getStudent(rs);
        pstmt.close();
        con.close();
        return student;
    }
}

