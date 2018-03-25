package ge.mziuri.servlet;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.util.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StaffLoginServlet extends HttpServlet {
    private StaffDAO staffDAO = new StaffDAOImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("failedAuth", "false");
        resp.sendRedirect("index.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("failedAuth", "true");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        Staff staff = new Staff();
        try {
            staff = staffDAO.loginStaff(email, password, DataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (staff != null) {
            resp.sendRedirect("login.html");
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            session.setMaxInactiveInterval(1000);
        } else {
            req.setAttribute("failedAuth", "true");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }


    }
}
