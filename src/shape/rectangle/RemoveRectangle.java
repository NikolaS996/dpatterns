package shape.rectangle;

import mvc.model.DrawingModel;
import shape.Command;

public class RemoveRectangle implements Command {

	private DrawingModel model;
	private Rectangle rectangle;

	public RemoveRectangle(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.removeShape(rectangle);

	}

	@Override
	public void unexecute() {
		model.addShape(rectangle);

	}
}