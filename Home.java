import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Home extends JFrame{

    private Menu menuBar;
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Card> card = new ArrayList<>();

    private NoteList noteList;
    private Views view;


    public Home(){
        super("ByteNote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));
        setSize(800, 500);
        view = new Views(this);
     
        FileOP file = new FileOP();
        file.readFile(notes,card);
        view.addCards(card);
        menuBar = new Menu();
        this.noteList = new NoteList();
        AddFileActions();
        setJMenuBar(menuBar.getMenuBar());
        setLayout(new FlowLayout());
        setContentPane(view);
        setVisible(true);

    }
    
    public static void main(String[] args){
        Home HomeScreen = new Home();
        // sSystem.out.println(HomeScreen.getNotes().get(0).getNoteText()+"\t" + HomeScreen.getNotes().get(0).getName());
    }



    //this edit method hould look like this, 
    // and be called from the home constructor.

    
    public void AddFileActions(){

        // this part of the code is for the File Menu, it adds the action listener to the menu items
        // notice how the file menu part is getMenu(0) , for edit it would be getMenu(1) , and notice how the menu items are
        // getComponent(0) , getComponent(2) and 6 , it's because they count by two , startting from 0

        FileItemAction actions = new FileItemAction(this, getMenuItem(0, 0));
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(0)).addActionListener(actions);

        CloseNoteAction closeNote = new CloseNoteAction(this);
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(6)).addActionListener(closeNote);

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

    public Views getView(){
        return view;
    }
}