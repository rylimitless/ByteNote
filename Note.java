import javax.swing.*;
import java.awt.*;


public class Note extends JFrame{

    private String name;
    private Date dateCreated;
    private JTextArea noteArea;
    private JScrollPane scrollPane;
    private String noteString="";
    

    public Note() {
        super("Note");
        dateCreated = new Date();
        noteArea = new JTextArea();
    }


    public void render(){
    
        setSize(600, 500);
        noteArea.setText(noteString);
        noteArea.setEditable(true);
        noteArea.setWrapStyleWord(true);
        noteArea.setLineWrap(true);
        scrollPane = new JScrollPane(noteArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        add(scrollPane);
    }


    public JScrollPane getScrollPane(){
        return scrollPane;
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
        if(noteString.equals(""))
            noteArea.setText(text);
    }

    public JTextArea getNoteArea(){
        return noteArea;
    }

    public String getName(){
        return name;
    }

    public void setNoteString(String text){
        noteString = text;
    }

    

}