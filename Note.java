import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

import java.awt.*;

public class Note extends Page{

    private String name;
    private String fileLocation;
    private Date dateCreated;
    private JTextArea noteArea;
    private JScrollPane scrollPane;
    

    public Note() {
        super("Note");
        dateCreated = new Date();
        name = JOptionPane.showInputDialog(null, "Name");
        render();
    }


    public String getName(){
        return name;
    }

    public void render(){
        setMinimumSize(new Dimension(600, 500));
        setSize(800, 500);
        noteArea = new JTextArea();
        // noteArea.setContentType("text/html");
        noteArea.setText("      ");
        noteArea.setEditable(true);
        noteArea.setWrapStyleWord(true);
        noteArea.setLineWrap(true);
        noteArea.setPreferredSize(new Dimension(600, 500));
        scrollPane = new JScrollPane(noteArea);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    // public JTextP getNotePane(){
    //     return notePane;
    // }

    public void setName(String name){
        this.name = name;
    }

    public String getDateString(){
        return dateCreated.toString();
    }

    public String getNoteText(){
        return noteArea.getText();
    }
}