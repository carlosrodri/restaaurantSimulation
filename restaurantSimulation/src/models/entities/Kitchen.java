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
		this.start();
	}

	@Override
	public void executeTask() {
		try {
			atent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * monitorea el tiempo de simulacion, tambien verifica si hay ordenes para atenderlas 
	 * @throws Exception 
	 */
	private void atent() throws Exception {
		timeOfSimulation ++;
		if (timeOfSimulation == 8000) {
			stopAll();
		}
		if (orderQueue.getHead() != null && chefDsiponibility(null) != null) {
			Order orderInWay = orderQueue.dequeue().getInformation();
			for (Dish dish : orderInWay.getDishesLis()) {
				Chef chef = chefDsiponibility(dish);
				chef.executeTask();
				if (chef != null) {
					chef.setTimeOfPreparation(dish.getTimeOfOfConsumption());
				}
			}
			orderInWay.setStateOfOrder(StateOfOrder.FINISHED);
		}
	}

	/**
	 * detiene el trabajo de la comcina como el de los chefs cuando se cumple con las horas de trabajo
	 */
	private void stopAll() {
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
	 * @throws Exception 
	 */
	public Chef chefDsiponibility(Dish dish) throws Exception {
		System.out.println(cheflist.get(0).getState() +" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if (cheflist.size() == 2) {
			if (cheflist.get(0).getState().toString().equals(State.FREE.toString())) {
				System.out.println("chef libre");
				return cheflist.get(0);
			}else if (cheflist.get(1).getState().toString().equals(State.FREE.toString())) {
				System.out.println("chef libre");
				return cheflist.get(1);
			}else{
				throw new Exception("No hay chefs libres, esperando...");
			}
		}else {
			
		}
		throw new Exception("No hay chefs libres, esperando...");
	}

}
