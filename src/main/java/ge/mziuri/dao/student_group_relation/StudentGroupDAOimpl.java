package ge.mziuri.dao.student_group_relation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentGroupDAOimpl implements StudentGroupDAO {
    @Override
    public void addRelation(int studentID, int groupID, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO student_group (student_id,group_id) VALUES (?,?)");
        pstm.setInt(1,studentID);
        pstm.setInt(2,groupID);
        pstm.executeUpdate();
        pstm.close();
        con.close();

    }


    @Override
    public void deleteRelation(int studentID, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("DELETE FROM student_group WHERE student_id=?");
        pstm.setInt(1,studentID);
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }
}
