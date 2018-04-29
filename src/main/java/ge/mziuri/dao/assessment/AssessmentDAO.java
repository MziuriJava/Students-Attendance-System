package ge.mziuri.dao.assessment;

import ge.mziuri.model.assessment.Assessment;
import ge.mziuri.model.assessment.Test;


import java.sql.Connection;
import java.util.List;

public interface AssessmentDAO {

    void addAssessment(Assessment assess, Connection con) throws Exception;

    String marshallTests(List<Test> tests) throws Exception;

    List<Test> unmarshallTests(String text) throws Exception;
}
