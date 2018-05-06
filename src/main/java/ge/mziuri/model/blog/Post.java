package ge.mziuri.model.blog;

import ge.mziuri.model.user.staff.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private int id;

    private String post;

    private Staff author;

    private Date date;

    private List<Comment> comments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Staff getAuthor() {
        return author;
    }

    public void setAuthor(Staff author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
