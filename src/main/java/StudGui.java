import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudGui implements ActionListener {

    private MyJDBC myJDBC;
    private ResultSet scheduleData;
    private String user;
    private JFrame studFrame;
    private Border createBorder;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subEastPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel[][] timetable = new JPanel[9][7];
    private boolean[][] timetableFieldEmpty = new boolean[9][7];
    private JButton logOutButton = new JButton();
    private List<String> daysOfWeek = new ArrayList<>();
    private List<String> timeFrom = new ArrayList<>();
    private List<String> timeUntil = new ArrayList<>();
    private List<String> subject = new ArrayList<>();
    private List<String> teacher = new ArrayList<>();
    private List<Integer> room = new ArrayList<>();

    public StudGui(MyJDBC jdbc, String user){
        this.myJDBC= jdbc;
        this.user = user;
        createFrame();
        createPanel();
        getTheCourses();
    }



    //TODO method to inscript for course

    public void createFrame(){
        this.studFrame = new JFrame();
        this.studFrame.getContentPane().setBackground(Color.white);
        this.studFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.studFrame.setSize(screenSize.width, screenSize.height);
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
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Student-timetable", 50), BorderLayout.NORTH);
        this.studFrame.add(northPanel, BorderLayout.NORTH);


        southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.studFrame.add(southPanel, BorderLayout.SOUTH);



        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(0,7));
        centerPanel.setPreferredSize(new Dimension(300,300));
        this.studFrame.add(centerPanel, BorderLayout.CENTER);
        fillTimetable();

        westPanel = new JPanel();
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.studFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(200,100));
        this.studFrame.add(eastPanel, BorderLayout.EAST);

        subEastPanel = new JPanel();
        subEastPanel.setBackground(new Color(100,200,200));
        subEastPanel.setLayout(new FlowLayout());
        subEastPanel.setPreferredSize(new Dimension(150,50));
        subEastPanel.add(createButton(logOutButton));
        subEastPanel.add(new JLabel());
        this.eastPanel.add(subEastPanel, BorderLayout.NORTH);
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
        button.setText("Submit");
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(this);
        return button;
    }

    public void fillTimetable(){
        this.createBorder = BorderFactory.createLineBorder(Color.GRAY);

        JPanel fromTo = new JPanel();
        fromTo.setBackground(Color.WHITE);
        fromTo.add(new JLabel("From-To"));
        fromTo.setBorder(createBorder);
        this.timetable[0][0] = fromTo;
        this.centerPanel.add(timetable[0][0]);

        JPanel monday = new JPanel();
        monday.setBackground(Color.WHITE);
        monday.add(new JLabel("Monday"));
        monday.setBorder(createBorder);
        this.timetable[0][1] = monday;
        this.centerPanel.add(timetable[0][1]);

        JPanel tuesday = new JPanel();
        tuesday.setBackground(Color.WHITE);
        tuesday.add(new JLabel("Tuesday"));
        tuesday.setBorder(createBorder);
        this.timetable[0][2] = tuesday;
        this.centerPanel.add(timetable[0][2]);

        JPanel wednesday = new JPanel();
        wednesday.setBackground(Color.WHITE);
        wednesday.add(new JLabel("Wednesday"));
        wednesday.setBorder(createBorder);
        this.timetable[0][3] = wednesday;
        this.centerPanel.add(timetable[0][3]);

        JPanel thursday = new JPanel();
        thursday.setBackground(Color.WHITE);
        thursday.add(new JLabel("Thursday"));
        thursday.setBorder(createBorder);
        this.timetable[0][4] = thursday;
        this.centerPanel.add(timetable[0][4]);

        JPanel friday = new JPanel();
        friday.setBackground(Color.WHITE);
        friday.add(new JLabel("Friday"));
        friday.setBorder(createBorder);
        this.timetable[0][5] = friday;
        this.centerPanel.add(timetable[0][5]);

        JPanel saturday = new JPanel();
        saturday.setBackground(Color.WHITE);
        saturday.add(new JLabel("Saturday"));
        saturday.setBorder(createBorder);
        this.timetable[0][6] = saturday;
        this.centerPanel.add(timetable[0][6]);
        fillAllFields();

    }


    public void fillAllFields(){

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                this.timetableFieldEmpty[i][j] = true;
                this.timetable[i][j] = new JPanel();
                this.timetable[i][j].setLayout(new GridLayout());
                this.timetable[i][j].setBackground(Color.WHITE);
                this.timetable[i][j].setBorder(createBorder);
                this.centerPanel.add(this.timetable[i][j]);

                if (j == 0 && i == 1){
                    this.timetable[i][j].add(new JLabel("08:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 2){
                    this.timetable[i][j].add(new JLabel("09:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 3){
                    this.timetable[i][j].add(new JLabel("10:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 4){
                    this.timetable[i][j].add(new JLabel("11:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 5){
                    this.timetable[i][j].add(new JLabel("12:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 6){
                    this.timetable[i][j].add(new JLabel("13:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 7){
                    this.timetable[i][j].add(new JLabel("14:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }else if (j == 0 && i == 8){
                    this.timetable[i][j].add(new JLabel("15:00"));
                    this.timetableFieldEmpty[i][j] = false;
                }
            }
        }
        setFieldsUsed();
    }

    public void setFieldsUsed(){
        for (int i = 0; i < 7; i++) {
            this.timetableFieldEmpty[0][i] = false;
        }
    }

    public void getTheCourses(){
        retrieveCourses();

        for (int i = 0; i < daysOfWeek.size(); i++) {
            fillTableWithCourses(daysOfWeek.get(i), timeFrom.get(i), i);
            fillTableWithCourses(daysOfWeek.get(i), timeUntil.get(i), i);
        }
    }


    public void fillTableWithCourses(String day, String time, int index){
    int columnDay = 0;

        switch (day) {
            case "monday":
                columnDay = 1;
                assignTime(time, columnDay, index);
                break;
            case "tuesday":
                columnDay = 2;
                assignTime(time, columnDay, index);
                break;
            case "wednesday":
                columnDay = 3;
                assignTime(time, columnDay, index);
                break;
            case "thursday":
                columnDay = 4;
                assignTime(time, columnDay, index);
                break;
            case "friday":
                columnDay = 5;
                assignTime(time, columnDay, index);
                break;
            case "saturday":
                System.out.println("No school at Saturday");
                break;
            case "sunday":
                System.out.println("No school at Sunday");
                break;
            default:
                System.out.println("wrong day");
                break;
        }
    }

    public void assignTime(String time, int columnDay, int index){

        switch (time){
            case "08:00":
                timetable[1][columnDay].removeAll();
                timetable[1][columnDay].add(createTextPane(index));
                break;
            case "09:00":
                timetable[2][columnDay].removeAll();
                timetable[2][columnDay].add(createTextPane(index));
                break;
            case "10:00":
                timetable[3][columnDay].removeAll();
                timetable[3][columnDay].add(createTextPane(index));
                break;
            case "11:00":
                timetable[4][columnDay].removeAll();
                timetable[4][columnDay].add(createTextPane(index));
                break;
            case "12:00":
                timetable[5][columnDay].removeAll();
                timetable[5][columnDay].add(createTextPane(index));
                break;
            case "13:00":
                timetable[6][columnDay].removeAll();
                timetable[6][columnDay].add(createTextPane(index));
                break;
            case "14:00":
                timetable[7][columnDay].removeAll();
                timetable[7][columnDay].add(createTextPane(index));
                break;
            case "15:00":
                timetable[8][columnDay].removeAll();
                timetable[8][columnDay].add(createTextPane(index));
                break;
        }
    }

    public JTextPane createTextPane(int index){
        JTextPane textPane = new JTextPane();
        textPane.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
        textPane.setEditable(false);
        textPane.setBackground(new Color(200,200,200));
        textPane.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addingMouseListener(textPane);
        return textPane;
    }

    public void addingMouseListener(JTextPane textPane){
        textPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignUpForCourseGui signUpForCourseGui = new SignUpForCourseGui(user, textPane, new MyJDBC());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public void retrieveCourses(){
         myJDBC.retrieveRecords("schedule");
         scheduleData = myJDBC.getResult();

         try {
              while (scheduleData.next()){
                 this.daysOfWeek.add(scheduleData.getString("dayOfWeek"));
                 this.timeFrom.add(scheduleData.getString("timeFrom"));
                 this.timeUntil.add(scheduleData.getString("timeTo"));
                 this.subject.add(scheduleData.getString("subject"));
                 this.teacher.add(scheduleData.getString("assistant"));
                 this.room.add(scheduleData.getInt("room_room_ID"));
              }
         }catch (SQLException e){
             System.out.println("something went wrong with the schedule resultset");
         }
    }


    public JButton getLogOutButton() {
        return logOutButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logOutButton){
            studFrame.dispose();
        }
    }
}

