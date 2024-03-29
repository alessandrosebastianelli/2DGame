package toolkit;

public class Vec2 {
	private float x,y;
	
	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void setValue(Vec2 value) {
		this.x = value.getX();
		this.y = value.getY();
	}

}
