package models.entities;

import java.util.ArrayList;

public class Waiter {

	private int id;
	private State state;
	private int hoursOfWork;
	private int quantumOfOrder;
	private int timeOfAtention;

	private double tip;
	private ArrayList<Double> calification;

	public Waiter( int id, State state, int hoursOfWork, int quantumOfOrder, double tip, int timeOfAtention) {
		this.id = id;
		this.state = state;
		this.hoursOfWork = hoursOfWork*1000;
		this.quantumOfOrder = quantumOfOrder;
		this.tip = tip;
		this.calification = new ArrayList<>();
		this.timeOfAtention = timeOfAtention;
	}
	public int getId() {
		return id;
	}
	public State getState() {
		return state;
	}
	public int getHoursOfWork() {
		return hoursOfWork;
	}
	public int getQuantumOfOrder() {
		return quantumOfOrder;
	}
	public void changeState() {
		if (this.state.equals(State.FREE)) {
			this.state = State.OCUPPED;
		}else {
			this.state = State.FREE;
		}
	}
	public ArrayList<Double> getCalification() {
		return calification;
	}
	public void addCalification(double calification) {
		this.calification.add(calification);
	}
	public double getTip() {
		return tip;
	}
	@Override
	public String toString() {
		return "Waiter [id=" + id + ", state=" + state + ", hoursOfWork=" + hoursOfWork + ", quantumOfBreaks="
				+ ", quantumOfOrder=" + quantumOfOrder + ", tip=" + tip + ", calificaation=\" + calification + ]";
	}

	public int getTimeOfAtention() {
		return timeOfAtention;
	}

	
	/**
	 * corre el tiempo de trabajo, valida sus descansos y cuando está libre o no dependiendo de los pedidos que tenga
	 * en cola
	 */
	public void executeTask() {
		hoursOfWork ++;
		if (timeOfAtention > 0) {
			timeOfAtention --;
		}else if (hoursOfWork % 2000 == 0) {
			changeState();
			if (hoursOfWork == 2166 || hoursOfWork == 4166 || hoursOfWork == 6166) {
				System.out.println("DEcansoooooooooooooooo");
				changeState();
			}
		}
		if (timeOfAtention == 0) {
			changeState();
		}
	}
	
	public void addOrder(Kitchen kitchen, ArrayList<Order> orderList, ArrayList<Client> clientList) {
		for (Order order : orderList) {
			kitchen.addOrdersToQueue(new Order(1, StateOfOrder.ON_WAY, order.getDishesLis(), null));
		}
	}

}
