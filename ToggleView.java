import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToggleView implements ActionListener{
    
        private Home home;
    
        public ToggleView(Home home){
            this.home = home;
        }
    
        public void actionPerformed(ActionEvent e){
            if(home.getView().getCLayout().equals("flow")){
                home.getView().setCLayout("grid");
                home.getView().setLayout(new GridLayout(2,3));
                home.getView().repaint();
            }
            else{
                home.getView().setCLayout("flow");
                home.getView().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
                home.getView().repaint();
            }
            home.pack();
        }
    
}
