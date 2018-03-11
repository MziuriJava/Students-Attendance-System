package ge.mziuri.dao;

import ge.mziuri.model.Staff;
import ge.mziuri.util.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {
    @Override
    public void addstaff(Staff staff,Connection con) throws Exception {

        PreparedStatement pstm = con.prepareStatement("INSERT INTO staff (id, namee , surname, mail , pnumber , pnumber2 , pass ) VALUES (?,?,?,?,?,?,?)");
        pstm.setInt(1, staff.getId());
        pstm.setString(2,staff.getFirstname());
        pstm.setString(3,staff.getLastname());
        pstm.setString(4,staff.getEmail());
        pstm.setString(5,staff.getMainPhoneNumber());
        pstm.setString(6,staff.getAdditionalPhoneNumber());
        pstm.setString(7,staff.getPassword());
        pstm.executeLargeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deletestaff(Staff staff, Connection con) throws Exception {

    }

    @Override
    public void editstaff(Staff staff,Connection con) throws Exception {
        PreparedStatement pstmt1 = con.prepareStatement( "Update staff SET pnumber =? , pnumber2 =? , mail = ? , pass = ?  Where id=? ");
        PreparedStatement pstmt2 = con.prepareStatement("SELECT * FROM staff WHERE id=?");
        pstmt2.setInt(1,staff.getId());
        pstmt1.setInt(5,staff.getId());
        ResultSet rs = pstmt2.executeQuery();
        rs.next();
        if(staff.getMainPhoneNumber().isEmpty()) pstmt1.setInt(1, rs.getInt("mainphonenumber"));
            else pstmt1.setString(1,staff.getMainPhoneNumber());
        if(staff.getAdditionalPhoneNumber().isEmpty() ) pstmt1.setInt(2, rs.getInt("additionalphonenumber"));
            else pstmt1.setString(2,staff.getAdditionalPhoneNumber());
        if(staff.getEmail().isEmpty()) pstmt1.setString(3, rs.getString("email"));
            else pstmt1.setString(3, staff.getEmail());
        if(staff.getPassword().isEmpty()) pstmt1.setString(4,rs.getString("password"));
            else pstmt1.setString(4,staff.getPassword());
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
        String pnumber1=rs.getString("mainphonenumber");
        String pnumber2=rs.getString("additionalphonenumber");
        String mail = rs.getString("email");
        Staff staff = new Staff();
        staff.setId(ID);
        staff.setEmail(mail);
        staff.setFirstname(name);
        staff.setLastname(surname);
        staff.setMainPhoneNumber(pnumber1);
        staff.setAdditionalPhoneNumber(pnumber2);
        staffs.add(staff);
        }
        pstmt.close();
        con.close();
        return staffs;

    }
}
