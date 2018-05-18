package ge.mziuri.manager;

import ge.mziuri.dao.assessment.AssessmentDAO;
import ge.mziuri.dao.assessment.AssessmentDAOImpl;
import ge.mziuri.dao.journal.JournalDAO;
import ge.mziuri.dao.journal.JournalDAOimpl;
import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.assessment.Attendance;
import ge.mziuri.model.assessment.Test;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessmentManager {

    public void createAssessment(int staff_id, int student_id, int group_id, String name, String description, Date startDate, Date endDate, Connection connection) throws Exception{

        JournalDAO journalDAO = new JournalDAOimpl();

        Assessment assessment = new Assessment();
        Staff staff = new Staff();
        Student student = new Student();
        Group group = new Group();
        staff.setId(staff_id);
        student.setId(student_id);
        group.setId(group_id);
        assessment.setStaff(staff);
        assessment.setStudent(student);
        assessment.setGroup(group);
        assessment.setName(name);
        assessment.setDescription(description);
        assessment.setStartDate(startDate);
        assessment.setEndDate(endDate);
        Assessment assessment1 = journalDAO.searchInJournal(startDate,endDate,group_id,staff_id,student_id,connection);
        assessment.setAvrglessonScore(assessment1.getAvrglessonScore());
        assessment.setAvrghomeworkScore(assessment1.getAvrglessonScore());
        assessment.setTests(assessment1.getTests());
        assessment.setAttendance(assessment1.getAttendance());
        AssessmentDAO assessmentDAO = new AssessmentDAOImpl();
        assessmentDAO.addAssessment(assessment,connection);

    }


}
