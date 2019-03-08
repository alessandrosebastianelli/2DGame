package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import loader.Loader;
import structures.Vec2;

public class TestEntity extends Entity{
	
	private BufferedImage image;
	private static final String ID = "test_entity";

	public TestEntity(Vec2 position, Vec2 size, String name) {
		super(ID, position, size, name);
		image = Loader.loadImage("res/"+name+".png");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, ImageObserver observer) {
		g.drawImage(image, (int)position.getX(), (int)position.getY(), (int)size.getX(), (int)size.getY(), observer);
		
	}
}
