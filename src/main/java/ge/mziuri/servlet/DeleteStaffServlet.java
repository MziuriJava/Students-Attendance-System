package ge.mziuri.servlet;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStaffServlet extends HttpServlet {
    private StaffDAO staffDAO = new StaffDAOImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int staffId = Integer.parseInt(req.getParameter("staffId"));
        try {
            Staff staff = new Staff();
            staff.setId(staffId);
            staffDAO.deleteStaff(staff, DataBaseConnector.getConnection());
            resp.sendRedirect("/loadStaffs");
        } catch (Exception ex) {
            // TODO
        }
    }
}