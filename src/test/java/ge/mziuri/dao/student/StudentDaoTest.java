package ge.mziuri.dao.student;


import ge.mziuri.model.user.student.Student;

import ge.mziuri.util.TestDataBaseConnector;
import ge.mziuri.util.db.DataBaseConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoTest {
    private StudentDao studentDao;

    @Before
    public void setUp() {
        studentDao = new StudentDaoImpl();
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
               Assert.assertEquals(mockStudent.getSchool(), student.getSchool());
               Assert.assertEquals(mockStudent.getBirthDate(),student.getBirthDate());
               Assert.assertEquals(mockStudent.getPersonalID(), student.getPersonalID());
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

    @Test
    public void testEditStudent() throws Exception {
        Student student = makeMockStudent1();
        Connection connection = DataBaseConnector.getConnection();
        studentDao.addStudent(student, connection);
        connection = DataBaseConnector.getConnection();
        List<Student> students = studentDao.getAllStudent(connection);
        Assert.assertTrue(!students.isEmpty());

        student.setId(students.get(0).getId());
        student.setFirstname("aqaaqare");
        student.setLastname("phrodiasdli");
        student.setPhoneNumber("44123747");
        student.setEmail("otooto250@gmail.com");
        student.setPassword("r2d2");
        student.setParentName("asdasd");
        student.setParentNumber("123123213");
        student.setSchool("OTO_DAMSJELI_SKOLA");
        student.setBirthDate(new Date(1999, 0,16));
        student.setPersonalID("123123123");


        connection = DataBaseConnector.getConnection();
        studentDao.editStudent(student, connection);
        connection = DataBaseConnector.getConnection();
        students = studentDao.getAllStudent(connection);
        Assert.assertEquals(1, students.size());
        Student studentFromDb = students.get(0);

        Assert.assertEquals(student.getFirstname(), studentFromDb.getFirstname());
        Assert.assertEquals(student.getLastname(), studentFromDb.getLastname());
        Assert.assertEquals(student.getEmail(), studentFromDb.getEmail());
        Assert.assertEquals(student.getPassword(),studentFromDb.getPassword());
        Assert.assertEquals(student.getParentName(),student.getParentName());
        Assert.assertEquals(student.getParentNumber(), studentFromDb.getParentName());
        Assert.assertEquals(student.getPhoneNumber(), studentFromDb.getPhoneNumber());
        Assert.assertEquals(student.getSchool(),studentFromDb.getSchool());
        Assert.assertEquals(student.getPersonalID(),studentFromDb.getPersonalID());
        Assert.assertEquals(student.getBirthDate(),studentFromDb.getBirthDate());

    }

    private Student makeMockStudent1(){
        Student student= new Student();
        student.setFirstname("BEQA");
        student.setLastname("vinmedze");
        student.setPhoneNumber("55555");
        student.setEmail(":)@:)@mail.com");
        student.setPassword(":):):)");
        student.setParentName("otototo");
        student.setParentNumber("5665685");
        student.setSchool("MZIURI");
        student.setBirthDate(new Date(2003,10 ,28));
        student.setPersonalID("1234");
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
        student.setSchool("OTOS_SKOLA");
        student.setBirthDate(new Date(2002, 0, 1));
        student.setPersonalID("12312312");
        return student;
    }
}
