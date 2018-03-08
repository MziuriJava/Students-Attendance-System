package ge.mziuri.dao.dao;

import ge.mziuri.dao.model.Admin;

import java.util.List;

public interface AdminDao {

    void addadmin(Admin admin) throws Exception;

    void deleteadmin(Admin admin) throws Exception;

    void editadmin (Admin admin) throws Exception;

    List<Admin> getAllAdmins () throws Exception;

}
