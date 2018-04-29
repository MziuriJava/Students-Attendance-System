package ge.mziuri.model.assessment;

public class Attendance {

    private int lessonNumber;

    private int attendedLessons;

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public int getAttendedLessons() {
        return attendedLessons;
    }

    public void setAttendedLessons(int attendedLessons) {
        this.attendedLessons = attendedLessons;
    }
}
