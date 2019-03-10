package gui;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import structures.Vec2;

public class PlayButton extends GuiElement{
	
	private static final Vec2 SIZE = new Vec2(32, 32);

	private boolean selected;
	
	public PlayButton(Vec2 position) {
		super("pause_button", position, SIZE, "pause");
		selected = false;
	}
	
	public void render(Graphics2D g, ImageObserver observer) {
		g.drawImage(image, (int)position.getX(), (int)position.getY(), (int)size.getX(), (int)size.getY(), observer);
	}

	@Override
	public void update() {	
		if(selected == false) {
			changeIDAndImage("play", "play_button");
			selected = true;
			return;
		} else {
			changeIDAndImage("pause","pause_button");
			selected = false;
			return;
		}
	}

}
