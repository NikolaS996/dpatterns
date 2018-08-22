package shape.point;

import mvc.model.DrawingModel;
import shape.Command;

public class AddPoint implements Command {

	private DrawingModel drawingModel;
	private Point point;

	public AddPoint(DrawingModel drawingModel, Point point) {
		this.drawingModel = drawingModel;
		this.point = point;
	}

	@Override
	public void execute() {
		drawingModel.addShape(point);

	}

	@Override
	public void unexecute() {
		drawingModel.removeShape(point);

	}
}
