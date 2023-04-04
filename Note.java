import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

import java.awt.*;

public class Note extends Page{

    private String name;
    private String fileLocation;
    private Date dateCreated;
    private JTextPane notePane;
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
        notePane = new JTextPane();
        notePane.setContentType("text/html");
        HTMLDocument document = new HTMLDocument();
        notePane.setDocument(document);
        notePane.setText("      ");
        notePane.setEditable(true);
        notePane.setPreferredSize(new Dimension(600, 500));
        scrollPane = new JScrollPane(notePane);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public JTextPane getNotePane(){
        return notePane;
    }

}