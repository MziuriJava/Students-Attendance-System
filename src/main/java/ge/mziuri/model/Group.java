package ge.mziuri.model;

import java.sql.Date;

public class Group {

    /*1.ID
    2.name
    3.course_id
    4.staff_id
    5.startdate*/

    private int id;

    private String groupName;

    private Date startDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
