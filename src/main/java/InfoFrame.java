import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Author: Bregovic Dominik
 * info about the success of action
 * Last change: 12.08.2021
 */

public class InfoFrame implements ActionListener {

    private JFrame errorFrame;
    private JButton okButton = new JButton();
    String frameText;

    public InfoFrame(){

    }

    public InfoFrame(String frameText){
        this.frameText = frameText;
        createFrame();
        createPanel();
    }

    public InfoFrame(JFrame signUpFrame, String frameText){
        signUpFrame.dispose();
        this.frameText = frameText;
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.errorFrame = new JFrame();
        this.errorFrame.getContentPane().setBackground(Color.white);
        this.errorFrame.setSize(400, 300);
        this.errorFrame.setVisible(true);
        this.errorFrame.setResizable(true);
        this.errorFrame.setLocationRelativeTo(null);
        this.errorFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,50));
        northPanel.add(createHeaderLabel(new JLabel(), "", 50), BorderLayout.NORTH);
        this.errorFrame.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.errorFrame.add(southPanel, BorderLayout.SOUTH);

        JPanel subSouthPanel = new JPanel();
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new FlowLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,50));
        subSouthPanel.add(createButton(okButton));
        subSouthPanel.add(new JLabel());
        southPanel.add(subSouthPanel, BorderLayout.EAST);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(300,100));
        centerPanel.add(createHeaderLabel(new JLabel(), frameText, 30), BorderLayout.CENTER);
        this.errorFrame.add(centerPanel, BorderLayout.CENTER);
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        label.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }


    public JButton createButton(JButton button){
        button.setText("Ok");
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        errorFrame.dispose();
    }
}
