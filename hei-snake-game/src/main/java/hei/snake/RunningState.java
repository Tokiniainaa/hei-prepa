package hei.snake;

public class RunningState implements GameState {
    @Override
    public void handleInput(Game game, String input) {
        switch (input.toUpperCase()) {
            case "W": game.changeDirection(Direction.UP); break;
            case "S": game.changeDirection(Direction.DOWN); break;
            case "A": game.changeDirection(Direction.LEFT); break;
            case "D": game.changeDirection(Direction.RIGHT); break;
        }
    }

    @Override
    public void update(Game game) {
        game.tick();
    }

    @Override
    public void render(Game game) {
        game.renderGrid();
    }
}