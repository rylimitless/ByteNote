import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseNoteAction implements ActionListener{

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