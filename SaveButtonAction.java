import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SaveButtonAction implements ActionListener{

    private FileOP file = new FileOP();
    private Home home;

    public SaveButtonAction (Home home){
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){

            for(Note note: home.getNotes()){
                file.saveFile(note.getName(),note.getNoteText());
            }
            
    }

}