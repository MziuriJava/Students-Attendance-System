package ge.mziuri.dao;

import ge.mziuri.model.Group;

import java.sql.Connection;

public interface GroupDAO {

    void addGroup(Group group, Connection con) throws Exception;

    void deleteGroup(Group group, Connection con) throws Exception;

    void editGroup(Group group, Connection con) throws Exception;
}
