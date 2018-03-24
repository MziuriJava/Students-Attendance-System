package ge.mziuri.model;

public class Course {

    private String courseName;

    private CourseStatus courseStatus;

    private int courseLength;

    private int courseLessonTime;

    private int lessonsPerWeek;

    private String Description;

    private Staff founder;

    private int price;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    public int getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(int courseLength) {
        this.courseLength = courseLength;
    }

    public int getCourseLessonTime() {
        return courseLessonTime;
    }

    public void setCourseLessonTime(int courseLessonTime) {
        this.courseLessonTime = courseLessonTime;
    }

    public int getLessonsPerWeek() {
        return lessonsPerWeek;
    }

    public void setLessonsPerWeek(int lessonsPerWeek) {
        this.lessonsPerWeek = lessonsPerWeek;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Staff getFounder() {
        return founder;
    }

    public void setFounder(Staff founder) {
        this.founder = founder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
