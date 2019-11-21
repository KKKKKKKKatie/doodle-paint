import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Canvas extends JPanel implements IView {
    private Model model;

    Canvas(Model model, Controller controller) {
        // create UI
        setBackground(Color.WHITE);

        // set the model
        this.model = model;

        // setup the event to go to the controller
        this.addMouseListener(controller);
        this.addMouseMotionListener(controller);
    }

    public void updateView() {
        System.out.println("View2: updateView");
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // cast to get 2D drawing methods
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  // antialiasing look nicer
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (model.shapes != null) {
            for (Shape shape : model.shapes) {
                shape.draw(g2);
            }
        }
    }


}
