
import java.awt.*;
import javax.swing.*;


interface PageInterface {
    public void render();
    public void show();
    public void hide();
}


abstract class Page extends JPanel implements PageInterface{

    private boolean isRendered = false;
    private boolean isVisible = false;

    public Page(String pageName) {
        super();
        setLayout(new FlowLayout());
        setVisible(isVisible);
    }

    public void render() {
        if (!isRendered) {
            isRendered = true;
            //renderPage();
        }
    }

    public void show() {
        if (!isVisible) {
            isVisible = true;
            setVisible(isVisible);
        }
    }

    public void hide() {
        if (isVisible) {
            isVisible = false;
            setVisible(isVisible);
        }
    }

    // protected abstract void renderPage();


}
