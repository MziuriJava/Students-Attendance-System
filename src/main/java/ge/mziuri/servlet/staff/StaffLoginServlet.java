package ge.mziuri.servlet.staff;

import ge.mziuri.dao.post.PostDAO;
import ge.mziuri.dao.post.PostDAOImpl;
import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.blog.Post;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.util.db.DataBaseConnector;
import ge.mziuri.util.encode.TextEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StaffLoginServlet extends HttpServlet {

    private StaffDAO staffDAO = new StaffDAOImpl();

    private PostDAO postDAO = new PostDAOImpl();

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
            staff = staffDAO.loginStaff(email, TextEncoder.textEncode(password), DataBaseConnector.getConnection());
            if (staff != null && (staff.getStaffStatus().equals(StaffStatus.ADMIN) || staff.getStaffStatus().equals(StaffStatus.TEACHER))) {
                HttpSession session = req.getSession();
                session.setAttribute("staff", staff);
                List<Post> posts = postDAO.getAllPost(DataBaseConnector.getConnection());
                session.setAttribute("posts", posts);
                session.setMaxInactiveInterval(3000);
                req.getRequestDispatcher("/sas/main.jsp").forward(req, resp);
            } else {
                req.setAttribute("failedAuth", "true");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
