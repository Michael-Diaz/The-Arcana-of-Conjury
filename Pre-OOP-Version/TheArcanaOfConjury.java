import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TheArcanaOfConjury {
   final static String PASSIVE = "Listen";
   final static String CHOICE = "Choose";
   final static String BATTLE = "Battle";
   final static int extraWindowWidth = 100;
   
   public void addComponentToPane(Container pane) {
      JTabbedPane tabbedPane = new JTabbedPane();
      
      JPanel listen = new JPanel() {
         public Dimension getPrefferedSize() {
            Dimension size = super.getPreferredSize();
            size.width += extraWindowWidth;
            return size;
         }
      };
      
      JPanel choose = new JPanel();
      
      JButton option1 = new JButton("Option 1");
      JButton option2 = new JButton("Option 2");
      JButton option3 = new JButton("Option 3");
      JButton option4 = new JButton("Option 4");
      JButton option5 = new JButton("Option 5");
      JButton option6 = new JButton("Option 6");
      JTextField speak = new JTextField("Speak your mind!", 20);
      JButton enter = new JButton("Enter");
      
      choose.add(option1);
      choose.add(option2);
      choose.add(option3);
      choose.add(option4);
      choose.add(option5);
      choose.add(option6);
      choose.add(speak);
      choose.add(enter);
      
      JPanel battle = new JPanel();
      
      //JComboBox 
      
      tabbedPane.addTab(PASSIVE, listen);
      tabbedPane.addTab(CHOICE, choose);
      tabbedPane.addTab(BATTLE, battle);
      
      pane.add(tabbedPane, BorderLayout.CENTER);
   }
   
   
   
   public static void createAndShowGUI() {
      JFrame frame = new JFrame("The Arcana of Conjury");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      TheArcanaOfConjury game = new TheArcanaOfConjury();
      game.addComponentToPane(frame.getContentPane());
      
      frame.pack();
      frame.setVisible(true);
   }
}