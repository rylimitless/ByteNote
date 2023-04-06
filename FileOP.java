import java.io.File;
import javax.swing.JOptionPane;
import java.io.*;

public class FileOP {

    String userDirectory;
    String fileFolder;
    String saveFolder;
    
    PrintWriter writer;
    File file;
    boolean isDirectoryCreated = false;
    boolean isSavesCreated = false;

    public FileOP(){
        userDirectory = System.getProperty("user.home");
        fileFolder = userDirectory + "/ByteNote/Notes";
        saveFolder = userDirectory + "/ByteNote/Saves";
        file = new File(fileFolder);
        isDirectoryCreated = file.mkdirs();
        file = new File(saveFolder);
        isSavesCreated = file.mkdirs();
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
    
    public File [] readFile(){

        File [] files = new File(saveFolder).listFiles();
        for(File file: files){
            // Card card = new Card(file.getName());
        }

        return null;
    }
        
}
