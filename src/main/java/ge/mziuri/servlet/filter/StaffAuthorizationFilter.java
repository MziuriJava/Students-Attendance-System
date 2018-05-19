package ge.mziuri.servlet.filter;


import ge.mziuri.model.user.staff.Staff;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class StaffAuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        try {
            HttpSession session = ((HttpServletRequest) req).getSession();
            Staff staff = (Staff) session.getAttribute("staff");
            if(staff == null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                if (staff.getStaffStatus().toString().equals("ADMIN")) {
                    chain.doFilter(req, resp);
                } else {
                    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ex.printStackTrace();
        }
    }
    @Override
    public void destroy() {

    }
}
