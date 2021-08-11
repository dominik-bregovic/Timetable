import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ErrorFrame implements ActionListener {

    private JFrame errorFrame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subSouthPanel;
    /*private JPanel westPanel;
    private JPanel eastPanel;*/
    private JPanel centerPanel;
    private JButton okButton = new JButton();

    public ErrorFrame(){
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.errorFrame = new JFrame();
        this.errorFrame.getContentPane().setBackground(Color.white);
        //this.errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.errorFrame.setSize(400, 300);
        //this.studFrame.setUndecorated(true);
        this.errorFrame.setVisible(true);
        this.errorFrame.setResizable(true);
        this.errorFrame.setLocationRelativeTo(null);
        this.errorFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,50));
        northPanel.add(createHeaderLabel(new JLabel(), "", 50), BorderLayout.NORTH);
        this.errorFrame.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.errorFrame.add(southPanel, BorderLayout.SOUTH);

        subSouthPanel = new JPanel();
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new FlowLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,50));
        subSouthPanel.add(createButton(okButton));
        subSouthPanel.add(new JLabel());
        this.southPanel.add(subSouthPanel, BorderLayout.EAST);


        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(300,100));
        centerPanel.add(createHeaderLabel(new JLabel(), "You are already signed in!", 30), BorderLayout.CENTER);
        this.errorFrame.add(centerPanel, BorderLayout.CENTER);

      /*  westPanel = new JPanel();
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(50,100));
        this.errorFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(50,100));
        //eastPanel.add(createLogPanelInput(new JPanel(), 100, 70, "Username:"), BorderLayout.NORTH);
        //eastPanel.add(createLogPanelPassInput(new JPanel(), 100, 0, "Password:"), BorderLayout.CENTER);
        //eastPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);
        this.errorFrame.add(eastPanel, BorderLayout.EAST);*/
    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        //label.setBackground(Color.MAGENTA); //set Background color
        //label.setOpaque(true);     //with this Background pixels are changed
        //label.setVerticalTextPosition(JLabel.CENTER);            //positioning text to image
        //label.setHorizontalTextPosition(JLabel.CENTER);       //positioning text to image
        //label.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        //label.setHorizontalAlignment(JLabel.LEFT);
        //label.setBounds(0,0,750,100);       //set label within frame

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
