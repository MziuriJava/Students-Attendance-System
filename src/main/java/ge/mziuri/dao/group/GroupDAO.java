package ge.mziuri.dao.group;

import ge.mziuri.model.assessment.Test;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.group.LessonSchedule;

import java.sql.Connection;
import java.util.List;

public interface GroupDAO {

    void addGroup(Group group, Connection con) throws Exception;

    void deleteGroup(Group group, Connection con) throws Exception;

    void editGroup(Group group, Connection con) throws Exception;

    String marshallSchedule(List<LessonSchedule> lessonSchedules);

    public List<LessonSchedule> unmarshallSchedule(String text);
}
