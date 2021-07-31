import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StudGui {

    JFrame studFrame;
    Border createBorder;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subSouthPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel subCenterPanel1;
    private JPanel subCenterPanel2;
    private JPanel[][] timetable = new JPanel[9][7];
    private JButton signUpButton = new JButton();

    public StudGui(){
        createFrame();
        createPanel();
        addCourse("Monday", "08:00");
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
        button.setText("Next");
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
                this.timetable[i][j] = new JPanel();
                this.timetable[i][j].setLayout(new GridLayout());
                this.timetable[i][j].setBackground(Color.WHITE);
                this.timetable[i][j].setBorder(createBorder);
                this.centerPanel.add(this.timetable[i][j]);

                if (j == 0 && i == 1){
                    this.timetable[i][j].add(new JLabel("08:00"));
                }else if (j == 0 && i == 2){
                    this.timetable[i][j].add(new JLabel("09:00"));
                }else if (j == 0 && i == 3){
                    this.timetable[i][j].add(new JLabel("10:00"));
                }else if (j == 0 && i == 4){
                    this.timetable[i][j].add(new JLabel("11:00"));
                }else if (j == 0 && i == 5){
                    this.timetable[i][j].add(new JLabel("12:00"));
                }else if (j == 0 && i == 6){
                    this.timetable[i][j].add(new JLabel("13:00"));
                }else if (j == 0 && i == 7){
                    this.timetable[i][j].add(new JLabel("14:00"));
                }else if (j == 0 && i == 8){
                    this.timetable[i][j].add(new JLabel("15:00"));
                }
            }
        }
    }


    public void addCourse(String day, String time){

        switch (day) {
            case "Monday":
                System.out.println("add to Monday");
                switch (time){
                    case "08:00":
                        timetable[1][1].add(new JLabel("Mathematics \n lets go"));
                }
                break;
            case "Tuesday":
                System.out.println("add to Tuesday");
                break;
            case "Wednesday":
                System.out.println("add to Wednesday");;
                break;
            case "Thursday":
                System.out.println("add to Thursday");;
                break;
            case "Friday":
                System.out.println("add to Friday");;
                break;
            case "Saturday":
                System.out.println("add to Saturday");;
                break;
            case "Sunday":
                System.out.println("add to Sunday");;
                break;
            default:
                System.out.println("wrong day");;
                break;
        }
    }


    public JButton getSignUpButton() {
        return signUpButton;
    }



}

