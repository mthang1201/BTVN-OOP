import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Layer.
 */
public class Layer extends JPanel {
    private ArrayList<Shape> shapes;

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
     *
     * @param shape of the layer.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    public void removeCircles() {
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                shapes.remove(shape);
            }
        }
        repaint();
    }

    /**
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
     *
     */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    shapes.remove(j);
                }
            }
        }
        repaint();
    }
}
