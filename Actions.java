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
    private NoteList notesList;

    public FileItemAction (JFrame frame , JMenuItem item){
        this.item = item;
        item.addActionListener(this);
        this.home = home;
        this.notesList = home.getNoteList();
    
    }

    public void actionPerformed(ActionEvent e){
       
        Note note = new Note();
        if(note.getName()!=null){
            notesList.addNote(note);
            frame.setContentPane(note);
        }
        frame.pack();
    }

}

class SaveButtonAction implements ActionListener{

    private FileOP file = new FileOP();
    private Home home;
    private JMenuItem item;
    private Note noteToSave;

    public SaveButtonAction (Home home , JMenuItem item){
        this.item = item;
        item.addActionListener(this);
        this.home = home;
        noteToSave = home.getNoteList().getTopNote();
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == item){
            String name = noteToSave.getName();
            String document = noteToSave.getNotePane().getText();
            file.saveFile(name, document);
        }
    }

}


// class CloseNoteAction implements ActionListener{

//     private JFrame frame;
//     private JMenuItem item;

//     public CloseNoteAction (JFrame frame , JMenuItem item){
//         this.item = item;
//         item.addActionListener(this);
//         this.frame = frame;
//     }

//     public void actionPerformed(ActionEvent e){
//         frame.setContentPane(new Home().getContentPane());
//     }

// }

// ```class DarkModeAction implements ActionListener{

//     private JFrame frame;
//     private JMenuItem item;

//     public DarkModeAction (JFrame frame , JMenuItem item){
//         this.item = item;
//         item.addActionListener(this);
//         this.frame = frame;
//     }

//     public void actionPerformed(ActionEvent e){
//         frame.setBackground(Color.BLACK);
//     }

//     private void setDarkMode(boolean dark) {
//         if (dark) {
//             // Define the dark mode colors
//             Color bg = Color.BLACK;
//             Color fg = Color.WHITE;
//             Color text = Color.LIGHT_GRAY;
//             Color selection = new Color(49, 98, 114);

//             // Set the dark mode colors for each component
//             UIManager.put("Panel.background", bg);
//             UIManager.put("Panel.foreground", fg);
//             UIManager.put("Label.foreground", text);
//             UIManager.put("Button.foreground", text);
//             UIManager.put("ToggleButton.foreground", text);
//             UIManager.put("TextField.background", fg);
//             UIManager.put("TextField.foreground", text);
//             UIManager.put("TextArea.background", fg);
//             UIManager.put("TextArea.foreground", text);
//             UIManager.put("TextPane.background", fg);
//             UIManager.put("TextPane.foreground", text);
//             UIManager.put("TextPane.selectionBackground", selection);
//         } else {
//             // Restore the default colors
//             for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                 if ("Nimbus".equals(info.getName())) {
//                     try {
//                         UIManager.setLookAndFeel(info.getClassName());
//                     } catch (Exception e) {
//                     }
//                     break;
//                 }
//             }
//         }

//         // 
//         SwingUtilities.updateComponentTreeUI(this);
//     }

// }   