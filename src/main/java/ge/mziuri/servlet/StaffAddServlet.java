package ge.mziuri.servlet;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import ge.mziuri.dao.StaffDAO;
import ge.mziuri.dao.StaffDAOImpl;
import ge.mziuri.emailsender.EmailSender;
import ge.mziuri.model.Staff;
import ge.mziuri.model.StaffStatus;
import ge.mziuri.util.DataBaseConnector;
import ge.mziuri.util.PropertiesUtil;
import ge.mziuri.util.random.RandomTextGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class StaffAddServlet extends HttpServlet {
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
            }
            case "Teacher" : {
                staff.setStaffStatus(StaffStatus.TEACHER);
            }
            case "Other" :
                default:
                    staff.setStaffStatus(StaffStatus.OTHER);
        }
        String password = RandomTextGenerator.generateRandomString(7);

        try {
            EmailSender.sendEmail(PropertiesUtil.getProperty("SenderEmail"), PropertiesUtil.getProperty("SenderPassword"), email , password , "დროებითი პაროლი");
            staff.setPassword(password);
            staffDAO.addStaff(staff, DataBaseConnector.getConnection());
        } catch (Exception ex) {
            // TODO
        }


    }


}
