package mvc.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import frame.DrawingFrame;
import mvc.model.DrawingModel;
import shape.Shape;
import shape.circle.AddCircle;
import shape.circle.Circle;
import shape.line.AddLine;
import shape.line.Line;
import shape.point.AddPoint;
import shape.point.Point;
import shape.rectangle.AddRectangle;
import shape.rectangle.Rectangle;
import shape.square.AddSquare;
import shape.square.Square;

public class DrawingController {

	private DrawingModel drawingModel;
	private DrawingFrame drawingFrame;
	
	private Point firstPoint;
	private Shape draggedShape;
	
	public DrawingController(DrawingModel drawingModel, DrawingFrame drawingFrame) {
		this.drawingModel=drawingModel;
		this.drawingFrame=drawingFrame;
	}
	
	private void addPointOnView(MouseEvent e) {
		AddPoint addPoint=new AddPoint(drawingModel,new Point(e.getX(),e.getY(), Color.CYAN));
		System.out.println("Before point: "+drawingModel.getShapes().size());
		addPoint.execute();
		drawingModel.getUndoStack().offerLast(addPoint);
		System.out.println("After point: " +drawingModel.getShapes().size());
		
	}
	
	private void addLineOnView(Line line) {
		AddLine addLine=new AddLine(drawingModel, line);
		addLine.execute();
		drawingModel.getUndoStack().offerLast(addLine);
		System.out.println("Line added");
	}
	
	private void addSquareOnView(Square square) {
		AddSquare addSquare=new AddSquare(drawingModel, square);
		addSquare.execute();
		drawingModel.getUndoStack().offerLast(addSquare); 
		System.out.println("Square added");
	}
	
	private void addCircleOnView(Circle circle) {
		AddCircle addCircle=new AddCircle(drawingModel, circle);
		addCircle.execute();
		drawingModel.getUndoStack().offerLast(addCircle);
		System.out.println("Circe added");
		
	}
	
	private void addRectangleOnView(Rectangle rectangle) {
		AddRectangle addRectangle=new AddRectangle(drawingModel, rectangle);
		addRectangle.execute();
		drawingModel.getUndoStack().offerLast(addRectangle);
	}
	//prvi se dodaje 2 puta? 
	public void drawShape(MouseEvent e) {
		
		if(draggedShape==null) {
			if(pickedShape().toLowerCase().equals("point")) {
				addPointOnView(e);
				
			}
			return;
		}
		
		switch(pickedShape().toLowerCase()) {
		case "line": {
			System.out.println("Line before: "+ drawingModel.getShapes().size());
			addLineOnView((Line) draggedShape);
			drawingModel.removeShape(draggedShape);
			System.out.println("Line after: " + drawingModel.getShapes().size());
			break;
		}
		case "square": {
			System.out.println("Square before: " + drawingModel.getShapes().size());
			addSquareOnView((Square) draggedShape);
			drawingModel.removeShape(draggedShape);
			System.out.println("Square after " +drawingModel.getShapes().size());
			break;
		}
		case "circle": {
			System.out.println("Circle before: " + drawingModel.getShapes().size());
			addCircleOnView((Circle) draggedShape);
			drawingModel.removeShape(draggedShape);
			System.out.println("Circle after: " +drawingModel.getShapes().size());
			break;
		}
		case "rectangle": {
			System.out.println("Rectangle before: " + drawingModel.getShapes().size());
			addRectangleOnView((Rectangle) draggedShape);
			drawingModel.removeShape(draggedShape);
			System.out.println("Rectangle after: " +drawingModel.getShapes().size());
			break;
		}
		
		}
		
		
		drawingFrame.repaint();
		draggedShape=null;

	}
	
	public void handleMousePressed(MouseEvent e) {
		if(pickedShape().equals("Point")) return;
		
	
		firstPoint=new Point(e.getX(), e.getY());
		
		
	}
	
	public void handleMouseDragged(MouseEvent e) {
		if(firstPoint == null) return;
		if(draggedShape!=null) {
			drawingModel.removeShape(draggedShape);
			draggedShape=null;
		} 
	
		int distance=(int)Math.abs(firstPoint.distance(new Point(e.getX(),e.getY())));
		
		switch(pickedShape().toLowerCase()) {
		case "point": {
			return;
		}
		case "line": {
			draggedShape=new Line(firstPoint, new Point(e.getX(), e.getY(), Color.PINK), Color.PINK);
			drawingModel.addShape(draggedShape);
			break;
		}
		case "square": {
			draggedShape=new Square(firstPoint,distance, Color.BLACK, Color.BLUE);	
			drawingModel.addShape(draggedShape);
			break;
		}
		case "circle": {
			draggedShape=new Circle(firstPoint, distance, Color.DARK_GRAY, Color.CYAN );
			drawingModel.addShape(draggedShape);
			break;
		}
		case "rectangle": {
			int XLength = (int) firstPoint.distance(new Point(e.getX(), firstPoint.getY()));
			int YWidth=(int) firstPoint.distance(new Point(firstPoint.getX(), e.getY()));
			draggedShape=new Rectangle(firstPoint, XLength,YWidth,Color.CYAN, Color.green );
			drawingModel.addShape(draggedShape);
			break;
		}
		}
	
		drawingFrame.repaint();
	}
	
	public String pickedShape() {
		return drawingFrame.getButtonView().getComboBox_Shapes().getSelectedItem().toString();
	}
	
	
	

}
