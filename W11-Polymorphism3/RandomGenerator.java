import java.util.Random;

/**
 * RandomGenerator.
 */
public class RandomGenerator {
    private Random random;

    private static RandomGenerator instance;

    public static RandomGenerator getInstance() {
        if (instance == null) {
            instance = new RandomGenerator();
        }
        return instance;
    }

    private RandomGenerator() {
        random = new Random();
    }

    public Point getVelocity() {
        double x = random.nextDouble(10);
        double y = random.nextDouble(10);
        return new Point(x, y);
    }

    public Circle getCircle() {
        double newRadius = getRadius();

        // R < X < SCREEN_WIDTH - R
        double x = random.nextDouble(App.SCREEN_WIDTH - 2 * newRadius) + newRadius;
        // R < Y < SCREEN_LENGTH - R
        double y = random.nextDouble(App.SCREEN_LENGTH - 2 * newRadius) + newRadius;
        Point newPoint = new Point(x, y);

        String newColor = getColor();
        boolean newFilled = isFilled();

        return new Circle(newPoint, newRadius, newColor, newFilled);
    }

    public Rectangle getRectangle() {
        double newWidth = getWidth();
        double newLength = getLength();

        // 0 < X < SCREEN_WIDTH - width
        double x = random.nextDouble(App.SCREEN_WIDTH - newWidth);
        // 0 < Y < SCREEN_LENGTH - length
        double y = random.nextDouble(App.SCREEN_LENGTH - newLength);
        Point newPoint = new Point(x, y);

        String newColor = getColor();
        boolean newFilled = isFilled();

        return new Rectangle(newPoint, newWidth, newLength, newColor, newFilled);
    }

    public Square getSquare() {
        double newLength = getLength();

        // 0 < X < SCREEN_WIDTH - length
        double x = random.nextDouble(App.SCREEN_WIDTH - newLength);
        // 0 < Y < SCREEN_LENGTH - length
        double y = random.nextDouble(App.SCREEN_LENGTH - newLength);
        Point newPoint = new Point(x, y);

        String newColor = getColor();
        boolean newFilled = isFilled();

        return new Square(newPoint, newLength, newColor, newFilled);
    }

    public Point getPoint() {
        double x = random.nextDouble(App.SCREEN_WIDTH);
        double y = random.nextDouble(App.SCREEN_LENGTH);
        return new Point(x, y);
    }

    public double getRadius() {
        return random.nextDouble((double) App.SCREEN_LENGTH / 2.0);
    }

    public double getWidth() {
        return random.nextDouble(App.SCREEN_WIDTH);
    }

    public double getLength() {
        return random.nextDouble(App.SCREEN_LENGTH);
    }

    public String getColor() {
//        String[] colorNames = {
//                "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta",
//                "Orange", "Pink", "Black", "White", "Gray"
//        };
//        int index = random.nextInt(colorNames.length);
//        return colorNames[index];

        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public boolean isFilled() {
        return random.nextBoolean();
    }
}
