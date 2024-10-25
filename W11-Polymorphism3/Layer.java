import javax.swing.JPanel;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Layer.
 */
public class Layer extends JPanel {
    private List<Shape> shapes;

    /**
     * Constructor.
     */
    public Layer() {
        this.shapes = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Shape shape : shapes) {
            shape.draw(graphics);
        }
    }

    public void update() {
        for (Shape shape : shapes) {
            shape.move();
        }
        repaint();
    }

    /**
     * addShape.
     *
     * @param shape of the layer.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    /**
     * removeCircles.
     */
    public void removeCircles() {
        int size = shapes.size();
        for (int i = size - 1; i >= 0; i--) {
            if (shapes.get(i) instanceof Circle) {
                shapes.remove(i);
            }
        }
        repaint();
    }

    /**
     * getInfo.
     *
     * @return getInfo.
     */
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Layer of crazy shapes:\n");

        for (Shape shape : shapes) {
            builder.append(shape.toString()).append("\n");
        }

        return builder.toString();
    }

    /**
     * removeDuplicates.
     */
    public void removeDuplicates() {
        Set<Shape> uniqueShapes = new HashSet<>(shapes);
        shapes.clear();
        shapes.addAll(uniqueShapes);
        repaint();
    }
}
