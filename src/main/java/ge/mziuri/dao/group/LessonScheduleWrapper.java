package ge.mziuri.dao.group;

import ge.mziuri.model.group.LessonSchedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class LessonScheduleWrapper {

    private List<LessonSchedule> lessonSchedules;

    @XmlElement
    public List<LessonSchedule> getLessonSchedules() {
        return lessonSchedules;
    }

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        this.lessonSchedules = lessonSchedules;
    }
}
