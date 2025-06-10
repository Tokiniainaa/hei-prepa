package hei.snake;

public interface MoveStrategy {
    Direction computeNextDirection(Snake snake, Direction currentDirection);
}