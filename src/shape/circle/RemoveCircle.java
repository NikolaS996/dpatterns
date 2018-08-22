package shape.circle;

import mvc.model.DrawingModel;
import shape.Command;

public class RemoveCircle implements Command {

	private DrawingModel model;
	private Circle circle;

	public RemoveCircle(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.removeShape(circle);

	}

	@Override
	public void unexecute() {
		model.addShape(circle);
		

	}
}