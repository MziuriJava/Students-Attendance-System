package ge.mziuri.model.user.student;

import ge.mziuri.model.user.User;

import java.util.Date;

public class Student extends User {

    private String phoneNumber;

    private String parentName;

    private String parentNumber;

    private Date birthDate;

    private String school;

    public String getParentNumber() { return parentNumber; }

    public void setParentNumber(String parentNumber) { this.parentNumber = parentNumber; }

    public String getParentName() { return parentName; }

    public void setParentName(String parentName) { this.parentName = parentName; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Date getBirthDate() { return birthDate; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getSchool() { return school;  }

    public void setSchool(String school) { this.school = school; }
}

