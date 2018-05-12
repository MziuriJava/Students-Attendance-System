package ge.mziuri.manager;

import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.assessment.Attendance;
import ge.mziuri.model.assessment.Test;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessmentManager {

    public void createAssessment(int staff_id, int student_id, int group_id, String name, String description, Date startDate, Date endDate, Connection connection) throws Exception{

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
        Assessment assessment1 = searchForAttendance(startDate,endDate,group_id,staff_id,student_id,connection);
    }

    public Assessment searchForAttendance(Date startDate, Date endDate, int groupID, int staffID, int studentID, Connection connection)throws Exception{
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM journal WHERE date >= ? and date <= ? and group_id =? and staff_id=? and student_id=?  ");
        pstm.setDate(1, new java.sql.Date(startDate.getTime()));
        pstm.setDate(2, new java.sql.Date(endDate.getTime()));
        pstm.setInt(3,groupID);
        pstm.setInt(4,staffID);
        pstm.setInt(5,studentID);

        ResultSet rs=pstm.executeQuery();
        List<Test> tests = new ArrayList<>();
        int attendedlessons=0;
        int missedlessons=0;
        int totalLessonScore=0,lessonMarkCounter=0;
        int totalHomeworkScore=0,homeworkMarkCounter=0;
        while(rs.next()){


            Test test = new Test();
            boolean attend=rs.getBoolean("attendance");
            int less=rs.getInt("lesson_mark");
            int home=rs.getInt("homework_mark");
            int test1=rs.getInt("test_mark");
            if(attend ) attendedlessons++; else missedlessons++;
            if(less>0 ) { totalLessonScore+=less; lessonMarkCounter++;}
            if(home>0 ) {totalHomeworkScore+=home; homeworkMarkCounter++;}
            if(test1>0) {test.setScore(test1); test.setDate(new Date(rs.getDate("date").getTime())); tests.add(test); }


            }



        return null;
    }
}
