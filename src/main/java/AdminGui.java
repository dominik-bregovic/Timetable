import javax.swing.*;
import java.awt.*;

public class AdminGui {
    private JFrame adminFrame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subSouthPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JButton createButton = new JButton();

    public AdminGui(){
        createFrame();
        createPanel();
    }

    public void createFrame(){
        this.adminFrame = new JFrame();
        this.adminFrame.getContentPane().setBackground(Color.white);
        this.adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.adminFrame.setSize(screenSize.width, screenSize.height);
        //this.studFrame.setUndecorated(true);
        this.adminFrame.setVisible(true);
        this.adminFrame.setResizable(true);
        this.adminFrame.setLocationRelativeTo(null);
        this.adminFrame.setLayout(new BorderLayout());
    }

    public void createPanel(){
        northPanel = new JPanel();
        //panel1.setBounds(50,50, 500,400);
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,70));
        northPanel.add(createHeaderLabel(new JLabel(), "Admin-Interface", 50), BorderLayout.NORTH);
        this.adminFrame.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        //panel2.setBounds(50,50, 500,400);
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,50));
        this.adminFrame.add(southPanel, BorderLayout.SOUTH);

        subSouthPanel = new JPanel();
        //panel4.setBounds(50,50, 500,400);
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new FlowLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,50));
        subSouthPanel.add(createButton(createButton));
        subSouthPanel.add(new JLabel());
        this.southPanel.add(subSouthPanel, BorderLayout.EAST);


        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridLayout(0,7));
        centerPanel.setPreferredSize(new Dimension(300,300));
        this.adminFrame.add(centerPanel, BorderLayout.CENTER);

        //centerPanel.add(createLogPanel(new JPanel(), 200, 70, "Username:"), BorderLayout.NORTH);
        //centerPanel.add(createLogPanel(new JPanel(), 200, 0, "Password:"), BorderLayout.CENTER);
        //centerPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);


        westPanel = new JPanel();
        // panel3.setBounds(50,50, 500,400);
        westPanel.setBackground(new Color(100,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.adminFrame.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(100,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(200,100));
        //eastPanel.add(createLogPanelInput(new JPanel(), 100, 70, "Username:"), BorderLayout.NORTH);
        //eastPanel.add(createLogPanelPassInput(new JPanel(), 100, 0, "Password:"), BorderLayout.CENTER);
        //eastPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);
        this.adminFrame.add(eastPanel, BorderLayout.EAST);
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
        button.setText("Submit");
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100,30));
        return button;
    }

    public void createAdmin(Administrator admin){
        HibernateSupport.beginTransaction();
        admin.saveToDB();
        HibernateSupport.commitTransaction();
    }

    public void createAssist(){

    }

    public void createStud(){

    }


    public JButton getCreateButton() {
        return createButton;
    }


}
