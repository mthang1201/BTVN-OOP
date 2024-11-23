public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(new Point(10, 5), 8, "RED", true);
        Shape rec1 = new Rectangle(new Point(10, 5), 8, 6, "RED", true);
        Shape rec2 = new Rectangle(new Point(10, 5), 8, 6, "BLUE", true);
        Shape square = new Square(new Point(10, 5), 8, "RED", true);
        Shape rec3 = new Rectangle(new Point(10, 5), 8, 6, "RED", true);

        Layer layer = new Layer();
        layer.addShape(circle);
        layer.addShape(rec1);
        layer.addShape(rec2);
        layer.addShape(square);
        layer.addShape(rec3);

        layer.removeDuplicates();

        System.out.println(layer.getInfo());
    }
}
