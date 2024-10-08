package coursework;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherGUI extends JFrame implements ActionListener {
    // Panel and TextFields for teacher details
    private JPanel panel;
    private JTextField teacherIdField, teacherNameField, addressField, workingTypeField, employmentStatusField,
            workingHoursField;

    // List to store teacher objects
    private ArrayList<Teacher> teacherList = new ArrayList<>();

    // Buttons and ComboBox for GUI functionality
    private JButton addTeacherBtn, clearBtn;
    private JComboBox<String> teacherTypeComboBox;
    private String[] teacherType;

    // Variables to store teacher details
    private int teacherId, workingHours;
    private String teacherName, address, workingType, employmentStatus;

    // Buttons for additional functionality
    private JButton displayDetailsBtn, removeTutorBtn, setSalaryBtn, gradeAssignmentBtn;

    // Colors and Fonts for GUI styling
    private final Color backgroundColor = new Color(18, 30, 48);
    private final Color secondaryColor = new Color(17, 34, 64);
    private final Color btnColor = new Color(84, 211, 184);
    private final Color borderColor = new Color(120, 205, 215);
    private final Font primaryFont = new Font("SansSerif", Font.PLAIN, 15);
    private final Font primaryFontBold = new Font("SansSerif", Font.BOLD, 14);

    // constructor for TeacherGUI
    public TeacherGUI() {
        // setting the size, title, default close operation, location, layout,
        // background color, and visibility of the frame
        setSize(830, 580);
        setTitle("Teacher Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(backgroundColor);
        // creating a label for the form
        createLabel(this, "Teacher Details", 350, 30, 300, 30);

        // creating a panel for teacher details
        panel = createPanel(this, 40, 100, 800, 300, "Teacher Details");
        // Teacher ID field
        createLabel(panel, "Teacher ID: ", 30, 50, 150, 30);
        teacherIdField = createTextField(panel, 150, 50, 190, 30);
        // Teacher Name field
        createLabel(panel, "Teacher Name: ", 400, 50, 150, 30);
        teacherNameField = createTextField(panel, 550, 50, 190, 30);
        // Address field
        createLabel(panel, "Address: ", 30, 110, 150, 30);
        addressField = createTextField(panel, 150, 110, 190, 30);

        // Working Type field
        createLabel(panel, "Working Type: ", 400, 110, 150, 30);
        workingTypeField = createTextField(panel, 550, 110, 190, 30);

        // Employment Status field
        createLabel(panel, "Status: ", 30, 170, 150, 30);
        employmentStatusField = createTextField(panel, 150, 170, 190, 30);

        // Working Hours field
        createLabel(panel, "Working Hours: ", 400, 170, 150, 30);
        workingHoursField = createTextField(panel, 550, 170, 190, 30);

        // Teacher Type field
        createLabel(panel, "Teacher Type: ", 30, 230, 150, 30);
        teacherType = new String[] { "Lecturer", "Tutor" };
        // Teacher Role ComboBox
        teacherTypeComboBox = createComboBox(panel, teacherType, 150, 230, 190, 40);
        // Add Teacher Button
        addTeacherBtn = createButton(panel, "Add Teacher", 400, 230, 140, 40);
        addTeacherBtn.addActionListener(this);

        // Clear Button
        clearBtn = createButton(panel, "Clear", 560, 230, 180, 40);
        clearBtn.addActionListener(this);
        // Display Details Button
        displayDetailsBtn = createButton(this, "Display Details", 610, 450, 180, 40);
        displayDetailsBtn.addActionListener(this);

        // Remove Tutor Button
        removeTutorBtn = createButton(this, "Remove Tutor", 430, 450, 160, 40);
        removeTutorBtn.addActionListener(this);

        // Set Salary Button
        setSalaryBtn = createButton(this, "Set Salary", 250, 450, 160, 40);
        setSalaryBtn.addActionListener(this);

        // Grade Assignment Button
        gradeAssignmentBtn = createButton(this, "Grade Assignment", 50, 450, 180, 40);
        gradeAssignmentBtn.addActionListener(this);
        add(gradeAssignmentBtn);

        setVisible(true);
    }

    // helper methods to create the JPanel
    private JPanel createPanel(Container container, int x, int y, int width, int height, String title) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, width, height);
        panel.setBackground(secondaryColor);
        Border border = BorderFactory.createLineBorder(borderColor, 1);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "   " + title + "  ");
        titledBorder.setTitleColor(Color.LIGHT_GRAY);
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        titledBorder.setTitleFont(new Font("SansSerif", Font.BOLD, 16));
        panel.setBorder(titledBorder);
        container.add(panel);
        return panel;
    }

    // helper methods to create the JComboBox
    private <T> JComboBox<T> createComboBox(Container container, T[] items, int x, int y, int width, int height) {
        JComboBox<T> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, height);
        comboBox.setBackground(secondaryColor);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(primaryFontBold);
        container.add(comboBox);
        return comboBox;
    }

    // helper methods to create the JLabel
    private JLabel createLabel(Container container, String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(Color.WHITE);
        label.setFont(primaryFont);
        container.add(label);
        return label;
    }

    // helper methods to create the JTextField
    private JTextField createTextField(Container container, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBackground(secondaryColor);
        textField.setForeground(Color.WHITE);
        textField.setFont(primaryFontBold);
        container.add(textField);
        return textField;
    }

    // helper methods to create the JButton
    private JButton createButton(Container container, String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(btnColor);
        button.setForeground(secondaryColor);
        button.setFont(primaryFontBold);
        button.setFocusable(false);
        container.add(button);
        return button;
    }

    // helper methods to show the error dialog
    private void showErrorDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // helper methods to show the success dialog
    private void showSuccessDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to check if the teacher ID is valid
    private boolean isValidTeacherId(int teacherId) {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId() == teacherId) {
                return true;
            }
        }
        return false;
    }

    // Method to show the teacher details
    private void showTeacherDetails(Teacher teacher, JPanel panel) {
        // FOR TEACHER ID
        createLabel(panel, "Teacher ID: ", 30, 50, 150, 30);
        createLabel(panel, String.valueOf(teacher.getTeacherId()), 200, 50, 190, 30);
        // FOR TEACHER NAME
        createLabel(panel, "Teacher Name: ", 400, 50, 150, 30);
        createLabel(panel, teacher.getTeacherName(), 550, 50, 190, 30);

        // FOR ADDRESS
        createLabel(panel, "Address: ", 30, 90, 150, 30);
        createLabel(panel, teacher.getAddress(), 200, 90, 190, 30);

        // FOR WORKING TYPE
        createLabel(panel, "Working Type: ", 400, 90, 150, 30);
        createLabel(panel, teacher.getWorkingType(), 550, 90, 190, 30);

        // FOR EMPLOYMENT STATUS
        createLabel(panel, "Status: ", 30, 130, 150, 30);
        createLabel(panel, teacher.getEmploymentStatus(), 200, 130, 190, 30);

        // FOR WORKING HOURS
        createLabel(panel, "Working Hours: ", 400, 130, 150, 30);
        createLabel(panel, String.valueOf(teacher.getWorkingHours()), 550, 130, 190, 30);

        JButton doneBtn = createButton(panel, "Done", 500, 330, 140, 40);

        doneBtn.addActionListener(e -> {
            JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(panel);
            dialog.dispose();
        });
        // checking if the teacher is an instance of Lecturer or Tutor
        if (teacher instanceof Lecturer) {

            addLecturerDetails((Lecturer) teacher, panel);

        } else {
            addTutorDetails((Tutor) teacher, panel);
        }

    }

    // Method to add the lecturer details
    private void addLecturerDetails(Lecturer lecturer, JPanel panel) {
        // FOR DEPARTMENT
        createLabel(panel, "Department: ", 30, 170, 150, 30);
        createLabel(panel, lecturer.getDepartment(), 200, 170, 190, 30);

        // FOR YEARS OF EXPERIENCE
        createLabel(panel, "Years of Experience: ", 400, 170, 150, 30);
        createLabel(panel, String.valueOf(lecturer.getYearsOfExperience()), 550, 170, 190, 30);

        // FOR GRADED SCORE
        createLabel(panel, "Graded Score: ", 30, 210, 150, 30);
        createLabel(panel, String.valueOf(lecturer.getGradedScore()), 200, 210, 190, 30);

        // FOR HAS GRADED
        createLabel(panel, "Has Graded: ", 400, 210, 150, 30);
        createLabel(panel, lecturer.getHasGraded() ? "Yes" : "No", 550, 210, 190, 30);

    }

    // Method to add the tutor details
    private void addTutorDetails(Tutor tutor, JPanel panel) {
        // FOR SALARY
        createLabel(panel, "Salary: ", 30, 170, 150, 30);
        createLabel(panel, String.valueOf(tutor.getSalary()), 200, 170, 190, 30);

        // FOR SPECIALIZATION
        createLabel(panel, "Specialization: ", 400, 170, 150, 30);
        createLabel(panel, tutor.getSpecialization(), 550, 170, 190, 30);

        // FOR ACADEMIC QUALIFICATION
        createLabel(panel, "Academic Qualification: ", 30, 210, 180, 30);
        createLabel(panel, tutor.getAcademicQualification(), 200, 210, 190, 30);

        // FOR PERFORMANCE INDEX
        createLabel(panel, "Performance Index: ", 400, 210, 150, 30);
        createLabel(panel, String.valueOf(tutor.getPerformanceIndex()), 550, 210, 190, 30);
        // FOR CERTIFIED
        createLabel(panel, "Certified: ", 30, 250, 150, 30);
        createLabel(panel, tutor.getIsCertified() ? "Yes" : "No", 200, 250, 190, 30);

    }

    // Method to set the properties of the dialog box
    private void setDialogBoxProperties(JDialog dialog, int width, int height) {
        dialog.setSize(width, height);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(null);
        dialog.setResizable(false);
        dialog.getContentPane().setBackground(backgroundColor);
        dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    // Method to get the teacher by ID
    private Teacher getTeacherByID(int teacherId) {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    // Method to check if the given input is Alphabet or not
    private boolean isAlphabet(String... inputs) {
        for (String input : inputs) {
            // Using regular expression to check if the input contains only alphabets and
            // spaces
            if (!input.matches("[a-zA-Z ]+")) {
                return false;
            }
        }
        return true;
    }

    // Method to handle the action events (button clicks) => overrides
    // actionPerformed method from ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        // if the clear button is clicked, clear all the text fields
        if (e.getSource() == clearBtn) {
            teacherIdField.setText("");
            teacherNameField.setText("");
            addressField.setText("");
            workingTypeField.setText("");
            employmentStatusField.setText("");
            workingHoursField.setText("");
        }
        // if the add teacher button is clicked, add the teacher details to the teacher
        // list
        if (e.getSource() == addTeacherBtn) {
            // if any of the text fields are empty, show an error dialog
            if (teacherIdField.getText().isEmpty() || teacherNameField.getText().isEmpty()
                    || addressField.getText().isEmpty() || workingTypeField.getText().isEmpty()
                    || employmentStatusField.getText().isEmpty() || workingHoursField.getText().isEmpty()) {
                showErrorDialog(this, "Please Fill in All Fields.");
                return;
            }
            // try to parse the teacher ID and working hours, if it fails, show an error
            // dialog
            try {
                teacherId = Integer.parseInt(teacherIdField.getText().trim());
                if (isValidTeacherId(teacherId)) {
                    showErrorDialog(this, "Teacher ID Already Exists.");
                    return;
                }
                workingHours = Integer.parseInt(workingHoursField.getText().trim());
                if (teacherId < 1 || workingHours < 1) {
                    showErrorDialog(this, "Teacher ID and Working Hours must be greater than 0");
                    return;
                }
                teacherName = teacherNameField.getText().trim();
                address = addressField.getText().trim();
                workingType = workingTypeField.getText().trim();
                employmentStatus = employmentStatusField.getText().trim();
                String teacherType = (String) teacherTypeComboBox.getSelectedItem();
                if (!isAlphabet(teacherName, workingType, employmentStatus)) {
                    showErrorDialog(this,
                            "Teacher Name, Working Type, and Employment Status should contain only Alphabets.");
                    return;
                }
                // if the teacher type is lecturer, show the lecturer dialog
                if (teacherType.equals("Lecturer")) {

                    // new LecturerGUI(this);
                    JDialog lecturerDialog = new JDialog(this, "Add Lecturer", true);
                    setDialogBoxProperties(lecturerDialog, 800, 500);

                    // creating a label for the form
                    createLabel(lecturerDialog, "Add Lecturer", 350, 30, 300, 30);
                    // creating a panel for lecturer details
                    JPanel lecturerPanel = createPanel(lecturerDialog, 40, 100, 800, 200, "Lecturer Details");

                    // Department field
                    createLabel(lecturerPanel, "Department: ", 30, 30, 150, 30);
                    JTextField departmentField = createTextField(lecturerPanel, 150, 30, 190, 30);

                    // Years of experience field
                    createLabel(lecturerPanel, "Years of Experience: ", 380, 30, 150, 30);
                    JTextField yearsOfExperienceField = createTextField(lecturerPanel, 540, 30, 190, 30);

                    // Add lecturer button
                    JButton addLecturerBtn = createButton(lecturerPanel, "Add Lecturer", 410, 130, 150, 40);
                    addLecturerBtn.addActionListener(event -> {
                        // if the department field or years of experience field is empty, show an error
                        // dialog
                        if (departmentField.getText().isEmpty() || yearsOfExperienceField.getText().isEmpty()) {
                            showErrorDialog(lecturerDialog, "Please fill in all the fields.");
                            return;
                        }
                        // try to parse the years of experience, if it fails, show an error dialog
                        try {
                            String department = departmentField.getText().trim();
                            int yearsOfExperience = Integer.parseInt(yearsOfExperienceField.getText().trim());
                            if (!isAlphabet(department)) {
                                showErrorDialog(lecturerDialog, "Department should contain only Alphabets.");
                                return;
                            }
                            teacherList.add(new Lecturer(teacherId, teacherName, address, workingType, department,
                                    employmentStatus, yearsOfExperience, workingHours));
                            showSuccessDialog(lecturerDialog, "Lecturer added successfully.");
                            departmentField.setText("");
                            yearsOfExperienceField.setText("");
                            lecturerDialog.dispose();

                        } catch (NumberFormatException ex) {
                            showErrorDialog(lecturerDialog, "Please enter a valid number for years of experience.");
                        }
                    });

                    // Clear button
                    JButton clearBtn = createButton(lecturerPanel, "Clear", 570, 130, 150, 40);
                    clearBtn.addActionListener(event -> {
                        departmentField.setText("");
                        yearsOfExperienceField.setText("");
                    });

                    lecturerDialog.setVisible(true);

                } else {
                    // if the teacher type is tutor, show the tutor dialog
                    JDialog tutorDialog = new JDialog(this, "Add Tutor", true);
                    setDialogBoxProperties(tutorDialog, 800, 500);

                    // creating a label for the form
                    createLabel(tutorDialog, "Add Tutor", 350, 30, 300, 30);
                    // creating a panel for lecturer details
                    JPanel tutorPanel = createPanel(tutorDialog, 40, 100, 800, 200, "Tutor Details");
                    // Qualification field
                    createLabel(tutorPanel, "Qualification: ", 30, 30, 150, 30);
                    JTextField qualificationField = createTextField(tutorPanel, 150, 30, 190, 30);

                    // Specialization field
                    createLabel(tutorPanel, "Specialization: ", 380, 30, 150, 30);
                    JTextField specializationField = createTextField(tutorPanel, 520, 30, 190, 30);
                    // Salary field
                    createLabel(tutorPanel, "Salary: ", 30, 80, 150, 30);
                    JTextField salaryField = createTextField(tutorPanel, 150, 80, 190, 30);

                    // Performance Index field
                    createLabel(tutorPanel, "Performance Index: ", 380, 80, 150, 30);
                    JComboBox<Integer> performanceIndexField = createComboBox(tutorPanel, new Integer[0], 520, 80, 190,
                            30);
                    for (int i = 1; i <= 10; i++) {
                        performanceIndexField.addItem(i);
                    }
                    // Add tutor button
                    JButton addTutorBtn = createButton(tutorPanel, "Add Tutor", 400, 140, 150, 40);
                    addTutorBtn.addActionListener(event -> {
                        if (qualificationField.getText().isEmpty() || specializationField.getText().isEmpty()
                                || salaryField.getText().isEmpty()) {
                            showErrorDialog(tutorDialog, "Please fill all the fields.");
                            return;
                        }
                        // try to parse the salary, if it fails, show an error dialog
                        try {
                            String academicQualification = qualificationField.getText().trim();
                            String specialization = specializationField.getText().trim();
                            double salary = Double.parseDouble(salaryField.getText().trim());
                            int performanceIndex = (int) performanceIndexField.getSelectedItem();

                            if (!isAlphabet(academicQualification, specialization)) {
                                showErrorDialog(tutorDialog,
                                        "Academic Qualification and Specialization should contain only Alphabets.");
                                return;
                            }

                            teacherList.add(new Tutor(teacherId, teacherName, address, workingType, employmentStatus,
                                    workingHours, salary, specialization, academicQualification, performanceIndex));
                            showSuccessDialog(tutorDialog, "Tutor Added Successfully.");
                            qualificationField.setText("");
                            specializationField.setText("");
                            salaryField.setText("");
                            performanceIndexField.setSelectedIndex(1);

                            tutorDialog.dispose();

                        } catch (NumberFormatException ex) {
                            showErrorDialog(tutorDialog, "Please enter a valid number for salary.");
                        }
                    });

                    // Clear button
                    JButton clearBtn = createButton(tutorPanel, "Clear", 570, 140, 150, 40);
                    clearBtn.addActionListener(event -> {
                        qualificationField.setText("");
                        specializationField.setText("");
                        salaryField.setText("");
                        performanceIndexField.setSelectedIndex(0);
                    });

                    tutorDialog.setVisible(true);

                }
            } catch (NumberFormatException ex) {
                showErrorDialog(this, "Please Enter a Valid Number for Teacher ID and Working Hours.");
                return;
            }

        }
        // if the display details button is clicked, display the teacher details
        if (e.getSource() == displayDetailsBtn) {
            // if the teacher list is empty, show an error dialog
            if (teacherList.isEmpty()) {
                showErrorDialog(this, "No Teacher Details to Display.");

            } else {
                // show the dialog box to display the teacher details
                JDialog dialog = new JDialog(this, "Teacher Details", true);
                setDialogBoxProperties(dialog, 600, 300);
                // FOR DISPLAY PANEL
                JPanel displayPanel = createPanel(dialog, 30, 30, 550, 200, "Display Teacher Details");

                // FOR TEACHER ID
                createLabel(displayPanel, "Teacher ID: ", 30, 50, 150, 30);
                JTextField teacherIdField = createTextField(displayPanel, 150, 50, 190, 30);

                // FOR DISPLAY BUTTON
                JButton displayBtn = createButton(displayPanel, "Display", 380, 45, 140, 40);
                displayBtn.addActionListener(event -> {
                    if (teacherIdField.getText().isEmpty()) {
                        showErrorDialog(this, "Please Enter Teacher ID.");
                        return;
                    }
                    // try to parse the teacher ID, if it fails, show an error dialog
                    try {
                        int teacherId = Integer.parseInt(teacherIdField.getText().trim());
                        if (isValidTeacherId(teacherId)) {
                            Teacher teacher = getTeacherByID(teacherId);
                            if (teacher instanceof Lecturer lecturer) {
                                JDialog lecturerDetails = new JDialog(dialog, "Lecturer Details", true);
                                setDialogBoxProperties(lecturerDetails, 800, 500);

                                JPanel lecturerPanel = createPanel(lecturerDetails, 30, 30, 900, 400,
                                        "Lecturer Details");

                                showTeacherDetails(lecturer, lecturerPanel);
                                lecturer.displayDetails();

                                lecturerDetails.setVisible(true);
                            } else {
                                Tutor tutor = (Tutor) teacher;
                                JDialog tutorDetails = new JDialog(dialog, "Tutor Details", true);
                                setDialogBoxProperties(tutorDetails, 800, 500);

                                JPanel tutorPanel = createPanel(tutorDetails, 30, 30, 900, 400, "Tutor Details");

                                showTeacherDetails(tutor, tutorPanel);
                                tutor.displayDetails();

                                tutorDetails.setVisible(true);
                            }

                        } else {
                            showErrorDialog(dialog, "Teacher ID Not Found.");
                        }

                    } catch (NumberFormatException ex) {
                        showErrorDialog(dialog, "Please Enter a Valid Number for Teacher ID.");
                    }
                });

                dialog.setVisible(true);

            }

        }
        // if the remove tutor button is clicked, remove the tutor details
        if (e.getSource() == removeTutorBtn) {
            // if the teacher list is empty, show an error dialog
            if (teacherList.isEmpty()) {
                showErrorDialog(this, "No Teacher Details to Remove.");
            } else {
                // show the dialog box to remove the tutor
                JDialog dialog = new JDialog(this, "Remove Tutor", true);
                setDialogBoxProperties(dialog, 600, 400);

                JPanel removePanel = createPanel(dialog, 30, 30, 550, 200, "Remove Tutor");

                createLabel(removePanel, "Teacher ID: ", 30, 50, 150, 30);
                JTextField teacherIdField = createTextField(removePanel, 150, 50, 190, 30);

                JButton removeBtn = createButton(removePanel, "Remove", 380, 45, 140, 40);
                removeBtn.addActionListener(event -> {
                    if (teacherIdField.getText().isEmpty()) {
                        showErrorDialog(this, "Please Enter Teacher ID.");
                        return;
                    }
                    // try to parse the teacher ID, if it fails, show an error dialog
                    try {
                        int teacherId = Integer.parseInt(teacherIdField.getText().trim());
                        if (isValidTeacherId(teacherId)) {
                            Teacher teacher = getTeacherByID(teacherId);
                            Tutor tutor = (Tutor) teacher;
                            // if the tutor is certified, show an error dialog else remove the tutor
                            if (tutor.getIsCertified()) {
                                showErrorDialog(dialog, "Certified Tutor cannot be removed.");
                                dialog.dispose();
                            } else {
                                tutor.removeTutor();
                                teacherList.remove(teacher);
                                showSuccessDialog(dialog, "Tutor Removed Successfully.");
                                dialog.dispose();
                            }

                        } else {
                            showErrorDialog(dialog, "Teacher ID Not Found.");
                        }
                    } catch (NumberFormatException ex) {
                        showErrorDialog(dialog, "Please Enter a Valid Number for Teacher ID.");
                    }
                });

                dialog.setVisible(true);
            }
        }
        // if the set salary button is clicked, set the salary of the tutor
        if (e.getSource() == setSalaryBtn) {
            if (teacherList.isEmpty()) {
                showErrorDialog(this, "No Teacher Details to Set Salary.");
            } else {
                JDialog dialog = new JDialog(this, "Set Salary", true);
                setDialogBoxProperties(dialog, 480, 400);
                // FOR SALARY PANEL
                JPanel salaryPanel = createPanel(dialog, 30, 30, 600, 250, "Set Salary");
                // FOR TEACHER ID
                createLabel(salaryPanel, "Teacher ID: ", 30, 50, 150, 30);
                JTextField teacherIdField = createTextField(salaryPanel, 190, 50, 190, 30);

                // FOR SALARY
                createLabel(salaryPanel, "Salary: ", 30, 90, 150, 30);
                JTextField salaryField = createTextField(salaryPanel, 190, 90, 190, 30);

                // FOR PERFORMANCE INDEX
                createLabel(salaryPanel, "Performance Index: ", 30, 130, 150, 30);
                JComboBox<Integer> performanceIndexField = createComboBox(salaryPanel, new Integer[0], 190, 130, 190,
                        30);
                for (int i = 1; i <= 10; i++) {
                    performanceIndexField.addItem(i);
                }

                // FOR SET SALARY BUTTON
                JButton setBtn = createButton(salaryPanel, "Set Salary", 190, 180, 190, 40);
                setBtn.addActionListener(event -> {
                    if (teacherIdField.getText().isEmpty() || salaryField.getText().isEmpty()) {
                        showErrorDialog(dialog, "Please Fill in All Fields.");
                        return;
                    }
                    // try to parse the teacher ID and salary, if it fails, show an error dialog
                    try {
                        int teacherId = Integer.parseInt(teacherIdField.getText().trim());
                        if (isValidTeacherId(teacherId)) {
                            Teacher teacher = getTeacherByID(teacherId);
                            if (teacher instanceof Tutor tutor) {
                                double salary = Double.parseDouble(salaryField.getText().trim());
                                int performanceIndex = (int) performanceIndexField.getSelectedItem();
                                int workingHours = tutor.getWorkingHours();
                                if (workingHours < 20) {
                                    showErrorDialog(dialog, "Tutor should work at least 20 hours.");
                                    return;
                                }
                                if (performanceIndex < 5) {
                                    showErrorDialog(dialog, "Tutor should have a performance index of at least 5.");
                                    return;
                                }
                                tutor.setSalary(salary, performanceIndex);
                                showSuccessDialog(dialog,
                                        "Salary Set Successfully.\n New Salary: Rs " + tutor.getSalary() + "\n"
                                                + "New Performance Index: " + tutor.getPerformanceIndex());
                                dialog.dispose();

                            } else {
                                showErrorDialog(dialog, "Teacher should be Tutor.");
                            }
                        } else {
                            showErrorDialog(dialog, "Teacher ID Not Found.");
                        }
                    } catch (NumberFormatException ex) {
                        showErrorDialog(dialog, "Please Enter a Valid Number for Teacher ID and Salary.");
                    }
                });
                dialog.setVisible(true);
            }

        }
        // if the grade assignment button is clicked, grade the assignment
        if (e.getSource() == gradeAssignmentBtn) {
            if (teacherList.isEmpty()) {
                showErrorDialog(this, "No Teacher Details to Grade Assignment.");
            } else {
                JDialog dialog = new JDialog(this, "Grade Assignment", true);
                setDialogBoxProperties(dialog, 480, 400);
                // FOR GRADE PANEL
                JPanel gradePanel = createPanel(dialog, 30, 30, 600, 250, "Grade Assignment");

                // FOR TEACHER ID
                createLabel(gradePanel, "Teacher ID: ", 30, 50, 150, 30);
                JTextField teacherIdField = createTextField(gradePanel, 190, 50, 190, 30);
                // FOR GRADED SCORE
                createLabel(gradePanel, "Graded Score: ", 30, 90, 150, 30);
                JTextField gradedScoreField = createTextField(gradePanel, 190, 90, 190, 30);

                // FOR DEPARTMENT
                createLabel(gradePanel, "Department: ", 30, 130, 150, 30);
                JTextField departmentField = createTextField(gradePanel, 190, 130, 190, 30);

                // FOR GRADE BUTTON
                JButton gradeBtn = createButton(gradePanel, "Grade Assignment", 190, 180, 190, 40);
                gradeBtn.addActionListener(event -> {
                    if (teacherIdField.getText().isEmpty() || gradedScoreField.getText().isEmpty()) {
                        showErrorDialog(dialog, "Please Fill in All Fields.");
                        return;
                    }
                    // try to parse the teacher ID and graded score, if it fails, show an error
                    // dialog
                    try {
                        int teacherId = Integer.parseInt(teacherIdField.getText().trim());
                        // if the teacher ID is not valid, show an error dialog
                        if (isValidTeacherId(teacherId)) {
                            Teacher teacher = getTeacherByID(teacherId);
                            if (teacher instanceof Lecturer lecturer) {
                                int gradedScore = Integer.parseInt(gradedScoreField.getText().trim());
                                String department = departmentField.getText().trim();
                                int yearsOfExperience = lecturer.getYearsOfExperience();
                                // if the department does not match, show an error dialog
                                if (!department.equals(lecturer.getDepartment())) {
                                    showErrorDialog(dialog, "Department does not match.");
                                    return;
                                }
                                if (gradedScore < 0 || gradedScore > 100) {
                                    showErrorDialog(dialog, "Graded Score should be between 0 and 100.");
                                    return;
                                }
                                if (lecturer.getYearsOfExperience() < 5) {
                                    showErrorDialog(dialog, "Lecturer should have a performance index of at least 5.");
                                    return;
                                }
                                lecturer.gradeAssignment(gradedScore, department, yearsOfExperience);
                                if (lecturer.getHasGraded()) {

                                    showSuccessDialog(dialog, "Assignment Graded Successfully.");
                                } else {
                                    showErrorDialog(dialog, "Teacher couldn't grade the assignment.");
                                }
                            } else {
                                showErrorDialog(dialog, "Teacher should be Lecturer to Grade.");
                            }
                        } else {
                            showErrorDialog(dialog, "Teacher ID Not Found.");

                        }
                    } catch (NumberFormatException ex) {
                        showErrorDialog(dialog, "Please Enter a Valid Number for Teacher ID and Graded Score.");
                    }
                });
                dialog.setVisible(true);
            }
        }

    }

}
