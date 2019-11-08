package models.entities;

public class Table {
	
	private int numberOfTable;
	private State state;
	private int capacity;
	public Table(int numberOfTable, State state, int capacity) {
		super();
		this.numberOfTable = numberOfTable;
		this.state = state;
		this.capacity = capacity;
	}
	public int getNumberOfTable() {
		return numberOfTable;
	}
	public State getState() {
		return state;
	}
	public void changeState() {
		if (this.state.equals(State.FREE)) {
			this.state = State.OCUPPED;
		}else {
			this.state = State.FREE;
		}
	}
	public int getCapacity() {
		return capacity;
	}
	@Override
	public String toString() {
		return "Table [numberOfTable=" + numberOfTable + ", state=" + state + ", capacity=" + capacity + "]";
	}
	
}
