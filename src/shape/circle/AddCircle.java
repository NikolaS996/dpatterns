package shape.circle;

import mvc.model.DrawingModel;
import shape.Command;

public class AddCircle implements Command {

	private DrawingModel drawingModel;
	private Circle circle;

	public AddCircle(DrawingModel drawingModel, Circle circle) {
		this.drawingModel = drawingModel;
		this.circle = circle;
	}

	@Override
	public void execute() {
		drawingModel.addShape(circle);

	}

	@Override
	public void unexecute() {
		drawingModel.removeShape(circle);

	}
}