import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Card extends JPanel implements ActionListener{
    
    public Card(String name){

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100,100));
        setBackground(Color.blue);
        setOpaque(true);
        JButton button = new JButton(name);
        add(button, BorderLayout.CENTER);
        button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Hello");
    }
}
