package mvc.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import shape.Command;
import shape.Shape;

public class DrawingModel {

	private ArrayList<Shape> shapes = new ArrayList<>();
	private Deque<Command> redoStack = new LinkedList<>();
	private Deque<Command> undoStack = new LinkedList<>();

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}

	public Shape getShape(int i) {
		return shapes.get(i);
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Deque<Command> getRedoStack() {
		return redoStack;
	}

	public Deque<Command> getUndoStack() {
		return undoStack;
	}
	
}