import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOP {

    String userDirectory;
    String fileFolder;
    String saveFolder;
    ArrayList<Note> notes;
    PrintWriter writer;
    File file;

    boolean isDirectoryCreated = false;
    boolean isSavesCreated = false;

    public FileOP(){
        userDirectory = System.getProperty("user.home");
        fileFolder = userDirectory + "/ByteNote/Notes";
        saveFolder = userDirectory + "/ByteNote/Saves";
        file = new File(fileFolder);

        if(!file.exists()){
            isDirectoryCreated = file.mkdirs();
        }
        else{
            isDirectoryCreated = true;
        }

    }

    public boolean saveFile(String fileName, String content){
        if(isDirectoryCreated){
            try{

                FileWriter writer = new FileWriter(fileFolder + "/" + fileName + ".txt");

                writer.write(content);
                writer.close();
                return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Failed to save file", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Failed to create file directory", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public void readFile(ArrayList<Note> notes, ArrayList<Card> cards){

        File [] files = new File(fileFolder).listFiles();
        for(File file: files){
            Card card = new Card(file.getName().split(".txt")[0]);
            Note note  = new Note();
            // note.render();
            note.setName(file.getName().split(".txt")[0]);
            note.getNoteArea().setText(fileReader(file));
            notes.add(note);
            cards.add(card);
        }

    }

    private Note createNoteFromFile(File file){

        Note note = new Note();
        note.setName(file.getName().split(".txt")[0]);
        note.setNoteText(file.toString());

        return note;
    }

    private String fileReader(File file){
        Scanner scan=null;
        String content = "";
        try{
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                content += scan.nextLine() + "\n";
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Failed to read file", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // finally{
        //     if(scan!=null)
        //     scan.close();
        // }
        return content;



    }


}
