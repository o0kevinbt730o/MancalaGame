public class MancalaApp{
    public static void main(String[] args) {
        MancalaModel model = new MancalaModel(4);
        MancalaView view = new MancalaView(model);
        MancalaController controller = new MancalaController(model, view);
    }
}