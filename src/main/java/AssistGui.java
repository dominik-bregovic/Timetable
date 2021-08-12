import javax.swing.*;
import java.awt.*;

/*
 * Author: Bregovic Dominik
 * creates the gui for the assistant
 * Last change: 12.08.2021
 */

public class AssistGui {

    private JFrame assistFrame;
    private JButton createButton = new JButton();

    public AssistGui(){
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.assistFrame = new JFrame();
        this.assistFrame.getContentPane().setBackground(Color.white);
        this.assistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.assistFrame.setSize(screenSize.width, screenSize.height);

        this.assistFrame.setVisible(true);
        this.assistFrame.setResizable(true);
        this.assistFrame.setLocationRelativeTo(null);
        this.assistFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Assist-Interface", 50), BorderLayout.NORTH);
        this.assistFrame.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.assistFrame.add(southPanel, BorderLayout.SOUTH);

        JPanel subSouthPanel = new JPanel();
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new FlowLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,50));
        subSouthPanel.add(createButton(createButton));
        subSouthPanel.add(new JLabel());
        southPanel.add(subSouthPanel, BorderLayout.EAST);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(0,7));
        centerPanel.setPreferredSize(new Dimension(300,300));
        this.assistFrame.add(centerPanel, BorderLayout.CENTER);

        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.assistFrame.add(westPanel, BorderLayout.WEST);


        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(200,100));
        this.assistFrame.add(eastPanel, BorderLayout.EAST);
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        return label;
    }


    public JButton createButton(JButton button){
        button.setText("Submit");
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        return button;
    }
}
