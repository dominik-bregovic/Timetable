import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudGui {

    private MyJDBC myJDBC;
    private ResultSet scheduleData;
    private JFrame studFrame;
    private Border createBorder;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subSouthPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel[][] timetable = new JPanel[9][7];
    private boolean[][] timetableFieldEmpty = new boolean[9][7];
    private JButton signUpButton = new JButton();
    private List<String> daysOfWeek = new ArrayList<>();
    private List<String> timeFrom = new ArrayList<>();
    private List<String> timeUntil = new ArrayList<>();
    private List<String> subject = new ArrayList<>();
    private List<String> teacher = new ArrayList<>();
    private List<Integer> room = new ArrayList<>();

    public StudGui(MyJDBC jdbc){
        this.myJDBC= jdbc;
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
        //panel1.setBounds(50,50, 500,400);
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Student-timetable", 50), BorderLayout.NORTH);
        this.studFrame.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        //panel2.setBounds(50,50, 500,400);
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.studFrame.add(southPanel, BorderLayout.SOUTH);

        subSouthPanel = new JPanel();
        //panel4.setBounds(50,50, 500,400);
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new FlowLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,50));
        subSouthPanel.add(createButton(signUpButton));
        subSouthPanel.add(new JLabel());
        this.southPanel.add(subSouthPanel, BorderLayout.EAST);


        centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setLayout(new GridLayout(0,7));
        centerPanel.setPreferredSize(new Dimension(300,300));
        this.studFrame.add(centerPanel, BorderLayout.CENTER);
        fillTimetable();

        //centerPanel.add(createLogPanel(new JPanel(), 200, 70, "Username:"), BorderLayout.NORTH);
        //centerPanel.add(createLogPanel(new JPanel(), 200, 0, "Password:"), BorderLayout.CENTER);
        //centerPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);


        westPanel = new JPanel();
        // panel3.setBounds(50,50, 500,400);
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.studFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(200,100));
        //eastPanel.add(createLogPanelInput(new JPanel(), 100, 70, "Username:"), BorderLayout.NORTH);
        //eastPanel.add(createLogPanelPassInput(new JPanel(), 100, 0, "Password:"), BorderLayout.CENTER);
        //eastPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);
        this.studFrame.add(eastPanel, BorderLayout.EAST);
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

        System.out.println(daysOfWeek.size());
        for (int i = 0; i < daysOfWeek.size(); i++) {
            fillTableWithCourses(daysOfWeek.get(i), timeFrom.get(i), i);
            fillTableWithCourses(daysOfWeek.get(i), timeUntil.get(i), i);
        }
    }


    public void fillTableWithCourses(String day, String time, int index){
    int columnDay = 0;

        switch (day) {
            case "monday":
                System.out.println("add to Monday");
                columnDay = 1;
                assignTime(time, columnDay, index);
                break;
            case "tuesday":
                System.out.println("add to Tuesday");
                columnDay = 2;
                assignTime(time, columnDay, index);
                break;
            case "wednesday":
                System.out.println("add to Wednesday");;
                columnDay = 3;
                assignTime(time, columnDay, index);
                break;
            case "thursday":
                System.out.println("add to Thursday");;
                columnDay = 4;
                assignTime(time, columnDay, index);
                break;
            case "friday":
                System.out.println("add to Friday");;
                columnDay = 5;
                assignTime(time, columnDay, index);
                break;
            case "saturday":
                System.out.println("No school at Saturday");;
                break;
            case "sunday":
                System.out.println("No school at Sunday");;
                break;
            default:
                System.out.println("wrong day");;
                break;
        }
    }

    public void assignTime(String time, int columnday, int index){
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        switch (time){
            case "08:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[1][columnday].add(textArea);
                break;
            case "09:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[2][columnday].add(textArea);
                break;
            case "10:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[3][columnday].add(textArea);
                break;
            case "11:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[4][columnday].add(textArea);
                break;
            case "12:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[5][columnday].add(textArea);
                break;
            case "13:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[6][columnday].add(textArea);
                break;
            case "14:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[7][columnday].add(textArea);
                break;
            case "15:00":
                textArea.setText("Sub: " + subject.get(index) + "\nProf: " +  teacher.get(index) + "\n" + "Room: " + room.get(index));
                timetable[8][columnday].add(textArea);
                break;
        }
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


    public JButton getSignUpButton() {
        return signUpButton;
    }



}

