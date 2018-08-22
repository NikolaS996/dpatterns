package shape.square;

import java.awt.Color;
import java.awt.Graphics;

import shape.Moveable;
import shape.SurfaceShape;
import shape.line.Line;
import shape.point.Point;

public class Square extends SurfaceShape implements Moveable{
	protected Point pointUpLeft;
	protected int lengthSide;
	

	public Square() {

	}

	public Square(Point pointUpLeft, int lengthSide) {
		this.pointUpLeft = pointUpLeft;
		this.lengthSide = lengthSide;
	}

	public Square(Point pointUpLeft, int lengthSide, Color color) {
		this(pointUpLeft, lengthSide);
		setColor(color);
	}
	public Square(Point pointUpLeft, int lengthSide, Color color,Color insideColor) {
		this(pointUpLeft, lengthSide);
		setColor(color);
		setInsideColor(insideColor);
	}
	
	public Line diagonal(){
		return new Line(pointUpLeft, new Point(pointUpLeft.getX() + lengthSide,pointUpLeft.getY() + lengthSide));
	}

	public Point center(){
		return diagonal().middleLine();
	}
	public String toString() {
		return "Left above point=(" + pointUpLeft.getX() + "," + pointUpLeft.getY() + "), side=" + lengthSide;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			Square temp = (Square) obj;
			if (this.pointUpLeft.equals(temp.pointUpLeft) && this.lengthSide == temp.lengthSide)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public void moveTo(int x, int y) {
		pointUpLeft.setX(x);
		pointUpLeft.setY(y);
	}

	public void moveFor(int x, int y) {
		pointUpLeft.setX(pointUpLeft.getX() + x);
		pointUpLeft.setY(pointUpLeft.getY() + y);
	}

	public int volume() {
		return 4 * lengthSide;
	}

	public int area() {
		return lengthSide * lengthSide;
	}
	public boolean contains(int x, int y) {
		if(this.getPointUpLeft().getX()<=x 
				&& x<=(pointUpLeft.getX() + lengthSide)
				&& this.pointUpLeft.getY()<=y 
				&& y<=(this.pointUpLeft.getY() + lengthSide))
			return true;
		else 
			return false;
	}
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Line(this.pointUpLeft, new Point(this.pointUpLeft.getX()+lengthSide, this.pointUpLeft.getY())).selected(g);;
		new Line(this.pointUpLeft, new Point(this.pointUpLeft.getX(), this.pointUpLeft.getY()+lengthSide)).selected(g);;
		new Line(new Point(this.pointUpLeft.getX()+lengthSide, this.pointUpLeft.getY()), diagonal().getEndPoint()).selected(g);;
		new Line(new Point(this.getPointUpLeft().getX(), this.pointUpLeft.getY()+lengthSide), diagonal().getEndPoint()).selected(g);;

	}
	public void drawShape(Graphics g){
		g.setColor(getColor());
		g.drawRect(pointUpLeft.getX(), pointUpLeft.getY(), lengthSide, lengthSide);
		if(isSelected())
			selected(g);
		fill(g);
	}
	public void fill(Graphics g){
		g.setColor(getInsideColor());
		g.fillRect(pointUpLeft.getX()+1, pointUpLeft.getY()+1, lengthSide-1, lengthSide-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Square){
			Square temp  = (Square) o;
			return this.area() - temp.area();
		}
		else 
			return 0;
	}

	public Point getPointUpLeft() {
		return pointUpLeft;
	}

	public void setPointUpLeft(Point pointUpLeft) {
		this.pointUpLeft = pointUpLeft;
	}

	public int getLengthSide() {
		return lengthSide;
	}

	public void setLengthSide(int lengthSide) {
		this.lengthSide = lengthSide;
	}
	

}