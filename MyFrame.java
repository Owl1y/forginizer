import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.JButton;

public class MyFrame extends JFrame implements ActionListener {

  public JButton button = new JButton("Select File"); // this should be the button that lets you click on the button to
                                                      // get the file selector GUI

  public void MyFrame() {

    ImageIcon Fileimg = new ImageIcon("filePhoto.png"); // putting a photo onto the GUI

    Image smallerFileImg = Fileimg.getImage(); // getting the folder image and turning it into an image to scale it down
    Image smallingFileimg = smallerFileImg.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); // this is what
                                                                                                     // scales the image
                                                                                                     // down (x, y,
                                                                                                     // method to scale
                                                                                                     // it down)
    Fileimg = new ImageIcon(smallingFileimg); // putting the smaller image into the main file image

    MyFrame Frame = new MyFrame();

    Frame.setLayout(null);
    JPanel shrinkPhoto = new JPanel(); // These 3 lines of code make the new panel
    shrinkPhoto.setBackground(new Color(199, 149, 168)); // color of the //150, 200, 181
    shrinkPhoto.setBounds(0, 0, 800, 250); // puts the panel on the upper left of the GUI with a size of 250x250

    JLabel folderPNG = new JLabel();
    folderPNG.setIcon(Fileimg); // makes the label object have a property of a photo which is the filePNG photo
    folderPNG.setText("File Organizer"); // puts the [title] next to the folder image for the title of the program

    ImageIcon geneTree = new ImageIcon("genealogy.png"); // photo for the thing in the corner
    Frame.setTitle("Forginizer"); // the name on the tab of the application
    Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This makes sure the when you click the X on the GUI it
                                                          // closes
    Frame.setSize(800, 920); // the resolution of the GUI
    Frame.setIconImage(geneTree.getImage()); // this is what puts the photo in the corner of the GUI
    Frame.getContentPane().setBackground(new Color(150, 200, 181)); // 150, 200, 181[also the color of the GUI]
    folderPNG.setForeground(new Color(150, 200, 181)); // color of the font {it was tile set font but im going to change
                                                       // it to folderPNG set font}

    button.addActionListener(this); // this makes the button have a reaction
    Frame.add(button); // adds the button to the frame
    this.pack(); // i have no idea what this does line of code does i just copied what the guy
                 // did in the video and it works
    button.setBounds(350, 400, 100, 50); // (x cord, y cord, width, height) for the button

    Frame.add(shrinkPhoto); // adds the panel to the GUI to put the file folder.png onto the panel to make
                            // it smaller
    shrinkPhoto.setLayout(null); // this is what let me put the folderPNG photo anywhere
    folderPNG.setBounds(-10, -10, 800, 250); // makes the label of the photo & text more organized
    shrinkPhoto.add(folderPNG); // the photo folder.png is added on the panel as if the panel is its own GUI
    folderPNG.setFont(new Font("Comonbo Sans", Font.PLAIN, 75)); // this set the text font,style,size in this one line
    folderPNG.setIconTextGap(-20); // this lowered the gap between the image of the folder and the text "File
                                   // organizer"

    button.addActionListener(this); // im like 85% sure this just listens to make sure when the button is pressed
    button.setVisible(true); // makes the button visible

    Frame.setVisible(true); // This just makes sure the GUI is visible
    Frame.setResizable(false); // makes sure you cant change the size of the GUI

  }

  @Override
  public void actionPerformed(ActionEvent press) {
    if (press.getSource() == button) {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File("/"));
      int response = fileChooser.showSaveDialog(null); // select file to save

      if (response == JFileChooser.APPROVE_OPTION) {
        File directoryPath = new File(fileChooser.getSelectedFile().getAbsolutePath()); // this saves the file and shows  the path to the file >:)
         //Creating a File object for directory
       //File directoryPath = directoryPath; //hold onto this cause it could be saucy
       //List of all files and directories
       File filesList[] = directoryPath.listFiles();
       for(File F: filesList){
        System.out.println(F);
       } 

       // File directoryPath = new File("D:\\ExampleDirectory");
        // List of all files and directories

      }
    }
  }
}
