package ge.mziuri.dao.comment;

import ge.mziuri.model.blog.comment.Comment;
import ge.mziuri.model.blog.post.Post;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{
    @Override
    public void addComment(Comment comment, Connection con) throws Exception {
        PreparedStatement pstm=con.prepareStatement("INSERT INTO comment(comment , author , date , post_id) VALUES (?,?,?, ?)");
        pstm.setString(1, comment.getComment());
        pstm.setString(2, comment.getAuthor());
        pstm.setDate(3, new Date(comment.getDate().getTime()));
        pstm.setInt(4,comment.getPost().getId());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void editComment(Comment comment, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update comment SET comment=?, author=?, date=?, post_id=? WHERE id=?");
        pstmt.setString(1, comment.getComment());
        pstmt.setString(2, comment.getAuthor());
        pstmt.setDate(3, new Date(comment.getDate().getTime()));
        pstmt.setInt(4,comment.getPost().getId());
        pstmt.setInt(5,comment.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Comment> getAllComment(Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM comment");
        ResultSet rs = pstmt.executeQuery();
        List<Comment> comments = new ArrayList<>();
        while (rs.next()) {
            comments.add(getComment(rs));
        }
        pstmt.close();
        con.close();
        return comments;
    }

    public Comment getComment(ResultSet rs)throws Exception{
        Comment comment=new Comment();
        comment.setId(rs.getInt("id"));
        comment.setComment(rs.getString("comment"));
        comment.setAuthor(rs.getString("author"));
        comment.setDate(rs.getDate("date"));
        Post post=new Post();
        post.setId(rs.getInt("post_id"));
        comment.setPost(post);
        return comment;
    }
}
