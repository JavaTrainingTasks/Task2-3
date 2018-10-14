package ua.training;

import ua.training.controllers.Controller;
import ua.training.model.Notebook;
import ua.training.view.View;

/**
 * Notebook
 *
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
