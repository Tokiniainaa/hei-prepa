package hei.snake;

public class MenuState implements GameState {
   @Override
public void handleInput(Game game, String input) {
    if ("start".equalsIgnoreCase(input)) {
        game.start();
        game.setState(new RunningState());
    }
}

    @Override
    public void update(Game game) {
        // Nothing to update in menu
    }

    @Override
    public void render(Game game) {
        System.out.println("=== SNAKE GAME ===");
        System.out.println("Tapez 'start' pour commencer !");
    }
}