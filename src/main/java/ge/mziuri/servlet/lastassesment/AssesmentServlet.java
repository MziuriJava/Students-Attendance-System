package ge.mziuri.servlet.lastassesment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssesmentServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String staffName="vinme";
        String topic="sazafxulo";
        String assesmentInformation="java";
        String active="25/30";
        String homework="12/15";
        String absent="5/20";
        String date1="10/02/17";
        String mark1="10";
        String descriprion="dzalian kargia";
        String teacherName="vinme vinmedze";

        req.setAttribute("staffName",staffName);
        req.setAttribute("topic",topic);
        req.setAttribute("assesmentInformation",assesmentInformation);
        req.setAttribute("active",active);
        req.setAttribute("homework",homework);
        req.setAttribute("absent",absent);
        req.setAttribute("date1",date1);
        req.setAttribute("mark1",mark1);
        req.setAttribute("descriprion", descriprion);
        req.setAttribute("teacherName", teacherName);


        req.getRequestDispatcher("/sas/assesmentTest/assessment.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
