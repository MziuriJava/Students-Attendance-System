package ge.mziuri.model.course;

import ge.mziuri.model.user.staff.Staff;

public class Course {

    private int id;

    private String courseName;

    private CourseStatus courseStatus;

    private int courseLength;

    private double courseLessonTime;

    private int lessonsPerWeek;

    private String Description;

    private Staff founder;

    private int price;

    private byte[] syllabus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getCourseLessonTime() {
        return courseLessonTime;
    }

    public void setCourseLessonTime(double courseLessonTime) {
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

    public byte[] getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(byte[] syllabus) {
        this.syllabus = syllabus;
    }
}
