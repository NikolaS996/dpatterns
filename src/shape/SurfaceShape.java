package shape;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape {
	private Color insideColor=Color.WHITE;
	public abstract void fill(Graphics g);

	public Color getInsideColor() {
		return insideColor;
	}
	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}
}