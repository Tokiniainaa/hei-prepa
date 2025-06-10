package hei.snake;

public class GameOverState implements GameState {
    @Override
    public void handleInput(Game game, String input) {
        if ("restart".equalsIgnoreCase(input)) {
            game.restart();
        }
    }

    @Override
    public void update(Game game) {
        // Nothing to update
    }

    @Override
    public void render(Game game) {
        System.out.println("=== GAME OVER ===");
        System.out.println("Tapez 'restart' pour rejouer !");
    }
}