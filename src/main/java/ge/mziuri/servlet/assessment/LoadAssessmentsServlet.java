package ge.mziuri.servlet.assessment;

import ge.mziuri.dao.assessment.AssessmentDAO;
import ge.mziuri.dao.assessment.AssessmentDAOImpl;
import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class LoadAssessmentsServlet extends HttpServlet {

    private AssessmentDAO assessmentDAO = new AssessmentDAOImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            String searchStaff = req.getParameter("searchName");
            String searchStudent = req.getParameter("searchStudent");
            String searchGroup = req.getParameter( "searchGroup");
            String searchStartDate = req.getParameter("searchStartDate");
            List<Assessment> assessments = assessmentDAO.searchAssessments(searchStaff, searchStudent, searchGroup, searchStartDate, DataBaseConnector.getConnection());
            req.setAttribute("assessments", assessments);
            req.setAttribute("searchStaff", searchStaff);
            req.setAttribute("searchStudent", searchStudent);
            req.setAttribute("searchGroup", searchGroup);
            req.setAttribute("searchStartDate", searchStartDate);
            req.getRequestDispatcher("assessments.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO
        }
    }

    // TODO remove
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        doPost(req, resp);
    }
}
