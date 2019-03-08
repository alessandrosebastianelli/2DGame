package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import loader.Loader;
import structures.Vec2;

public class GuiElement {
	
	private String id;
	private Vec2 position;
	private Vec2 size;
	private BufferedImage image;
	
	public GuiElement(String id,Vec2 position, Vec2 size, String imageName) {
		this.id = id;
		this.position = position;
		this.size = size;
		this.image = Loader.loadImage("res/gui/"+imageName+".png");
	}
	
	public void render(Graphics g, ImageObserver observer) {
		g.drawImage(image, (int)position.getX(), (int)position.getY(), (int)size.getX(), (int)size.getY(), observer);
	}
	
	public boolean mouseOver(float mouseX, float mouseY) {
		if(mouseX > position.getX() && mouseX < position.getX() + size.getX()) {
			if(mouseY > position.getY() && mouseX < position.getY() + size.getY()) {
				return true;
			} else return false;
		}else return false;
	}
	
	public void startAnimation() {
		this.size = new Vec2((float)(size.getX()*1.3), (float) (size.getY()*1.3));
	}
	
	public void stopAnimation() {
		this.size = new Vec2((float)(size.getX()/1.3), (float) (size.getY()/1.3));
	}

	public Vec2 getPosition() {
		return position;
	}

	public void setPosition(Vec2 position) {
		this.position = position;
	}

	public Vec2 getSize() {
		return size;
	}

	public void setSize(Vec2 size) {
		this.size = size;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
