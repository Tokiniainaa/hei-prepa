package hei.snake;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;

    public Snake(List<Point> initialBody, Direction direction) {
        this.body = new LinkedList<>(initialBody);
        this.direction = direction;
    }

    public Point getHead() {
        return body.getFirst();
    }

    public List<Point> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public void move(boolean grow) {
        Point newHead = getHead().move(direction);
        body.addFirst(newHead);
        if (!grow) {
            body.removeLast();
        }
    }

    public boolean isColliding(Point p) {
        return body.contains(p);
    }

    public boolean isCollidingWithSelf() {
        Point head = getHead();
        return body.stream().skip(1).anyMatch(p -> p.equals(head));
    }
}