package shape.square;

import mvc.model.DrawingModel;
import shape.Command;

public class RemoveSquare implements Command {

	private DrawingModel model;
	private Square square;

	public RemoveSquare(DrawingModel model, Square square) {
		this.model = model;
		this.square = square;
	}

	@Override
	public void execute() {
		model.removeShape(square);
		

	}

	@Override
	public void unexecute() {
		model.addShape(square);
		

	}
}