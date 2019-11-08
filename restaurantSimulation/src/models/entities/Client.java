package models.entities;

import java.util.ArrayList;

public class Client {
	private String nombre;
	private ArrayList<Dish> dishesList;
	public Client(String nombre, ArrayList<Dish> dishesList) {
		super();
		this.nombre = nombre;
		this.dishesList = dishesList;
	}
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Dish> getDishesList() {
		return dishesList;
	}
	
	public void addDish(Dish dish) {
		this.dishesList.add(dish);
	}
	
	@Override
	public String toString() {
		return "Client [nombre=" + nombre + ", dishesList=" + dishesList + "]";
	}

}
