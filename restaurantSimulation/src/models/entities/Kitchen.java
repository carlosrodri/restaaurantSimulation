package models.entities;

import java.util.ArrayList;

import models.structures.NodeList;
import models.structures.Queue;

public class Kitchen extends MyThread{

	private Queue<Order> orderQueue; 
	private ArrayList<Chef> cheflist;
	private int timeOfSimulation;

	public Kitchen(int sleep, ArrayList<Chef> cheflist) {
		super(sleep);
		this.cheflist = cheflist;
		this.orderQueue = new Queue<>();
		this.timeOfSimulation = 0;
	}

	@Override
	public void executeTask() {
		try {
			atent();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * monitorea el tiempo de simulacion, tambien verifica si hay ordenes para atenderlas 
	 * @throws InterruptedException 
	 */
	private void atent() throws InterruptedException {
		if (timeOfSimulation == 8000) {
			stopAll();
		}
		if (!orderQueue.isEmpty() && chefDsiponibility(null) != null) {
			Order orderInWay = orderQueue.dequeue().getInformation();
			for (Dish dish : orderInWay.getDishesLis()) {
				Chef chef = chefDsiponibility(dish);
				if (chef != null) {
					chef.setTimeOfPreparation(dish.getTimeOfOfConsumption());
				}else {
					System.out.println("el chef está ocupado");
					wait();
				}
			}
			orderInWay.setStateOfOrder(StateOfOrder.FINISHED);
		}
	}

	/**
	 * detiene el trabajo de la comcina como el de los chefs cuando se cumple con las horas de trabajo
	 */
	private void stopAll() {
		for (Chef chef : cheflist) {
			chef.stop();
		}
		this.stop();
	}

	/**
	 * encola ordenes en la cocina
	 * @param order es la nueva orden que llega desde el pedido del mesero
	 */
	public void addOrdersToQueue(Order order) {
		orderQueue.enqueue(new NodeList<Order>(order));
	}


	/**
	 * verifica si hay un chef disponible 
	 * @return un chef en caso de que este esté disponible
	 */
	public Chef chefDsiponibility(Dish dish) {
		for (Chef chef : cheflist) {
			if (chef.getState().equals(State.FREE) || dish.getHability().equals(chef.getHabilities().get(0))) {
				return chef;
			}else if (chef.getState().equals(State.FREE) || dish.getHability().equals(chef.getHabilities().get(1))) {
				return chef;
			}else{
				return null;
			}
		}
		return null;
	}

}
