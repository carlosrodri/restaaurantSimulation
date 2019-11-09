package models.entities;

import java.util.ArrayList;

public class Atention extends MyThread{

	private Waiter waiter;
	private ArrayList<Client> clientList;
	private ArrayList<Order> orderList;
	private Table table;
	private double time;
	
	public Atention(int sleep, Waiter waiter, ArrayList<Client> clientList, ArrayList<Order> orderList, Table table, Kitchen kitchen) {
		super(sleep);
		this.waiter = waiter;
		this.waiter.addOrder(kitchen, orderList, clientList);
		this.clientList = clientList;
		this.orderList = orderList;
		this.table = table;
		this.time = 0;
	}
	
	public Waiter getWaiterList() {
		return waiter;
	}
	public ArrayList<Client> getClientList() {
		return clientList;
	}
	
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	public Table getTable() {
		return table;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public double getTime() {
		return time;
	}
	@Override
	public String toString() {
		return "Atention [waiterList=" + waiter + ", clientList=" + clientList + "]";
	}
	@Override
	public void executeTask() {
		time ++;
		waiter.executeTask();
	}
}
