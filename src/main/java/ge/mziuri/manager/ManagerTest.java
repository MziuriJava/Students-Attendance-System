package ge.mziuri.manager;

import ge.mziuri.util.db.DataBaseConnector;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManagerTest {
    public static void main(String[] args)throws Exception {
        testCreateAssessment();
    }
    AssessmentManager assessmentManager = new AssessmentManager();

    public static void testCreateAssessment()throws Exception{
        Connection connection = DataBaseConnector.getConnection();
        AssessmentManager assessmentManager = new AssessmentManager();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
       //(sdf.parse("2017.05.20")
        Date startdate = sdf.parse("2017.05.20");
        Date endDate =sdf.parse("2018.12.20");

        assessmentManager.createAssessment(3,1,1,"shefaseba","kargi mowafe",startdate,endDate,connection);
    }
}
