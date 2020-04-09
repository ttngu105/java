public class Stack<T> extends LinkedList
{
	private LinkedList<T> theStack;

	public Stack()
	{
		theStack = new LinkedList<T>();
	}

	public T pop()
	{
		return theStack.popFirstNode(); 
	}

	public boolean stackIsEmnpty()
	{
		return theStack.isEmpty();
	}
	public void push(T value)
	{
		theStack.add(value);
	}
}