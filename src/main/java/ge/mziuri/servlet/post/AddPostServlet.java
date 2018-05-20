package ge.mziuri.servlet.post;

import ge.mziuri.dao.post.PostDAO;
import ge.mziuri.dao.post.PostDAOImpl;
import ge.mziuri.model.blog.Post;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.util.db.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AddPostServlet extends HttpServlet {

    private PostDAO postDAO = new PostDAOImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String postText = req.getParameter("post");
            Post post = new Post();
            post.setPost(postText);
            post.setComments(new ArrayList<>());
            post.setDate(new Date());
            Staff author = new Staff();
            HttpSession session = req.getSession();
            author.setId(((Staff) session.getAttribute("staff")).getId());
            post.setAuthor(author);
            postDAO.addPost(post, DataBaseConnector.getConnection());
        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
