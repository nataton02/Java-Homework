package de.telran.shapes.types;

public class Rectangle extends Shape{
    private final int height;
    private final int width;
    private final Line line;

    public Rectangle(char symbol, int height, int width, Line line) {
        super(symbol);
        this.height = height;
        this.width = width;
        this.line = new Line(symbol, width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            line.draw();
        }
    }

}
