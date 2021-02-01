import javax.swing.*;

public class App {

    public static void main(String[] args) {

        DrawPanel drawPanel = new DrawPanel();

        JFrame frame = new JFrame();
        frame.add(drawPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        drawPanel.createFractal(100000);
    }
}