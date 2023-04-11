import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class FileItemAction implements ActionListener{

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
            else{
                home.setContentPane(home.getView());
            }
            home.pack();
        }
    
    }
