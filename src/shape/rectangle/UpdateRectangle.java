package shape.rectangle;

import shape.Command;
import shape.point.Point;

public class UpdateRectangle implements Command {
	
	private Rectangle originalRectangle; 
	private Rectangle newRectangle; 
	private Rectangle tmpRectangle; 
	
	public UpdateRectangle(Rectangle originalRectangle, Rectangle newRectangle) {
		this.originalRectangle=originalRectangle;
		this.newRectangle=newRectangle;
	}

	@Override
	public void execute() {
		tmpRectangle=new Rectangle(new Point(originalRectangle.getPointUpLeft().getX(), originalRectangle.getPointUpLeft().getY(), originalRectangle.getPointUpLeft().getColor()), originalRectangle.getLengthSide(), originalRectangle.getWidth(), originalRectangle.getColor(), originalRectangle.getInsideColor());
		originalRectangle.getPointUpLeft().setX(newRectangle.getPointUpLeft().getX());
		originalRectangle.getPointUpLeft().setY(newRectangle.getPointUpLeft().getY());
		originalRectangle.getPointUpLeft().setColor(newRectangle.getPointUpLeft().getColor());
		originalRectangle.setLengthSide(newRectangle.getLengthSide());
		originalRectangle.setWidth(newRectangle.getWidth());
		originalRectangle.setColor(newRectangle.getColor());
		originalRectangle.setInsideColor(newRectangle.getInsideColor());
	}

	@Override
	public void unexecute() {
		originalRectangle.getPointUpLeft().setX(tmpRectangle.getPointUpLeft().getX());
		originalRectangle.getPointUpLeft().setY(tmpRectangle.getPointUpLeft().getY());
		originalRectangle.getPointUpLeft().setColor(tmpRectangle.getPointUpLeft().getColor());
		originalRectangle.setLengthSide(tmpRectangle.getLengthSide());
		originalRectangle.setWidth(tmpRectangle.getWidth());
		originalRectangle.setColor(tmpRectangle.getColor());
		originalRectangle.setInsideColor(tmpRectangle.getInsideColor());
		
	}

}