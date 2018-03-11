package ge.mziuri.dao;

import ge.mziuri.model.Staff;

import java.sql.Connection;
import java.util.List;

public interface StaffDAO {

    void addstaff(Staff staff,Connection con) throws Exception;

    void deletestaff(Staff staff, Connection con) throws Exception;

    void editstaff (Staff staff,Connection con) throws Exception;

    List<Staff> getAllStaffs (Connection con) throws Exception;
}
