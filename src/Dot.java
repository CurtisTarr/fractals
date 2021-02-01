import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@RequiredArgsConstructor
public class Dot {

    private static final int RADIUS = 1;

    private final double x;
    private final double y;
    private final Color color;
    private final int radius;

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, radius, radius);

        graphics.setColor(color);
        graphics2D.fill(circle);
    }

}