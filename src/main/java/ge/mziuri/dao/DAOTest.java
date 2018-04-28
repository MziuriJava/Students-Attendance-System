package ge.mziuri.dao;

import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.dao.journal.JournalDAO;
import ge.mziuri.dao.journal.JournalDAOimpl;
import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.dao.student.StudentDao;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.course.CourseStatus;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.journal.Label;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;
import ge.mziuri.util.encode.TextEncoder;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DAOTest {

public static void main(String[]args)throws Exception{
    //TestAddStaff();
    //TestGetallstaff();
    //TestEditstaff();
    //TestDeleteStaff();
    //TestAddCourse();
    //TestEditCourse();
    //TestGetCourses();
    TestAddStudent();
    //TestAddLabel();
        }
    private static StudentDao studentDao = new StudentDaoImpl();
    private static StaffDAO staffDAO = new StaffDAOImpl();
    private static CourseDAO courseDAO = new CourseDAOImpl();
    private static JournalDAO journalDAO = new JournalDAOimpl();
    public static void   TestAddStaff() throws Exception{
        try {
        Scanner scanner = new Scanner(System.in);
        Staff staff = new Staff();
        staff.setFirstname(scanner.nextLine());
        staff.setLastname(scanner.nextLine());
        staff.setEmail(scanner.nextLine());
        staff.setMainPhoneNumber(scanner.nextLine());
        staff.setAdditionalPhoneNumber(scanner.nextLine());
        staff.setPassword(TextEncoder.textEncode("rame"));
        staff.setStaffStatus(StaffStatus.ADMIN);
        Connection con = DataBaseConnector.getConnection();
        staffDAO.addStaff(staff, con);
        con.close();
    } catch (Exception ex){
        ex.printStackTrace();
    }}
    public static void TestGetallstaff() throws Exception{
        try {
        List <Staff> staffs = new ArrayList<>();
        Connection con = DataBaseConnector.getConnection();
        staffs=staffDAO.getAllStaffs(con);
        for(int i = 0; i < staffs.size() ; i ++){
            System.out.println(staffs.get(i).getFirstname());
        }
        con.close();

    }catch (Exception ex){
        ex.printStackTrace();
    }
    }
    public static void TestEditstaff() throws Exception{
        try{
        Staff staff = new Staff();
        staff.setFirstname("xXx");
        staff.setLastname("xXx");
        staff.setMainPhoneNumber("xXx");
        staff.setStaffStatus(StaffStatus.TEACHER);
        staff.setAdditionalPhoneNumber("xXx");
        staff.setEmail("xXx");
        staff.setId(2);
        Connection con = DataBaseConnector.getConnection();
        staffDAO.editStaff(staff,con);
        con.close();
    }catch (Exception ex){
        ex.printStackTrace();
    }
    }
    public static void TestDeleteStaff() throws Exception {
        try {
            Staff staff = new Staff();
            staff.setId(2);
            Connection con = DataBaseConnector.getConnection();
            staffDAO.deleteStaff(staff, con);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void TestLoginStaff() throws Exception {
        try{
            Staff staff = new Staff();
            staff.setPassword("esdf");
            staff.setEmail("alex");



    }
    catch (Exception ex){
        ex.printStackTrace();
    }
    }

    public static void TestAddCourse() throws  Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DataBaseConnector.getConnection();
        Course course = new Course();
        course.setCourseName(sc.nextLine());
        course.setCourseStatus(CourseStatus.DEACTIVATED);
        Staff staff = new Staff();
        staff.setId(1);
        course.setFounder(staff);
        courseDAO.addCourse(course,con);
    }
    public static void TestEditCourse() throws Exception{
        Connection con = DataBaseConnector.getConnection();
        Course course = new Course();
        course.setCourseName("JAVA");
        course.setID(1);
        course.setCourseStatus(CourseStatus.DEACTIVATED);
        Staff staff = new Staff();
        staff.setId(1);
        course.setFounder(staff);
        courseDAO.editCourse(course,con);
    }
    public static void TestGetCourses() throws Exception{
        Connection con = DataBaseConnector.getConnection();
        List <Course> course;
        course=courseDAO.getAllCourse(con);
        for(int i=0;i<course.size();i++){
            System.out.println(course.get(i).getID());
        }
    }
    public static void TestAddStudent() throws Exception{
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        student.setFirstname(sc.nextLine());
        student.setLastname(sc.nextLine());
        student.setEmail(sc.nextLine());
        student.setPassword(TextEncoder.textEncode("rame"));
        student.setPhoneNumber(sc.nextLine());
        student.setParentName(sc.nextLine());
        student.setParentNumber(sc.nextLine());
        studentDao.addStudent(student, DataBaseConnector.getConnection());
    }
    public static void TestAddLabel() throws Exception{
        Student student = new Student();
        student.setId(1);
        Group group = new Group();
        group.setId(1);
        Label label = new Label();
        label.setAttend(true);
        label.setStudent(student);
        label.setGroup(group);
        label.setDate(new Date());
        label.setLessonMark(9);
        Connection con = DataBaseConnector.getConnection();
        journalDAO.addLabel(label,con);
    }
    }

