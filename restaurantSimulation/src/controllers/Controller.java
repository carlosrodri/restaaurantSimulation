package controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.entities.Chef;
import models.entities.Hability;
import models.entities.Kitchen;
import models.entities.Restaurant;
import models.entities.State;

public class Controller {
	private Restaurant restaurant;
	private Kitchen kitchen;
	
	public Controller() {
		ArrayList<Chef> chefList = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			chefList.add(new Chef(i, "Chef " + i, 8, 2, generateHabilitiesList(), 2, State.FREE));
		}
		kitchen = new Kitchen(16, chefList);
		restaurant = new Restaurant(16, Integer.parseInt(JOptionPane.showInputDialog("Por favor ingresa las horas de simulación (Numero entero)")), kitchen);
		restaurant.start();
	}

	private ArrayList<Hability> generateHabilitiesList() {
		ArrayList<Hability> habilities = new ArrayList<Hability>();
		for (int i = 0; i < 4; i++) {
			habilities.add(Hability.ENTARDA);
			habilities.add(Hability.PLATO_PRINCIPAL);
			habilities.add(Hability.POSTRE);
			habilities.add(Hability.POSTRE);
		}
		return habilities;
	}
}
