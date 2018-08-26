package mvc.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Deque;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import dialogs.UpdateCircleDialog;
import dialogs.UpdateLineDialog;
import dialogs.UpdatePointDialog;
import dialogs.UpdateRectangleDialog;
import dialogs.UpdateSquareDialog;
import frame.DrawingFrame;
import mvc.model.DrawingModel;
import shape.Command;
import shape.Shape;
import shape.circle.Circle;
import shape.circle.RemoveCircle;
import shape.circle.UpdateCircle;
import shape.line.Line;
import shape.line.RemoveLine;
import shape.line.UpdateLine;
import shape.point.Point;
import shape.point.RemovePoint;
import shape.point.UpdatePoint;
import shape.rectangle.Rectangle;
import shape.rectangle.RemoveRectangle;
import shape.rectangle.UpdateRectangle;
import shape.square.RemoveSquare;
import shape.square.Square;
import shape.square.UpdateSquare;

public class ButtonController {

	private DrawingFrame drawingFrame;
	private DrawingModel drawingModel;
	private ArrayList<Shape> selectedShapes = new ArrayList<>();
	private Color outlineColor=Color.BLACK;
	private Color interiorColor=Color.WHITE;

	public ButtonController(DrawingFrame drawingFrame, DrawingModel drawingModel) {
		super();
		this.drawingFrame = drawingFrame;
		this.drawingModel = drawingModel;
	}

	public void undoClick() {
		System.out.println(drawingModel.getUndoStack().size());
		System.out.println("Model " + drawingModel.getShapes().size());
		if (!drawingModel.getUndoStack().isEmpty()) {
			Command previousCommand = drawingModel.getUndoStack().pollLast();
			previousCommand.unexecute();
			drawingModel.getRedoStack().offerLast(previousCommand);
			drawingFrame.repaint();
		}
	}

	public void redoClick() {
		if (!drawingModel.getRedoStack().isEmpty()) {
			System.out.println(drawingModel.getRedoStack().size());
			Command previousCommand = drawingModel.getRedoStack().pollLast();
			drawingModel.getUndoStack().offerLast(previousCommand);
			previousCommand.execute();
			drawingFrame.repaint();
		}
	}

	public boolean selectedClick(int x, int y) {
		for (int i = drawingModel.getShapes().size() - 1; i >= 0; i--) {
			if (drawingModel.getShapes().get(i).contains(x, y)) {
				drawingModel.getShapes().get(i).setSelected(true);
				selectedShapes.add(drawingModel.getShapes().get(i));
				return true;
			}
		}
		unselectArray();
		return false;
	}

	public void unselectArray() {

		for (int i = selectedShapes.size() - 1; i >= 0; i--) {
			selectedShapes.get(i).setSelected(false);
		}

	}

