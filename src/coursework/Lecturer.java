package coursework;

/**
 * This is child Class coursework.Lecturer that inherits coursework.Teacher
 * and stores the details of coursework.Lecturer.
 *
 * @author (Sahil Dahal)
 *
 */

public class Lecturer extends Teacher{
    //  Attributes of coursework.Lecturer class.
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    //    Constructor of coursework.Lecturer Class to initialize instance variables/ attributes;
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String department, String employmentStatus,int yearsOfExperience, int workingHours) {
//        Calling the constructor of the coursework.Teacher Class using the super keyword.
        super(teacherId, teacherName,address, workingType, employmentStatus);
// calling setWorkingHours method of the coursework.Teacher Class using the super keyword.
        super.setWorkingHours(workingHours);
//        Initializing the gradedScore to 0;
        this.gradedScore = 0;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
//        Initializing the hasGraded  to false.
        this.hasGraded = false;

    }
    //    Getter Methods for all the attributes of the coursework.Lecturer Class.
    public String getDepartment() {
        return this.department;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public int getGradedScore() {
        return this.gradedScore;
    }

    public boolean getHasGraded() {
        return this.hasGraded;
    }
    //    Mutator Method for the gradedScore.
    public void setGradedScore(int gradedScore) {
        this.gradedScore = gradedScore;
    }
    //    gradeAssignment method to grade the assignment.
    public void gradeAssignment(int gradedScore, String department, int yearsOfExperience){
// checks if department is also relevant to the department with same area of interest, and if the lecturer has more than 5 years of experience.
//        If block executes only if the above conditions are met. otherwise it will execute the else block.
        if(department.equals(this.department) && yearsOfExperience >= 5){
            this.gradedScore = gradedScore;
            if(gradedScore >= 70){
                System.out.println("Grade: A");
            }else if(gradedScore >= 60) {
                System.out.println("Grade: B");
            }else if(gradedScore >= 50) {
                System.out.println("Grade: C");
            } else if(gradedScore >= 40) {
                System.out.println("Grade: D");
            } else if(gradedScore < 40){
                System.out.println("Grade: E");
            }
            this.hasGraded = true;
        }else{
            System.out.println("Lecturer is not eligible to grade the assignment.");
        }


    }
//    Method to display the details of the coursework.Lecturer.
//    Overriding the displayDetails method of the coursework.Teacher Class.

    @Override
    public void displayDetails(){
//        Calling the displayDetails method of the coursework.Teacher Class using the super keyword.
        super.displayDetails();
        System.out.println("Department: " + this.department);
        System.out.println("Years of Experience: " + this.yearsOfExperience);
        System.out.println("Graded Score: " + this.gradedScore);
        if(!this.hasGraded){
            System.out.println("Student has not been Graded");
        }
    }


}
