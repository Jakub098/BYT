package p1;

public class Driver {

	public static void main(String[] args) {
		
		MementoKeeper caretaker = new MementoKeeper();
        StateManager originator = new StateManager();
        originator.setState("1");
        caretaker.addMemento(originator.createMemento());
        originator.setState("2");
        caretaker.addMemento(originator.createMemento());
        originator.setState("3");
        caretaker.addMemento(originator.createMemento());
        originator.restore(caretaker.getMemento(0));
        System.out.println("current state is " + originator.getState());
        originator.restore(caretaker.getMemento(1));
        System.out.println("current state is " + originator.getState());
	}

}
