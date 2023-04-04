import javax.swing.JFrame;

public class Views {
    
    private JFrame frame;

    public Views(JFrame frame){
        this.frame = frame;
    }

    public void render(){
        frame.pack();
    }


}


