package coursework;

/**
 * This is child Class coursework.Tutor that inherits coursework.Teacher
 * and stores the details of coursework.Tutor.
 *
 * @author (Sahil Dahal)
 *
 */

public class Tutor extends Teacher{
    //    Attributes of coursework.Tutor.
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    //Constructor of coursework.Tutor Class.
    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus, int workingHours, double salary, String specialization, String academicQualification, int performanceIndex) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        super.setWorkingHours(workingHours);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualification = academicQualification;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
    }
    //    Getter Methods for all the attributes of the coursework.Tutor Class.
    public double getSalary() {
        return this.salary;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public String getAcademicQualification() {
        return this.academicQualification;
    }

    public int getPerformanceIndex() {
        return this.performanceIndex;
    }

    public boolean getIsCertified() {
        return this.isCertified;
    }
    //    Setter Method for the Salary.
    public void setSalary(double newSalary, int newPerformanceIndex) {
        this.performanceIndex = newPerformanceIndex;

        if(newPerformanceIndex >5 && this.getWorkingHours()>20){
            double appraisalPercent = 0.0;
            if(newPerformanceIndex >=5 && newPerformanceIndex <=7){
                appraisalPercent = 0.05;
            }else if(newPerformanceIndex >=8 && newPerformanceIndex <=9) {
                appraisalPercent = 0.10;
            }else if(newPerformanceIndex == 10) {
                appraisalPercent = 0.20;
            }
            newSalary += (newSalary * appraisalPercent);
            this.salary = newSalary;
            this.isCertified = true;
        }else{
            System.out.println("The Salary cannot be approved.");
        }

    }
    public void removeTutor(){
        // Checks if the coursework.Tutor is certified, if the tutor is not certified, it will remove the tutor details.
        if(!isCertified) {
            this.salary = 0;
            this.specialization = "";
            this.academicQualification = "";
            this.performanceIndex = 0;
            this.isCertified = false;
        }
    }
    //    Method to display the details of the coursework.Tutor. It overrides the method displayDetails() of parent class coursework.Teacher.
    @Override
    public void displayDetails(){
        // This method prints the extra details such as salary, specialization,academic qualification, performance index, isCertified or not only if the tutor is certified else
        if(!isCertified){
            super.displayDetails();
        }else{
            super.displayDetails();
            System.out.println("Salary: " + this.salary);
            System.out.println("Specialization: " + this.specialization);
            System.out.println("Academic Qualification: " + this.academicQualification);
            System.out.println("Performance Index: " + this.performanceIndex);
        }

    }

}
