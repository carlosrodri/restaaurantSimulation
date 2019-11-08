package models.entities;

import java.util.ArrayList;

public class Dish {
	
	private String name;
	private Hability hability;
	private double price;
	private double timeOfOPreparation;
	private double timeOfOfConsumption;
	private ArrayList<Double> califications;
	
	public Dish(String name, Hability hability, double price, double timeOfOPreparation, double timeOfOfConsumption) {
		super();
		this.name = name;
		this.hability = hability;
		this.price = price;
		this.timeOfOPreparation = timeOfOPreparation;
		this.califications = new ArrayList<>();
		this.timeOfOfConsumption = timeOfOfConsumption;
	}
	public String getName() {
		return name;
	}
	public Hability getHability() {
		return hability;
	}
	public double getPrice() {
		return price;
	}
	public double getTimeOfOfConsumption() {
		return timeOfOfConsumption;
	}
	public double getTimeOfOPreparation() {
		return timeOfOPreparation;
	}
	public ArrayList<Double> getCalification() {
		return califications;
	}
	public void addClification(double calification) {
		this.califications.add(calification);
	}
	@Override
	public String toString() {
		return "Dish [name=" + name + ", hability=" + hability + ", price=" + price + ", timeOfOPreparation="
				+ timeOfOPreparation + " , calificaation=\" + calification +]";
	}
	
}
