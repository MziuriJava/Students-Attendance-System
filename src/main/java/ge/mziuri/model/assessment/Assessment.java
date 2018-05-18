package ge.mziuri.model.assessment;

import ge.mziuri.model.group.Group;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.student.Student;

import java.util.Date;
import java.util.List;

public class Assessment {

    private int ID;

    private Staff staff;

    private Student student;

    private Group group;

    private String name;

    private Date startDate;

    private Date endDate;

    private String description;

    private int avrgHomeworkScore;

    private int avrgLessonScore;

    private List<Test> tests;

    private Attendance attendance;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAvrgHomeworkScore() {
        return avrgHomeworkScore;
    }

    public void setAvrgHomeworkScore(int avrgHomeworkScore) {
        this.avrgHomeworkScore = avrgHomeworkScore;
    }

    public int getAvrgLessonScore() {
        return avrgLessonScore;
    }

    public void setAvrgLessonScore(int avrgLessonScore) {
        this.avrgLessonScore = avrgLessonScore;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
