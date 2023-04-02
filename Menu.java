import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenu viewMenu = new JMenu("View");
    private JMenu helpMenu = new JMenu("Help");

    JMenuItem newFile = new JMenuItem("New");
    
    public Menu(){
        createFileMenu();
    }

    private void createFileMenu(){

        final  JMenuItem newFile = new JMenuItem("New");
        final  JMenuItem openFile = new JMenuItem("Open");
        final  JMenuItem saveFile = new JMenuItem("Save");
        
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);


        menuBar.add(fileMenu);
    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

}


