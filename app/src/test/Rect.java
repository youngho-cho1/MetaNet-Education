package test;

public class Rect extends Shape{
	protected int width, height;
	public Rect() {
		this(0,0);
	}
	public Rect(int w, int h) {
		width = w;
		height = h;
		x = getWidth();
		y = getHeight();
	}
	public double a() {
		return width * height;
	}
	
	public double b() {
		return 2 * (width + height);
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setSzie(int w, int h) {
		width = w;
		height = h;
	}
	public int getSize() {
		return x * y;
	}
}

