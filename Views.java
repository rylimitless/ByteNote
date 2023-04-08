import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Views extends JPanel{
    
    private Home frame;
    private ArrayList<Card> cards;

    public Views(Home frame){
        this.frame = frame;
        cards = new ArrayList<>();
        render();
    }

    private void render(){

        // add(new JLabel("Notes"), BorderLayout.SOUTH);
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setVisible(true);


        for(Card card: cards){
            add(card);
          }
  
        JScrollPane scrollPane = new JScrollPane(this);
        // panel.setVisible(true);
        scrollPane.setVisible(true);
        // add(panel);
        // scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // frame.add(scrollPane);
        frame.pack();

    }

    public void addCards(ArrayList<Card> cards){
        for(Card card:cards){
            card.getButton().addActionListener(new CardAction(frame.getNotes(), card, frame));
            add(card);
        }
    }

}


