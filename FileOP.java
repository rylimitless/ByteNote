import java.io.File;
import javax.swing.JOptionPane;

public class FileOP {

    String userDirectory;
    File file;
    boolean isDirectoryCreated = false;

    public FileOP(){
        userDirectory = System.getProperty("user.home");
        file = new File(userDirectory + "/Notes");

        if(!file.exists()){
            try{
                isDirectoryCreated = file.mkdirs();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Failed to create file directory", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public boolean saveFile(String fileName, String content){
        if(isDirectoryCreated){
            File file = new File(userDirectory + "/Notes/" + fileName + ".txt");
            try{
                file.createNewFile();
                return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Failed to create file", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Failed to create file directory", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
        
}
