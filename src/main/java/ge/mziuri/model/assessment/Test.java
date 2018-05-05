package ge.mziuri.model.assessment;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Test {

    private Date date;

    private int score;

    @XmlElement
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlElement
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
