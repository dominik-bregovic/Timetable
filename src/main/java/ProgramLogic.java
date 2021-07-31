import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramLogic implements ActionListener{

    LogGui logGui;
    MyJDBC myJDBC;
    JTextField userName;
    JPasswordField userPass;
    JButton loginButton;

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
                this.logGui.closeLogFrame();
                StudGui studGui = new StudGui();

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
    }

    public void studInterface(){
        System.out.println("Is this user a Stud: "+myJDBC.searchForRecord("name", "student",userName.getText()));
        System.out.println("is this user pass valid: "+myJDBC.searchForRecord("password", "student",userPass.getText()));
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
