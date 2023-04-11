import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.UIManager;

public class Home extends JFrame{

    private Menu menuBar;
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Card> card = new ArrayList<>();

    private Views view;


    public Home(){
        super("ByteNote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
        setMinimumSize(new Dimension(800, 500));
        setSize(800, 500);
        view = new Views(this);
     
        FileOP file = new FileOP();
        file.readFile(notes,card);
        view.addCards(card);
        menuBar = new Menu();
   
        //Adding actions

        AddFileActions();
        AddViewActions();

        setJMenuBar(menuBar.getMenuBar());
        setLayout(new FlowLayout());
        setContentPane(view);
        setVisible(true);

    }
    
    public static void main(String[] args){
        Home HomeScreen = new Home();
    }


    public void AddFileActions(){

        FileItemAction actions = new FileItemAction(this);
        getMenuItem(0, 0).addActionListener(actions);

        CloseNoteAction closeNote = new CloseNoteAction(this);
        getMenuItem(0,4).addActionListener(closeNote);

        SaveButtonAction saveNote = new SaveButtonAction(this);
        getMenuItem(0,2).addActionListener(saveNote);

        DeleteNoteAction deleteNote = new DeleteNoteAction(card, this);
        getMenuItem(0, 6).addActionListener(deleteNote);
    }

    public void AddViewActions(){
        // ViewItemAction actions = new ViewItemAction(this, menuBar.getMenuBar().getMenu(1));
        // ((JMenuItem)
        // menuBar.getMenuBar().getMenu(1).getMenuComponent(0)).addActionListener(actions);
        SortByNameButtonAction sortByName = new SortByNameButtonAction(this);
        getMenuItem(2,2).addActionListener(sortByName);

        SortByNameDesc sortByNameDesc = new SortByNameDesc(this);
        getMenuItem(2,4).addActionListener(sortByNameDesc);

        ToggleView toggleView = new ToggleView(this);
        getMenuItem(2,0).addActionListener(toggleView);
        //Dark Mode 
        getMenuItem(2, 6).addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    view.repaint();
                } catch (Exception ex) {

                }
            }
        });
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

    public ArrayList<Card> getCard(){
        return card;
    }
}