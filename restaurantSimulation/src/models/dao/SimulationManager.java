package models.dao;

import java.util.ArrayList;

import models.entities.Atention;
import models.entities.Client;
import models.entities.Dish;
import models.entities.Hability;
import models.entities.Order;
import models.entities.State;
import models.entities.Table;
import models.entities.Waiter;

public class SimulationManager {
	private static ArrayList<Waiter> waiters;
	private static ArrayList<Table> tables;
	private static ArrayList<Dish> dishes;

	public SimulationManager() {
		SimulationManager.waiters = new ArrayList<>();
		SimulationManager.tables =  new ArrayList<>();
		dishes = new ArrayList<>();
		generate();
	}

	/**
	 * genera 2 meseros y las 14 mesas
	 */
	private void generate() {
		for (int i = 0; i < 2; i++) {
			waiters.add(new Waiter(16, i, State.FREE, 8, 0, 0, 0));
		}

		for (int i = 0; i < 14; i++) {
			tables.add(new Table(i, State.FREE, 5));
		}

		dishes.add(new Dish("Causa de atún", Hability.ENTARDA, 13000, 5, 7.10));
		dishes.add(new Dish("Chicharrón de calamar", Hability.ENTARDA, 11000, 6, 4));
		dishes.add(new Dish("Chicharrón de pescado", Hability.ENTARDA, 14000, 9.12, 5.12));
		dishes.add(new Dish("Choritos a la chalaca", Hability.ENTARDA, 10600, 7.14, 9.34));
		dishes.add(new Dish("Leche de tigre ", Hability.ENTARDA, 9800, 4.6, 13.1));

		dishes.add(new Dish("Aguadito norteño ", Hability.PLATO_PRINCIPAL, 33800, 11.23, 27.12));
		dishes.add(new Dish("Chupe de langostinos", Hability.PLATO_PRINCIPAL, 35200, 15.19, 32));
		dishes.add(new Dish("Lomo saltado", Hability.PLATO_PRINCIPAL, 28600, 18.33, 22.18));
		dishes.add(new Dish("Saltado orgía marina", Hability.PLATO_PRINCIPAL, 40000, 14.02, 25.17));
		dishes.add(new Dish("Sudado de pescado", Hability.PLATO_PRINCIPAL, 37700, 7, 26.31));

		dishes.add(new Dish("Chocotejas", Hability.POSTRE, 5000, 11.34, 8.07));
		dishes.add(new Dish("Arroz con leche.", Hability.POSTRE, 3600, 13.19, 7.12));
		dishes.add(new Dish("Suspiro limeño.", Hability.POSTRE, 6900, 19.22, 9.40));
		dishes.add(new Dish("Leche asada", Hability.POSTRE, 7600, 17.14, 6.37));
		dishes.add(new Dish("Mazamorra morada", Hability.POSTRE, 4800, 15.18, 6.18));
		dishes.add(new Dish("Sanguito", Hability.POSTRE, 6200, 12, 8.19));
		dishes.add(new Dish("Frejol colado", Hability.POSTRE, 5800, 13.21, 7.2));
		dishes.add(new Dish("Picarones", Hability.POSTRE, 4000, 14.32, 6.28));
		dishes.add(new Dish("Ranfañote", Hability.POSTRE, 6000, 15.09, 10.12));
		dishes.add(new Dish("Bola de oro", Hability.POSTRE, 7400, 13.12, 4.58));
	}

	public synchronized Atention generateAtention() {
		ArrayList<Client> clientList = generateClientList();
		if (getFreeWaiter() != null && getFreeTable() != null) {
			System.out.println("Generando una nueva orden de atencion en el tiempo: ");
			Waiter waiter = getFreeWaiter();
			return new Atention(16, waiter, clientList, generateOrderList(), getFreeTable());
		}else return null;
	}


	private static Table getFreeTable() {
		for (Table table : tables) {
			if (table.getState().equals(State.FREE)) {
				return table;
			}else return null;
		}
		return null;
	}

	private static Waiter getFreeWaiter() {
		for (Waiter waiter : waiters) {
			if (waiter.getState().equals(State.FREE)) {
				return waiter;
			}else System.out.println("No hay un mesero disponible todavia"); 
				return null;
		}
		return null;
	}

	private static ArrayList<Order> generateOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * genera unna lista de clientes para una mesa
	 * @return una lista con una cantidad aleatoria de clientes
	 */
	private static ArrayList<Client> generateClientList() {
		ArrayList<Client> clientList = new ArrayList<>();
		for (int i = 0; i < (int)(Math.random()*5) + 1; i++) {
			clientList.add(new Client(i+"", generateDishes()));
		}
		return clientList;
	}

	
	/**
	 * Se generan los platos del pedido de cada persona de forma random
	 * @return una lista de platos que pertenece al pedido de cada persona de la mesa
	 */
	private static ArrayList<Dish> generateDishes() {
		ArrayList<Dish> dishesList = new ArrayList<>();
		dishesList.add(dishes.get(randomF()));
		for (int i = 0; i < randomE(); i++) {
			dishesList.add(dishes.get(randomEN()));
		}
		for (int i = 0; i < randomP(); i++) {
			dishesList.add(dishes.get(randomPO()));
		}
		return dishesList;
	}


	private static int randomPO() {
		return (int) Math.floor(Math.random()*(19-9+1)+9);
	}

	private static int randomP() {
		return (int) Math.floor(Math.random()*(1-0+1)+1);
	}

	private static int randomEN() {
		return (int) Math.floor(Math.random()*(4-0+1)+0);
	}

	private static int randomE() {
		return (int) Math.floor(Math.random()*(2-1+1)+1);
	}

	private static int randomF() {
		return (int) Math.floor(Math.random()*(9-5+1)+5);
	}

	/**
	 * valida si hay un mesero libre para asignarle una mesa
	 * @return
	 */
	public static boolean getWaiterSimulation() {
		for (Waiter waiter : waiters) {
			return waiter.getState().equals(State.FREE);
		}
		return false;
	}

}
