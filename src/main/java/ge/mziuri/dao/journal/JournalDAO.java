package ge.mziuri.dao.journal;

import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.journal.Label;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface JournalDAO {

    void addLabel(Label label, Connection con) throws Exception;

    void editLabel(Label label, Connection con) throws Exception;

    List<Label> getLabelsByCourseAndDate(Course course, Date date, Connection con) throws Exception;

    public Assessment searchInJournal (java.util.Date startDate, java.util.Date endDate, int groupID, int staffID, int studentID, Connection connection)throws Exception;
}
