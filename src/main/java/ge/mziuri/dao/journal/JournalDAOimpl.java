package ge.mziuri.dao.journal;

import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.assessment.Attendance;
import ge.mziuri.model.assessment.Test;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.journal.Label;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JournalDAOimpl implements JournalDAO {

    @Override
    public void addLabel(Label label, Connection con) throws Exception {
        try {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO journal (student_id,group_id, date, attendance, lesson_mark, homework_mark, test_mark,staff_id) VALUES(?,?,?,?,?,?,?,?) ");
            pstm.setInt(1, label.getStudent().getId());
            pstm.setInt(2, label.getGroup().getId());
            pstm.setDate(3, new Date(label.getDate().getTime()));
            pstm.setBoolean(4, label.isAttend());
            pstm.setInt(5, label.getLessonMark());
            pstm.setInt(6, label.getHomeworkMark());
            pstm.setInt(7, label.getTestMark());
            pstm.setInt(8,label.getStaff().getId());
            pstm.executeUpdate();
            pstm.close();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            con.close();
        }
    }

    @Override
    public void editLabel(Label label, Connection con) throws Exception {
        PreparedStatement pstm =con.prepareStatement("Update journal SET attendance=?, lesson_mark=?, homework_mark=?, test_mark=? WHERE student_id=? AND group_id=? AND date=? ");
        pstm.setBoolean(1, label.isAttend());
        pstm.setInt(2, label.getLessonMark());
        pstm.setInt(3, label.getHomeworkMark());
        pstm.setInt(4, label.getTestMark());
        pstm.setInt(5, label.getStudent().getId());
        pstm.setInt(6, label.getGroup().getId());
        pstm.setDate(7, new Date(label.getDate().getTime()));
        pstm.executeUpdate();
        pstm.close();
        con.close();

    }

    @Override
    public List<Label> getLabelsByCourseAndDate(Course course, Date date, Connection con) throws Exception {
        return null;
    }

    @Override
    public Assessment searchInJournal(java.util.Date startDate, java.util.Date endDate, int groupID, int staffID, int studentID, Connection connection)throws Exception{
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
            if(test1>0) {test.setScore(test1); test.setDate(new java.util.Date(rs.getDate("date").getTime())); tests.add(test); }


        }
        if(lessonMarkCounter==0){ lessonMarkCounter++;}
        if(homeworkMarkCounter==0){homeworkMarkCounter++;}

        Attendance attendance = new Attendance();
        attendance.setAttendedLessons(attendedlessons);
        attendance.setLessonNumber(attendedlessons+missedlessons);
        Assessment assessment = new Assessment();
        assessment.setAttendance(attendance);
        assessment.setTests(tests);
        assessment.setAvrgHomeworkScore(totalHomeworkScore/homeworkMarkCounter);
        assessment.setAvrgLessonScore(totalLessonScore/lessonMarkCounter);


        return assessment;
    }
}
