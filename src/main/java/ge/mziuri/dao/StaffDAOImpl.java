package ge.mziuri.dao;

import ge.mziuri.model.Staff;
import ge.mziuri.model.StaffStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {

    @Override
    public void addStaff(Staff staff, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO staff (firstname , lastname, email , main_phone_number , additional_phone_number , password, staff_status) VALUES (?,?,?,?,?,?,?)");
        pstm.setString(1, staff.getFirstname());
        pstm.setString(2, staff.getLastname());
        pstm.setString(3, staff.getEmail());
        pstm.setString(4, staff.getMainPhoneNumber());
        pstm.setString(5, staff.getAdditionalPhoneNumber());
        pstm.setString(6, staff.getPassword());
        pstm.setString(7, staff.getStaffStatus().name());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteStaff(Staff staff, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("DELETE  FROM staff where id=?");
        pstmt.setInt(1, staff.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public void editStaff(Staff staff, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update staff SET firstname=?, lastname=?, email=?, main_phone_number=?,additional_phone_number=?, staff_status=? WHERE id=?");
        pstmt.setString(1, staff.getFirstname());
        pstmt.setString(2, staff.getLastname());
        pstmt.setString(3, staff.getEmail());
        pstmt.setString(4, staff.getMainPhoneNumber());
        pstmt.setString(5, staff.getAdditionalPhoneNumber());
        pstmt.setString(6, staff.getStaffStatus().name());
        pstmt.setInt(7, staff.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Staff> getAllStaffs(Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM staff");
        ResultSet rs = pstmt.executeQuery();
        List<Staff> staffs = new ArrayList<>();
        while (rs.next()) {
            staffs.add(getStaff(rs));
        }
        pstmt.close();
        con.close();
        return staffs;
    }

    @Override
    public Staff loginStaff(String email , String password , Connection con) throws Exception {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM staff WHERE email = ? AND password = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return getStaff(rs);
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Staff getStaff(ResultSet rs) throws SQLException {
        int ID = rs.getInt("id");
        String name = rs.getString("firstname");
        String surname = rs.getString("lastname");
        String mainPhoneNumber = rs.getString("main_phone_number");
        String additionalPhoneNumber = rs.getString("additional_phone_number");
        String mail = rs.getString("email");
        StaffStatus staffstatus = StaffStatus.valueOf(rs.getString("staff_status"));

        Staff staff = new Staff();
        staff.setId(ID);
        staff.setEmail(mail);
        staff.setFirstname(name);
        staff.setLastname(surname);
        staff.setMainPhoneNumber(mainPhoneNumber);
        staff.setAdditionalPhoneNumber(additionalPhoneNumber);
        staff.setStaffStatus(staffstatus);
        return staff;
    }
}
