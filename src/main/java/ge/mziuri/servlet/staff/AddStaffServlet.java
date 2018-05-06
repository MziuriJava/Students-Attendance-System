package ge.mziuri.servlet.staff;

import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.util.emailsender.EmailSender;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.util.db.DataBaseConnector;
import ge.mziuri.util.properies.PropertiesUtil;
import ge.mziuri.util.encode.TextEncoder;
import ge.mziuri.util.random.RandomTextGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStaffServlet extends HttpServlet {

    private StaffDAO staffDAO = new StaffDAOImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String id = req.getParameter("id");   // TODO use id
        String mainNumber = req.getParameter("MainNumber");
        String subNumber = req.getParameter("SubNumber");
        String statusStr = req.getParameter("status");

        Staff staff = new Staff();
        staff.setEmail(email);
        staff.setFirstname(name);
        staff.setLastname(surname);
        staff.setMainPhoneNumber(mainNumber);
        staff.setAdditionalPhoneNumber(subNumber);
        switch (statusStr) {
            case "Administrator" : {
                staff.setStaffStatus(StaffStatus.ADMIN);
                break;
            }
            case "Teacher" : {
                staff.setStaffStatus(StaffStatus.TEACHER);
                break;
            }
            case "Other" :
                default:
                    staff.setStaffStatus(StaffStatus.OTHER);
        }
        String password = RandomTextGenerator.generateRandomString(7);

        try {
            EmailSender.sendEmail(PropertiesUtil.getProperty("SenderEmail"), PropertiesUtil.getProperty("SenderPassword"), email , password , "დროებითი პაროლი");
            staff.setPassword(TextEncoder.textEncode(password));
            staffDAO.addStaff(staff, DataBaseConnector.getConnection());
            resp.sendRedirect("/loadStaffs");
        } catch (Exception ex) {
            // TODO
        }
    }
}
