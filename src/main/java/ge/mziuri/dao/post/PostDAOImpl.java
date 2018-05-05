package ge.mziuri.dao.post;

import ge.mziuri.model.blog.Post;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {

    @Override
    public void addPost(Post post, Connection con) throws Exception {
        PreparedStatement pstm=con.prepareStatement("INSERT INTO post(post, author, date) VALUES (?,?,?)");
        pstm.setString(1, post.getPost());
        pstm.setString(2, post.getAuthor());
        pstm.setDate(3, new Date(post.getDate().getTime()));
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void editPost(Post post, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update post SET post=?, author=?, date=? WHERE id=?");
        pstmt.setString(1, post.getPost());
        pstmt.setString(2, post.getAuthor());
        pstmt.setDate(3, new Date(post.getDate().getTime()));
        pstmt.setInt(4, post.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Post> getAllPost(Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM post");
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = new ArrayList<>();
        while (rs.next()) {
            posts.add(getPost(rs));
        }
        pstmt.close();
        con.close();
        return posts;
    }

    private Post getPost(ResultSet rs)throws Exception{
        Post post=new Post();
        post.setId(rs.getInt("id"));
        post.setPost(rs.getString("post"));
        post.setAuthor(rs.getString("author"));
        post.setDate(rs.getDate("date"));
        return post;
    }
}
