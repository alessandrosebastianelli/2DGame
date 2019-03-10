package entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.ImageObserver;
import java.util.List;

import gui.GuiManager;

public class PlanetsManager implements MouseListener, MouseWheelListener{
	
	private int selectedPlanet = 0;
	
	private List<Planet> planets;
	
	
	public PlanetsManager(List<Planet> planets) {
		this.planets = planets;
	}
	
	public void render(Graphics2D g, ImageObserver observer) {
		Planet p = planets.get(selectedPlanet);
		p.render(g, observer);
		g.setColor(new Color((int)GuiManager.GUI_COLOR.getX(),(int)GuiManager.GUI_COLOR.getY(),
				(int)GuiManager.GUI_COLOR.getZ(),(int)GuiManager.GUI_COLOR.getW()));
		g.setStroke(new BasicStroke(5));
		g.drawRoundRect((int)p.getX()-5, (int)p.getY()-5, (int)p.getWidth()+10, (int)p.getHeight()+10, 50, 50);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(Planet planet:planets) {
			if(planet.mouseOver(e.getX(), e.getY())) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					planet.update();
				}
			}	
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
			int wheelRot = e.getWheelRotation();
			selectedPlanet += wheelRot;
			selectedPlanet = Math.max(0, Math.min(planets.size()-1, selectedPlanet));
		
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

	public String getSelectedPlanet() {
		return planets.get(selectedPlanet).getId();
	}


}
