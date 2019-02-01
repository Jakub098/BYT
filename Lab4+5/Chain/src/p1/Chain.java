package p1;

public interface Chain {

	/**
	 * defines the next object to handle he request (if this one can't)
	 * 
	 * @param nextChain
	 */
	public void setNextChain(Chain nextChain);

	/**
	 * calculate the result or sends the request to the next element in the chain
	 * 
	 * @param request
	 */
	public void calculate(Request request);

}
