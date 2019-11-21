import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Doodle");
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
        Canvas canvas = new Canvas(model, controller);
        Scrollbar scrollbar = new Scrollbar(model, controller);
        model.addView(view);
        model.addView(canvas);
        model.addView(scrollbar);
        JPanel p = new JPanel(new BorderLayout());
        frame.getContentPane().add(p);
        p.add(view, BorderLayout.WEST);
        p.add(canvas, BorderLayout.CENTER);
        p.add(scrollbar, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(1200, 900));
        frame.setMinimumSize(new Dimension(800, 500));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
