import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// import javax.swing.text.StyledDocument;
// import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import java.util.ArrayList;
import javax.swing.UIManager.*;


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
        if(note.getName()!=null){
            System.out.println(note.getName());
            notesList.add(note);
            home.setContentPane(note);
        }
        home.pack();
        System.out.println(notesList.size());
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

    private JFrame frame;
    private JMenuItem item;

    public CloseNoteAction (JFrame frame , JMenuItem item){
        this.item = item;
        item.addActionListener(this);
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e){
        frame.setContentPane(new Views(frame));
    }

}