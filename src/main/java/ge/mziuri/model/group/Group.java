package ge.mziuri.model.group;

import ge.mziuri.model.course.Course;
import ge.mziuri.model.user.staff.Staff;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private int id;

    private String groupName;

    private Date startDate;

    private Course course;

    private Staff staff;

    private List<LessonSchedule> lessonSchedules = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<LessonSchedule> getLessonSchedules() {
        return lessonSchedules;
    }

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        this.lessonSchedules = lessonSchedules;
    }
}
