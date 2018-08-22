package shape.square;

import mvc.model.DrawingModel;
import shape.Command;

public class AddSquare implements Command {

	private DrawingModel drawingModel;
	private Square square;

	public AddSquare(DrawingModel model, Square square) {
		this.drawingModel = model;
		this.square = square;
	}

	@Override
	public void execute() {
		drawingModel.addShape(square);

	}

	@Override
	public void unexecute() {
		drawingModel.removeShape(square);

	}
}

