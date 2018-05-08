package ge.mziuri.dao.blog;

import ge.mziuri.dao.comment.CommentDAO;
import ge.mziuri.dao.comment.CommentDAOImpl;
import ge.mziuri.dao.post.PostDAO;
import ge.mziuri.dao.post.PostDAOImpl;
import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.model.blog.Comment;
import ge.mziuri.model.blog.Post;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.TestDataBaseConnector;
import ge.mziuri.util.db.DataBaseConnector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogTest {

    private CommentDAO commentDAO;

    private PostDAO postDAO;

    private StaffDAO staffDAO;

    @Before
    public void setUp() {
        commentDAO = new CommentDAOImpl();
        postDAO = new PostDAOImpl();
        staffDAO = new StaffDAOImpl();
    }

    @Test
    public void testBlogDao() throws Exception {
        List<Post> posts=new ArrayList<>();
        Connection connection = TestDataBaseConnector.getConnection();
        posts.add(makeMockPost1());
        posts.add(makeMockPost2());
        for (Post post : posts) {
            postDAO.addPost(post, connection);
            for (Comment comment : post.getComments()) {
                commentDAO.addComment(comment, connection);
            }
        }
        List<Post> postList=postDAO.getAllPost(connection);
        Assert.assertEquals(posts.size(), postList.size());
        for (int i = 0; i < posts.size(); i++){
            Post post=posts.get(i);
            Post postl=postList.get(i);

            Assert.assertEquals(post.getAuthor(), postl.getAuthor());
            Assert.assertEquals(post.getComments().size(), postl.getComments().size());
            for (int j = 0; j < post.getComments().size(); j++) {
                Comment comment=post.getComments().get(j);
                Comment commentl=postl.getComments().get(j);

                Assert.assertEquals(comment.getAuthor(), commentl.getAuthor());
                Assert.assertEquals(comment.getComment(), commentl.getComment());
                Assert.assertEquals(comment.getDate(), commentl.getComment());
                Assert.assertEquals(comment.getPostId(), commentl.getPostId());
            }

            Assert.assertEquals(post.getDate(), postl.getDate());
            Assert.assertEquals(post.getPost(), postl.getPost());
        }

    }

    private Post makeMockPost1() throws Exception {
        Post post=new Post();

        List<Comment>comments=new ArrayList<>();
        Comment comment1=makeMockComment1();
        Comment comment2=makeMockComment2();
        comments.add(comment1);
        comments.add(comment2);

        post.setPost("posting test1");
        post.setAuthor(makeMockStaff1());
        post.setDate(new Date(2003, 10, 28));
        post.setComments(comments);
        return post;
    }

    private Post makeMockPost2() throws Exception {
        Post post=new Post();

        List<Comment>comments=new ArrayList<>();
        Comment comment3=makeMockComment3();
        comments.add(comment3);

        post.setPost("posting test2");
        post.setAuthor(makeMockStaff3());
        post.setDate(new Date(2017, 9, 17));
        post.setComments(comments);
        return post;
    }

    private Staff makeMockStaff1() throws Exception {
        Staff staff = new Staff();
        Connection connection = TestDataBaseConnector.getConnection();
        staff.setFirstname("vinme1");
        staff.setLastname("vinmedze1");
        staff.setMainPhoneNumber("555551");
        staff.setAdditionalPhoneNumber("5555555551");
        staff.setEmail(":)@:)1@mail.com");
        staff.setPassword(":):):)1");
        staff.setStaffStatus(StaffStatus.TEACHER);
        try {
            staffDAO.addStaff(staff,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        staff.setId(1);
        return staff;
    }

    private Staff makeMockStaff2() throws Exception {
        Staff staff = new Staff();
        Connection connection = TestDataBaseConnector.getConnection();
        staff.setFirstname("vinme2");
        staff.setLastname("vinmedze2");
        staff.setMainPhoneNumber("555552");
        staff.setAdditionalPhoneNumber("5555555552");
        staff.setEmail(":)@:)2@mail.com");
        staff.setPassword(":):):)2");
        staff.setStaffStatus(StaffStatus.TEACHER);
        try {
            staffDAO.addStaff(staff,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        staff.setId(2);
        return staff;
    }


    private Comment makeMockComment1() throws Exception {
        Comment comment=new Comment();
        comment.setAuthor(makeMockStaff2());
        comment.setComment("testing comment1");
        comment.setDate(new Date(2018,12,12));
        comment.setPostId(makeMockPost1().getId());
        return comment;
    }

    private Comment makeMockComment2() throws Exception {
        Comment comment=new Comment();
        comment.setAuthor(makeMockStaff1());
        comment.setComment("testing comment2");
        comment.setDate(new Date(2017,11,22));
        comment.setPostId(makeMockPost1().getId());
        return comment;
    }

    private Staff makeMockStaff3() throws Exception {
        Connection connection = TestDataBaseConnector.getConnection();
        Staff staff = new Staff();
        staff.setFirstname("vinme3");
        staff.setLastname("vinmedze3");
        staff.setMainPhoneNumber("555553");
        staff.setAdditionalPhoneNumber("5555555553");
        staff.setEmail(":)@:)3@mail.com");
        staff.setPassword(":):):)3");
        staff.setStaffStatus(StaffStatus.TEACHER);
        try {
            staffDAO.addStaff(staff,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        staff.setId(3);
        return staff;
    }

    private Comment makeMockComment3() throws Exception {
        Comment comment=new Comment();
        comment.setAuthor(makeMockStaff3());
        comment.setComment("testing comment3");
        comment.setDate(new Date(2011,2,1));
        comment.setPostId(makeMockPost2().getId());
        return comment;
    }

    @After
    public void cleanUp1() throws Exception {
        Connection connection = TestDataBaseConnector.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM post");
        pstm.executeUpdate();
        pstm.close();
    }

    @After
    public void cleanUp2() throws Exception {
        Connection connection = TestDataBaseConnector.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM comment");
        pstm.executeUpdate();
        pstm.close();
    }
}
