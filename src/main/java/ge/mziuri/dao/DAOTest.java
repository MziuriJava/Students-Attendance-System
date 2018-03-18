package ge.mziuri.dao;

import ge.mziuri.model.Staff;
import ge.mziuri.model.StaffStatus;
import ge.mziuri.util.DataBaseConnector;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ge.mziuri.util.random.RandomTextGenerator.generateRandomString;
public class DAOTest {

public static void main(String[]args)throws Exception{
    //TestAddStaff();
    //TestGetallstaff();
    //TestEditstaff();
    TestDeleteStaff();
        }

    private static  StaffDAO staffDAO = new StaffDAOImpl();

    public static void   TestAddStaff() throws Exception{
        try {
        Scanner scanner = new Scanner(System.in);
        Staff staff = new Staff();
        staff.setFirstname(scanner.nextLine());
        staff.setLastname(scanner.nextLine());
        staff.setEmail(scanner.nextLine());
        staff.setMainPhoneNumber(scanner.nextLine());
        staff.setAdditionalPhoneNumber(scanner.nextLine());
        staff.setPassword(generateRandomString(5));
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
    }
