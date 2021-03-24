import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Image;

public class MyFrame extends JFrame{

  public void MyFrame(){

   JLabel title = new JLabel();                       //this intilizes the text & should put the text on the GUI
   ImageIcon Fileimg = new ImageIcon("filePhoto.png");//putting a photo onto the GUI
   title.setText("File organizer");                   //trying to put text on the GUI

   Image smallerFileImg = Fileimg.getImage();                                                       //getting the folder image and turning it into an image to scale it down
   Image smallingFileimg = smallerFileImg.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); //this is what scales the image down (x, y, method to scale it down)
   Fileimg = new ImageIcon(smallingFileimg);                                                        //putting the smaller image into the main file image


   MyFrame Frame = new MyFrame();

   Frame.setLayout(null);
   JPanel shrinkPhoto = new JPanel();                  //These 3 lines of code make the new panel
   shrinkPhoto.setBackground(new Color(199, 149, 168));//color of the //150, 200, 181
   shrinkPhoto.setBounds(0, 0, 800, 250);              //puts the panel on the upper left of the GUI with a size of 250x250

   JLabel folderPNG = new JLabel();
   folderPNG.setIcon(Fileimg);

   ImageIcon geneTree = new ImageIcon("genealogy.png"); //photo for the thing in the corner
   Frame.setTitle("Forginizer");                        // just the place holder name cause I thought it was funny
   Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This makes sure the when you click the X on the GUI it closes
   Frame.setSize(800, 920);                             //the resolution of the GUI
  // Frame.setVisible(true);                              //This just makes sure the GUI is visible
   Frame.setIconImage(geneTree.getImage());             //this is what puts the photo in the corner of the GUI
   Frame.getContentPane().setBackground(new Color(150, 200, 181));//150, 200, 181[also the color of the GUI]
   Frame.add(title);                                    //trying to add text onto the GUI
   title.setForeground(new Color(0, 0, 0));             //color font
   title.setHorizontalTextPosition(JLabel.CENTER);


   Frame.add(shrinkPhoto);// adds the panel to the GUI to put the file folder.png onto the panel to make it smaller
   shrinkPhoto.add(folderPNG);// the photo folder.png is added on the panel as if the panel is its own GUI


   Frame.setVisible(true);                              //This just makes sure the GUI is visible

 }
}
