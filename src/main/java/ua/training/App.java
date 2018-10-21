package ua.training;

import ua.training.controllers.Controller;
import ua.training.model.entity.Notebook;
import ua.training.view.View;

/**
 * Notebook
 * Give you opportunity to work with notes
 * Created 15.10.18
 * @author Yaroslav Kratt
 */
public class App 
{
    public static void main( String[] args ) {
        Notebook notebook = new Notebook();
        View view = new View();
        Controller controller = new Controller(view, notebook);
        controller.run();

    }
}
