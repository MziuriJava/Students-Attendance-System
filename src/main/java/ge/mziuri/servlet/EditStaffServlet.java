package ge.mziuri.servlet;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditStaffServlet extends HttpServlet {

    private StaffDAO staffDAO = new StaffDAOImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int staffId = Integer.parseInt(req.getParameter("staffId"));
        try {
            Staff staff = staffDAO.getStaffById(staffId);
            req.setAttribute("staff", staff);
            resp.sendRedirect("addStaff.jsp");
        } catch (Exception ex) {
            // TODO
        }
    }
}
