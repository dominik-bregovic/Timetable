import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    private JFrame login;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JTextField user = new JTextField();

    public Gui(){
        createFrame(700, 700);
        createPanel();

    }

    public void createFrame(int  width, int height){
        this.login = new JFrame();
        this.login.getContentPane().setBackground(new Color(200,200,200));
        this.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.login.setSize(width, height);
        this.login.setVisible(true);
        this.login.setResizable(false);
        this.login.setLocationRelativeTo(null);
        this.login.setLayout(new BorderLayout());
    }


    public void createPanel(){
        panel1 = new JPanel();
        panel1.setBounds(50,50, 500,400);
        panel1.setBackground(new Color(100,100,100));
        panel1.setLayout(new BorderLayout());
        panel1.setPreferredSize(new Dimension(100,100));
        this.login.add(panel1, BorderLayout.NORTH);
        panel1.add(createHeaderLabel(new JLabel(), "Timetable Master 3000:", 60), BorderLayout.CENTER);

        panel2 = new JPanel();
        panel2.setBounds(50,50, 500,400);
        panel2.setBackground(Color.red);
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(100,100));
        this.login.add(panel2, BorderLayout.SOUTH);

        panel3 = new JPanel();
        panel3.setBounds(50,50, 500,400);
        panel3.setBackground(Color.blue);
        panel3.setLayout(new BorderLayout());
        panel3.setPreferredSize(new Dimension(100,100));
        this.login.add(panel3, BorderLayout.WEST);

        panel4 = new JPanel();
        panel4.setBounds(50,50, 500,400);
        panel4.setBackground(Color.BLACK);
        panel4.setLayout(new BorderLayout());
        panel4.setPreferredSize(new Dimension(100,100));
        panel4.add(createButton(new JButton()), BorderLayout.NORTH);
        this.panel2.add(panel4, BorderLayout.EAST);

        panel5 = new JPanel();
        panel5.setBounds(50,50, 500,400);
        panel5.setBackground(Color.WHITE);
        panel5.setLayout(new BorderLayout());
        panel5.setPreferredSize(new Dimension(100,100));
        this.login.add(panel5, BorderLayout.CENTER);

    }

    public JLabel createHeaderLabel(JLabel label, String text, int fontsize){

        label.setText(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, fontsize));
        //label.setBackground(Color.WHITE); //set Background color
        label.setOpaque(true);     //with this Background pixels are changed
        //label.setVerticalTextPosition(JLabel.CENTER);            //positioning text to image
        //label.setHorizontalTextPosition(JLabel.CENTER);       //positioning text to image
        //label.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        //label.setHorizontalAlignment(JLabel.LEFT);
        //label.setBounds(0,0,750,100);       //set label within frame

        return label;
    }

    public JTextField createTextField(JTextField text, int width, int height){
        text.setText("Hallo");
        text.setBackground(Color.black);
        text.setPreferredSize(new Dimension(width, height));
        return text;
    }

    public JPanel createTextLinesUser(JPanel panel, int x, int y, int width, int height){
        panel.setBounds(x, y, width, height);
        panel.add(createTextField(this.user, 200, 25));
        return panel;
    }

    public JPanel createHeadLines(JPanel panel, int x, int y, int width, int height, String text){
        panel.setBounds(x, y, width, height);
        panel.add(createHeaderLabel(new JLabel(),text, 20));
        return panel;
    }

    public JButton createButton(JButton button){
        button.setText("Next");
        button.setFocusable(false);
        button.setLayout(new BorderLayout());
        button.setVerticalAlignment(JLabel.CENTER); // set place of label only by BorderLayout
        button.setHorizontalAlignment(JLabel.CENTER);
        return button;
    }


}
