import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Scrollbar extends JPanel implements  IView {
    Model model;

    JSlider scrollbar;
    private JButton undo;
    private JButton redo;
    private JButton play;
    private JButton playback;

    public Scrollbar(Model model, Controller controller) {
        scrollbar = new JSlider();
        scrollbar.setValue(scrollbar.getMaximum());


        undo = new JButton("undo");
        undo.setBackground(Color.BLACK);
        undo.setForeground(Color.BLACK);
        undo.setMaximumSize(new Dimension(10, 20));
        undo.setPreferredSize(new Dimension(10, 20));
        undo.addActionListener(controller);
        undo.setOpaque(true);

        redo = new JButton("redo");
        redo.setBackground(Color.BLACK);
        redo.setForeground(Color.BLACK);
        redo.setMaximumSize(new Dimension(10, 20));
        redo.setPreferredSize(new Dimension(10, 20));
        redo.addActionListener(controller);
        redo.setOpaque(true);

        play = new JButton("play");
        play.setBackground(Color.BLACK);
        play.setForeground(Color.BLACK);
        play.setMaximumSize(new Dimension(10, 20));
        play.setPreferredSize(new Dimension(10, 20));
        play.addActionListener(controller);
        play.setOpaque(true);

        playback = new JButton("play back");
        playback.setBackground(Color.BLACK);
        playback.setForeground(Color.BLACK);
        playback.setMaximumSize(new Dimension(10, 20));
        playback.setPreferredSize(new Dimension(10, 20));
        playback.addActionListener(controller);
        playback.setOpaque(true);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.weightx = 0.2;
        gbc.gridy = 0;
        gbc.weighty = 0.2;

        this.add(scrollbar, gbc);
        gbc.gridx += 10;
        this.add(play, gbc);
        gbc.gridx++;
        this.add(playback, gbc);
        gbc.gridx++;
        this.add(redo, gbc);
        gbc.gridx++;
        this.add(undo, gbc);

        this.model = model;
    }
    int vel = 0;
    //int velback = scrollbar.getMaximum();
    @Override
    public void updateView() {
        if (model.playback) {
            vel += scrollbar.getMaximum()/model.shapes_backup.size();
            scrollbar.setValue(scrollbar.getMaximum() - vel);
        } else if (model.play) {
            vel += scrollbar.getMaximum()/model.shapes_backup.size();
            scrollbar.setValue(vel);
        } else {
            vel = 0;
            scrollbar.setValue(scrollbar.getMaximum());
        }
//        if (!model.play && (scrollbar.getValue() != scrollbar.getMaximum())) {
//            System.out.println("scrollbar");
//            model.shapes = new ArrayList<Shape>();
//            int i = 0;
//            while (scrollbar.getValue()/scrollbar.getMaximum()*model.shapes_backup.size() > i) {
//                model.shapes.add(model.shapes_backup.get(i));
//                i++;
//            }
//            model.notifyObservers();
//            //repaint();
//        }
    }

}
