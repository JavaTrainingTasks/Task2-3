package ua.training;

import ua.training.controllers.Controller;
import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

/**
 * Notebook
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Note note = new Note();
        Notebook notebook = new Notebook();
        View view = new View();
        Controller controller = new Controller(note, view, notebook);
        controller.run();

    }
}
