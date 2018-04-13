package ge.mziuri.dao.group;

import ge.mziuri.dao.group.GroupDAO;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.user.staff.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GroupDAOImpl implements GroupDAO {

    @Override
    public void addGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO group_ (groupName , startDate, course_id, staff_id) VALUES (?,?,?,?)");
        pstm.setString(1, group.getGroupName());
        pstm.setDate(2, group.getStartDate());
        pstm.setInt(3, group.getCourse().getID());
        pstm.setInt(4, group.getStaff().getId());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("DELETE  FROM group_ where id=?");
        pstmt.setInt(1, group.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public void editGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update group_ SET groupName=?, startDate=?, course_id=?, staff_id=?  WHERE id=?");
        pstmt.setString(1, group.getGroupName());
        pstmt.setDate(2, group.getStartDate());
        pstmt.setInt(3, group.getCourse().getID());
        pstmt.setInt(4, group.getStaff().getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }
}
