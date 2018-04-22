package ge.mziuri.model.journal;

import ge.mziuri.model.group.Group;
import ge.mziuri.model.user.student.Student;

import java.util.Date;

public class Journal {

    private Group group;

    private Student student;

    private Date date;

    private boolean attend;

    private int lessonMark;

    private int homeworkMark;

    private int testMark;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public int getLessonMark() {
        return lessonMark;
    }

    public void setLessonMark(int lessonMark) {
        this.lessonMark = lessonMark;
    }

    public int getHomeworkMark() {
        return homeworkMark;
    }

    public void setHomeworkMark(int homeworkMark) {
        this.homeworkMark = homeworkMark;
    }

    public int getTestMark() {
        return testMark;
    }

    public void setTestMark(int testMark) {
        this.testMark = testMark;
    }
}
