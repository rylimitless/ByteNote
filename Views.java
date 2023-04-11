import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Views extends JPanel{
    
    private Home frame;
    private ArrayList<Card> cards;
    private String layout="flow";

    public Views(Home frame){
        this.frame = frame;
        cards = new ArrayList<>();
        render();
    }

    private void render(){

        setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        setVisible(true);


        for(Card card: cards){
            add(card);
          }
  
        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setVisible(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.pack();

    }

    public void addCards(ArrayList<Card> cards){
        for(Card card:cards){
            card.getButton().addActionListener(new CardAction(frame.getNotes(), card, frame));
            add(card);
        }
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public String getCLayout(){
        return layout;
    }

    public void setCLayout(String layout){
        this.layout = layout;
    }
}


