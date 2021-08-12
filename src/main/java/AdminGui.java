import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminGui implements ActionListener {
    private JFrame adminFrame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subEastPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JButton createCourseButton = new JButton();
    private JButton addRoomButton = new JButton();
    private JButton updateScheduleButton = new JButton();
    private JButton updateInfoButton = new JButton();
    private JPanel courseViewPanel = new JPanel();
    private JPanel roomViewPanel = new JPanel();
    private JPanel scheduleViewPanel = new JPanel();
    private JPanel organisationViewPanel = new JPanel();
    private MyJDBC jdbc = new MyJDBC();
    private ResultSet resultSet;
    private List<String> courseNames = new ArrayList<>();


    public AdminGui(){
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.adminFrame = new JFrame();
        this.adminFrame.getContentPane().setBackground(Color.white);
        this.adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.adminFrame.setSize(screenSize.width, screenSize.height);
        this.adminFrame.setVisible(true);
        this.adminFrame.setResizable(true);
        this.adminFrame.setLocationRelativeTo(null);
        this.adminFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Admin-Interface", 50), BorderLayout.NORTH);
        this.adminFrame.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.adminFrame.add(southPanel, BorderLayout.SOUTH);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(4,0, 0 ,25));
        centerPanel.setPreferredSize(new Dimension(300,300));
        centerPanel.add(createCourseViewPanel(courseViewPanel));
        centerPanel.add(createRoomViewPanel(roomViewPanel));
        centerPanel.add(createPanel(scheduleViewPanel));
        centerPanel.add(createPanel(organisationViewPanel));
        this.adminFrame.add(centerPanel, BorderLayout.CENTER);


        westPanel = new JPanel();
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.adminFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new GridLayout(4,0, 0, 50));
        eastPanel.setPreferredSize(new Dimension(200,100));
        eastPanel.add(createButton(createCourseButton, "create Course"));
        eastPanel.add(createButton(addRoomButton, "add Room"));
        eastPanel.add(createButton(updateScheduleButton, "update Schedule"));
        eastPanel.add(createButton(updateInfoButton,"Organisation"));
        this.adminFrame.add(eastPanel, BorderLayout.EAST);

        /*subEastPanel = new JPanel();
        subEastPanel.setBackground(new Color(200,200,200));
        subEastPanel.setLayout(new FlowLayout());
        subEastPanel.setPreferredSize(new Dimension(150,50));

        subEastPanel.add(new JLabel());
        this.eastPanel.add(subEastPanel);*/
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


    public JButton createButton(JButton button, String text){
        button.setText(text);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(this);
        return button;
    }
    public JPanel createPanel(JPanel panel){
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(200,100));

        return panel;
    }

    public JPanel createCourseViewPanel(JPanel panel){
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(200,100));
        makeView("subject","subject_Name", courseViewPanel);
        return panel;
    }

    public JPanel createRoomViewPanel(JPanel panel){
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(200,100));
        makeView("room","room_ID", roomViewPanel);
        return panel;
    }

    public void makeView(String table, String column, JPanel panel){
        jdbc.retrieveRecords(table);
        resultSet = jdbc.getResult();
        panel.setLayout(new GridLayout(0,5,20,10));
        try {
            while (resultSet.next()){
                panel.add(createTextPane(new JTextPane(), resultSet.getString(column)));
            }
        }catch (SQLException e){
            System.out.println("something went wrong with the schedule resultset");
        }

    }

    // here i used cod from the internet to center my Text
    public JTextPane createTextPane(JTextPane pane, String text){
        pane.setText(text);
        pane.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        pane.setBackground(new Color(100,200,200));
        StyledDocument doc = pane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        return pane;
    }
    ////////////////////////////////created view of the courses and rooms

    public JLabel createLabel(JLabel label, String text, int fontsize){

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

    public void createAdmin(Administrator admin){
        HibernateSupport.beginTransaction();
        admin.saveToDB();
        HibernateSupport.commitTransaction();
    }

    public void createAssist(){

    }

    public void createStud(){

    }


    public JButton getCreateCourseButton() {
        return createCourseButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createCourseButton){
            CreateCourse course = new CreateCourse();
        }
    }
}
