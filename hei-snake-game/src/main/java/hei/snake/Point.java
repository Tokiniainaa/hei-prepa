package hei.snake;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point move(Direction dir) {
        switch (dir) {
            case UP: return new Point(x, y - 1);
            case DOWN: return new Point(x, y + 1);
            case LEFT: return new Point(x - 1, y);
            case RIGHT: return new Point(x + 1, y);
            default: return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }
}