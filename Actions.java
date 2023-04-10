import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

/**
 * This actions file is used to handle all the actions in the application
 * spend some time to understand how it works
 * so you can impoement the edit options.
 */

class FileItemAction implements ActionListener{

    private Home home;
    private ArrayList<Note> notesList;

    public FileItemAction (Home home){
        this.home = home;
        this.notesList = home.getNotes();
    
    }

    public void actionPerformed(ActionEvent e){
       
        Note note = new Note();
        note.setName(JOptionPane.showInputDialog("Enter Note Name: "));
        if(note.getName()!=null){
            notesList.add(note);
            note.render();
            home.getContentPane().removeAll();
            home.setContentPane(note.getContentPane());
        }
        home.pack();
    }

}

class SaveButtonAction implements ActionListener{

    private FileOP file = new FileOP();
    private Home home;

    public SaveButtonAction (Home home){
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){

            for(Note note: home.getNotes()){
                home.getNotes().add(note);
                file.saveFile(note.getName(),note.getNoteText());
            }
            
        home.setContentPane(home.getView());
        home.getView().repaint();
        home.pack();

    }

}


class CloseNoteAction implements ActionListener{

    private Home frame;

    public CloseNoteAction (Home frame){
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e){
        frame.setContentPane(frame.getView());
        frame.getView().repaint();
        frame.pack();
    }

}

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

class DeleteNoteAction implements ActionListener{

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

class sortByName implements Comparator<Card>{

    public int compare(Card a, Card b){
        return a.getName().compareTo(b.getName());
    }

}

// class sortByDate implements Comparator<Note>{

//     public int compare(Note a, Note b){
//         return a.getDate().compareTo(b.getDate());
//     }

// }

class SortByNameButtonAction implements ActionListener{

    private Home home;

    public SortByNameButtonAction(Home home){
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){
        Collections.sort(home.getCard(), new sortByName());
        home.getView().removeAll();
        home.getView().addCards(home.getCard());
        home.setContentPane(home.getView());
        home.pack();
    }
}