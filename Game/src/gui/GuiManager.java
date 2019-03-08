package gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.List;

import display.GameWindow;


public class GuiManager implements MouseMotionListener{
	
	private List<GuiElement> guiElements;
	
	public GuiManager(List<GuiElement> guiElements) {
		this.guiElements = guiElements;
	}
	
	public void render(Graphics g, ImageObserver observer) {
		for(GuiElement guiElement:guiElements) {
			guiElement.render(g, observer);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		float x = e.getX();
		float y = e.getY();
		
		System.out.println("x: " + x +" y: "+ y);		
		for(GuiElement guiElement:guiElements) {
			if(guiElement.mouseOver(x, y)) {
				System.out.println("IN");
			}
		}
		
	}



}
