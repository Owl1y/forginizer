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
import java.util.Arrays;
import static java.nio.file.StandardCopyOption.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

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
      // fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

      fileChooser.setCurrentDirectory(new File("/home/a"));
      fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      int response = fileChooser.showSaveDialog(null); // select file to save

      if (response == JFileChooser.APPROVE_OPTION) {
        File directoryPath = new File(fileChooser.getSelectedFile().getAbsolutePath()); // this saves the file and shows
                                                                                        // the path to the file >:)
        String StringPath = directoryPath.toString();
        Path parentOfFile = Paths.get(StringPath);  //this is to get the directory path to put the folders in the directory instead of like on like some random other folder
        String stringyFile = parentOfFile.toString();

        // List of all files and directories
        File filesList[] = directoryPath.listFiles();

        File vidDir = new File(stringyFile + "/vidDir");
        File photoDir = new File(stringyFile + "/photoDir");
        File windowsDir = new File(stringyFile + "/windowsDir");
        File archivedDir = new File(stringyFile + "/archivedDir");
        File docsDir = new File(stringyFile + "/docsDir");

        for (File file : filesList) {
          // convert file name into string
          String fileName = file.toString();

          int index = fileName.lastIndexOf('.');
          if (index > 0) {
            String extension = fileName.substring(index + 1);
            System.out.println(fileName + "\t" + extension);
           // System.out.println(fileName);
            //Path src = Paths.get(fileName);


            if (extension.equals("dll") || extension.equals("exe") || extension.equals("msi")) {
             if (!windowsDir.exists()) {
                  windowsDir.mkdirs();
                 System.out.println("THIS SHOULD NOT RUN AT ALL SINCE THE WINDOWS DIR HAS ALREADY BEEN CREATED I JUST NEED MY FILES TO GO INTO HERE");
              } else {
                try {
                  //Path target = Paths.get(windowsDir.getPath());
                  //Files.move(src, target, REPLACE_EXISTING);
                 // boolean success = file.renameTo(new File(windowsDir + "/" + file));
                 File a = new File(fileName);
                 a.renameTo(new File(windowsDir + "/new" + a.getName()));
                 a.delete();

                  System.out.println("the file was moved bro to the other file and it should be good now!");
                } catch (Exception ex) {
                  System.out.println("===TARGET FILE ALREADY EXISTS===");
                }
              }
            }

            if (extension.equals("jpg") || extension.equals("png")) {
             if (!photoDir.exists()) {
                  photoDir.mkdirs();
                 System.out.println("THIS SHOULD NOT RUN AT ALL SINCE THE PHOTO DIR HAS ALREADY BEEN CREATED I JUST NEED MY FILES TO GO INTO HERE");
              } else {
                try {
                  File b = new File(fileName);
                  b.renameTo(new File(photoDir + "/new" + b.getName()));
                  b.delete();
                  System.out.println("the file was moved bro to the other file and it should be good now!");
                } catch (Exception ex) {
                  System.out.println("===TARGET FILE ALREADY EXISTS===");
                }
              }
            }

            if (extension.equals("webm") || extension.equals("mp4") || extension.equals("mkv")) {
             if (!vidDir.exists()) {
                  vidDir.mkdirs();
                 System.out.println("THIS SHOULD NOT RUN AT ALL SINCE THE WINDOWS DIR HAS ALREADY BEEN CREATED I JUST NEED MY FILES TO GO INTO HERE");
              } else {
                try {
                 File c = new File(fileName);
                 c.renameTo(new File(vidDir + "/new" + c.getName()));
                 c.delete();
                  System.out.println("the file was moved bro to the other file and it should be good now!");
                } catch (Exception ex) {
                  System.out.println("===TARGET FILE ALREADY EXISTS===");
                }
              }
            }

            if (extension.equals("zip") || extension.equals("rar") || extension.equals("7z") || extension.equals("tar")) {
             if (!archivedDir.exists()) {
                  archivedDir.mkdirs();
                 System.out.println("THIS SHOULD NOT RUN AT ALL SINCE THE WINDOWS DIR HAS ALREADY BEEN CREATED I JUST NEED MY FILES TO GO INTO HERE");
              } else {
                try {
                 File d = new File(fileName);
                 d.renameTo(new File(archivedDir + "/new" + d.getName()));
                 d.delete();
                  System.out.println("the file was moved bro to the other file and it should be good now!");
                } catch (Exception ex) {
                  System.out.println("===TARGET FILE ALREADY EXISTS===");
                }
              }
            }

            if (extension.equals("docx") || extension.equals("pdf") || extension.equals("djvu")) {
             if (!docsDir.exists()) {
                  docsDir.mkdirs();
                 System.out.println("THIS SHOULD NOT RUN AT ALL SINCE THE WINDOWS DIR HAS ALREADY BEEN CREATED I JUST NEED MY FILES TO GO INTO HERE");
              } else {
                try {
                 File e = new File(fileName);
                 e.renameTo(new File(docsDir + "/new" + e.getName()));
                 e.delete();
                  System.out.println("the file was moved bro to the other file and it should be good now!");
                } catch (Exception ex) {
                  System.out.println("===TARGET FILE ALREADY EXISTS===");
                }
              }
            }

          }

        }

        System.out.println("----------------------------- " + filesList.length);

      }
    }
  }

}
