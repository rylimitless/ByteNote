import javax.swing.*;
import java.awt.*;

public class Note extends JTextPane{

    private String name;
    private String fileLocation;
    private Date dateCreated;
    private JTextPane notePane;
    private JScrollPane scrollPane;
    

    public Note () {
        dateCreated = new Date();
        name = JOptionPane.showInputDialog(null, "Name");
    }

    public String getName(){
        return name;
    }

    public void render(){
        setMinimumSize(new Dimension(600, 500));
        setSize(800, 500);
        setVisible(true);
    }

}