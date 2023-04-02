import javax.swing.*;
import java.awt.*;

public class Home extends JFrame{
    
    public Home(){
        super("ByteNote");
        setMinimumSize(new Dimension(600, 400));
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Menu menuBar = new Menu();
        setJMenuBar(menuBar.getMenuBar());
        setLayout(new FlowLayout());
        setVisible(true);
    }
    
    public static void main(String[] args){
        Home HomeScreen = new Home();
    }
}