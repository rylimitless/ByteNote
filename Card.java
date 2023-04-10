import java.awt.*;
import javax.swing.*;

public class Card extends JPanel{
    
    private String name;
    private JButton button;

    public Card(String name){
        this.name = name;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100,100));
        setBackground(Color.blue);
        setOpaque(true);
        button = new JButton(name);
        button.setVisible(true);
    

        // Set panel's background color
        setBackground(new Color(255, 255, 255));

        // Set panel's border
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createLoweredBevelBorder()));
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
