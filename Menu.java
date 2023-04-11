import javax.swing.*;

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

        final JMenuItem newNote = new JMenuItem("New Note   Ctrl+N");
        final JMenuItem closeNote = new JMenuItem("Close Note");
        final JMenuItem  openFolder = new JMenuItem("Open Folder   Ctrl+O");
        final JMenuItem  closeFolder = new JMenuItem("Close Folder   Ctrl+W");
        final JMenuItem  deleteNote = new JMenuItem("Delete Note      Ctrl+D");
        final  JMenuItem saveFile = new JMenuItem("Save   Ctrl+S");
        
        fileMenu.add(newNote);
        fileMenu.addSeparator();

        fileMenu.add(saveFile);
        fileMenu.addSeparator();


        fileMenu.add(closeNote);
        fileMenu.addSeparator();

        

        fileMenu.add(deleteNote);
        fileMenu.addSeparator();

        fileMenu.add(openFolder);
        fileMenu.addSeparator();

        fileMenu.add(closeFolder);

        menuBar.add(fileMenu);
    }


    //This is the menu you'll be implementing functionality 
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

        final JMenuItem toggleView = new JMenuItem("Toggle View");
        final JMenuItem sortByName = new JMenuItem("Sort By Name Ascending");
        final JMenuItem sortByNameD = new JMenuItem("Sort By Name Descending");
        final JMenuItem darkMode = new JMenuItem("Change Theme");

        viewMenu.add(toggleView);
        viewMenu.addSeparator();

        viewMenu.add(sortByName);
        viewMenu.addSeparator();

        viewMenu.add(sortByNameD);
        viewMenu.addSeparator();

        viewMenu.add(darkMode);

        menuBar.add(viewMenu);
    }

    private void createHelpMenu(){

        JMenuItem help = new JMenuItem("Help");
        JMenuItem about = new JMenuItem("About");

        helpMenu.add(help);
        helpMenu.addSeparator();

        helpMenu.add(about);
        menuBar.add(helpMenu);

    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }


}