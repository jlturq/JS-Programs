import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonDemo extends JFrame implements ActionListener {
  // Declare a panel to display message
  private MessagePanel messagePanel;

  // Declare two buttons to move message left and right
  private JButton jbtLeft, jbtRight;

  private JTextField jtfNewMessage = new JTextField(8);
  private JComboBox jcboInterval = new JComboBox();
  private JRadioButton jrbRed = new JRadioButton("Red");
  private JRadioButton jrbGreen = new JRadioButton("Green");
  private JRadioButton jrbBlue = new JRadioButton("Blue");
  private JCheckBox jchkCentered = new JCheckBox("Center");
  private JCheckBox jchkBold = new JCheckBox("Bold");
  private JCheckBox jchkItalic = new JCheckBox("Italic");

  // Font name
  private String fontName = "SansSerif";

  // Font style
  private int fontStyle = Font.PLAIN;

  // Font Size
  private int fontSize = 14;

  /** Main method */
  public static void main(String[] args) {
    ButtonDemo frame = new ButtonDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 250);
    frame.setLocationRelativeTo(null); // Center frame
    frame.setVisible(true);
  }

  /** Default constructor */
  public ButtonDemo() {
    setTitle("User Interface Demo");

    // Create a MessagePanel instance; set colors
    messagePanel = new MessagePanel("Welcome to Java");
    messagePanel.setBackground(Color.white);

    // Create Panel jpButtons to hold two Buttons "<=" and "=>"
    JPanel jpButtons = new JPanel();
    jpButtons.setLayout(new FlowLayout());
    jpButtons.add(jbtLeft = new JButton());
    jpButtons.add(jbtRight = new JButton());

    // Set button text/mnemonics
    jbtLeft.setText("<=");
    jbtRight.setText("=>");

    jbtLeft.setMnemonic('L');
    jbtRight.setMnemonic('R');

    // Set icons
    // jbtLeft.setIcon(new ImageIcon("image/left.gif"));
    //jbtRight.setIcon(new ImageIcon("image/right.gif"));

    // Set toolTipText on "<=" and "=>" buttons
    jbtLeft.setToolTipText("Move message to left");
    jbtRight.setToolTipText("Move message to right");

    // Place panels in frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(jpButtons, BorderLayout.SOUTH);

    // Register listeners 
    jbtLeft.addActionListener(this);
    jbtRight.addActionListener(this);

    jpButtons.add(new JLabel("Enter a new message"));
    jpButtons.add(jtfNewMessage);

    jtfNewMessage.addActionListener(this);

    jpButtons.add(new JLabel("Select an interval"));
    jpButtons.add(jcboInterval);
    for(int interval = 5; interval <= 100; interval += 5)
      jcboInterval.addItem(interval + "");

    jcboInterval.addActionListener(this);

    /**
     * Add three radio buttons enabling user to select foreground
     * color for the message as Red, Green, and Blue.
     */

    JPanel panel = new JPanel();
    getContentPane().add(panel, BorderLayout.NORTH);

    panel.add(jrbRed);
    panel.add(jrbGreen);
    panel.add(jrbBlue);
    ButtonGroup btg = new ButtonGroup();
    btg.add(jrbRed);
    btg.add(jrbGreen);
    btg.add(jrbBlue);
    jrbRed.addActionListener(this);
    jrbGreen.addActionListener(this);
    jrbBlue.addActionListener(this);

    /**
     * Add three check boxes enabling user to center the message
     * and display it in italic or bold.
     */

    panel.add(jchkCentered);
    panel.add(jchkBold);
    panel.add(jchkItalic);
    jchkCentered.addActionListener(this);
    jchkBold.addActionListener(this);
    jchkItalic.addActionListener(this);

    /**
     * Add a border titled Message Panel on the message panel.
     */

    messagePanel.setBorder(new TitledBorder("Message Panel"));
    jpButtons.setBorder(new TitledBorder("South Panel"));
    panel.setBorder(new TitledBorder("North Panel"));

    this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  }

  /** Handle button events */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtLeft) {
      messagePanel.moveLeft();
      messagePanel.repaint();
    }
    else if (e.getSource() == jbtRight) {
      messagePanel.moveRight();
      messagePanel.repaint();
    }
    else if (e.getSource() == jtfNewMessage) {
      messagePanel.setMessage(jtfNewMessage.getText());
      messagePanel.repaint();
    }
    else if (e.getSource() == jcboInterval) {
      messagePanel.setInterval(
        Integer.parseInt((String)(jcboInterval.getSelectedItem())));
      messagePanel.repaint();
    }
    else if (e.getSource() == jrbRed) {
      messagePanel.setForeground(Color.red);
    }
    else if (e.getSource() == jrbGreen) {
      messagePanel.setForeground(Color.green);
    }
    else if (e.getSource() == jrbBlue) {
      messagePanel.setForeground(Color.blue);
    }
    else if (e.getSource() == jchkCentered) {
      if (jchkCentered.isSelected())
        messagePanel.setCentered(true);
      else
        messagePanel.setCentered(false);

      messagePanel.repaint();
    }
    else if ((e.getSource() == jchkBold) ||
             (e.getSource() == jchkItalic)) {
      fontStyle = Font.PLAIN;

      // Determine a font style
      if (jchkBold.isSelected())
        fontStyle = fontStyle + Font.BOLD;
      if (jchkItalic.isSelected())
        fontStyle = fontStyle + Font.ITALIC;

      // Set font for the message
      messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
    }
  }
}

