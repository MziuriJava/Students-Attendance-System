package ge.mziuri.dao.assessment;

import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.assessment.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AssessmentDAOImpl implements AssessmentDAO {

    @Override
    public void addAssessment(Assessment assess, Connection con) throws Exception {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO assessment (staff_id,student_id,group_id,name,start_date,end_date,description,average_lesson_grade,tests,number_of_lessons,attended_lessons,average_homework_grade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        pstm.setInt(1, assess.getStaff().getId());
        pstm.setInt(2, assess.getStudent().getId());
        pstm.setInt(3, assess.getGroup().getId());
        pstm.setString(4, assess.getName());
        pstm.setDate(5, new java.sql.Date(assess.getStartDate().getTime()));
        pstm.setDate(6, new java.sql.Date(assess.getEndDate().getTime()));
        pstm.setString(7, assess.getDescription());
        pstm.setInt(8, assess.getAvrglessonScore());
        pstm.setString(9, marshallTests(assess.getTests()));
        pstm.setInt(10, assess.getAttendance().getLessonNumber());
        pstm.setInt(11, assess.getAttendance().getAttendedLessons());
        pstm.setInt(12,assess.getAvrghomeworkScore());
        pstm.executeUpdate();
        pstm.close();
        con.close();
    }

    @Override
    public String marshallTests(List<Test> tests) {
        String result=null;
        try {
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(TestWrapper.class);
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //setting the values in POJO class
//            Test test = new Test();
//            test.setDate(new Date());
//            test.setScore(10);
//            List<Test> tests = new ArrayList<>();

            TestWrapper testWrapper = new TestWrapper();
            testWrapper.setTests(tests);
            //calling the marshall method
            StringWriter sw = new StringWriter();
            marshallObj.marshal(testWrapper, sw);

            result = sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public List<Test> unmarshallTests(String text) {
        List<Test> tests= new ArrayList<>();
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(TestWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(text);
            TestWrapper testWrapper = (TestWrapper) unmarshaller.unmarshal(reader);
            tests=testWrapper.getTests();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tests;
    }
}
