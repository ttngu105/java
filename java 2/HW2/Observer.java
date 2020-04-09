public interface Observer {
	
	/** @param o checks if observable has changed
	*@param arg give an argument for the observable
	* this method is called when the observered onject is changed*/
	public void update(Observable o, Object arg);
	
}