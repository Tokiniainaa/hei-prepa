package hei.snake;

import java.util.Scanner;

public class Game {
    private static final int GRID_SIZE = 10;
    private GameState state;
    private Snake snake;
    private Point food;
    private MoveStrategy moveStrategy;

    public Game() {
        setState(new MenuState());
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void start() {
        snake = new SnakeBuilder()
                .at(new Point(GRID_SIZE / 2, GRID_SIZE / 2))
                .length(3)
                .direction(Direction.RIGHT)
                .build();
        food = FoodFactory.generateFood(GRID_SIZE, snake);
        moveStrategy = (s, d) -> d;
    }

    public void restart() {
        start();
        setState(new RunningState());
    }

    public void changeDirection(Direction dir) {
        snake.setDirection(dir);
    }

    public void tick() {
        Direction nextDir = moveStrategy.computeNextDirection(snake, snake.getDirection());
        snake.setDirection(nextDir);
        Point nextHead = snake.getHead().move(nextDir);
        if (nextHead.x < 0 || nextHead.x >= GRID_SIZE || nextHead.y < 0 || nextHead.y >= GRID_SIZE) {
            setState(new GameOverState());
            return;
        }
        if (snake.isColliding(nextHead)) {
            setState(new GameOverState());
            return;
        }
        boolean grow = nextHead.equals(food);
        snake.move(grow);
        if (grow) {
            food = FoodFactory.generateFood(GRID_SIZE, snake);
        }
    }

    public void renderGrid() {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                Point p = new Point(x, y);
                if (snake.getHead().equals(p)) {
                    System.out.print("* ");
                } else if (snake.getBody().contains(p)) {
                    System.out.print("# ");
                } else if (food.equals(p)) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            state.render(this);
            System.out.print("> ");
            String input = scanner.nextLine();
            state.handleInput(this, input);
            state.update(this);
        }
    }
}