import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Author: Bregovic Dominik
 * here the user input decides which interface is getting accessed
 * Last change: 12.08.2021
 */

public class AdminAssistOrStudInterface implements ActionListener{

    LogGui logGui;
    AdminGui adminGui;
    AssistGui assistGui;
    StudGui studGui;
    MyJDBC myJDBC;
    JTextField userName;
    JPasswordField userPass;
    JButton loginButton;
    JButton createUser;

    public AdminAssistOrStudInterface(){

    }

    public AdminAssistOrStudInterface(LogGui log, MyJDBC jdbc){
        this.logGui = log;
        this.myJDBC = jdbc;
        retrieveLogData();
    }

    public void retrieveLogData(){
        this.loginButton = logGui.getLoginButton();
        this.loginButton.addActionListener(this);
        this.userName = logGui.getUserNameInput();
        this.userName.addActionListener(this);
        this.userPass = logGui.getUserPasswordInput();
        this.userPass.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton || e.getSource() == userPass){
            String userNameInput = userName.getText();
            if (myJDBC.searchForRecord("name", "student",userNameInput) &&
                    myJDBC.searchForRecord("password", "student",userPass.getText())) {
                //TODO call stud frame
                studInterface(userNameInput);
            }
            if (myJDBC.searchForRecord("name", "assistant",userName.getText()) &&
                    myJDBC.searchForRecord("password", "assistant",userPass.getText())){
                //TODO call assist frame
                assistInterface();
            }
            if (myJDBC.searchForRecord("name", "administrator",userName.getText()) &&
                    myJDBC.searchForRecord("password", "administrator",userPass.getText())){
                //TODO call admin frame
                adminInterface();
            }else{
                //TODO is no user, call error frame
                //InfoFrame infoFrame = new InfoFrame("No such User");
            }
            userName.setText("");
            userPass.setText("");
        }

    }


    public void studInterface(String user){
        this.logGui.closeLogFrame();
        this.studGui = new StudGui(myJDBC, user, true);
    }

    public void assistInterface(){
        this.logGui.closeLogFrame();
        this.assistGui = new AssistGui();
    }

    public void adminInterface(){
        this.logGui.closeLogFrame();
        this.adminGui = new AdminGui();
        this.createUser = adminGui.getCreateCourseButton();
        this.createUser.addActionListener(this);
    }

}
