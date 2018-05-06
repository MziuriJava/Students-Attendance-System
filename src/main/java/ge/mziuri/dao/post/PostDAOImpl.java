package ge.mziuri.dao.post;

import ge.mziuri.dao.comment.CommentDAO;
import ge.mziuri.dao.comment.CommentDAOImpl;
import ge.mziuri.model.blog.Post;
import ge.mziuri.model.user.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {

    private CommentDAO commentDAO = new CommentDAOImpl();

    @Override
    public void addPost(Post post, Connection con) throws Exception {
        PreparedStatement pstm=con.prepareStatement("INSERT INTO post(post, author_id, date ) VALUES (?,?,?)");
        pstm.setString(1, post.getPost());
        pstm.setInt(2, post.getAuthor().getId());
        pstm.setDate(3, new Date(post.getDate().getTime()));
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void editPost(Post post, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update post SET post=?, author=?, date=? WHERE id=?");
        pstmt.setString(1, post.getPost());
        pstmt.setInt(2, post.getAuthor().getId());
        pstmt.setDate(3, new Date(post.getDate().getTime()));
        pstmt.setInt(4, post.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Post> getAllPost(Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT post.id, post.post, post.date, staff.firstname, staff.lastname " +
                "FROM post INNER JOIN staff ON post.author_id = staff.id ORDER BY  date DESC ");
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = new ArrayList<>();
        while (rs.next()) {
            Post post=new Post();
            post.setId(rs.getInt("id"));
            post.setPost(rs.getString("post"));
            post.setDate(rs.getDate("date"));
            User user = new User();
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            post.setComments(commentDAO.getAllComment(post.getId(), con));
            posts.add(post);
        }
        pstmt.close();
        con.close();
        return posts;
    }
}
