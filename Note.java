import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.undo.*;


public class Note extends JFrame{

    private String name;
    private Date dateCreated;
    private JTextArea noteArea;
    private JScrollPane scrollPane;
    private String noteString="";
    private UndoManager undoManager = new UndoManager();
    

    public Note() {
        super("Note");
        dateCreated = new Date();
        noteArea = new JTextArea();

        scrollPane = new JScrollPane(noteArea);
    }


    public void render(){
        noteEvents();
        noteArea.getDocument().addUndoableEditListener(undoManager);
        setSize(600, 500);
        noteArea.setEditable(true);
        noteArea.setFont(new Font("Arial", Font.PLAIN, 15));
        noteArea.setMargin(new Insets(10, 10, 10, 10));
        noteArea.setCaretPosition(0);
        noteArea.requestFocusInWindow();
        noteArea.setWrapStyleWord(true);
        noteArea.setLineWrap(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 500));
        scrollPane.setVisible(true);
        add(scrollPane);


    }

    public void noteEvents(){

        noteArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_X && e.isControlDown()) {
                    noteArea.cut();
                }

                if (e.getKeyCode() == KeyEvent.VK_C && e.isControlDown()) {
                    noteArea.copy();
                }

                if (e.getKeyCode() == KeyEvent.VK_V && e.isControlDown()) {
                    // noteArea.paste();
                }

                if (e.getKeyCode() == KeyEvent.VK_Z && e.isControlDown()) {
                    try{
                        if(undoManager.canUndo())
                            undoManager.undo();
                    }
                    catch(NullPointerException ex){}
                }

                if (e.getKeyCode() == KeyEvent.VK_Y && e.isControlDown()) {
                    try{
                        if(undoManager.canRedo())
                            undoManager.redo();
                    }
                    catch(NullPointerException ex){}
                }
            }
        });


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