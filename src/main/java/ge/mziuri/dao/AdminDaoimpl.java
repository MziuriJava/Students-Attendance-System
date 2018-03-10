package ge.mziuri.dao;

import ge.mziuri.model.Admin;
import ge.mziuri.util.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoimpl implements AdminDao {
    @Override
    public void addadmin(Admin admin) throws Exception {
        Connection con = DataBaseConnector.getConnection();
        PreparedStatement pstm = con.prepareStatement("INSERT INTO admin (id, namee , surname, mail , pnumber , pnumber2 , pass ) VALUES (?,?,?,?,?,?,?)");
        pstm.setInt(1, admin.getID());
        pstm.setString(2,admin.getName());
        pstm.setString(3,admin.getSurname());
        pstm.setString(4,admin.getMail());
        pstm.setInt(5,admin.getPhonenumber1());
        pstm.setInt(6,admin.getPhonenumber2());
        pstm.setString(7,admin.getPass());
        pstm.executeLargeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteadmin(Admin admin) throws Exception {

    }

    @Override
    public void editadmin(Admin admin) throws Exception {
        Connection con = DataBaseConnector.getConnection();
        PreparedStatement pstmt1 = con.prepareStatement( "Update admin SET pnumber =? , pnumber2 =? , mail = ? , pass = ?  Where id=? ");
        PreparedStatement pstmt2 = con.prepareStatement("SELECT * FROM admin WHERE id=?");
        pstmt2.setInt(1,admin.getID());
        pstmt1.setInt(5,admin.getID());
        ResultSet rs = pstmt2.executeQuery();
        rs.next();
        if(admin.getPhonenumber1() == 0 ) pstmt1.setInt(1, rs.getInt("pnumber"));
            else pstmt1.setInt(1,admin.getPhonenumber1());
        if(admin.getPhonenumber2() == 0 ) pstmt1.setInt(2, rs.getInt("pnumber2"));
            else pstmt1.setInt(2,admin.getPhonenumber2());
        if(admin.getMail().isEmpty()) pstmt1.setString(3, rs.getString("mail"));
            else pstmt1.setString(3, admin.getMail());
        if(admin.getPass().isEmpty()) pstmt1.setString(4,rs.getString("pass"));
            else pstmt1.setString(4,admin.getPass());
    }

    @Override
    public List<Admin> getAllAdmins() throws Exception {
        Connection con = DataBaseConnector.getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM admin");
        ResultSet rs=pstmt.executeQuery();
        List <Admin> admins = new ArrayList<>();
        while(rs.next()){
        int ID = rs.getInt("id");
        String name =rs.getString("namee");
        String surname =rs.getString("surname");
        int pnumber1=rs.getInt("pnumber");
        int pnumber2=rs.getInt("pnumber2");
        String mail = rs.getString("mail");
        Admin admin = new Admin();
        admin.setID(ID);
        admin.setMail(mail);
        admin.setName(name);
        admin.setSurname(surname);
        admin.setPhonenumber1(pnumber1);
        admin.setPhonenumber2(pnumber2);
        admins.add(admin);
        }
        pstmt.close();
        con.close();
        return admins;

    }
}
