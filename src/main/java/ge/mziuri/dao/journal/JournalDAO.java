package ge.mziuri.dao.journal;

import ge.mziuri.model.course.Course;
import ge.mziuri.model.journal.Label;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface JournalDAO {

    void addLabel (Label label, Connection con) throws Exception;

    void editLabel (Label label, Connection con) throws Exception;

    List<Label> getLabelbyCourseandDate (Course course, Date date, Connection con) throws Exception;
}
