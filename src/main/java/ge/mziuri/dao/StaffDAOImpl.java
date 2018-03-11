package ge.mziuri.dao;

import ge.mziuri.model.Staff;
import ge.mziuri.model.StaffStatus;
import ge.mziuri.util.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {

    @Override
    public void addStaff(Staff staff, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO staff (firstname , lastname, email , main_phone_number , additional_phone_number , password, staff_status) VALUES (?,?,?,?,?,?,?)");
        pstm.setString(1, staff.getFirstname());
        pstm.setString(2,staff.getLastname());
        pstm.setString(3,staff.getEmail());
        pstm.setString(4,staff.getMainPhoneNumber());
        pstm.setString(5,staff.getAdditionalPhoneNumber());
        pstm.setString(6,staff.getPassword());
        pstm.setString(7,staff.getStaffStatus().name());
        pstm.executeLargeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteStaff(Staff staff, Connection con) throws Exception {

    }

    @Override
    public void editStaff(Staff staff, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement( "Update staff SET firstname = ?, lastname = ? , main_phone_number =? , additional_phone_number =? , email = ? , password = ? , staff_status = ?  Where id=? ");

        pstmt.setString(1,staff.getFirstname());
        pstmt.setString(2,staff.getLastname());
        pstmt.setString(3,staff.getMainPhoneNumber());
        pstmt.setString(4,staff.getAdditionalPhoneNumber());
        pstmt.setString(5, staff.getEmail());
        pstmt.setString(6,staff.getPassword());
        pstmt.setString(7,staff.getStaffStatus().name());
        pstmt.executeLargeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Staff> getAllStaffs(Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM staff");
        ResultSet rs=pstmt.executeQuery();
        List <Staff> staffs = new ArrayList<>();
        while(rs.next()){
        int ID = rs.getInt("id");
        String name =rs.getString("firstname");
        String surname =rs.getString("lastname");
        String mainphonenumber=rs.getString("mainphonenumber");
        String additionalphonenumber=rs.getString("additionalphonenumber");
        String mail = rs.getString("email");
        String staffstatus = rs.getString("staff_status");
        StaffStatus staffstatus1 = StaffStatus.valueOf(staffstatus);

        Staff staff = new Staff();
        staff.setId(ID);
        staff.setEmail(mail);
        staff.setFirstname(name);
        staff.setLastname(surname);
        staff.setMainPhoneNumber(mainphonenumber);
        staff.setAdditionalPhoneNumber(additionalphonenumber);
        staff.setStaffStatus(staffstatus1);
        staffs.add(staff);
        }
        pstmt.close();
        con.close();
        return staffs;
    }
}
