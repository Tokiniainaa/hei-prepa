package hei.snake;

import java.util.ArrayList;
import java.util.List;

public class SnakeBuilder {
    private Point start;
    private int length = 3;
    private Direction direction = Direction.RIGHT;

    public SnakeBuilder at(Point start) {
        this.start = start;
        return this;
    }

    public SnakeBuilder length(int length) {
        this.length = length;
        return this;
    }

    public SnakeBuilder direction(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Snake build() {
        List<Point> body = new ArrayList<>();
        Point p = start;
        body.add(p);
        for (int i = 1; i < length; i++) {
            p = p.move(opposite(direction));
            body.add(p);
        }
        return new Snake(body, direction);
    }

    private Direction opposite(Direction dir) {
        switch (dir) {
            case UP: return Direction.DOWN;
            case DOWN: return Direction.UP;
            case LEFT: return Direction.RIGHT;
            case RIGHT: return Direction.LEFT;
            default: return dir;
        }
    }
}