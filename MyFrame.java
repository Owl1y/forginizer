import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;


public class MyFrame extends JFrame{

  public void MyFrame(){

   MyFrame Frame = new MyFrame();

   ImageIcon image = new ImageIcon("genealogy.png");
   Frame.setTitle("Verminator");
   Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Frame.setSize(800, 920);
   Frame.setVisible(true);
   Frame.setIconImage(image.getImage());
   Frame.getContentPane().setBackground(new Color(150, 200, 181));
 }
}