	public void deleteShape() {
		countSelectedShapes();
		if (!drawingModel.getShapes().isEmpty()) {
			if (!selectedShapes.isEmpty()) {
				Object[] answer = new Object[] { "Yes", "No" };
				int result = JOptionPane.showOptionDialog(null,
						"Are you sure that you want to delete " + selectedShapes.size() + " shapes?", "Delete",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, answer, answer[0]);
				if (result == JOptionPane.YES_OPTION) {
					for (int i = selectedShapes.size() - 1; i >= 0; i--) {

						if (checkSelectedShape(i)) {

							selectedShapes.remove(selectedShapes.get(i));
						}
					}

				}
			} else {
				JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Array of shapes is empty!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateShape() {
		countSelectedShapes();
		if (!selectedShapes.isEmpty()) {
			if (selectedShapes.size() == 1) {

				if (selectedShapes.get(0) instanceof Point) {
					UpdatePointDialog updatePoint = new UpdatePointDialog((Point) selectedShapes.get(0));
					if (updatePoint.getPoint() != null) {
						System.out.println(updatePoint.getPoint().toString());
						UpdatePoint updatePointCommand = new UpdatePoint((Point) selectedShapes.get(0),
								updatePoint.getPoint());
						updatePointCommand.execute();
						drawingModel.getUndoStack().offerLast(updatePointCommand);
					}
					return;
				} 
				if (selectedShapes.get(0) instanceof Line) {
					UpdateLineDialog updateLine = new UpdateLineDialog((Line) selectedShapes.get(0));
					if (updateLine.getLine() != null) {
						System.out.println(updateLine.getLine().toString());
						UpdateLine updateLineCommand = new UpdateLine((Line) selectedShapes.get(0),
								updateLine.getLine());
						updateLineCommand.execute();
						drawingModel.getUndoStack().offerLast(updateLineCommand);
					}
					return;
					
				}
				if (selectedShapes.get(0) instanceof Circle) {
					UpdateCircleDialog updateCircle = new UpdateCircleDialog((Circle) selectedShapes.get(0));
					if (updateCircle.getCircle() != null) {
						System.out.println(updateCircle.getCircle().toString());
						UpdateCircle updateCircleCommand = new UpdateCircle((Circle) selectedShapes.get(0),
								updateCircle.getCircle());
						updateCircleCommand.execute();
						drawingModel.getUndoStack().offerLast(updateCircleCommand);
					}
					return;
					
				}
				if (selectedShapes.get(0) instanceof Square) {
					UpdateSquareDialog updateSquare = new UpdateSquareDialog((Square) selectedShapes.get(0));
					if (updateSquare.getSquare() != null) {
						System.out.println(updateSquare.getSquare().toString());
						UpdateSquare updateSquareCommand = new UpdateSquare((Square) selectedShapes.get(0),
								updateSquare.getSquare());
						updateSquareCommand.execute();
						drawingModel.getUndoStack().offerLast(updateSquareCommand);
					}
					return;
					
				}
				if (selectedShapes.get(0) instanceof Rectangle) {
					UpdateRectangleDialog updateRectangle = new UpdateRectangleDialog((Rectangle) selectedShapes.get(0));
					if (updateRectangle.getRectangle() != null) {
						System.out.println(updateRectangle.getRectangle().toString());
						UpdateRectangle updateRectangleCommand = new UpdateRectangle((Rectangle) selectedShapes.get(0),
								updateRectangle.getRectangle());
						updateRectangleCommand.execute();
						drawingModel.getUndoStack().offerLast(updateRectangleCommand);
					}
					return;
					
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "More than one shape are selected!", "Error!!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void countSelectedShapes() {

		selectedShapes.clear();
		for (int i = drawingModel.getShapes().size() - 1; i >= 0; i--) {
			if (drawingModel.getShapes().get(i).isSelected()) {
				selectedShapes.add(drawingModel.getShapes().get(i));
			}
		}
	}

	public boolean checkSelectedShape(int i) {
		System.out.println(selectedShapes.get(i));
		if (selectedShapes.get(i) instanceof Point) {

			RemovePoint removePoint = new RemovePoint(drawingModel, (Point) selectedShapes.get(i));
			removePoint.execute();
			drawingModel.getUndoStack().offerLast(removePoint);
		}

		else if (selectedShapes.get(i) instanceof Line) {

			RemoveLine removeLine = new RemoveLine(drawingModel, (Line) selectedShapes.get(i));
			removeLine.execute();
			drawingModel.getUndoStack().offerLast(removeLine);
		} else if (selectedShapes.get(i) instanceof Square) {

			RemoveSquare removeSquare = new RemoveSquare(drawingModel, (Square) selectedShapes.get(i));
			removeSquare.execute();
			drawingModel.getUndoStack().offerLast(removeSquare);
		} else if (selectedShapes.get(i) instanceof Rectangle) {

			RemoveRectangle removeRectangle = new RemoveRectangle(drawingModel, (Rectangle) selectedShapes.get(i));
			removeRectangle.execute();
			drawingModel.getUndoStack().offerLast(removeRectangle);
		} else if (selectedShapes.get(i) instanceof Circle) {

			RemoveCircle removeCircle = new RemoveCircle(drawingModel, (Circle) selectedShapes.get(i));
			removeCircle.execute();
			drawingModel.getUndoStack().offerLast(removeCircle);
		} else {
			return false;
		}

		return true;
	}
	
	public void changeOutlineColor() {
		Color newColor = JColorChooser.showDialog(null, "Choose color: ", outlineColor);
               if(newColor!=null) {
            		if(newColor==Color.BLACK) {
                		drawingFrame.getButtonView().getBtnOutlineColor().setForeground(Color.WHITE);
                	} else {
                		drawingFrame.getButtonView().getBtnOutlineColor().setForeground(Color.BLACK);
                	}
            	   drawingFrame.getButtonView().getBtnOutlineColor().setBackground(newColor);
            	   outlineColor=newColor;
               }
	}
	
	public void changeInteriorColor() {
		Color newColor = JColorChooser.showDialog(null, "Choose color: ", interiorColor);
        if(newColor!=null) {
        	if(newColor==Color.BLACK) {
        		drawingFrame.getButtonView().getBtnInteriorColor().setForeground(Color.WHITE);
        	} else {
        		drawingFrame.getButtonView().getBtnInteriorColor().setForeground(Color.BLACK);
        	}
     	   drawingFrame.getButtonView().getBtnInteriorColor().setBackground(newColor);
     	   interiorColor=newColor;
        }
        
	}

	public Color getOutlineColor() {
		return outlineColor;
	}

	public Color getInteriorColor() {
		return interiorColor;
	}

}