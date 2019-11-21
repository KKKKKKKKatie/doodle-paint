import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Controller implements ActionListener, MouseListener, MouseMotionListener {
        Model model;
        Controller(Model model) {
            this.model = model;
        }

        public void actionPerformed(java.awt.event.ActionEvent e){
            System.out.println("Controller: changing Model (actionPerformed)");
            //model.notifyObservers();
            switch(e.getActionCommand()) {
                case "black":
                    model.setcolor(Color.BLACK);
                    break;
                case "yellow":
                    model.setcolor(Color.YELLOW);
                    break;
                case "blue":
                    model.setcolor(Color.BLUE);
                    break;
                case "red":
                    model.setcolor(Color.RED);
                    break;
                case "pink":
                    model.setcolor(Color.PINK);
                    break;
                case "gray":
                    model.setcolor(Color.GRAY);
                    break;
                case "custom color":
                    Color c = JColorChooser.showDialog(null, "custom color", model.currentcolor);
                    model.setcolor(c);
                    break;
                case "thick1":
                    model.setthick(1);
                    break;
                case "thick2":
                    model.setthick(2);
                    break;
                case "thick3":
                    model.setthick(3);
                    break;
                case "redo":
                    model.redo();
                    break;
                case "undo":
                    model.undo();
                    break;
                case "play":
                    model.play();
                    break;
                case "play back":
                    model.playback();
                    break;
            }



        }

        public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) {
        model.addshape();
    }
    public void mouseReleased(MouseEvent e) {
            model.shapes_backup = new ArrayList<Shape>(model.shapes);
    }
    public void mouseMoved(MouseEvent e) { }
    @Override
    public void mouseDragged(MouseEvent e) {
            double x = e.getX();
            double y = e.getY();
            model.setshape(x, y);
    }

}