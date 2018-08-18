package shape.point;

import mvc.model.DrawingModel;
import shape.Command;

public class AddPoint implements Command {

	private DrawingModel model;
	private Point point;

	public AddPoint(DrawingModel model, Point point) {
		this.model=model;
		this.point=point;	
	}

	@Override
	public void execute() {
		model.addShape(point);

	}

	@Override
	public void unexecute() {
		model.removeShape(point);
	}
}