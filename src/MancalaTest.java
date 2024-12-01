public class MancalaTest {
    public static void main(String[] args) {
        MancalaModel model = new MancalaModel(0);
        MancalaView mancalaView = new MancalaView(model);
        MancalaInitScreen mancalaInitView = new MancalaInitScreen(model);
        MancalaController controller = new MancalaController(model, mancalaView, mancalaInitView);
    }
}