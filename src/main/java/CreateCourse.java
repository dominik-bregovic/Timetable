import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Author: Bregovic Dominik
 * here the admin can create a course and add it to the database
 * Last change: 12.08.2021
 */


public class CreateCourse implements ActionListener {


    private JFrame studFrame;
    private JButton addCourseButton = new JButton();
    private JTextField profField = new JTextField();
    private JTextField date = new JTextField();
    private JTextField dayOfWeek = new JTextField();
    private JTextField course = new JTextField();
    private JTextField timeStart = new JTextField();
    private JTextField timeTo = new JTextField();
    private MyJDBC jdbc = new MyJDBC();
    private boolean[][] timeTableFree;

    public CreateCourse(){
    }

    public CreateCourse(StudGui gui){
        timeTableFree = gui.getTimetableFieldEmpty();
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.studFrame = new JFrame();
        this.studFrame.getContentPane().setBackground(Color.white);
        this.studFrame.setSize(700, 500);
        this.studFrame.setVisible(true);
        this.studFrame.setResizable(true);
        this.studFrame.setLocationRelativeTo(null);
        this.studFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){

        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,50));
        northPanel.add(new JLabel("Make your course:"));
        this.studFrame.add(northPanel, BorderLayout.NORTH);


        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.studFrame.add(southPanel, BorderLayout.SOUTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(7,0,0,10));
        centerPanel.setPreferredSize(new Dimension(300,300));
        centerPanel.add(this.profField);
        centerPanel.add(this.date);
        centerPanel.add(this.dayOfWeek);
        centerPanel.add(this.course);
        centerPanel.add(this.timeStart);
        centerPanel.add(this.timeTo);
        this.studFrame.add(centerPanel, BorderLayout.CENTER);

        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new GridLayout(7,0,0,10));
        westPanel.setPreferredSize(new Dimension(130,100));
        westPanel.add(createHeaderLabel(new JLabel(), "Professor:", 20));
        westPanel.add(createHeaderLabel(new JLabel(), "Date:", 20));
        westPanel.add(createHeaderLabel(new JLabel(), "Day of week:", 20));
        westPanel.add(createHeaderLabel(new JLabel(), "Course:", 20));
        westPanel.add(createHeaderLabel(new JLabel(), "Time-From:", 20));
        westPanel.add(createHeaderLabel(new JLabel(), "Time-To:", 20));
        this.studFrame.add(westPanel, BorderLayout.WEST);


        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(100,100));
        eastPanel.add(createButton(addCourseButton), BorderLayout.SOUTH);
        this.studFrame.add(eastPanel, BorderLayout.EAST);


    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        label.setBackground(Color.WHITE);
        label.setOpaque(true);     //with this Background pixels are changed
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
            if (!checkIfFreeTime()){
                InfoFrame errorFrame = new InfoFrame("This Course already exists");
            }else{
                try {
                    jdbc.insertIntoScheduleTable(profField.getText(), date.getText(), dayOfWeek.getText(),
                            course.getText(), timeStart.getText(), timeTo.getText(), "2");
                    InfoFrame errorFrame = new InfoFrame("Signed in successfully!");
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
                // after i successfully added a course i have to refresh the adminGui to let him see the result
            }
        }
    }

    public boolean checkIfFreeTime(){
    boolean free = false;
    String day = dayOfWeek.getText().toLowerCase();

            switch (day) {
                case "monday":
                    free = checkTime(1, timeStart.getText()) && checkTime(1, timeTo.getText());
                    break;
                case "tuesday":
                    free = checkTime(2, timeStart.getText()) && checkTime(2, timeTo.getText());
                    break;
                case "wednesday":
                    free = checkTime(3, timeStart.getText()) && checkTime(3, timeTo.getText());
                    break;
                case "thursday":
                    free = checkTime(4, timeStart.getText()) && checkTime(4, timeTo.getText());
                    break;
                case "friday":
                    free = checkTime(5, timeStart.getText()) && checkTime(5, timeTo.getText());
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
        return free;
    }

    public boolean checkTime(int index, String time){
        boolean roomFree = true;
        switch (time) {
            case "00:00":
            case "01:00":
            case "02:00":
            case "03:00":
            case "04:00":
            case "05:00":
            case "06:00":
            case "07:00":
            case "16:00":
            case "17:00":
            case "18:00":
            case "19:00":
            case "20:00":
            case "21:00":
            case "22:00":
            case "23:00":
            case "24:00":
                roomFree = false;
                break;
            case "08:00":
                roomFree = timeTableFree[1][index];
                break;
            case "09:00":
                roomFree = timeTableFree[2][index];
                break;
            case "10:00":
                roomFree = timeTableFree[3][index];
                break;
            case "11:00":
                roomFree = timeTableFree[4][index];
                break;
            case "12:00":
                roomFree = timeTableFree[5][index];
                break;
            case "13:00":
                roomFree = timeTableFree[6][index];
                break;
            case "14:00":
                roomFree = timeTableFree[7][index];
                break;
            case "15:00":
                roomFree = timeTableFree[8][index];
                break;
        }
        return roomFree;
    }


        /*jdbc.retrieveRecords("schedule");
        resultSet = jdbc.getResult();
        try {
            while (resultSet.next()){
                this.daysOfWeek.add(resultSet.getString("dayOfWeek"));
                this.timeFrom.add(resultSet.getString("timeFrom"));
                this.timeUntil.add(resultSet.getString("timeTo"));
            }
        }catch (SQLException f){
            System.out.println("something went wrong with the schedule resultset");
        }
*/
}
