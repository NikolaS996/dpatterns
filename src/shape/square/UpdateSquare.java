package shape.square;

import shape.Command;
import shape.point.Point;

public class UpdateSquare implements Command {
	
	private Square originalSquare; 
	private Square newSquare; 
	private Square tmpSquare; 
	
	public UpdateSquare(Square originalSquare, Square newSquare) {
		this.originalSquare=originalSquare;
		this.newSquare=newSquare;
	}

	@Override
	public void execute() {
		tmpSquare=new Square(new Point(originalSquare.getPointUpLeft().getX(), originalSquare.getPointUpLeft().getY(), originalSquare.getPointUpLeft().getColor()), originalSquare.getLengthSide(), originalSquare.getColor(), originalSquare.getInsideColor());
		originalSquare.getPointUpLeft().setX(newSquare.getPointUpLeft().getX());
		originalSquare.getPointUpLeft().setY(newSquare.getPointUpLeft().getY());
		originalSquare.getPointUpLeft().setColor(newSquare.getPointUpLeft().getColor());
		originalSquare.setLengthSide(newSquare.getLengthSide());
		originalSquare.setColor(newSquare.getColor());
		originalSquare.setInsideColor(newSquare.getInsideColor());
	}

	@Override
	public void unexecute() {
		originalSquare.getPointUpLeft().setX(tmpSquare.getPointUpLeft().getX());
		originalSquare.getPointUpLeft().setY(tmpSquare.getPointUpLeft().getY());
		originalSquare.getPointUpLeft().setColor(tmpSquare.getPointUpLeft().getColor());
		originalSquare.setLengthSide(tmpSquare.getLengthSide());
		originalSquare.setColor(tmpSquare.getColor());
		originalSquare.setInsideColor(tmpSquare.getInsideColor());
		
	}

}