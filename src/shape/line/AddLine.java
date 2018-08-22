package shape.line;

import mvc.model.DrawingModel;
import shape.Command;

public class AddLine implements Command {

	private DrawingModel drawingModel;
	private Line line;

	public AddLine(DrawingModel drawingModel, Line line) {
		this.drawingModel = drawingModel;
		this.line = line;
	}

	@Override
	public void execute() {
		//System.out.println(drawingModel.getShapes().size());
		drawingModel.addShape(line);

	}

	@Override
	public void unexecute() {
		drawingModel.removeShape(line);

	}
}