import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;


public class DeleteNoteAction implements ActionListener{

    private Home home;
    private ArrayList<Note> notes;
    private ArrayList<Card> cards;
    private String noteToDelete;
    private FileOP fileOp;

    public DeleteNoteAction (ArrayList<Card> cards, Home home){
        // this.note = note;
        this.notes = home.getNotes();
        this.cards = cards;
        this.home = home;
        fileOp = new FileOP();

        // noteList = new JComboBox<>(notes.toArray(new String[0]));

    }

    public void actionPerformed(ActionEvent e){
        noteToDelete =JOptionPane.showInputDialog("", "Enter Note Name:");
        for(Note n: notes){
            if(n!=null && n.getName()!=null){
                if(n.getName().equals(noteToDelete)){
                    notes.remove(n);
                    fileOp.deleteFile(noteToDelete);

                    break;
                }
            }
        }
        for(Card c: cards){
            if(c!=null && c.getName()!=null){
                if(c.getName().equals(noteToDelete)){
                    cards.remove(c);
                    break;
                }
            }
        }
        home.getView().removeAll();
        home.getView().addCards(home.getCard());
        home.setContentPane(home.getView());
        home.pack();
    }

}