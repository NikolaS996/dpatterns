package mvc.controller;

import java.util.ArrayList;
import java.util.Deque;

import javax.swing.JOptionPane;

import dialogs.UpdatePointDialog;
import frame.DrawingFrame;
import mvc.model.DrawingModel;
import mvc.model.RedoStack;
import mvc.model.UndoStack;
import shape.Command;
import shape.Shape;
import shape.point.Point;
import shape.point.RemovePoint;
import shape.point.UpdatePoint;

public class ButtonController {

	private DrawingFrame drawingFrame;
	private DrawingModel drawingModel;

	private ArrayList<Shape> selectedShapes = new ArrayList<>();
	private Deque<Command> undoStack = UndoStack.getUndoStack();

	public ButtonController(DrawingFrame drawingFrame, DrawingModel drawingModel) {
		super();
		this.drawingFrame = drawingFrame;
		this.drawingModel = drawingModel;
	}

	public void undoClick() {
		UndoStack.undoLastCommand();
	}

	public void redoClick() {
		RedoStack.redoLastCommand();
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

		if (!drawingModel.getShapes().isEmpty()) {
			if (!selectedShapes.isEmpty()) {
				Object[] answer = new Object[] { "Yes", "No" };
				int result = JOptionPane.showOptionDialog(null, "Are you sure that you want to delete " + selectedShapes.size() + " shapes?",
						"Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, answer, answer[0]);
				if (result == JOptionPane.YES_OPTION) {
					for (int i = selectedShapes.size() - 1; i >= 0; i--) {
						RemovePoint removePoint = new RemovePoint(drawingModel, (Point)(selectedShapes.get(i)));
						removePoint.execute();
						undoStack.offerLast(removePoint);
						selectedShapes.remove(selectedShapes.get(i));

					}

				}} else {
					JOptionPane.showMessageDialog(null, "You need to select shape!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}

		} else {
			JOptionPane.showMessageDialog(null, "Array of shapes is empty!", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateShape() {
		countSelectedShapes();
		if(selectedShapes.size()==1) {
			UpdatePointDialog updatePoint = new UpdatePointDialog((Point)selectedShapes.get(0));
			if(updatePoint.getPoint()!=null) {
				System.out.println(updatePoint.getPoint().toString());
				UpdatePoint updatePointCommand = new UpdatePoint((Point) selectedShapes.get(0), updatePoint.getPoint());
				updatePointCommand.execute();
				undoStack.offerLast(updatePointCommand);
			}
		} else {
			JOptionPane.showMessageDialog(null, "More than one shape are selected!", "Error!!", JOptionPane.ERROR_MESSAGE);
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
}
