package de.telran.shapes.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Picture extends Shape{
    private final List<Shape> shapes;
    private final Line border;
    private final int borderLength;

    public Picture(char symbol, int borderLength, List<Shape> shapes) {
        super(symbol);
        this.shapes = new ArrayList<>(shapes);
        this.borderLength = borderLength;
        this.border = new Line(symbol, borderLength);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void draw() {
        border.draw();
        shapes.forEach(Shape::draw);
        border.draw();
    }
}
