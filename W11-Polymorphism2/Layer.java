import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Layer.
 */
public class Layer {
    private List<Shape> shapes;

    /**
     * Constructor.
     */
    public Layer() {
        this.shapes = new ArrayList<>();
    }

    /**
     * addShape.
     *
     * @param shape of the layer.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
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
        LinkedHashSet<Shape> shapeSet = new LinkedHashSet<>(shapes);
        this.shapes = new ArrayList<>(shapeSet);
    }
}
