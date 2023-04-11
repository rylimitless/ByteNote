import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;


public class SortByNameDesc implements ActionListener {
    
    private Home home;

    public SortByNameDesc(Home home){
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){
        Collections.sort(home.getCard(), (a, b) -> a.getName().compareTo(b.getName()));
        Collections.reverse(home.getCard());
        update();

    }

    private void update(){
        home.getView().removeAll();
        home.getView().addCards(home.getCard());
        home.setContentPane(home.getView());
        home.pack();
    }


}
