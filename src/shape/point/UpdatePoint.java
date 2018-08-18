package shape.point;

import shape.Command;

public class UpdatePoint implements Command {
	
	private Point originalPoint; //u modelu
	private Point newPoint; //na koji hocemo da izmjenimo
	private Point tmpPoint; //kao privremena u kojoj cuvamo prethodno stanje
	
	public UpdatePoint(Point originalPoint, Point newPoint) {
		this.originalPoint=originalPoint;
		this.newPoint=newPoint;
	}

	@Override
	public void execute() {
		tmpPoint=new Point(originalPoint.getX(),originalPoint.getY(),originalPoint.getColor());
		originalPoint.setX(newPoint.getX());
		originalPoint.setY(newPoint.getY());
		originalPoint.setColor(newPoint.getColor());
		
	}

	@Override
	public void unexecute() {
		originalPoint.setX(tmpPoint.getX());
		originalPoint.setY(tmpPoint.getY());
		originalPoint.setColor(tmpPoint.getColor());
		
	}

}