package ge.mziuri.model.user.staff;

import ge.mziuri.model.user.User;

public class Staff extends User {

    private String mainPhoneNumber;

    private String additionalPhoneNumber;

    private StaffStatus staffStatus;

    public String getMainPhoneNumber() {
        return mainPhoneNumber;
    }

    public void setMainPhoneNumber(String mainPhoneNumber) {
        this.mainPhoneNumber = mainPhoneNumber;
    }

    public String getAdditionalPhoneNumber() {
        return additionalPhoneNumber;
    }

    public void setAdditionalPhoneNumber(String additionalPhoneNumber) {
        this.additionalPhoneNumber = additionalPhoneNumber;
    }

    public StaffStatus getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(StaffStatus staffStatus) {
        this.staffStatus = staffStatus;
    }
}
