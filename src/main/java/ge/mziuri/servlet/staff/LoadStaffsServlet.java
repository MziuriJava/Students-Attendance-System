package ge.mziuri.servlet.staff;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoadStaffsServlet extends HttpServlet {

    private StaffDAO staffDAO = new StaffDAOImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            String searchName = req.getParameter("searchName");
            String searchLastName = req.getParameter("searchLastName");
            String searchPersonalId = req.getParameter( "searchPersonalId");
            String searchEmail = req.getParameter("searchEmail");
            String searchStatus = req.getParameter( "searchStatus");
            List<Staff> staffs = staffDAO.searchStaff(searchName, searchLastName, searchPersonalId, searchEmail, getStaffStatus(searchStatus), DataBaseConnector.getConnection());
            req.setAttribute("staffs", staffs);
            req.setAttribute("searchName", searchName);
            req.getRequestDispatcher("staffs.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO
        }
    }

    // TODO remove
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        doPost(req, resp);
    }

    private StaffStatus getStaffStatus(String status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case "Administrator" :
                return StaffStatus.ADMIN;
            case "Teacher" :
                return StaffStatus.TEACHER;
            case "Other" :
                return StaffStatus.OTHER;
            case "All" :
                default:
                    return null;
        }
    }
}
