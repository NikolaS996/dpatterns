package mvc.view;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import mvc.model.DrawingModel;
import shape.Shape;

public class DrawingView extends JPanel {

	DrawingModel drawingmodel;

	public void paint(Graphics g) {
		super.paint(g);

		if(drawingmodel!=null) {
			Iterator<Shape> it = drawingmodel.getShapes().iterator();
			
			while(it.hasNext()) {
				it.next().drawShape(g);
			}
		}
		repaint();
	}

	public DrawingModel getDrawingmodel() {
		return drawingmodel;
	}

	public void setDrawingmodel(DrawingModel drawingmodel) {
		this.drawingmodel = drawingmodel;
	}
}