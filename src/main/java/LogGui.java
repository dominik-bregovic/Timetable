import javax.swing.*;
import java.awt.*;
/*
 * Author: Bregovic Dominik
 * here the admin can create a course and add it to the database
 * Last change: 12.08.2021
 */

public class LogGui{

    private JFrame login;
    private JButton loginButton = new JButton();
    private JTextField userNameInput = new JTextField("Enter Username");
    private JPasswordField userPasswordInput = new JPasswordField();


    public LogGui(){
        createFrame(600, 400);
        createPanel();

    }

    public void createFrame(int  width, int height){
        this.login = new JFrame();
        this.login.getContentPane().setBackground(new Color(200,100,200));
        this.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.login.setSize(width, height);
        this.login.setVisible(true);
        this.login.setResizable(true);
        this.login.setLocationRelativeTo(null);
        this.login.setLayout(new BorderLayout());
    }



    public void createPanel(){
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,140));
        northPanel.add(createHeaderLabel(new JLabel(), "Timetable Master 3000", 60), BorderLayout.NORTH);
        this.login.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.login.add(southPanel, BorderLayout.SOUTH);

        JPanel subSouthPanel = new JPanel();
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new FlowLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,50));
        subSouthPanel.add(createButton(loginButton));
        subSouthPanel.add(new JLabel());
        southPanel.add(subSouthPanel, BorderLayout.EAST);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(100,0));
        centerPanel.add(createLogPanel(new JPanel(), 200, 70, "Username:"), BorderLayout.NORTH);
        centerPanel.add(createLogPanel(new JPanel(), 200, 0, "Password:"), BorderLayout.CENTER);
        this.login.add(centerPanel, BorderLayout.CENTER);


        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(200,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,50));
        this.login.add(westPanel, BorderLayout.WEST);


        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(new Color(200,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(200,0));
        eastPanel.add(createLogPanelInput(new JPanel(), 100, 70), BorderLayout.NORTH);
        eastPanel.add(createLogPanelPassInput(new JPanel(), 100, 0), BorderLayout.CENTER);
        this.login.add(eastPanel, BorderLayout.EAST);
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        return label;
    }


    public JPanel createLogPanel(JPanel panel, int width, int height, String usage){
        panel.setBackground(new Color(200,200,200));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(width,height));
        panel.add(new JLabel(usage), BorderLayout.NORTH);
        return panel;
    }

    public JPanel createLogPanelInput(JPanel panel, int width, int height){
        panel.setBackground(new Color(200,200,200));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(width,height));
        panel.add(userNameInput, BorderLayout.NORTH);
        return panel;
    }
    public JPanel createLogPanelPassInput(JPanel panel, int width, int height){
        panel.setBackground(new Color(200,200,200));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(width,height));
        userPasswordInput.setText("Enter Password");
        panel.add(userPasswordInput, BorderLayout.NORTH);
        return panel;
    }

    public JButton createButton(JButton button){
        button.setText("Next");
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));

        return button;
    }

    public void closeLogFrame(){
        this.login.dispose();
    }


    public JTextField getUserNameInput() {
        return userNameInput;
    }

    public void setUserNameInput(JTextField userNameInput) {
        this.userNameInput = userNameInput;
    }

    public JPasswordField getUserPasswordInput() {
        return userPasswordInput;
    }

    public void setUserPasswordInput(JPasswordField userPasswordInput) {
        this.userPasswordInput = userPasswordInput;
    }

    public JButton getLoginButton() {
        return loginButton;
    }


}
