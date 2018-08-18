package mvc.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Deque;

import frame.DrawingFrame;
import mvc.model.DrawingModel;
import mvc.model.UndoStack;
import shape.Command;
import shape.point.AddPoint;
import shape.point.Point;

public class DrawingController {
	
	private DrawingModel drawingModel;
	private DrawingFrame drawingFrame;
	private Deque<Command> undoStack = UndoStack.getUndoStack();
	
	public DrawingController(DrawingModel drawingModel, DrawingFrame drawingFrame) {
		this.drawingModel=drawingModel;
		this.drawingFrame=drawingFrame;
	}
	
	public void addPoint(MouseEvent e) {
		AddPoint addPoint=new AddPoint(drawingModel,new Point(e.getX(),e.getY(), Color.CYAN));
		addPoint.execute();
		undoStack.offerLast(addPoint);
	}
}
