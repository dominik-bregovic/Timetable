import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramLogic implements ActionListener{

    LogGui logGui;
    StudGui studGui;
    MyJDBC myJDBC;
    JTextField userName;
    JPasswordField userPass;
    JButton loginButton;
    JButton signUpForCourse;

    public ProgramLogic(){

    }

    public ProgramLogic(LogGui log, MyJDBC jdbc){
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
            if (myJDBC.searchForRecord("name", "student",userName.getText()) &&
                    myJDBC.searchForRecord("password", "student",userPass.getText())) {
                //TODO call stud frame
                studInterface();
                //only have to implement the possibility to sign up fro courses
            }
            if (myJDBC.searchForRecord("name", "assistant",userName.getText()) &&
                    myJDBC.searchForRecord("password", "assistant",userPass.getText())){
                //TODO call assist frame
                assitInterface();
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

    public void actionPerformed2(){

    }

    public void studInterface(){
        this.logGui.closeLogFrame();
        this.studGui = new StudGui(myJDBC);
        signUpForCourse = studGui.getSignUpButton();
        signUpForCourse.addActionListener(this);
    }

    public void assitInterface(){
        System.out.println("Is this user a Assist: "+myJDBC.searchForRecord("name", "assistant",userName.getText()));
        System.out.println("is this user pass valid: "+myJDBC.searchForRecord("password", "assistant",userPass.getText()));
    }

    public void adminInterface(){
        System.out.println("Is this user a Admin: "+myJDBC.searchForRecord("name", "administrator",userName.getText()));
        System.out.println("is this user pass valid: "+myJDBC.searchForRecord("password", "administrator",userPass.getText()));
    }

}
