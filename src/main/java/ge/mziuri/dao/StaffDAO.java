package ge.mziuri.dao;

import ge.mziuri.model.Staff;

import java.sql.Connection;
import java.util.List;

public interface StaffDAO {

    void addStaff(Staff staff, Connection con) throws Exception;

    void deleteStaff(Staff staff, Connection con) throws Exception;

    void editStaff(Staff staff, Connection con) throws Exception;

    List<Staff> getAllStaffs (Connection con) throws Exception;
}
