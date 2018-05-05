package ge.mziuri.servlet.staff;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoadStaffsServlet extends HttpServlet {

    private StaffDAO staffDAO = new StaffDAOImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            List<Staff> staffs = staffDAO.getAllStaffs(DataBaseConnector.getConnection());
            req.setAttribute("staffs", staffs);
            req.getRequestDispatcher("staffs.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO
        }
    }

    // TODO remove
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            List<Staff> staffs = staffDAO.getAllStaffs(DataBaseConnector.getConnection());
            req.setAttribute("staffs", staffs);
            req.getRequestDispatcher("staffs.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO
            e.printStackTrace();
        }
    }







}
