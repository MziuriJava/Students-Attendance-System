package ge.mziuri.dao.group;

import ge.mziuri.dao.group.GroupDAO;
import ge.mziuri.model.group.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GroupDAOImpl implements GroupDAO {


    @Override
    public void addGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO group (name , date) VALUES (?,?)");
        pstm.setString(1, group.getGroupName());
        pstm.setDate(2, group.getStartDate());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("DELETE  FROM group where id=?");
        pstmt.setInt(1, group.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public void editGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update group SET name=?, date=? WHERE id=?");
        pstmt.setString(1, group.getGroupName());
        pstmt.setDate(2, group.getStartDate());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }
}
