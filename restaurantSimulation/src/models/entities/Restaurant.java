package models.entities;


import models.dao.SimulationManager;
import models.structures.NodeList;
import models.structures.Queue;

public class Restaurant extends MyThread{

	private Queue<Atention> atentionQueue;
	private int timeOfSimulation;
	private int currentTime;
	private SimulationManager simulationManager;
	private Kitchen kitchen;

	public Restaurant(int sleep, int timeOfSimulation, Kitchen kitchen) {
		super(sleep);
		this.atentionQueue = new Queue<>();
		this.timeOfSimulation = timeOfSimulation*1000;
		simulationManager = new SimulationManager();
		this.kitchen = kitchen;
	}

	public Queue<Atention> getAtentionQueue() {
		return atentionQueue;
	}
	public int getTimeOfSimulation() {
		return timeOfSimulation;
	}

	public void addAtention(Atention atention) {
		this.atentionQueue.enqueue(new NodeList<Atention>(atention));
	}

	@Override
	public String toString() {
		return "Restaurant [atentionQueue=" + atentionQueue + ", timeOfSimulation=" + timeOfSimulation + "]";
	}
	@Override
	public void executeTask() {
		currentTime ++;
		System.out.println(currentTime + "tiempo actual  ------------  " + timeOfSimulation + " tiempo de simulacion");
		if (currentTime == timeOfSimulation) {
			this.stop();
		}
		try {
			if(simulationManager.generateAtention(kitchen) != null) {
				addAtention(simulationManager.generateAtention(kitchen));
			}else {
				System.out.println("Cliente en espera...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dequeueAtentions();		
	}

	private void dequeueAtentions() {
		if (this.atentionQueue.getHead()
				!= null && SimulationManager.getWaiterSimulation()) {
			
			while (this.atentionQueue.getHead() != null) {
				Atention atention = atentionQueue.dequeue().getInformation();
				atention.start();
			}
		}

	}
}
