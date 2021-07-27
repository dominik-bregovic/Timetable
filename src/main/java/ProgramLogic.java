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
            System.out.println(myJDBC.searchForRecord("name", "assistant",userName.getText()));
            System.out.println(myJDBC.searchForRecord("password", "assistant",userPass.getText()));
            userName.setText("");
            userPass.setText("");

            // here just check if Admin, Prof or Student

            System.out.println("hallo");
        }
    }

}
