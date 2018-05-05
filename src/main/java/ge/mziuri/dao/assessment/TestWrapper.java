package ge.mziuri.dao.assessment;

import ge.mziuri.model.assessment.Test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class TestWrapper {

    private List <Test> tests = new ArrayList<>();

    @XmlElement
    public List <Test> getTests() {return tests;}

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
