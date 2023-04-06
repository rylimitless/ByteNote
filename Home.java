import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.io.*;

public class Home extends JFrame{

    private Menu menuBar;
    private ArrayList<Note> notes = new ArrayList<>();
    private Deque<Note> prevNotes = new LinkedList<>();
    private ArrayList<Page> prevPages;
    private NoteList noteList;
    private Views view;

    public Home(){
        super("ByteNote");
        setMinimumSize(new Dimension(800, 500));
        setSize(800, 500);
        view = new Views(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new Menu();
        this.noteList = new NoteList();
        AddFileActions();
        setJMenuBar(menuBar.getMenuBar());
        setLayout(new FlowLayout());
        setBackground(Color.green);
        setContentPane(view);
        setVisible(true);

    }
    
    public static void main(String[] args){
        Home HomeScreen = new Home();
    }



    public void AddFileActions(){
        FileItemAction actions = new FileItemAction(this, getMenuItem(0, 0));
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(0)).addActionListener(actions);

        // CloseNoteAction closeNote = new CloseNoteAction(this, menuBar.getMenuBar().getMenu(0));
        // ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(2)).addActionListener(closeNote);

        SaveButtonAction saveNote = new SaveButtonAction(this, menuBar.getMenuBar().getMenu(0));
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(2)).addActionListener(saveNote);
    }

    public void AddViewActions(){
        // ViewItemAction actions = new ViewItemAction(this, menuBar.getMenuBar().getMenu(1));
        // ((JMenuItem)
        // menuBar.getMenuBar().getMenu(1).getMenuComponent(0)).addActionListener(actions);
    }

    public NoteList getNoteList(){
        return noteList;
    }

    public JMenuItem getMenuItem(int menu, int item){
        return (JMenuItem) menuBar.getMenuBar().getMenu(menu).getMenuComponent(item);
    }

    public ArrayList<Note> getNotes(){
        return notes;
    }
    
    public void updateNotes(ArrayList<Note> noteL){
        notes = noteL;
    }
}