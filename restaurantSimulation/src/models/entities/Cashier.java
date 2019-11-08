package models.entities;

public class Cashier {
	
	private int id;
	private String nombre;
	private int qunatumBreaks;
	private State state;
	public Cashier(int id, String nombre, int qunatumBreaks, State state) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.qunatumBreaks = qunatumBreaks;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getQunatumBreaks() {
		return qunatumBreaks;
	}
	public void changeState() {
		if (this.state.equals(State.FREE)) {
			this.state = State.OCUPPED;
		}else {
			this.state = State.FREE;
		}
	}
	public State getState() {
		return state;
	}
	@Override
	public String toString() {
		return "Cashier [id=" + id + ", nombre=" + nombre + ", qunatumBreaks=" + qunatumBreaks + ", state=" + state
				+ "]";
	}
	
}
