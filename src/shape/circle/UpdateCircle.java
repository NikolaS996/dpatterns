package shape.circle;

import shape.Command;
import shape.point.Point;

public class UpdateCircle implements Command {
	
	private Circle originalCircle; 
	private Circle newCircle; 
	private Circle tmpCircle; 
	
	public UpdateCircle(Circle originalCircle, Circle newCircle) {
		this.originalCircle=originalCircle;
		this.newCircle=newCircle;
	}

	@Override
	public void execute() {
		tmpCircle=new Circle(new Point(originalCircle.getCenter().getX(), originalCircle.getCenter().getY(), originalCircle.getColor()), originalCircle.getR(), originalCircle.getColor(), originalCircle.getInsideColor());
		originalCircle.getCenter().setX(newCircle.getCenter().getX());
		originalCircle.getCenter().setY(newCircle.getCenter().getY());
		originalCircle.getCenter().setColor(newCircle.getCenter().getColor());
		originalCircle.setR((newCircle.getR()));
		originalCircle.setColor(newCircle.getColor());
		originalCircle.setInsideColor(newCircle.getInsideColor());
	}

	@Override
	public void unexecute() {
		originalCircle.getCenter().setX(tmpCircle.getCenter().getX());
		originalCircle.getCenter().setY(tmpCircle.getCenter().getY());
		originalCircle.getCenter().setColor(tmpCircle.getCenter().getColor());
		originalCircle.setR(tmpCircle.getR());
		originalCircle.setColor(tmpCircle.getColor());
		originalCircle.setInsideColor(tmpCircle.getInsideColor());
		
	}

}