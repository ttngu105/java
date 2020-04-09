/**
*	an observable is an object thet is observed by an observer
* 	@author Thien Tommy Nguyen
*	@version Verison V.1
*/
import java.util.ArrayList;
public class Observable extends Object{
	
	private boolean changed;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
/**
*	boolean changed sees if this object has changed
* 	observers makes an aray containing observer
*/

	/**
	* @param o is passed into the parameter addObserver
	*/
	public void addObserver(Observer o){
		observers.add(o);
	}

	/**notifyObservers this object has changed then notify 
	*all of its observers
	*this method is equal to null
	*/
	public void notifyObservers(){
		if(changed == true){
			for(int index = 0; index < observers.size(); index++){
				observers.get(index).update(this,null);
			}
		}
	}

	/**notifyObservers this object has changed then notify all of its observers
	* this method is used to indicate that this object has no longer changed
	* @param arg is passed into the parameter for notifyObservers
	*/
	public void notifyObservers(Object arg){
		if(changed == true){
			for(int index = 0; index < observers.size(); index++){
				observers.get(index).update(this,arg);
			}
		}
	}

	/**
	* this Observable object as having been changed
	* the hasChanged method will now return true.
	*/
	protected void setChanged(){
		this.changed = true;
	}

	/**
	* this method indicates that this
	* object has no longer changed
	*/
	protected void clearChanged(){
		this.changed = false;
	}

	/**
	* @return true if and only if the setChanged method has been called more recently than the clearChanged method
	*/
	public boolean hasChanged(){
		return this.changed;
	}

	/**
	* @return the number of observers of this Observable object.
	*/
	public int countObservers(){
		return observers.size();
	}
}