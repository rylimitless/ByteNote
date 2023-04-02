import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class FileItemAction implements ActionListener{

    private JFrame frame;
    private JMenuItem item;

    public FileItemAction (JFrame frame , JMenuItem item){
        this.item = item;
        item.addActionListener(this);
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e){
       
        Note note = new Note();
        frame.pack();
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
       frame.setContentPane(frame);
    }

}