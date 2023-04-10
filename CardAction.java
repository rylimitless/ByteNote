import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class CardAction implements ActionListener{

    private Home home;
    private Card card;
    private ArrayList<Note> notes;

    public CardAction (ArrayList<Note> notes, Card card, Home home){
        this.card = card;
        this.notes = notes;
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){
        for(Note note: notes){
            if(note!=null && note.getName()!=null){
                if(note.getName().equals(card.getName())){
    
                    note.render();
                
                    home.setContentPane(note.getContentPane());
                    home.pack();
                }
            }
            
        }

    }

}