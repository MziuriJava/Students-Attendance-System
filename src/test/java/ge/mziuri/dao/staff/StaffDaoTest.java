package ge.mziuri.dao.staff;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.util.DataBaseConnector;
import ge.mziuri.util.TestDataBaseConnector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoTest {

    private StaffDAO staffDAO;

    @Before
    public void setUp() {
        staffDAO = new StaffDAOImpl();
    }

    @Test
    public void testAddStaffAndGetAllStaffs() throws Exception {
        List<Staff> mockStaffs = new ArrayList<>();
        Staff staff1 = makeMockStaff1();
        mockStaffs.add(staff1);
        Connection connection = TestDataBaseConnector.getConnection();
        staffDAO.addStaff(staff1, connection);
        Staff staff2 = makeMockStaff2();
        mockStaffs.add(staff2);
        connection = TestDataBaseConnector.getConnection();
        staffDAO.addStaff(staff2, connection);
        connection = TestDataBaseConnector.getConnection();
        List<Staff> staffs = staffDAO.getAllStaffs(connection);
        Assert.assertEquals(mockStaffs.size(), staffs.size());
        for (int i = 0; i < mockStaffs.size(); i++) {
            Staff mockStaff = mockStaffs.get(i);
            Staff staff = staffs.get(i);
            Assert.assertEquals(mockStaff.getFirstname(), staff.getFirstname());
            Assert.assertEquals(mockStaff.getLastname(), staff.getLastname());
            Assert.assertEquals(mockStaff.getEmail(), staff.getEmail());
            Assert.assertEquals(mockStaff.getMainPhoneNumber(), staff.getMainPhoneNumber());
            Assert.assertEquals(mockStaff.getAdditionalPhoneNumber(), staff.getAdditionalPhoneNumber());
            Assert.assertEquals(mockStaff.getPassword(), staff.getPassword());
            Assert.assertEquals(mockStaff.getStaffStatus(), staff.getStaffStatus());
        }
    }

    @Test
    public void testEditStaff() throws Exception {
        Staff staff = makeMockStaff1();
        Connection connection = DataBaseConnector.getConnection();
        staffDAO.addStaff(staff, connection);
        connection = DataBaseConnector.getConnection();
        List<Staff> staffs = staffDAO.getAllStaffs(connection);
        Assert.assertTrue(!staffs.isEmpty());

        staff.setId(staffs.get(0).getId());
        staff.setFirstname("oto");
        staff.setLastname("phrodiashvili");
        staff.setMainPhoneNumber("44474747");
        staff.setAdditionalPhoneNumber("1235325642");
        staff.setEmail("otokargibiwia@masarunda.qebao");
        staff.setPassword("BestBoieverOTO666");
        staff.setStaffStatus(StaffStatus.OTHER);

        connection = DataBaseConnector.getConnection();
        staffDAO.editStaff(staff, connection);
        connection = DataBaseConnector.getConnection();
        staffs = staffDAO.getAllStaffs(connection);
        Assert.assertEquals(1, staffs.size());
        Staff staffFromDb = staffs.get(0);
        Assert.assertEquals(staff.getFirstname(), staffFromDb.getFirstname());
        Assert.assertEquals(staff.getLastname(), staffFromDb.getLastname());
        Assert.assertEquals(staff.getMainPhoneNumber(), staffFromDb.getMainPhoneNumber());
        Assert.assertEquals(staff.getAdditionalPhoneNumber(), staffFromDb.getAdditionalPhoneNumber());
        Assert.assertEquals(staff.getEmail(),staffFromDb.getEmail());
        Assert.assertEquals(staff.getPassword(),staffFromDb.getPassword());
        Assert.assertEquals(staff.getStaffStatus(), staffFromDb.getStaffStatus());
    }

    @Test
    public void testDeleteStaff() throws Exception {
        Staff staff = makeMockStaff1();
        Connection connection = DataBaseConnector.getConnection();
        staffDAO.addStaff(staff, connection);
        connection = DataBaseConnector.getConnection();
        List<Staff> staffs = staffDAO.getAllStaffs(connection);
        Assert.assertTrue(!staffs.isEmpty());

        connection = DataBaseConnector.getConnection();
        staff.setId(staffs.get(0).getId());
        staffDAO.deleteStaff(staff, connection);
        connection = DataBaseConnector.getConnection();
        staffs = staffDAO.getAllStaffs(connection);
        Assert.assertTrue(staffs.isEmpty());
    }

    @Test
    public void testLoginStaff() throws Exception{
        Staff staff = makeMockStaff1();
        Connection connection = DataBaseConnector.getConnection();
        staffDAO.addStaff(staff, connection);

        connection = DataBaseConnector.getConnection();
        Staff staffFromDb = staffDAO.loginStaff(":)@:)@mail.com", ":):):)", connection);
        Assert.assertEquals(staff.getFirstname(), staffFromDb.getFirstname());
        Assert.assertEquals(staff.getLastname(), staffFromDb.getLastname());
        Assert.assertEquals(staff.getMainPhoneNumber(), staffFromDb.getMainPhoneNumber());
        Assert.assertEquals(staff.getAdditionalPhoneNumber(), staffFromDb.getAdditionalPhoneNumber());
        Assert.assertEquals(staff.getEmail(),staffFromDb.getEmail());
        Assert.assertEquals(staff.getPassword(),staffFromDb.getPassword());
        Assert.assertEquals(staff.getStaffStatus(), staffFromDb.getStaffStatus());

        connection = DataBaseConnector.getConnection();
        staffFromDb = staffDAO.loginStaff(":)@:)@mail.com", ":):)sfg:)", connection);
        Assert.assertNull(staffFromDb);
    }

    @After
    public void cleanUp() throws Exception {
        Connection connection = DataBaseConnector.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM staff");
        pstm.executeUpdate();
    }

    private Staff makeMockStaff1() {
        Staff staff = new Staff();
        staff.setFirstname("vinme");
        staff.setLastname("vinmedze");
        staff.setMainPhoneNumber("55555");
        staff.setAdditionalPhoneNumber("555555555");
        staff.setEmail(":)@:)@mail.com");
        staff.setPassword(":):):)");
        staff.setStaffStatus(StaffStatus.TEACHER);
        return staff;
    }

    private Staff makeMockStaff2() {
        Staff staff = new Staff();
        staff.setFirstname("vinme");
        staff.setLastname("vinmesjvili");
        staff.setMainPhoneNumber("5684368");
        staff.setAdditionalPhoneNumber("555555555");
        staff.setEmail(":)@safg:)msa@fgail.com");
        staff.setPassword("safhsafgh");
        staff.setStaffStatus(StaffStatus.ADMIN);
        return staff;
    }
}

