package p1;

public class Add implements Chain {

	private Chain nextInChain;

	public void setNextChain(Chain nextChain) {
		nextInChain = nextChain;
	}

	public void calculate(Request request) {
		if (request.getOperation().equals("+")) {
			Driver.result = request.getNumber1() + request.getNumber2();
		} else {
			nextInChain.calculate(request);
		}
	}
}