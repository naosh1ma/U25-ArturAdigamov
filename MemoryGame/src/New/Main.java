package New;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Frame frame = new Frame();
        Controller controller = new Controller(model, frame);
    }
}
