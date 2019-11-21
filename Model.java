
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

// View interface
interface IView {
    public void updateView();
}

public class Model implements ActionListener {
    /** The observers that are watching this model for changes. */
   List<Observer> observers = new ArrayList<Observer>();
   List<Shape> shapes = new ArrayList<Shape>();
    List<Shape> shapes_backup = new ArrayList<Shape>();
   ArrayList<IView> views = new ArrayList<IView>();
   Color currentcolor = Color.BLACK;
   int thick = 1;
   boolean play = false;
   boolean playback = false;
   //int count = 0;

    /**
     * Create a new model.
     */
    //public Model() {
    //    this.observers = new ArrayList();
     //   this.shapes = new ArrayList();
   // }
    public void addView(IView view) {
        views.add(view);
        view.updateView();
    }
    /**
     * Add an observer to be notified when this model changes.
     */
//    public void notifyObservers() {
//        for (IView view : this.views) {
//            System.out.println("Model: notify View");
//            view.updateView();
//        }
//    }

    /**
     * Remove an observer from this model.
     */
//    public void removeObserver(Observer observer) {
//        this.observers.remove(observer);
//    }

    /**
     * Notify all observers that the model has changed.
     */
    public void notifyObservers() {
        for (IView view : this.views) {
            System.out.println("Model: notify View");
            view.updateView();
        }
    }

    public void setcolor(Color c) {
        this.currentcolor = c;
        notifyObservers();
    }

    public void setthick(int t) {
        this.thick = t;
        notifyObservers();
    }

    public Color getcolor() {
        return this.currentcolor;
    }

    public int getthick() {
        return this.thick;
    }

    public void addshape() {
        Shape s = new Shape();
        s.setColour(currentcolor);
        if (thick == 1) s.setStrokeThickness(3.0f);
        if (thick == 2) s.setStrokeThickness(6.0f);
        if (thick == 3) s.setStrokeThickness(9.0f);
        shapes.add(s);
        shapes_backup = shapes;
    }

    public void setshape(double x, double y) {
        shapes.get(shapes.size() - 1).addPoint(x, y);
        shapes_backup.get(shapes.size() - 1).addPoint(x, y);
        notifyObservers();
    }

    public void redo() {
        if (shapes_backup.size() > shapes.size()) {
            shapes.add(shapes_backup.get(shapes.size()));
        }
        notifyObservers();
    }

    public void undo() {
        if (shapes.size() > 0) {
            shapes.remove(shapes.size() - 1);
        }
        notifyObservers();
    }
    int count;
    int count_back;
    javax.swing.Timer tm = new Timer(1000, this);
    public void play() {
        if (shapes.size() > 0) {
            shapes = new ArrayList<Shape>();
            tm.start();
            count = 0;
            play = true;
            playback = false;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (play) {
            shapes.add(shapes_backup.get(count));
            count++;
            if (shapes.size() == shapes_backup.size()) {
                tm.stop();
                play = false;
            }
        } else if (playback) {
            shapes.remove(shapes_backup.get(count_back));
            count_back--;
            if (shapes.size() == 0) {
                tm.stop();
                playback = false;
                shapes = new ArrayList<Shape>(shapes_backup);
            }
        }
        notifyObservers();
    }

    public void playback() {
        if (shapes.size() > 0) {
            tm.start();
            playback = true;
            play = false;
            count_back = shapes_backup.size() - 1;
        }
    }
}
