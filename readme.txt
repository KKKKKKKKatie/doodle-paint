It is a simple doodle program. 
I implement it with MVC. We have three views in this program. 
The first is color palette(View Class). It shows on the left of 
the window. When we choose a color, we have a current color button 
to indicate the color that user choose. We also have custom color 
button, and user could choose other colors outside the color 
palette. Besides, we have three thick buttons, so the doodle 
support to draw line with different thickness. The second view is 
the canvas(Canvas Class). It is the main area of this program. If 
we draw a new shape, it will repaint. On the bottom of the area is
 the controller (Scrollbar Class). There are four buttons, play, 
 playback, undo and redo. It can be played animations both forward
  and backward (Enhancement).

Model receives data and performed actions. I use two array to 
store the shapes, one is current shape and the other is the backup 
shape. Since we have redo and undo features, backup shape can help 
us to do this. 

Controller receives all actions from mouse. When user click a 
button, it will call back to model to perform the corresponding 
actions.

