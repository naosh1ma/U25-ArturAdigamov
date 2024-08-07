package New;

public class Controller {
    Model model;
    View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;

        view.addListener(null);
    }


}
