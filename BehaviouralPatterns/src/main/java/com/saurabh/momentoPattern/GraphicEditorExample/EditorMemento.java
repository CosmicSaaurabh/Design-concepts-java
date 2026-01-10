// The EditorMemento class stores the state of a shape, allowing for the preservation and restoration of its attributes in the Memento pattern.

package com.saurabh.momentoPattern.GraphicEditorExample;

public class EditorMemento {

    private final String shapeType;
    private final int x;
    private final int y;
    private final String color;
    private final int size;

    public EditorMemento(String shapeType, int x, int y, String color, int size) {
        this.shapeType = shapeType;
        this.color = color;
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public String getShapeType() {
        return shapeType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
