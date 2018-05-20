package ge.mziuri.dao.student_group_relation;

import java.sql.Connection;

public interface StudentGroupDAO {

    void addRelation(int studentID, int groupID, Connection con) throws Exception;

    void deleteRelation (int studentID, Connection con) throws Exception;
}
