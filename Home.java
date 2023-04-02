import javax.swing.*;
import java.awt.*;

public class Home extends JFrame{

    private Menu menuBar;

    public Home(){
        super("ByteNote");
        setMinimumSize(new Dimension(800, 500));
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // super.setPostionRelativeTo(null);
        menuBar = new Menu();
        AddActions();
        setJMenuBar(menuBar.getMenuBar());
        setLayout(new FlowLayout());
        setVisible(true);
    }
    
    public static void main(String[] args){
        Home HomeScreen = new Home();
    }

    public void AddActions(){
        FileItemAction actions = new FileItemAction(this, menuBar.getMenuBar().getMenu(0));
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(0)).addActionListener(actions);

        CloseNoteAction closeNote = new CloseNoteAction(this, menuBar.getMenuBar().getMenu(0));
        ((JMenuItem) menuBar.getMenuBar().getMenu(0).getMenuComponent(2)).addActionListener(closeNote);
    }
}