package shape.line;

import shape.Command;
import shape.point.Point;

public class UpdateLine implements Command {
	
	private Line originalLine; 
	private Line newLine; 
	private Line tmpLine; 
	
	public UpdateLine(Line originalLine, Line newLine) {
		this.originalLine=originalLine;
		this.newLine=newLine;
	}

	@Override
	public void execute() {
		tmpLine=new Line(new Point(originalLine.getStartPoint().getX(), originalLine.getStartPoint().getY(), originalLine.getStartPoint().getColor()), new Point(originalLine.getEndPoint().getX(), originalLine.getEndPoint().getY(), originalLine.getEndPoint().getColor()), originalLine.getColor());
		originalLine.getStartPoint().setX(newLine.getStartPoint().getX());
		originalLine.getStartPoint().setY(newLine.getStartPoint().getY());
		originalLine.getStartPoint().setColor(newLine.getStartPoint().getColor());
		originalLine.getEndPoint().setX(newLine.getEndPoint().getX());
		originalLine.getEndPoint().setY(newLine.getEndPoint().getY());
		originalLine.getEndPoint().setColor(newLine.getEndPoint().getColor());
		originalLine.setColor(newLine.getColor());
	}

	@Override
	public void unexecute() {
		originalLine.getStartPoint().setX(tmpLine.getStartPoint().getX());
		originalLine.getStartPoint().setY(tmpLine.getStartPoint().getY());
		originalLine.getStartPoint().setColor(tmpLine.getStartPoint().getColor());
		originalLine.getEndPoint().setX(tmpLine.getEndPoint().getX());
		originalLine.getEndPoint().setY(tmpLine.getEndPoint().getY());
		originalLine.getEndPoint().setColor(tmpLine.getEndPoint().getColor());
		originalLine.setColor(tmpLine.getColor());
		
	}

}