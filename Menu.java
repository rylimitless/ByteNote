import javax.swing.*;
import java.awt.*;

public class Menu{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File    ");
    private JMenu editMenu = new JMenu("Edit    ");
    private JMenu viewMenu = new JMenu("View    ");
    private JMenu helpMenu = new JMenu("Help    ");

    
    public Menu(){

        // menuBar.setLayout(new );
        createFileMenu();
        createEditMenu();
        createViewMenu();
        createHelpMenu();
    }

    private void createFileMenu(){

        // final JMenuItem newFile = new JMenuItem("New");
        final  JMenuItem newNote = new JMenuItem("New Note");
        final  JMenuItem openNote = new JMenuItem("Open Note ");
        final JMenuItem  openFolder = new JMenuItem("Open Folder");
        final JMenuItem  closeFolder = new JMenuItem("Close Folder");
        final JMenuItem  deleteNote = new JMenuItem("Delete Note");

        final  JMenuItem saveFile = new JMenuItem("Save");
        
        fileMenu.add(newNote);
        fileMenu.addSeparator();

        fileMenu.add(openNote);
        fileMenu.addSeparator();

        fileMenu.add(saveFile);
        fileMenu.addSeparator();

        fileMenu.add(deleteNote);
        fileMenu.addSeparator();

        fileMenu.add(openFolder);
        fileMenu.addSeparator();

        fileMenu.add(closeFolder);

        menuBar.add(fileMenu);
    }

    private void createEditMenu(){

        final JMenuItem cut = new JMenuItem("Cut");
        final JMenuItem copy = new JMenuItem("Copy");
        final JMenuItem paste = new JMenuItem("Paste");
        final JMenuItem undo  = new JMenuItem("Undo");
        final JMenuItem redo = new JMenuItem("Redo");

        editMenu.add(undo);
        editMenu.addSeparator();

        editMenu.add(redo);
        editMenu.addSeparator();

        editMenu.add(cut);
        editMenu.addSeparator();

        editMenu.add(copy);
        editMenu.addSeparator();

        editMenu.add(paste);
        
        menuBar.add(editMenu);

    }

    private void createViewMenu(){

        menuBar.add(viewMenu);
    }

    private void createHelpMenu(){

        menuBar.add(helpMenu);

    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

}

