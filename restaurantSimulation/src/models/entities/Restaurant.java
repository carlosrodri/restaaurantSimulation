package models.entities;


import models.dao.SimulationManager;
import models.structures.NodeList;
import models.structures.Queue;

public class Restaurant extends MyThread{

	private Queue<Atention> atentionQueue;
	private int timeOfSimulation;
	private int currentTime;
	private SimulationManager simulationManager;

	public Restaurant(int sleep, int timeOfSimulation) {
		super(sleep);
		this.atentionQueue = new Queue<>();
		this.timeOfSimulation = timeOfSimulation;
		simulationManager = new SimulationManager();
		start();
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
		if (currentTime == timeOfSimulation) {
			this.stop();
		}
		addAtention(simulationManager.generateAtention());

		dequeueAtentions();		
	}

	private void dequeueAtentions() {
		while (!this.atentionQueue.isEmpty() && SimulationManager.getWaiterSimulation()) {
			atentionQueue.dequeue().getInformation().start();
		}
	}
}
