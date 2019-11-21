
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class View extends JPanel implements IView {

    private Model model;
    private JButton black;
    private JButton yellow;
    private JButton blue;
    private JButton red;
    private JButton pink;
    private JButton gray;
    private JButton current;
    private JButton thick1;
    private JButton thick2;
    private JButton thick3;
    private JButton customcolor;

    /**
     * Create a new View.
     */
    public View(Model model, Controller controller) {
        // Set up the window.
        //this.setTitle("Doodle");
        black = new JButton("black");
        black.setBackground(Color.BLACK);
        black.setForeground(Color.BLACK);
        black.setMaximumSize(new Dimension(50, 30));
        black.setPreferredSize(new Dimension(50, 30));
        black.addActionListener(controller);
        black.setOpaque(true);

        yellow = new JButton("yellow");
        yellow.setBackground(Color.YELLOW);
        yellow.setMaximumSize(new Dimension(50, 30));
        yellow.setPreferredSize(new Dimension(50, 30));
        yellow.addActionListener(controller);
        yellow.setOpaque(true);

        blue = new JButton("blue");
        blue.setBackground(Color.BLUE);
        blue.setMaximumSize(new Dimension(50, 30));
        blue.setPreferredSize(new Dimension(50, 30));
        blue.addActionListener(controller);
        blue.setOpaque(true);

        red = new JButton("red");
        red.setBackground(Color.RED);
        red.setMaximumSize(new Dimension(50, 30));
        red.setPreferredSize(new Dimension(50, 30));
        red.addActionListener(controller);
        red.setOpaque(true);

        pink = new JButton("pink");
        pink.setBackground(Color.PINK);
        pink.setMaximumSize(new Dimension(50, 30));
        pink.setPreferredSize(new Dimension(50, 30));
        pink.addActionListener(controller);
        pink.setOpaque(true);

        gray = new JButton("gray");
        gray.setBackground(Color.GRAY);
        gray.setMaximumSize(new Dimension(50, 30));
        gray.setPreferredSize(new Dimension(50, 30));
        gray.addActionListener(controller);
        gray.setOpaque(true);

        current = new JButton("current");
        current.setBackground(model.getcolor());
        black.setForeground(model.getcolor());
        current.setMaximumSize(new Dimension(50, 30));
        current.setPreferredSize(new Dimension(50, 30));
        current.addActionListener(controller);
        current.setOpaque(true);

        thick1 = new JButton("thick1");
        thick1.setBackground(Color.BLACK);
        thick1.setMaximumSize(new Dimension(50, 5));
        thick1.setPreferredSize(new Dimension(50, 5));
        thick1.addActionListener(controller);
        thick1.setOpaque(true);

        thick2 = new JButton("thick2");
        thick2.setBackground(Color.BLACK);
        thick2.setMaximumSize(new Dimension(50, 10));
        thick2.setPreferredSize(new Dimension(50, 10));
        thick2.addActionListener(controller);
        thick2.setOpaque(true);

        thick3 = new JButton("thick3");
        thick3.setBackground(Color.BLACK);
        thick3.setMaximumSize(new Dimension(50, 20));
        thick3.setPreferredSize(new Dimension(50, 20));
        thick3.addActionListener(controller);
        thick3.setOpaque(true);

        customcolor = new JButton("custom color");
        customcolor.setMaximumSize(new Dimension(50, 30));
        customcolor.setPreferredSize(new Dimension(50, 30));
        customcolor.addActionListener(controller);
        customcolor.setOpaque(true);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //gbc.insets = new Insets(1,1,1,1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.weightx = 0.2;
        gbc.gridy = 0;
        gbc.weighty = 0.2;

        this.add(black, gbc);
        gbc.gridx++;
        this.add(yellow, gbc);
        gbc.gridy++;
        gbc.gridx--;
        this.add(blue, gbc);
        gbc.gridx++;
        this.add(red, gbc);
        gbc.gridy++;
        gbc.gridx--;
        this.add(pink, gbc);
        gbc.gridx++;
        this.add(gray, gbc);
        gbc.gridy++;
        gbc.gridx--;
        this.add(current, gbc);
        gbc.gridy++;
        this.add(customcolor, gbc);
        gbc.gridy--;
        gbc.gridx++;

        this.add(thick1, gbc);
        gbc.weighty = 0.4;
        gbc.gridy++;
        this.add(thick2, gbc);
        gbc.weighty = 0.6;
        gbc.gridy++;
        this.add(thick3, gbc);
        gbc.weighty = 0.9;
        gbc.gridy++;
        //this.setMinimumSize(new Dimension(128, 128));
        //this.setSize(800, 600);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;
        //model.addObserver(this);

        //setVisible(true);
    }

    /**
     * Update with data from the model.
     */
    public void updateView() {
        // XXX Fill this in with the logic for updating the view when the model
        // changes.
        System.out.println("View: updateView");
        current.setBackground(model.getcolor());
    }
}
