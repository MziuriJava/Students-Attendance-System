package ge.mziuri.model.group;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class LessonSchedule {

    private WeekDay weekDay;

    private Date startTime;

    private String room;

    @XmlElement
    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    @XmlElement
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @XmlElement
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
