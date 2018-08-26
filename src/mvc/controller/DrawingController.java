package mvc.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import dialogs.AddSquareDialog;
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
	private boolean helpClick;
	private Shape shape;
	
	public DrawingController(DrawingModel drawingModel, DrawingFrame drawingFrame) {
		this.drawingModel=drawingModel;
		this.drawingFrame=drawingFrame;
	}
	
	private void addPointOnView(MouseEvent e) {
		AddPoint addPoint=new AddPoint(drawingModel,new Point(e.getX(),e.getY(), pickedColor()));
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
		
		if(shape==null) {
			if(pickedShape().toLowerCase().equals("point")) {
				addPointOnView(e);
				
			}
			return;
		}
		
		switch(pickedShape().toLowerCase()) {
		case "line": {
			System.out.println("Line before: "+ drawingModel.getShapes().size());
			addLineOnView((Line) shape);
			drawingModel.removeShape(shape);
			System.out.println("Line after: " + drawingModel.getShapes().size());
			break;
		}
		case "square": {
			System.out.println("Square before: " + drawingModel.getShapes().size());
			addSquareOnView((Square) shape);
			drawingModel.removeShape(shape);
			System.out.println("Square after " +drawingModel.getShapes().size());
			break;
		}
		case "circle": {
			System.out.println("Circle before: " + drawingModel.getShapes().size());
			addCircleOnView((Circle) shape);
			drawingModel.removeShape(shape);
			System.out.println("Circle after: " +drawingModel.getShapes().size());
			break;
		}
		case "rectangle": {
			System.out.println("Rectangle before: " + drawingModel.getShapes().size());
			addRectangleOnView((Rectangle) shape);
			drawingModel.removeShape(shape);
			System.out.println("Rectangle after: " +drawingModel.getShapes().size());
			break;
		}
		
		}
		
		
		drawingFrame.repaint();
		shape=null;

	}
	
	public void handleMousePressed(MouseEvent e) {
		if(pickedShape().equals("Point")) return;
		
		//firstPoint=new Point(e.getX(), e.getY());
		
		if(pickedShape().equals("Line")) {
			if(helpClick == false) {
				firstPoint = new Point(e.getX(), e.getY(), pickedColor());
				helpClick = true;
			}else
			{
				shape = new Line(firstPoint, new Point(e.getX(), e.getY(), pickedColor()), pickedColor());
				helpClick = false;
				drawingModel.addShape(shape);
				drawingFrame.repaint();
			}
		}
		
		/*if(tglbtnKvadrat.isSelected()){
						Tacka goreLevo = new Tacka(arg0.getX(), arg0.getY());
						DlgCrtanjeKvadrata dlgKvadrat = new DlgCrtanjeKvadrata();
						dlgKvadrat.setVisible(true);

						if(dlgKvadrat.prihvaceno)
						{
							Kvadrat kv = new Kvadrat(goreLevo, dlgKvadrat.duzinaStranice, bojaIvice, bojaUnutrasnjosti);
							kv.crtajSe(pnlCrtanje.getGraphics());
							kv.popuni(pnlCrtanje.getGraphics());
							pnlCrtanje.listaOblika.add(kv);
						}
					}*/
		
		if(pickedShape().equals("Square")) {
			firstPoint = new Point(e.getX(), e.getY(), pickedColor());
			AddSquareDialog addSquare = new AddSquareDialog();
			
			if(addSquare.accepted) {
				shape = new Square(firstPoint, Integer.parseInt(addSquare.txtSideLength.getText()));
				drawingModel.addShape(shape);
				drawingFrame.repaint();
			}
		}
	}

//		
//		
//	}
	
//	public void handleMouseDragged(MouseEvent e) {
//		if(firstPoint == null) return;
//		if(draggedShape!=null) {
//			drawingModel.removeShape(draggedShape);
//			draggedShape=null;
//		} 
//	
//		int distance=(int)Math.abs(firstPoint.distance(new Point(e.getX(),e.getY())));
//		
//		switch(pickedShape().toLowerCase()) {
//		case "point": {
//			return;
//		}
//		case "line": {
//			draggedShape=new Line(firstPoint, new Point(e.getX(), e.getY(), Color.PINK), Color.PINK);
//			drawingModel.addShape(draggedShape);
//			break;
//		}
//		case "square": {
//			draggedShape=new Square(firstPoint,distance, Color.BLACK, Color.BLUE);	
//			drawingModel.addShape(draggedShape);
//			break;
//		}
//		case "circle": {
//			draggedShape=new Circle(firstPoint, distance, Color.DARK_GRAY, Color.CYAN );
//			drawingModel.addShape(draggedShape);
//			break;
//		}
//		case "rectangle": {
//			int XLength = (int) firstPoint.distance(new Point(e.getX(), firstPoint.getY()));
//			int YWidth=(int) firstPoint.distance(new Point(firstPoint.getX(), e.getY()));
//			draggedShape=new Rectangle(firstPoint, XLength,YWidth,Color.CYAN, Color.green );
//			drawingModel.addShape(draggedShape);
//			break;
//		}
//		}
	
		//drawingFrame.repaint();
//	}
	
	public String pickedShape() {
		return drawingFrame.getButtonView().getComboBox_Shapes().getSelectedItem().toString();
	}
	
	public Color pickedColor() {
				return drawingFrame.getButtonController().getOutlineColor();
			}
			
			public Color pickedInteriorColor() {
				return drawingFrame.getButtonController().getInteriorColor();
			}
	

}
