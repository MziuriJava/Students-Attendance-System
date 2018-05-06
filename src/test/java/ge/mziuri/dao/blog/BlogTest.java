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
import org.junit.Before;
import org.junit.Test;

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
        posts.add(makeMockPost1());
        posts.add(makeMockPost2());
        for (Post post : posts) {
            postDAO.addPost(post, TestDataBaseConnector.getConnection());
            for (Comment comment : post.getComments()) {
                commentDAO.addComment(comment, TestDataBaseConnector.getConnection());
            }
        }
    }

    private Post makeMockPost1(){
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

    private Post makeMockPost2(){
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

    private Staff makeMockStaff1() {
        Staff staff = new Staff();
        staff.setFirstname("vinme1");
        staff.setLastname("vinmedze1");
        staff.setMainPhoneNumber("555551");
        staff.setAdditionalPhoneNumber("5555555551");
        staff.setEmail(":)@:)1@mail.com");
        staff.setPassword(":):):)1");
        staff.setStaffStatus(StaffStatus.TEACHER);
        try {
            staffDAO.addStaff(staff,TestDataBaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        staff.setId(1);
        return staff;
    }

    private Staff makeMockStaff2() {
        Staff staff = new Staff();
        staff.setFirstname("vinme2");
        staff.setLastname("vinmedze2");
        staff.setMainPhoneNumber("555552");
        staff.setAdditionalPhoneNumber("5555555552");
        staff.setEmail(":)@:)2@mail.com");
        staff.setPassword(":):):)2");
        staff.setStaffStatus(StaffStatus.TEACHER);
        return staff;
    }


    private Comment makeMockComment1(){
        Comment comment=new Comment();
        comment.setAuthor(makeMockStaff2());
        comment.setComment("testing comment1");
        comment.setDate(new Date(2018,12,12));
        comment.setPost(makeMockPost1());
        return comment;
    }

    private Comment makeMockComment2(){
        Comment comment=new Comment();
        comment.setAuthor(makeMockStaff1());
        comment.setComment("testing comment2");
        comment.setDate(new Date(2017,11,22));
        comment.setPost(makeMockPost1());
        return comment;
    }

    private Staff makeMockStaff3() {
        Staff staff = new Staff();
        staff.setFirstname("vinme3");
        staff.setLastname("vinmedze3");
        staff.setMainPhoneNumber("555553");
        staff.setAdditionalPhoneNumber("5555555553");
        staff.setEmail(":)@:)3@mail.com");
        staff.setPassword(":):):)3");
        staff.setStaffStatus(StaffStatus.TEACHER);
        return staff;
    }

    private Comment makeMockComment3(){
        Comment comment=new Comment();
        comment.setAuthor(makeMockStaff3());
        comment.setComment("testing comment3");
        comment.setDate(new Date(2011,2,1));
        comment.setPost(makeMockPost2());
        return comment;
    }
}
