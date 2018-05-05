package ge.mziuri.dao.journal;

import ge.mziuri.model.course.Course;
import ge.mziuri.model.journal.Label;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class JournalDAOimpl implements JournalDAO {

    @Override
    public void addLabel(Label label, Connection con) throws Exception {
        try {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO journal (student_id,group_id, date, attendance, lesson_mark, homework_mark, test_mark) VALUES(?,?,?,?,?,?,?) ");
            pstm.setInt(1, label.getStudent().getId());
            pstm.setInt(2, label.getGroup().getId());
            pstm.setDate(3, new Date(label.getDate().getTime()));
            pstm.setBoolean(4, label.isAttend());
            pstm.setInt(5, label.getLessonMark());
            pstm.setInt(6, label.getHomeworkMark());
            pstm.setInt(7, label.getTestMark());
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
}
