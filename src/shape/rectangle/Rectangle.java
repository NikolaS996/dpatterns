package shape.rectangle;

import java.awt.Color;
import java.awt.Graphics;

import shape.line.Line;
import shape.point.Point;
import shape.square.Square;

public class Rectangle extends Square{
	
	private int width;

	public Rectangle(){

	}
	public Rectangle(Point pointUpLeft, int length, int width){
		super(pointUpLeft, length);
		this.width = width;
	}
	public Rectangle(Point pointUpLeft, int length, int width, Color color){
		this(pointUpLeft, length, width);
		setColor(color);
	}
	public Rectangle(Point pointUpLeft, int length, int width, Color color, Color insideColor){
		this(pointUpLeft, length, width);
		setColor(color);
		setInsideColor(insideColor);
	}
	public Line diagonal(){
		return new Line(pointUpLeft, new Point(pointUpLeft.getX() + lengthSide, pointUpLeft.getY() + width));
	}
	public Point center(){
		return diagonal().middleLine();
	}
	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle tmp=(Rectangle) obj;
			if(this.pointUpLeft.equals(tmp.pointUpLeft) && this.width==tmp.width && lengthSide==tmp.lengthSide)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public String toString(){
		return "Point above left="+ pointUpLeft +", width="+width+", length="+this.lengthSide;
	}

	public int volume(){
		return 2 * (width + lengthSide);
	}
	public int area(){
		return width * lengthSide;
	}
	public boolean sadrzi(int x, int y) {
		if(pointUpLeft.getX()<=x 
				&& x<=(pointUpLeft.getX() + width)
				&& pointUpLeft.getY()<=y 
				&& y<=(pointUpLeft.getY() + lengthSide))
			return true;
		else 
			return false;
	}
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(pointUpLeft, new Point(pointUpLeft.getX()+lengthSide, pointUpLeft.getY())).selected(g);;
		new Line(pointUpLeft, new Point(pointUpLeft.getX(), pointUpLeft.getY()+width)).selected(g);;
		new Line(new Point(pointUpLeft.getX()+lengthSide, pointUpLeft.getY()), diagonal().getEndPoint()).selected(g);;
		new Line(new Point(pointUpLeft.getX(), pointUpLeft.getY()+width), diagonal().getEndPoint()).selected(g);;
	}
	public void drawShape(Graphics g){
		g.setColor(getColor());
		g.drawRect(pointUpLeft.getX(), pointUpLeft.getY(), lengthSide, width);
		fill(g);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getInsideColor());
		g.fillRect(pointUpLeft.getX()+1, pointUpLeft.getY()+1, lengthSide-1, width-1);
		
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}





}
