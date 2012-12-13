import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutEx implements ItemListener {
  JPanel cards; //a panel that uses CardLayout
  final static String BUTTONPANEL = "Card with JButtons";
  final static String TEXTPANEL = "Card with JTextField";
    
  public void addComponentToPane(Container pane) {
    //Put JComboBox in JPanel for better look.
    JPanel comboBoxPane = new JPanel();                  //use FlowLayout
    String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
    JComboBox cb = new JComboBox(comboBoxItems);
    cb.setEditable(false);
    cb.addItemListener(this);
    comboBoxPane.add(cb);
        
    //Create "cards".
    JPanel card1 = new JPanel();
    card1.add(new JButton("Button 1"));
    card1.add(new JButton("Button 2"));
    card1.add(new JButton("Button 3"));
        
    JPanel card2 = new JPanel();
    card2.add(new JTextField("TextField", 20));
        
    //Create panel containing "cards".
    cards = new JPanel(new CardLayout());
    cards.add(card1, BUTTONPANEL);
    cards.add(card2, TEXTPANEL);
        
    pane.add(comboBoxPane, BorderLayout.PAGE_START);
    pane.add(cards, BorderLayout.CENTER);
  }
    
    public void itemStateChanged(ItemEvent evt) {
      CardLayout cl = (CardLayout)(cards.getLayout());
      cl.show(cards, (String)evt.getItem());
    }
    
    /**
     * Create GUI; show it.  
     * method should be invoked from 
     * event dispatch thread.
     */
    private static void createandShowGUI() {
      //Create/set up the window.
      JFrame frame = new JFrame("CardLayoutDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //Create/set-up content pane.
      CardLayoutEx = new CardLayoutEx();
      demo.addComponentToPane(frame.getContentPane());
        
      //Display window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        try {
            
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule job for event dispatch thread:
        //creat/show app's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
