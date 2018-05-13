package ge.mziuri.dao.group;

import ge.mziuri.dao.assessment.TestWrapper;
import ge.mziuri.model.assessment.Test;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.group.LessonSchedule;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class GroupDAOImpl implements GroupDAO {

    @Override
    public void addGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO class_group (groupName , startDate, course_id,) VALUES (?,?,?,?)");
        pstm.setString(1, group.getGroupName());
        pstm.setDate(2, group.getStartDate());
        pstm.setInt(3, group.getCourse().getId());
        pstm.setInt(4, group.getStaff().getId());

        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public void deleteGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("DELETE  FROM class_group where id=?");
        pstmt.setInt(1, group.getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public void editGroup(Group group, Connection con) throws Exception {
        PreparedStatement pstmt = con.prepareStatement("Update class_group SET groupName=?, startDate=?, course_id=?, staff_id=?  WHERE id=?");
        pstmt.setString(1, group.getGroupName());
        pstmt.setDate(2, group.getStartDate());
        pstmt.setInt(3, group.getCourse().getId());
        pstmt.setInt(4, group.getStaff().getId());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }
    @Override
    public String marshallSchedule(List<LessonSchedule> lessonSchedules) {
        String result=null;
        try {
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(LessonScheduleWrapper.class);
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //setting the values in POJO class
//            Test test = new Test();
//            test.setDate(new Date());
//            test.setScore(10);
//            List<Test> tests = new ArrayList<>();

            LessonScheduleWrapper lessonScheduleWrapper = new LessonScheduleWrapper();
            lessonScheduleWrapper.setLessonSchedules(lessonSchedules);
            //calling the marshall method
            StringWriter sw = new StringWriter();
            marshallObj.marshal(lessonScheduleWrapper, sw);

            result = sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public List<LessonSchedule> unmarshallSchedule(String text) {
        List<LessonSchedule> lessonSchedules = new ArrayList<>();
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(LessonScheduleWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(text);
            LessonScheduleWrapper lessonScheduleWrapper = (LessonScheduleWrapper) unmarshaller.unmarshal(reader);
            lessonSchedules = lessonScheduleWrapper.getLessonSchedules();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lessonSchedules;
    }
}
