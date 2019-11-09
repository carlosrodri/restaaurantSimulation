package models.entities;

import java.util.ArrayList;

public class Order {

	private double timeToOrder;
	private int priority;
	private StateOfOrder stateOfOrder;
	private ArrayList<Dish> dishesList;
	private Client client;

	public Order(int priority, StateOfOrder stateOfOrder, ArrayList<Dish> dishesList, Client client) {
		super();
		this.timeToOrder = getTimeOfOrder();
		this.priority = priority;
		this.stateOfOrder = stateOfOrder;
		this.dishesList = dishesList;
		this.client = client;
	}

	private double getTimeOfOrder() {
		double time = 0;
		if (dishesList != null) {
			for (Dish dish : dishesList) {
				time += dish.getTimeOfOPreparation();
			}
			return time;
		}
		return time;
	}

	public Client getClient() {
		return client;
	}
	
	public double getTimeToOrder() {
		return timeToOrder;
	}
	public int getPriority() {
		return priority;
	}

	public void addDish(Dish dish) {
		dishesList.add(dish);
		timeToOrder = getTimeOfOrder();

	}
	public void setStateOfOrder(StateOfOrder stateOfOrder) {
		this.stateOfOrder = stateOfOrder;
	}
	public StateOfOrder getStateOfOrder() {
		return stateOfOrder;
	}
	@Override
	public String toString() {
		return "Order [timeToOrder=" + timeToOrder + ", priority=" + priority + ", stateOfOrder=" + stateOfOrder + "]";
	}
	public ArrayList<Dish> getDishesLis() {
		return dishesList;
	}
}
