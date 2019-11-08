package models.entities;

import java.util.ArrayList;

public class Chef extends MyThread{
	
	private int id;
	private String nombre;
	private int hoursOfWork;
	private int quantumBreaks;
	private ArrayList<Hability> habilities;
	private double error;
	private State state;
	private double timeOfSimulation;
	private double timeOfPreparation;
	public Chef(int sleep, int id, String nombre, int hoursOfWork, int quantumBreaks, ArrayList<Hability> habilities, double error,
			State state) {
		super(sleep);
		this.id = id;
		this.nombre = nombre;
		this.hoursOfWork = hoursOfWork;
		this.quantumBreaks = quantumBreaks;
		this.habilities = habilities;
		this.error = error;
		this.state = state;
		this.timeOfSimulation = 0;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setTimeOfPreparation(double time) {
		this.timeOfPreparation = time;
		changeState();
	}
	public int getHoursOfWork() {
		return hoursOfWork;
	}
	public int getQuantumBreaks() {
		return quantumBreaks;
	}
	public ArrayList<Hability> getHabilities() {
		return habilities;
	}
	public double getError() {
		return error;
	}
	public void changeState() {
		if (this.state.equals(State.OCUPPED)) {
			this.state = State.FREE;
		}else {
			this.state = State.OCUPPED;
		}
	}
	public State getState() {
		return state;
	}
	@Override
	public String toString() {
		return "Chef [id=" + id + ", nombre=" + nombre + ", hoursOfWork=" + hoursOfWork + ", quantumBreaks="
				+ quantumBreaks + ", habilities=" + habilities + ", error=" + error + ", state=" + state + "]";
	}
	@Override
	public void executeTask() {
		timeOfSimulation ++;
		timeOfPreparation --;
		if (timeOfSimulation%2000 == 0) {
			changeState();
			if (timeOfSimulation == 2332 || timeOfSimulation == 4332 || timeOfSimulation == 6332) {
				changeState();
			}
		}
		if (timeOfPreparation == 0) {
			changeState();
		}
	}
}
