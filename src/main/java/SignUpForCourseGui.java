import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForCourseGui implements ActionListener {

    private JFrame signUpFrame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subSouthPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JButton signUpButton = new JButton();
    private JButton cancelButton = new JButton();
    private String user;
    private JTextArea userTextField;

    public SignUpForCourseGui(){
        /*createFrame();
        createPanel();*/
    }

    public SignUpForCourseGui(String user, JTextArea courseField){
        this.user = user;
        this.userTextField =  courseField;
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.signUpFrame = new JFrame();
        this.signUpFrame.getContentPane().setBackground(Color.BLACK);
        //this.signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.signUpFrame.setSize(500, 300);
        //this.studFrame.setUndecorated(true);
        this.signUpFrame.setVisible(true);
        this.signUpFrame.setResizable(true);
        this.signUpFrame.setLocationRelativeTo(null);
        this.signUpFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Do you want to sign up for this course?", 25), BorderLayout.CENTER);
        this.signUpFrame.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        southPanel.add(createButton(signUpButton, "Sign-up"), BorderLayout.WEST);
        southPanel.add(createButton(cancelButton, "Cancel"), BorderLayout.EAST);
        this.signUpFrame.add(southPanel, BorderLayout.SOUTH);


        centerPanel = new JPanel();
        centerPanel.setBackground(new Color(200,200,200));
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setPreferredSize(new Dimension(300,300));
        userTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        userTextField.setLineWrap(false);
        centerPanel.add(userTextField);
        this.signUpFrame.add(centerPanel, BorderLayout.CENTER);


        westPanel = new JPanel();
        westPanel.setBackground(new Color(200,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(100,100));
        this.signUpFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(200,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(100,100));
        this.signUpFrame.add(eastPanel, BorderLayout.EAST);
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        //label.setBackground(Color.MAGENTA); //set Background color
        //label.setOpaque(true);     //with this Background pixels are changed
        //label.setVerticalTextPosition(JLabel.CENTER);            //positioning text to image
        //label.setHorizontalTextPosition(JLabel.CENTER);       //positioning text to image
        label.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBounds(0,0,750,100);       //set label within frame

        return label;
    }


    public JButton createButton(JButton button, String buttonText){
        button.setText(buttonText);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(this);
        return button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton){
            // process for signing Up!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // here i have to get the right subject object and add the students names to it so that i can recognise if the student is already signed in.
            //including save amount of students into database
            System.out.println(userTextField.getText());
            Subject sub = new Subject();
        }
        if (e.getSource() == cancelButton){
            signUpFrame.dispose();
        }

    }

    public void retrieveSubject(){
        String course = userTextField.getText();
        if (course.contains("Mathematics")){

        }
    }
}
