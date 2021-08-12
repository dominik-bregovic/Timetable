import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/*
 * Author: Bregovic Dominik
 * created gui that lets us save us which student wants to visit which course
 * Last change: 12.08.2021
 */

public class SignUpForCourseGui implements ActionListener {

    private JFrame signUpFrame;
    private JButton signUpButton = new JButton();
    private JButton cancelButton = new JButton();
    private String user;
    private JTextPane userTextField;
    private JTextPane text = new JTextPane();
    private MyJDBC jdbc;

    public SignUpForCourseGui(){
    }

    public SignUpForCourseGui(String user, JTextPane courseField, MyJDBC jdbc){
        this.user = user;
        this.userTextField =  courseField;
        this.jdbc = jdbc;
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.signUpFrame = new JFrame();
        this.signUpFrame.getContentPane().setBackground(Color.BLACK);
        this.signUpFrame.setSize(500, 300);
        this.signUpFrame.setVisible(true);
        this.signUpFrame.setResizable(true);
        this.signUpFrame.setLocationRelativeTo(null);
        this.signUpFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Do you want to sign up for this course?", 25), BorderLayout.CENTER);
        this.signUpFrame.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        southPanel.add(createButton(signUpButton, "Sign-up"), BorderLayout.WEST);
        southPanel.add(createButton(cancelButton, "Cancel"), BorderLayout.EAST);
        this.signUpFrame.add(southPanel, BorderLayout.SOUTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(200,200,200));
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setPreferredSize(new Dimension(300,300));
        text.setText(userTextField.getText());
        text.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        centerPanel.add(text);
        this.signUpFrame.add(centerPanel, BorderLayout.CENTER);


        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(200,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(100,100));
        this.signUpFrame.add(westPanel, BorderLayout.WEST);


        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(new Color(200,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(100,100));
        this.signUpFrame.add(eastPanel, BorderLayout.EAST);
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        label.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }


    public JButton createButton(JButton button, String buttonText){
        button.setText(buttonText);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(this);
        return button;
    }

    // process for signing Up
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton){
            signUp();
        }
        if (e.getSource() == cancelButton){
            signUpFrame.dispose();
        }

    }
        /*
        * Here we are signing the student up for his course over the Database by jdbc
        * First we are retrieving the course he wants to sign up and the assign him to this course
        * if the user tries to sign in again, then an error is thrown
        */
    public void signUp(){
        String course = this.userTextField.getText();

        if (course.contains("Mathematics")){

            if (this.jdbc.searchForRecord("students_student_ID", "subject_student",
                    this.jdbc.retrieveID("student_ID", "student", "name", this.user))
                    && this.jdbc.searchForRecord("Subject_subject_id", "subject_student",
                    this.jdbc.retrieveID("subject_id", "subject", "subject_Name", "Mathematics"))){

                InfoFrame errorFrame = new InfoFrame(this.signUpFrame, "You are already signed in!"); ///////////////////handle signing out here

            }else{
                try {
                    this.jdbc.insertIntoScheduleStudentTable(this.jdbc.retrieveID("subject_id", "subject", "subject_Name", "Mathematics"),
                            this.jdbc.retrieveID("student_ID", "student", "name", this.user));
                    this.signUpFrame.dispose();
                    InfoFrame errorFrame = new InfoFrame(this.signUpFrame, "Signed-up!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }else if (course.contains("German")){

            if (this.jdbc.searchForRecord("students_student_ID", "subject_student",
                    this.jdbc.retrieveID("student_ID", "student", "name", this.user))
                && this.jdbc.searchForRecord("Subject_subject_id", "subject_student",
                    this.jdbc.retrieveID("subject_id", "subject", "subject_Name", "German"))){

                InfoFrame errorFrame = new InfoFrame(this.signUpFrame, "You are already signed in!"); ///////////////////handle signing out here

            }else{
                try {
                    this.jdbc.insertIntoScheduleStudentTable(this.jdbc.retrieveID("subject_id", "subject", "subject_Name", "German"),
                            this.jdbc.retrieveID("student_ID", "student", "name", this.user));
                    this.signUpFrame.dispose();
                    InfoFrame errorFrame = new InfoFrame(this.signUpFrame, "Signed-up!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else if (course.contains("English")){

            if (this.jdbc.searchForRecord("students_student_ID", "subject_student",
                    this.jdbc.retrieveID("student_ID", "student", "name", this.user))
                && this.jdbc.searchForRecord("Subject_subject_id", "subject_student",
                    this.jdbc.retrieveID("subject_id", "subject", "subject_Name", "English"))){

                InfoFrame errorFrame = new InfoFrame(signUpFrame, "You are already signed in!"); ///////////////////handle signing out here

            }else{
                try {
                    this.jdbc.insertIntoScheduleStudentTable(this.jdbc.retrieveID("subject_id", "subject", "subject_Name", "English"),
                            this.jdbc.retrieveID("student_ID", "student", "name", this.user));
                    this.signUpFrame.dispose();
                    InfoFrame errorFrame = new InfoFrame(this.signUpFrame, "Signed-up!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
