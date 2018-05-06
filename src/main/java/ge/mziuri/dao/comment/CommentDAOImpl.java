package ge.mziuri.dao.comment;

import ge.mziuri.model.blog.Comment;
import ge.mziuri.model.blog.Post;
import ge.mziuri.model.user.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{

    @Override
    public void addComment(Comment comment, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO comment(comment , author_id , date , post_id) VALUES (?,?,?,?)");
        pstm.setString(1, comment.getComment());
        pstm.setInt(2, comment.getAuthor().getId());
        pstm.setDate(3, new Date(comment.getDate().getTime()));
        pstm.setInt(4, comment.getPost().getId());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void editComment(Comment comment, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update comment SET comment=?, author_id=?, date=?, post_id=? WHERE id=?");
        pstmt.setString(1, comment.getComment());
        pstmt.setInt(2, comment.getAuthor().getId());
        pstmt.setDate(3, new Date(comment.getDate().getTime()));
        pstmt.setInt(4, comment.getPost().getId());
        pstmt.setInt(5, comment.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Comment> getAllComment(int postId,Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT comment.id, comment.comment, comment.date, staff.firstname, staff.lastname " +
                "FROM comment INNER JOIN staff ON comment.author_id = staff.id WHERE post_id=? ORDER BY  date DESC ");
        pstmt.setInt(1, postId);
        ResultSet rs = pstmt.executeQuery();
        List<Comment> comments = new ArrayList<>();
        while (rs.next()) {
            Comment comment=new Comment();
            comment.setId(rs.getInt("id"));
            comment.setComment(rs.getString("comment"));
            comment.setDate(rs.getDate("date"));
            User user = new User();
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            comment.setAuthor(user);
            comments.add(comment);
        }
        pstmt.close();
        con.close();
        return comments;
    }
}
