package shape.line;

import mvc.model.DrawingModel;
import shape.Command;

public class RemoveLine implements Command {

	private DrawingModel model;
	private Line line;
	
	public RemoveLine(DrawingModel model, Line line) {
		this.model=model;
		this.line=line;
	}
	
	@Override
	public void execute() {
		model.removeShape(line);	
	}

	@Override
	public void unexecute() {
		model.addShape(line);
	}
}