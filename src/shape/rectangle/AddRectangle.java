package shape.rectangle;

import mvc.model.DrawingModel;
import shape.Command;

public class AddRectangle implements Command {

	private DrawingModel drawingModel;
	private Rectangle rectangle;

	public AddRectangle(DrawingModel drawingModel, Rectangle rectangle) {
		this.drawingModel = drawingModel;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		drawingModel.addShape(rectangle);

	}

	@Override
	public void unexecute() {
		drawingModel.removeShape(rectangle);

	}
}


