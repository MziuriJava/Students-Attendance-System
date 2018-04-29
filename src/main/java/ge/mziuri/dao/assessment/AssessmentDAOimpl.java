package ge.mziuri.dao.assessment;

import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.assessment.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessmentDAOimpl implements AssessmentDAO {
    @Override
    public void addAssessment(Assessment assess, Connection con) throws Exception {

    }
    @Override
    public String marshallTests(List<Test> tests) {
        String Result=null;
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

            String result = sw.toString();
            Result=result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result;
    }


    @Override
    public List<Test> unmarshallTests(String text) throws Exception {
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
