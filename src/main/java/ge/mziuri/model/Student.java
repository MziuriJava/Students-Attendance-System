package ge.mziuri.model;

public class Student extends User {

    private String PhoneNumber;

    private String ParentName;

    private String ParentNumber;


    public String getParentNumber() { return ParentNumber; }

    public void setParentNumber(String parentNumber) { ParentNumber = parentNumber; }

    public String getParentName() { return ParentName; }

    public void setParentName(String parentName) { ParentName = parentName; }

    public String getPhoneNumber() { return PhoneNumber; }

    public void setPhoneNumber(String phoneNumber) { PhoneNumber = phoneNumber; }
}

