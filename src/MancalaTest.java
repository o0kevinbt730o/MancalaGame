/**
 * @author Kevin Chau
 * @version 1.0
 * The MancalaTest class acts as the entry point for the Mancala game application.
 * It initializes the model, view, and controller components of the game.
 * 
 * This class performs the following actions:
 * - Creates an instance of MancalaModel with an initial state.
 * - Creates an instance of MancalaView to represent the game's user interface.
 * - Creates an instance of MancalaInitScreen for the initial game setup screen.
 * - Creates an instance of MancalaController to handle interactions between the model and view.
 * 
 * @param args Command line arguments (not used).
 */
public class MancalaTest {
    public static void main(String[] args) {
        MancalaModel model = new MancalaModel(0);
        MancalaView mancalaView = new MancalaView(model);
        MancalaInitScreen mancalaInitView = new MancalaInitScreen(model);
        MancalaController controller = new MancalaController(model, mancalaView, mancalaInitView);
    }
}