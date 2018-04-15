package ge.mziuri.dao;

import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.course.CourseStatus;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.util.db.DataBaseConnector;
import ge.mziuri.util.encode.TextEncoder;

import java.sql.Connection;
import java.util.ArrayList;
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
    TestGetCourses();
        }

    private static StaffDAO staffDAO = new StaffDAOImpl();
    private static CourseDAO courseDAO = new CourseDAOImpl();
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
        Connection con = DataBaseConnector.getConnection();
        Course course = new Course();
        course.setCourseName("JAVA");
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
        List <Course> course = new ArrayList<>();
        course=courseDAO.getAllCourse(con);
        for(int i=0;i<course.size();i++){
            System.out.println(course.get(i).getID());
        }
    }
    }

