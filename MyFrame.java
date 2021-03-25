import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Font;

public class MyFrame extends JFrame{

  public void MyFrame(){

   //JLabel title = new JLabel();                       //this intilizes the text & should put the text on the GUI
   ImageIcon Fileimg = new ImageIcon("filePhoto.png");//putting a photo onto the GUI
   //title.setText("File organizer");                   //trying to put text on the GUI

   Image smallerFileImg = Fileimg.getImage();                                                       //getting the folder image and turning it into an image to scale it down
   Image smallingFileimg = smallerFileImg.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); //this is what scales the image down (x, y, method to scale it down)
   Fileimg = new ImageIcon(smallingFileimg);                                                        //putting the smaller image into the main file image


   MyFrame Frame = new MyFrame();

   Frame.setLayout(null);
   JPanel shrinkPhoto = new JPanel();                  //These 3 lines of code make the new panel
   shrinkPhoto.setBackground(new Color(199, 149, 168));//color of the //150, 200, 181
   shrinkPhoto.setBounds(0, 0, 800, 250);              //puts the panel on the upper left of the GUI with a size of 250x250

   JLabel folderPNG = new JLabel();
   folderPNG.setIcon(Fileimg);//makes the label object have a property of a photo which is the filePNG photo
   folderPNG.setText("File Organizer");//puts the [title] next to the folder image for the title of the program

   ImageIcon geneTree = new ImageIcon("genealogy.png"); //photo for the thing in the corner
   Frame.setTitle("Forginizer");                        // the name on the tab of the application
   Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This makes sure the when you click the X on the GUI it closes
   Frame.setSize(800, 920);                             //the resolution of the GUI
   Frame.setIconImage(geneTree.getImage());             //this is what puts the photo in the corner of the GUI
   Frame.getContentPane().setBackground(new Color(150, 200, 181));//150, 200, 181[also the color of the GUI]
   folderPNG.setForeground(new Color(150, 200, 181));             //color of the font {it was tile set font but im going to change it to folderPNG set font}
  // title.setFont(new Font("Times New Roman", Font.PLAIN,48)); //sets up title font and the style then the title size


   Frame.add(shrinkPhoto);// adds the panel to the GUI to put the file folder.png onto the panel to make it smaller
   shrinkPhoto.setLayout(null);
   folderPNG.setBounds(-10, -10, 800, 250);
   shrinkPhoto.add(folderPNG);// the photo folder.png is added on the panel as if the panel is its own GUI
   //shrinkPhoto.add(title); //puts the [title] next to the folder image for the title of the program
   folderPNG.setFont(new Font("Comonbo Sans", Font.PLAIN, 75));
   folderPNG.setIconTextGap(-20);

   Frame.setVisible(true);                              //This just makes sure the GUI is visible
   Frame.setResizable(false);
 }
}
