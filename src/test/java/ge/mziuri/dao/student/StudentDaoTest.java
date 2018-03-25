package ge.mziuri.dao.student;


import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.DataBaseConnector;
import ge.mziuri.util.TestDataBaseConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoTest {
    private StudentDao studentDao;

    @Before
    public void setUp() {
        studentDao = new StudentDaoimpl();
    }

        @Test
        public void testAddStudentAndGetAllStudnent() throws Exception {
            List<Student> mockStudents = new ArrayList<>();
            Student student1 = makeMockStudent1();
            mockStudents.add(student1);
            Connection connection = TestDataBaseConnector.getConnection();
            studentDao.addStudent(student1, connection);
            Student student2 = makeMockStudent2();
            mockStudents.add(student2);
            connection = TestDataBaseConnector.getConnection();
            studentDao.addStudent(student2, connection);
            connection = TestDataBaseConnector.getConnection();
            List<Student> students = studentDao.getAllStudent(connection);
            Assert.assertEquals(mockStudents.size(), students.size());
            for (int i = 0; i < mockStudents.size(); i++) {
                Student mockStudent = mockStudents.get(i);
                Student student = students.get(i);
               Assert.assertEquals(mockStudent.getFirstname(), student.getFirstname());
               Assert.assertEquals(mockStudent.getLastname(),student.getLastname());
               Assert.assertEquals(mockStudent.getPhoneNumber(),student.getPhoneNumber());
               Assert.assertEquals(mockStudent.getEmail(), student.getEmail());
               Assert.assertEquals(mockStudent.getPassword(),student.getPassword());
               Assert.assertEquals(mockStudent.getParentName(),student.getParentName());
               Assert.assertEquals(mockStudent.getParentNumber(),student.getParentNumber());
  }
  }


    @Test
    public  void testDeleteStudent() throws Exception
    {
        Student student = makeMockStudent1();
        Connection connection = DataBaseConnector.getConnection();
        studentDao.addStudent(student, connection);
        connection = DataBaseConnector.getConnection();
        List<Student> students = studentDao.getAllStudent(connection);
        Assert.assertTrue(!students.isEmpty());

        connection = DataBaseConnector.getConnection();
        student.setId(students.get(0).getId());
        studentDao.deleteStudent(student, connection);
        connection = DataBaseConnector.getConnection();
        students = studentDao.getAllStudent(connection);
        Assert.assertTrue(students.isEmpty());
    }


    private Student makeMockStudent1(){
        Student student= new Student();
        student.setFirstname("vinme");
        student.setLastname("vinmedze");
        student.setPhoneNumber("55555");
        student.setEmail(":)@:)@mail.com");
        student.setPassword(":):):)");
        student.setParentName("otototo");
        student.setParentNumber("5665685");
        return student;
    }

    private Student makeMockStudent2(){
        Student student= new Student();
        student.setFirstname("oto");
        student.setLastname("vinze");
        student.setPhoneNumber("5125555");
        student.setEmail(":)@::))@mail.com");
        student.setPassword(":):):):):)");
        student.setParentName("ototototooto");
        student.setParentNumber("566565454554685");
        return student;
    }
}
