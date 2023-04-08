import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;


class FileItemAction implements ActionListener{

    private JFrame frame;
    private JMenuItem item;
    private Home home;
    private ArrayList<Note> notesList;

    public FileItemAction (Home home, JMenuItem item){
        this.item = item;
        item.addActionListener(this);
        this.home = home;
        this.notesList = home.getNotes();
    
    }

    public void actionPerformed(ActionEvent e){
       
        Note note = new Note();
        note.setName(JOptionPane.showInputDialog("Enter Note Name: "));
        if(note.getName()!=null){
            System.out.println(note.getName());
            notesList.add(note);
            note.render();
            home.setContentPane(note);
        }
        home.pack();
    }

}

class SaveButtonAction implements ActionListener{

    private FileOP file = new FileOP();
    private Home home;
    private JMenuItem item;

    public SaveButtonAction (Home home , JMenuItem item){
        this.item = item;
        item.addActionListener(this);
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){

            for(Note note: home.getNotes()){
                file.saveFile(note.getName(),note.getNoteText());
            }
    }
}


class CloseNoteAction implements ActionListener{

    private Home frame;
    private JMenuItem item;

    public CloseNoteAction (Home frame){
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e){
        frame.setContentPane(frame.getView());
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
        System.out.println(notes.size());
        for(Note note: notes){
            if(note!=null && note.getName()!=null){
                if(note.getName().equals(card.getName())){
                    // System.out.println(note.getNoteText());
                    note.render();
                    // System.out.println("Hello"+note.getNoteText());
                    home.setContentPane(note.getContentPane());
                    home.pack();
                }
            }
            
        }
        // System.out.print(n);


    }

}

class DeleteNoteAction implements ActionListener{

    private Home home;
    private Note note;
    private ArrayList<Note> notes;
    private ArrayList<Card> cards;

    public DeleteNoteAction (ArrayList<Note> notes, ArrayList<Card> cards, Note note, Home home){
        this.note = note;
        this.notes = notes;
        this.cards = cards;
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){
        for(Note n: notes){
            if(n!=null && n.getName()!=null){
                if(n.getName().equals(note.getName())){
                    notes.remove(n);
                    break;
                }
            }
        }
        for(Card c: cards){
            if(c!=null && c.getName()!=null){
                if(c.getName().equals(note.getName())){
                    cards.remove(c);
                    break;
                }
            }
        }
        home.setContentPane(home.getView());
        home.pack();
    }

}