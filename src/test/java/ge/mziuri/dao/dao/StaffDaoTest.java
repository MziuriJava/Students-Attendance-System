package ge.mziuri.dao.dao;

import ge.mziuri.dao.StaffDAO;
import ge.mziuri.dao.StaffDAOImpl;
import ge.mziuri.model.Staff;
import ge.mziuri.util.TestDataBaseConnector;
import org.junit.After;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StaffDaoTest {

    @Test
    public void testAddStaffAndGetAllStaffs() throws Exception {
        StaffDAO staffDAO = new StaffDAOImpl();
        // create test staff
        Staff staff = new Staff();
        staffDAO.addStaff(staff, TestDataBaseConnector.getConnection());
    }

    @Test
    public void testEditStaff() {

    }

    @Test
    public void testDeleteStaff() {

    }

    @After
    public void cleanUp() throws Exception {
        Connection connection = TestDataBaseConnector.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM staff");
        pstm.executeUpdate();
    }
}
