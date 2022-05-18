package de.telran.shapes.types;

public abstract class Shape {
    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void draw();
}
