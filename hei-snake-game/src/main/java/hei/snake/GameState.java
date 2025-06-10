package hei.snake;

public interface GameState {
    void handleInput(Game game, String input);
    void update(Game game);
    void render(Game game);
}