import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateCourse implements ActionListener {

    public CreateCourse(){
        createFrame();
        createPanel();
    }
    private JFrame studFrame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subEastPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JButton addCourseButton = new JButton();
    private JTextField textField = new JTextField();
    private MyJDBC jdbc = new MyJDBC();


    public void createFrame(){
        this.studFrame = new JFrame();
        this.studFrame.getContentPane().setBackground(Color.white);
        this.studFrame.setSize(400, 200);
        //this.studFrame.setUndecorated(true);
        this.studFrame.setVisible(true);
        this.studFrame.setResizable(true);
        this.studFrame.setLocationRelativeTo(null);
        this.studFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,50));
        northPanel.add(createHeaderLabel(new JLabel(), "Add your Course:", 35), BorderLayout.NORTH);
        this.studFrame.add(northPanel, BorderLayout.NORTH);


        southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.studFrame.add(southPanel, BorderLayout.SOUTH);


        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(300,300));
        centerPanel.add(this.textField);
        this.studFrame.add(this.centerPanel, BorderLayout.CENTER);

        westPanel = new JPanel();
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(100,100));
        westPanel.add(new JLabel("Course name:"));
        this.studFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new FlowLayout());
        eastPanel.setPreferredSize(new Dimension(100,100));
        eastPanel.add((createButton(addCourseButton)));
        this.studFrame.add(eastPanel, BorderLayout.EAST);

        /*subEastPanel = new JPanel();
        subEastPanel.setBackground(new Color(100,200,200));
        subEastPanel.setLayout(new FlowLayout());
        subEastPanel.setPreferredSize(new Dimension(150,50));
        subEastPanel.add(createButton(addCourseButton));
        subEastPanel.add(new JLabel());
        this.eastPanel.add(subEastPanel, BorderLayout.NORTH);*/
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        //label.setBackground(Color.MAGENTA); //set Background color
        //label.setOpaque(true);     //with this Background pixels are changed
        //label.setVerticalTextPosition(JLabel.CENTER);            //positioning text to image
        //label.setHorizontalTextPosition(JLabel.CENTER);       //positioning text to image
        //label.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        //label.setHorizontalAlignment(JLabel.LEFT);
        //label.setBounds(0,0,750,100);       //set label within frame

        return label;
    }


    public JButton createButton(JButton button){
        button.setText("add Course");
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCourseButton){
            if (jdbc.searchForRecord("subject_Name", "subject", textField.getText())){

                ErrorFrame errorFrame = new ErrorFrame("This Course already exists");
            }else{

                try {
                    jdbc.insertIntoCoursesTable(textField.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
    }
}
