import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Author: Bregovic Dominik
 * creates the Gui for the Administrator all actions are getting saved into database
 * Last change: 12.08.2021
 */

public class AdminGui implements ActionListener {
    private JFrame adminFrame;
    private JButton createCourseButton = new JButton();
    private JButton addRoomButton = new JButton();
    private JButton updateScheduleButton = new JButton();
    private JButton updateInfoButton = new JButton();
    private JPanel courseViewPanel = new JPanel();
    private JPanel roomViewPanel = new JPanel();
    private JPanel scheduleViewPanel = new JPanel();
    private JPanel organisationViewPanel = new JPanel();
    private MyJDBC jdbc = new MyJDBC();

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
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Admin-Interface", 50), BorderLayout.NORTH);
        this.adminFrame.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.adminFrame.add(southPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(4,0, 0 ,25));
        centerPanel.setPreferredSize(new Dimension(300,300));
        centerPanel.add(createCourseViewPanel(this.courseViewPanel));
        centerPanel.add(createRoomViewPanel(this.roomViewPanel));
        centerPanel.add(createPanel(this.scheduleViewPanel));
        centerPanel.add(createPanel(this.organisationViewPanel));
        this.adminFrame.add(centerPanel, BorderLayout.CENTER);


        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.WHITE);
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.adminFrame.add(westPanel, BorderLayout.WEST);


        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.WHITE);
        eastPanel.setLayout(new GridLayout(4,0, 0, 50));
        eastPanel.setPreferredSize(new Dimension(200,100));
        eastPanel.add(createButton(this.createCourseButton, "create Course"));
        eastPanel.add(createButton(this.addRoomButton, "add Room"));
        eastPanel.add(createButton(this.updateScheduleButton, "update Schedule"));
        eastPanel.add(createButton(this.updateInfoButton,"Organisation"));
        this.adminFrame.add(eastPanel, BorderLayout.EAST);

    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){
        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
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
        makeView("subject","subject_Name", this.courseViewPanel);
        return panel;
    }

    public JPanel createRoomViewPanel(JPanel panel){
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(200,100));
        makeView("room","room_ID", this.roomViewPanel);
        return panel;
    }

    public void makeView(String table, String column, JPanel panel){
        this.jdbc.retrieveRecords(table);
        ResultSet resultSet = this.jdbc.getResult();
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

    public JButton getCreateCourseButton() {
        return createCourseButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createCourseButton){
            CreateCourse course = new CreateCourse(new StudGui(jdbc, false));
        }
    }
}
