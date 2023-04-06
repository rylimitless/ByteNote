import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.JScrollPane;


public class Views extends JPanel{
    
    private JFrame frame;
    private ArrayList<Card> cards;

    public Views(JFrame frame){
        this.frame = frame;
        cards = new ArrayList<>();
        render();
    }

    private void render(){
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        for(Card card: cards){
            panel.add(card);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        panel.setVisible(true);
        // scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // scrollPane.setHorizontalScrollBar(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);
        frame.pack();
    }

    public void addCard(Card card){
        cards.add(card);
    }

}


