import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramLogic implements ActionListener{

    LogGui logGui;
    MyJDBC myJDBC;
    String userName;
    String pass;
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
        System.out.println("hallo");
    }

}
