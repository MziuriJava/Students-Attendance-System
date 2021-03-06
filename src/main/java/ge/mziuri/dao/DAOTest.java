package ge.mziuri.dao;

import ge.mziuri.dao.assessment.AssessmentDAO;
import ge.mziuri.dao.assessment.AssessmentDAOImpl;
import ge.mziuri.dao.course.CourseDAO;
import ge.mziuri.dao.course.CourseDAOImpl;
import ge.mziuri.dao.group.GroupDAO;
import ge.mziuri.dao.group.GroupDAOImpl;
import ge.mziuri.dao.journal.JournalDAO;
import ge.mziuri.dao.journal.JournalDAOimpl;
import ge.mziuri.dao.staff.StaffDAO;
import ge.mziuri.dao.staff.StaffDAOImpl;
import ge.mziuri.dao.student.StudentDAO;
import ge.mziuri.dao.student.StudentDaoImpl;
import ge.mziuri.dao.student_group_relation.StudentGroupDAO;
import ge.mziuri.dao.student_group_relation.StudentGroupDAOimpl;
import ge.mziuri.model.assessment.Test;
import ge.mziuri.model.course.Course;
import ge.mziuri.model.course.CourseStatus;
import ge.mziuri.model.group.Group;
import ge.mziuri.model.group.LessonSchedule;
import ge.mziuri.model.group.WeekDay;
import ge.mziuri.model.journal.Label;
import ge.mziuri.model.user.staff.Staff;
import ge.mziuri.model.user.staff.StaffStatus;
import ge.mziuri.model.user.student.Student;
import ge.mziuri.util.db.DataBaseConnector;
import ge.mziuri.util.encode.TextEncoder;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DAOTest {

public static void main(String[]args)throws Exception{
    //TestAddStaff();
    //TestGetallstaff();
    //TestEditstaff();
    //TestDeleteStaff();
    //TestAddCourse();
    //TestEditCourse();
    //TestGetCourses();
    TestAddStudent();
    //TestAddLabel();
    //TestSearchStudents();
    //Testunmarshller();
    //TestEditGroup();
    TestAddRelation();
        }
    private static StudentDAO studentDao = new StudentDaoImpl();
    private static StaffDAO staffDAO = new StaffDAOImpl();
    private static CourseDAO courseDAO = new CourseDAOImpl();
    private static JournalDAO journalDAO = new JournalDAOimpl();
    private static AssessmentDAO assessmentDAO = new AssessmentDAOImpl();
    private static GroupDAO groupDAO = new GroupDAOImpl();
    private static StudentGroupDAO sgd = new StudentGroupDAOimpl();
    public static void   TestAddStaff() throws Exception{
        try {
        Scanner scanner = new Scanner(System.in);
        Staff staff = new Staff();
        staff.setFirstname(scanner.nextLine());
        staff.setLastname(scanner.nextLine());
        staff.setEmail(scanner.nextLine());
        staff.setMainPhoneNumber(scanner.nextLine());
        staff.setAdditionalPhoneNumber(scanner.nextLine());
        staff.setPassword(TextEncoder.textEncode("rame"));
        staff.setStaffStatus(StaffStatus.ADMIN);
        Connection con = DataBaseConnector.getConnection();
        staffDAO.addStaff(staff, con);
        con.close();
    } catch (Exception ex){
        ex.printStackTrace();
    }}
    public static void TestGetallstaff() throws Exception{
        try {
        List <Staff> staffs = new ArrayList<>();
        Connection con = DataBaseConnector.getConnection();
        staffs=staffDAO.searchStaff(null,null,null,null,null, con);
        for(int i = 0; i < staffs.size() ; i ++){
            System.out.println(staffs.get(i).getFirstname());
        }
        con.close();

    }catch (Exception ex){
        ex.printStackTrace();
    }
    }
    public static void TestEditstaff() throws Exception{
        try{
        Staff staff = new Staff();
        staff.setFirstname("xXx");
        staff.setLastname("xXx");
        staff.setMainPhoneNumber("xXx");
        staff.setStaffStatus(StaffStatus.TEACHER);
        staff.setAdditionalPhoneNumber("xXx");
        staff.setEmail("xXx");
        staff.setId(2);
        Connection con = DataBaseConnector.getConnection();
        staffDAO.editStaff(staff,con);
        con.close();
    }catch (Exception ex){
        ex.printStackTrace();
    }
    }
    public static void TestDeleteStaff() throws Exception {
        try {
            Staff staff = new Staff();
            staff.setId(2);
            Connection con = DataBaseConnector.getConnection();
            staffDAO.deleteStaff(staff, con);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void TestLoginStaff() throws Exception {
        try{
            Staff staff = new Staff();
            staff.setPassword("esdf");
            staff.setEmail("alex");



    }
    catch (Exception ex){
        ex.printStackTrace();
    }
    }

    public static void TestAddCourse() throws  Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DataBaseConnector.getConnection();
        Course course = new Course();
        course.setCourseName(sc.nextLine());
        course.setCourseStatus(CourseStatus.DEACTIVATED);
        Staff staff = new Staff();
        staff.setId(1);
        course.setFounder(staff);
        courseDAO.addCourse(course,con);
    }
    public static void TestEditCourse() throws Exception{
        Connection con = DataBaseConnector.getConnection();
        Course course = new Course();
        course.setCourseName("JAVA");
        course.setId(1);
        course.setCourseStatus(CourseStatus.DEACTIVATED);
        Staff staff = new Staff();
        staff.setId(1);
        course.setFounder(staff);
        courseDAO.editCourse(course,con);
    }
    public static void TestGetCourses() throws Exception{
        Connection con = DataBaseConnector.getConnection();
        List <Course> course;
        course=courseDAO.getAllCourse(con);
        for(int i=0;i<course.size();i++){
            System.out.println(course.get(i).getId());
        }
    }
    public static void TestAddStudent() throws Exception{
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        student.setFirstname(sc.nextLine());
        student.setLastname(sc.nextLine());
        student.setEmail(sc.nextLine());
        student.setPersonalId("10101013");
        student.setSchool("komarovi");
        student.setPassword(TextEncoder.textEncode("rame"));
        student.setPhoneNumber("579460707");
        student.setParentName("alex");
        student.setBirthDate(new Date());
        student.setParentNumber("555555555");
        Group group = new Group();
        group.setId(1);
        List<Group> groups = new ArrayList<>();
        student.setGroups(groups);
        studentDao.addStudent(student, DataBaseConnector.getConnection());
    }
    public static void TestAddLabel() throws Exception{
        Student student = new Student();
        student.setId(1);
        Group group = new Group();
        group.setId(1);
        Staff staff = new Staff();
        staff.setId(3);
        Label label = new Label();
        label.setStaff(staff);
        label.setAttend(false);
        label.setStudent(student);
        label.setGroup(group);
        label.setDate(new Date());
        label.setTestMark(10);
        label.setHomeworkMark(2);
        label.setLessonMark(2);
        Connection con = DataBaseConnector.getConnection();
        journalDAO.addLabel(label,con);
    }

    public static void TestSearchStudents() throws Exception{
        List<Student> students=new ArrayList<>();
        Connection con = DataBaseConnector.getConnection();
        students=studentDao.searchStudent("lekso","bora","lekso","komarovi",con);
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).getFirstname());
        }
    }
    public static void Testunmarshller() throws Exception{

        List <Test> tests = new ArrayList<>();
        String marshall="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<testWrapper>\n" +
                "    <tests>\n" +
                "        <date>2018-05-05T16:22:57.459+04:00</date>\n" +
                "        <score>10</score>\n" +
                "    </tests>\n" +
                "    <tests>\n" +
                "        <date>2018-05-05T16:22:57.460+04:00</date>\n" +
                "        <score>9</score>\n" +
                "    </tests>\n" +
                "</testWrapper>";
        tests=assessmentDAO.unmarshallTests(marshall);
        System.out.println(tests.get(0).getDate()+" "+tests.get(0).getScore());


    }
    public static void TestEditGroup() throws Exception{
        Group group = new Group();
        group.setId(1);
        group.setGroupName("MAIN_GROUP");
        Course course = new Course();
        course.setId(1);
        group.setCourse(course);
        Staff staff = new Staff();
        staff.setId(3);
        group.setStaff(staff);
        LessonSchedule lessonSchedule = new LessonSchedule();
        lessonSchedule.setRoom("1");
        lessonSchedule.setWeekDay(WeekDay.MONDAY);
        lessonSchedule.setStartTime(new Date());
        List <LessonSchedule> lessonSchedules = new ArrayList<>();
        lessonSchedules.add(lessonSchedule);
        group.setLessonSchedules(lessonSchedules);
        Connection con = DataBaseConnector.getConnection();
        groupDAO.editGroup(group,con);
    }

    public static void TestAddRelation() throws Exception{
        Connection con = DataBaseConnector.getConnection();
        sgd.addRelation(1,1,con);
        //sgd.deleteRelation(1,con);
    }
}

