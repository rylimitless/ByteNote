import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class SortByNameButtonAction implements ActionListener{

    private Home home;

    public SortByNameButtonAction(Home home){
        this.home = home;
    }

    public void actionPerformed(ActionEvent e){
        Collections.sort(home.getCard(), (a, b) -> a.getName().compareTo(b.getName()));

        update();

    }

    private void update(){
        home.getView().removeAll();
        home.getView().addCards(home.getCard());
        home.setContentPane(home.getView());
        home.pack();
    }
}
