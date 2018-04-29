package ge.mziuri.dao.comment;

import ge.mziuri.model.blog.comment.Comment;

import java.sql.Connection;
import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment, Connection con) throws Exception;

    void editComment(Comment comment, Connection con) throws Exception;

    List<Comment> getAllComment(Connection con) throws Exception;
}
