package p1;

public class StateManager {

	private String state;
	

	public void setState(String state) {
		System.out.println("StateManager: setting state to: " + state);
		this.state = state;
	}

	public Memento createMemento() {
		System.out.println("StateManager: memento created");
		return new Memento(state);
	}

	public void restore(Memento m) {
		state = m.getState();
		System.out.println("StateManager: state after restoring: " + state);
	}

	public String getState() {
		return state;
	}
	
	
}
