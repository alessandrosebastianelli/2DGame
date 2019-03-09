package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.List;

import display.GameWindow;
import structures.Vec2;
import structures.Vec3;

public class PlanetsManager implements MouseListener{
	public static final Vec2 TOP_GUI_POSITION = new Vec2(0, 0);
	public static final Vec2 TOP_GUI_SIZE = new Vec2(GameWindow.WIDTH, 40);
	public static final Vec3 GUI_COLOR = new Vec3(25, 25, 112);
	
	private List<Planet> planets;
	
	
	public PlanetsManager(List<Planet> planets) {
		this.planets = planets;
	}
	
	public void render(Graphics g, ImageObserver observer) {
		g.setColor(new Color((int)GUI_COLOR.getX(),(int)GUI_COLOR.getY(),(int)GUI_COLOR.getZ()));
		g.fillRect((int)TOP_GUI_POSITION.getX(),(int)TOP_GUI_POSITION.getY(),(int)TOP_GUI_SIZE.getX(),(int)TOP_GUI_SIZE.getY());
		for(Planet planet:planets) {
			planet.render(g, observer);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(Planet planet:planets) {
			
				if(planet.mouseOver(e.getX(), e.getY())) {
					if(e.getButton() == MouseEvent.BUTTON1) {
					planet.update();
					System.out.println(planet.id);
				}
			}
			
		}
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void addPlanet(Planet planet) {
		this.planets.add(planet);
	}
	
	public Planet searchPlanetByID(String id) {
		Planet planet = null;
		for(Planet p:planets) {
			if(p.getId().equalsIgnoreCase(id)) {
				planet = p;
			}
		}
		return planet;
	}
	
	public void removePlanet(Planet planet) {
		this.planets.remove(planet);
	}

	public void removeAllElements() {
		this.planets.clear();
	}

}
