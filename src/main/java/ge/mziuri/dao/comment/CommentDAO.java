package ge.mziuri.dao.comment;

import ge.mziuri.model.blog.Comment;

import java.sql.Connection;
import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment, Connection con) throws Exception;

    void editComment(Comment comment, Connection con) throws Exception;

    List<Comment> getAllComment(int postId,Connection con) throws Exception;
}
