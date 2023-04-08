import java.awt.*;
import javax.swing.*;

public class Card extends JPanel{
    
    private String name;
    private JButton button;

    public Card(String name){
        this.name = name;
        // add(new JLabel("Hey"));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100,100));
        setBackground(Color.blue);
        setOpaque(true);
        button = new JButton(name);
        button.setVisible(true);
        add(button, BorderLayout.CENTER);
        setVisible(true);
    }


    public String getName(){
        return name;
    }

    public JButton getButton(){
        return button;
    }
}
