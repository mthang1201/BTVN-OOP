import java.util.ArrayList;

/**
 * Layer.
 */
public class Layer {
    private ArrayList<Shape> shapes;

    /**
     * Constructor.
     */
    public Layer() {
        this.shapes = new ArrayList<>();
    }

    /**
     *
     * @param shape of the layer.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeCircles() {
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                shapes.remove(shape);
            }
        }
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
    }
}
