package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import display.GameWindow;
import toolkit.Vec2;


public class GuiManager implements MouseListener, MouseMotionListener{
	
	public static final Vec2 TOP_GUI_POSITION = new Vec2(0, 0);
	public static final Vec2 TOP_GUI_SIZE = new Vec2(GameWindow.WIDTH, 40);
	public static final Color GUI_COLOR_1 = new Color(25, 25, 112, 200);
	public static final Color GUI_COLOR_2 = new Color(255, 255, 255, 255);
	
	private static float mouseX;
	private static float mouseY;
	
	private boolean swpawn = false;
	
	private String clicked;
	
	public List<GuiElement> guiElements = new ArrayList<GuiElement>();
	public GuiManager() {
		clicked = " ";
		mouseX = 0;
		mouseY = 0;
	}
	
	public void render(Graphics2D g, ImageObserver observer) {
		for(GuiElement guiElement:guiElements) {
			guiElement.render(g, observer);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			for(GuiElement guiElement:guiElements) {
				if(guiElement.mouseOver(e.getX(), e.getY())) {
					guiElement.update();
					clicked = guiElement.id;
				} 
			}
			
		} else {
			clicked = " ";
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		for(GuiElement guiElement:guiElements) {
			if(!swpawn) {
				if(guiElement.mouseOver(mouseX,mouseY)) {
					guiElement.changeColor(GUI_COLOR_2);
				} else {
					guiElement.changeColor(GUI_COLOR_1);
				}
			}
		}
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	public void addGuiElement(GuiElement guiElement) {
		this.guiElements.add(guiElement);
	}
	
	public GuiElement searchGuiElementByID(String id) {
		GuiElement guiElement = null;
		for(GuiElement guiEle:guiElements) {
			if(guiEle.getId().equalsIgnoreCase(id)) {
				guiElement = guiEle;
			}
		}
		return guiElement;
	}
	
	public void removeGuiElement(GuiElement guiElement) {
		this.guiElements.remove(guiElement);
	}

	public void removeAllElements() {
		this.guiElements.clear();
	}
	
	public static Vec2 getMousePosition() {
		return new Vec2(mouseX, mouseY);
	}
	
	public String getClicked() {
		return this.clicked;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
