package ge.mziuri.servlet.staff;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditStaffServlet extends HttpServlet {

    private StaffDAO staffDAO = new StaffDAOImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int staffId = Integer.parseInt(req.getParameter("staffId"));
        try {
            Staff staff = staffDAO.getStaffById(staffId, DataBaseConnector.getConnection());
            req.setAttribute("staff", staff);
            req.getRequestDispatcher("sas/admin/addStaff.jsp").forward(req, resp);
        } catch (Exception ex) {
            // TODO
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int staffId = Integer.parseInt(req.getParameter("staffId"));
        try {
            Staff staff = staffDAO.getStaffById(staffId, DataBaseConnector.getConnection());
            req.setAttribute("staff", staff);
            req.getRequestDispatcher("sas/admin/addStaff.jsp").forward(req, resp);
        } catch (Exception ex) {
            // TODO
        }
    }
}
