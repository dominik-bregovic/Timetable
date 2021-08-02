import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAssistOrStudInterface implements ActionListener{

    LogGui logGui;
    StudGui studGui;
    MyJDBC myJDBC;
    JTextField userName;
    JPasswordField userPass;
    JButton loginButton;
    JButton signUpForCourse;

    public AdminAssistOrStudInterface(){

    }

    public AdminAssistOrStudInterface(LogGui log, MyJDBC jdbc){
        this.logGui = log;
        this.myJDBC = jdbc;
        retrieveLogData();
    }

    public void retrieveLogData(){
        loginButton = logGui.getLoginButton();
        loginButton.addActionListener(this);
        userName = logGui.getUserNameInput();
        userName.addActionListener(this);
        userPass = logGui.getUserPasswordInput();
        userPass.addActionListener(this);

    }

   /* public void getInput(){
        logGui.getUserNameInput().getText();
        userName = user.getText();
        user.setText("");
        password = pass.getText();
        pass.setText("");
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton || e.getSource() == userPass){
            String userNameInput = userName.getText();
            if (myJDBC.searchForRecord("name", "student",userNameInput) &&
                    myJDBC.searchForRecord("password", "student",userPass.getText())) {
                //TODO call stud frame
                studInterface(userNameInput);
                //only have to implement the possibility to sign up for courses
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
            }
            userName.setText("");
            userPass.setText("");
        }




        //hope this will work
        if (e.getSource() == signUpForCourse){
            System.out.println("all working");
        }


    }


    public void studInterface(String user){
        this.logGui.closeLogFrame();
        this.studGui = new StudGui(myJDBC, user);
        signUpForCourse = studGui.getSignUpButton();
        signUpForCourse.addActionListener(this);
    }

    public void assistInterface(){
        System.out.println("Is this user a Assist: "+myJDBC.searchForRecord("name", "assistant",userName.getText()));
        System.out.println("is this user pass valid: "+myJDBC.searchForRecord("password", "assistant",userPass.getText()));
    }

    public void adminInterface(){
        System.out.println("Is this user a Admin: "+myJDBC.searchForRecord("name", "administrator",userName.getText()));
        System.out.println("is this user pass valid: "+myJDBC.searchForRecord("password", "administrator",userPass.getText()));
    }

}
