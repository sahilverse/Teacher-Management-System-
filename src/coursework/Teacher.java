package coursework;

/**
 * This is Parent Class coursework.Teacher that stores details of coursework.Teacher.
 *
 * @author (Sahil Dahal)
 *
 */

public class Teacher {
    //    Attributes of coursework.Teacher class.
    private int teacherId;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;
    // creating constructor of coursework.Teacher Class to initialize attributes/ instance variables;
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }
    // Getter Methods for all the attributes of the coursework.Teacher Class.
    public int getTeacherId() {
        return this.teacherId;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getWorkingType() {
        return this.workingType;
    }

    public String getEmploymentStatus() {
        return this.employmentStatus;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }
    // Setter Method for the Working Hours.
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    //    Method to display the details of the coursework.Teacher.
    public void displayDetails(){
        System.out.println("Teacher ID: " + this.teacherId);
        System.out.println("Teacher Name: " + this.teacherName);
        System.out.println("Address: " + this.address);
        System.out.println("Working Type: " + this.workingType);
        System.out.println("Employment Status: " + this.employmentStatus);
//        If the working hours is not set, it will display "Not Set".
        if(this.workingHours < 1){
            System.out.println("Teacher Working Hours: " + "Not Set");
        }else{
            System.out.println("Teacher Working Hours: " + this.workingHours);
        }

    }

}
