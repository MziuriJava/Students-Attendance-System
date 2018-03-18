package ge.mziuri.dao;

import ge.mziuri.model.Staff;
import ge.mziuri.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface StaffDAO {

    void addStaff(Staff staff, Connection con) throws Exception;

    void deleteStaff(Staff staff, Connection con) throws Exception;

    void editStaff(Staff staff, Connection con) throws Exception;

    List<Staff> getAllStaffs (Connection con) throws Exception;

    Staff loginStaff(String email, String password, Connection con) throws Exception;
}
