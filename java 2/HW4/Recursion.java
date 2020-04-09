import java.util.ArrayList;
/**
@author Thien Tommy Nguyen 
@version Version 1
**/
public class Recursion{
	public static int n = 0;

/**
@return an int when comparing to strings
@return the method until it hits base case
@param s1 the first string
@param s2 the second string
**/
	public static int compareTo (String s1, String s2){
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		if (s1.length()==n && s2.length()==n){
			return 0;
		}
		else if (s1.length()==n){
			return -1;
		}
		else if (s2.length()==n){
			return 1;
		}

		if (s1.charAt(n) < s2.charAt(n)){
			return -1;
		}
		else if (s1.charAt(n) > s2.charAt(n)){
			return 1;
		}

		else{
			return compareTo(s1.substring(n+1),s2.substring(n+1));
		}
	}
/**
@return returns the helper method findMinimum();
@param list the arraylist of strings
**/
	public static String findMinimum(ArrayList<String> list){
		return findMinimum(list,0);
	}
/**
@return returns the method until it gets to the base case
@param n1 the first index in the list
@param n2 the all numbers in the index in the list
**/
	private static String findMinimum(ArrayList<String> stringList, int startindex){
		//make var equal to size-1
		int lastindex = stringList.size()-1;
		//base case for recursion
		if(lastindex == startindex){
			return stringList.get(lastindex);
		}
		// make string equal to the recurse this method
		String stringInIndex = findMinimum(stringList,startindex+1);
		// check if compareTo gets correct data	
		if (compareTo(stringList.get(startindex), stringInIndex) < 0){
			return stringList.get(startindex);
		}
		//else return the indexof the rest
		else {
			return stringInIndex;
		}
	}
}
	
