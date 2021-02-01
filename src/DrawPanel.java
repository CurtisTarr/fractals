import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {

    private static final Random random = new Random();

    private final Dot dotA;
    private final Dot dotB;
    private final Dot dotC;
    private final List<Dot> dots = new ArrayList<>();

    private Dot lastDot;

    public DrawPanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500, 500));

        dotA = addDot(50, 450, Color.RED, 5);
        dotB = addDot(450, 450, Color.GREEN, 5);
        dotC = addDot(250, 50, Color.BLUE, 5);

        lastDot = addDot(250, 250, Color.CYAN, 5);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i < dots.size(); i++) {
            dots.get(i).draw(graphics);
        }
    }

    public void createFractal(int iterations) {
        for (int i = 0; i < iterations; i++) {
            Dot targetDot = getDotToMoveTowards();
            double x = getMidPoint(lastDot.getX(), targetDot.getX());
            double y = getMidPoint(lastDot.getY(), targetDot.getY());
            lastDot = addDot(x, y, Color.WHITE, 1);
        }
        repaint();
    }

    private Dot getDotToMoveTowards() {
        int roll = random.nextInt(3) + 1;
        switch (roll) {
            case 1:
                return dotA;
            case 2:
                return dotB;
            case 3:
            default:
                return dotC;
        }
    }

    private double getMidPoint(double i, double j) {
        if (i == j) {
            return i;
        } else {
            return (i + j) / 2;
        }
    }

    private Dot addDot(double x, double y, Color color, int radius) {
        Dot dot = new Dot(x, y, color, radius);
        dots.add(dot);
        return dot;
    }
}