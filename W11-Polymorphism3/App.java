import javax.swing.*;
import java.awt.*;

/**
 * App.
 */
public class App extends JFrame {
    private Layer layer;

    private Timer timer;

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_LENGTH = 600;
    private static final int TIMER_DELAY = 16;

    public App() {
        layer = new Layer();

        JButton circleButton = new JButton("Insert Circle");
        circleButton.addActionListener(e -> {
            layer.addShape(RandomGenerator.getInstance().getCircle());
        });

        JButton rectangleButton = new JButton("Insert Rectangle");
        rectangleButton.addActionListener(e -> {
            layer.addShape(RandomGenerator.getInstance().getRectangle());
        });

        JButton squareButton = new JButton("Insert Square");
        squareButton.addActionListener(e -> {
            layer.addShape(RandomGenerator.getInstance().getSquare());
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(squareButton);

        add(layer, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);

        initUI();
        startAnimation();
    }

    private void initUI() {
        setTitle("App");
        setSize(SCREEN_WIDTH, SCREEN_LENGTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void startAnimation() {
        timer = new Timer(TIMER_DELAY, e -> {
            layer.update();
        });
        timer.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var app = new App();
            app.setVisible(true);
        });
    }
}
