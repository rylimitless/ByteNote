import javax.swing.*;
import java.awt.*;


//this is the note class that you'll need
public class Note extends JFrame{

    private String name;
    private Date dateCreated;
    private JTextArea noteArea;
    private JScrollPane scrollPane;
    

    public Note() {
        super("Note");
        dateCreated = new Date();
        noteArea = new JTextArea();
    }


    public void render(){
    
        setSize(600, 500);
        // noteArea.setContentType("text/html");
        // noteArea.setText("      ");
        noteArea.setEditable(true);
        noteArea.setWrapStyleWord(true);
        noteArea.setLineWrap(true);
        scrollPane = new JScrollPane(noteArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        add(scrollPane, BorderLayout.CENTER);
    }


    public void setName(String name){
        this.name = name;
    }

    public String getDateString(){
        return dateCreated.toString();
    }

    public String getNoteText(){
        return noteArea.getText();
    }

    public void setNoteText(String text){
        noteArea.setText(text);
    }

    public JTextArea getNoteArea(){
        return noteArea;
    }

    public String getName(){
        return name;
    }

}