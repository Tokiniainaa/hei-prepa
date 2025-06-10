package hei.snake;

import java.util.Random;

public class FoodFactory {
    private static final Random RANDOM = new Random();

    public static Point generateFood(int gridSize, Snake snake) {
        Point food;
        do {
            int x = RANDOM.nextInt(gridSize);
            int y = RANDOM.nextInt(gridSize);
            food = new Point(x, y);
        } while (snake.isColliding(food));
        return food;
    }
}