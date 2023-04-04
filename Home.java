import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector.*;

public class Home extends JFrame{

    private Menu menuBar;
    private ArrayList<Note> notes = new ArrayList<>();
    private Deque<Note> prevNotes = new LinkedList<>();
    private ArrayList<Page> prevPages;
    private NoteList noteList;

    public Home(Home home , NoteList noteList){
        super("ByteNote");
        setMinimumSize(new Dimension(800, 500));
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new Menu();
        this.noteList = noteList;
        AddFileActions();
        setJMenuBar(menuBar.getMenuBar());
        setLayout(new FlowLayout());
        setBackground(Color.green);
        setVisible(true);
    }
    
    public static void main(String[] args){
        NoteList noteList = new NoteList();
        Home HomeScreen = new Home(null, noteList);
    }

    public void run(){
        Home home = new Home(this,null);
    }

    public void AddFileActions(){
        FileItemAction actions = new FileItemAction(this, menuBar.getMenuBar().getMenu(0));
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(0)).addActionListener(actions);

        // CloseNoteAction closeNote = new CloseNoteAction(this, menuBar.getMenuBar().getMenu(0));
        // ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(2)).addActionListener(closeNote);

        SaveButtonAction saveNote = new SaveButtonAction(this, menuBar.getMenuBar().getMenu(0));
        // ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(1)).addActionListener(saveNote);
    }

    public void AddViewActions(){
        // ViewItemAction actions = new ViewItemAction(this, menuBar.getMenuBar().getMenu(1));
        //((JMenuItem) menuBar.getMenuBar().getMenu(1).getMenuComponent(0)).addActionListener(actions);
    }

    public NoteList getNoteList(){
        return noteList;
    }

    public JMenuItem getMenuItem(int menu, int item){
        return (JMenuItem) menuBar.getMenuBar().getMenu(menu).getMenuComponent(item);
    }
    
}