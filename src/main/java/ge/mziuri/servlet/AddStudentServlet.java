package ge.mziuri.servlet;

import ge.mziuri.dao.student.StudentDao;
import ge.mziuri.dao.student.StudentDaoimpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet{

    private StudentDao studentDao = new StudentDaoimpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StudentName = req.getParameter("StudentName");
        String StudentSurname = req.getParameter("StudentSurname");
        String StudentEmail = req.getParameter("StudentEmail");

        req.setAttribute("failedAuth", "false");
        resp.sendRedirect("index.jsp");
    }


}
