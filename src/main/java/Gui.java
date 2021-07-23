import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Gui{

    private JFrame login;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel subSouthPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel subCenterPanel;
    private JTextField user = new JTextField("Enter Username");

    public Gui(){
        createFrame(600, 600);
        createPanel();

    }

    public void createFrame(int  width, int height){
        this.login = new JFrame();
        this.login.getContentPane().setBackground(new Color(200,100,200));
        this.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.login.setSize(width, height);
        this.login.setVisible(true);
        this.login.setResizable(false);
        this.login.setLocationRelativeTo(null);
        this.login.setLayout(new BorderLayout());
    }


    public void createPanel(){
        northPanel = new JPanel();
        //panel1.setBounds(50,50, 500,400);
        northPanel.setBackground(new Color(200,200,200));
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,100));
        northPanel.add(createHeaderLabel(new JLabel(), "Timetable Master 3000", 60), BorderLayout.CENTER);
        this.login.add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        //panel2.setBounds(50,50, 500,400);
        southPanel.setBackground(new Color(200,200,200));
        southPanel.setLayout(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(200,100));
        this.login.add(southPanel, BorderLayout.SOUTH);

        subSouthPanel = new JPanel();
        //panel4.setBounds(50,50, 500,400);
        subSouthPanel.setBackground(new Color(200,200,200));
        subSouthPanel.setLayout(new BorderLayout());
        subSouthPanel.setPreferredSize(new Dimension(150,100));
        subSouthPanel.add(createButton(new JButton()), BorderLayout.NORTH);
        subSouthPanel.add(new JLabel());
        this.southPanel.add(subSouthPanel, BorderLayout.EAST);


        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(100,0));
        centerPanel.add(createLogPanel(new JPanel(), 200, 100, "Username:"), BorderLayout.NORTH);
        centerPanel.add(createLogPanel(new JPanel(), 200, 100, "E-Mail:"), BorderLayout.CENTER);
        centerPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);
        this.login.add(centerPanel, BorderLayout.CENTER);


        westPanel = new JPanel();
        // panel3.setBounds(50,50, 500,400);
        westPanel.setBackground(new Color(200,200,200));
        westPanel.setLayout(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(200,100));
        this.login.add(westPanel, BorderLayout.WEST);


        eastPanel = new JPanel();
        eastPanel.setBackground(new Color(200,200,200));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(200,100));
        eastPanel.add(createLogPanelInput(new JPanel(), 200, 100, "Username:"), BorderLayout.NORTH);
        eastPanel.add(createLogPanelInput(new JPanel(), 200, 100, "E-Mail:"), BorderLayout.CENTER);
        eastPanel.add(createLogPanel(new JPanel(), 200, 200, ""), BorderLayout.SOUTH);
        this.login.add(eastPanel, BorderLayout.EAST);
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

    public JTextField createTextField(JTextField text){
        text.setText("Hallo");
        text.setBackground(Color.YELLOW);
        //text.setPreferredSize(new Dimension(10, 2));
        return text;
    }

    /*public JPanel createTextLinesUser(JPanel panel, int x, int y, int width, int height){
        panel.setBounds(x, y, width, height);
        panel.add(createTextField(this.user, 200, 25));
        return panel;
    }*/

    public JPanel createPanel(JPanel panel, int width, int height){
        panel.setBackground(new Color(200,200,200));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(width,height));
        return panel;
    }


    public JPanel createLogPanel(JPanel panel, int width, int height, String usage){
        panel.setBackground(new Color(200,200,200));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(width,height));
        panel.add(new JLabel(usage), BorderLayout.SOUTH);
        return panel;
    }

    public JPanel createLogPanelInput(JPanel panel, int width, int height, String usage){
        panel.setBackground(new Color(200,200,200));
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(width,height));
        panel.add(new JTextField(), BorderLayout.SOUTH);
        return panel;
    }

    public JButton createButton(JButton button){
        button.setText("Next");
        button.setFocusable(false);
        return button;
    }


}
