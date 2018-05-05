package ge.mziuri.dao.post;

import ge.mziuri.model.blog.Post;

import java.sql.Connection;
import java.util.List;

public interface PostDAO {

    void addPost(Post post, Connection con) throws Exception;

    void editPost(Post post, Connection con) throws Exception;

    List<Post> getAllPost(Connection con) throws Exception;
}
