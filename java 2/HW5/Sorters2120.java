import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;
public class Sorters2120{

    public static <T extends Comparable<T> > void bubbleSort(List<T> theList) {
        int lastToConsider = theList.size();
        while (lastToConsider > 1) {
            for (int j=0; j<lastToConsider-1; j++) {
                if (theList.get(j).compareTo(theList.get(j+1))  >  0 ) {
                    swap(theList,j,j+1);
                }
            }
            lastToConsider--;
        }
    }

    private static <T extends Comparable<T> > void swap(List<T> theList, int i1, int i2) {
        T temp = theList.get(i1);
        theList.set(i1,theList.get(i2));
        theList.set(i2,temp);
    }

    public static <T extends Comparable<T> > void selectionSort(List<T> theList) {
        //SelectionSort
        //Compiles properly; did not check if it actually works yet
        int length = theList.size();
        for(int i = 0; i < length - 1; i++){
            int min = i;
            for(int iPlus = i + 1; iPlus < length; iPlus++){
                if((theList.get(iPlus)).compareTo(theList.get(min)) < 0){
                     min = iPlus;
                }
            }       
        swap(theList, i, min);
        }
    }

    public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
        recursiveMergeSortHelper(theList,0,theList.size()-1);
    }

    private static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {
       //Well, try tree
        //not base case recursive caller to break down theList into multiple list
        if((last - first) >= 1){ //If not base case, so if the list has more then 1 slot
            int middle = (first + last)/2;
            int middlePlus1 = middle + 1;

            recursiveMergeSortHelper(theList, first, middle);
            recursiveMergeSortHelper(theList, middlePlus1, last);

            //Implement something to sort/merge 
            merger(theList, first, middle, middlePlus1, last);
}
}

    private static <T extends Comparable<T> > void merger(List<T> theList, int first, int middle1, int middle2, int last){
         //variables so none of the orginial data is changed
        int left = first;
        int right = middle2;
        int fusedIndex = first;
        List<T> fused = new ArrayList<T>(theList.size());


        //fills null in variables fused
            for(int i = 0; i < theList.size(); i++){
            fused.add(null);
}
        

        while(left <= middle1 && right <= last){
            if(theList.get(left).compareTo(theList.get(right)) <= 0){
                fused.set((fusedIndex++),(theList.get(left++)));
}//Ends if statement
            else{
                fused.set((fusedIndex++), (theList.get(right++)));
} //End of if-else
}// End of while loop

        //if left is empty
        if(left == middle2){
            while(right <= last){
                fused.set((fusedIndex++),(theList.get(right++)));
}// End of while loop
}//Ends of if statement
        else{
            while(left <= middle1){
                fused.set((fusedIndex++),(theList.get(left++)));
}// End of while loop
}//Ends else statement

        for(int i = first; i <= last; i++){
            theList.set((i),(fused.get(i)));
}// Ends for Loop
} // End of merger
 
    public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);
}

    //If the list is sorted
    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last){
        int mid = (first + last)/2;
        int placeholder = -1;

        if(first <= last){
            if(searchItem.compareTo(theList.get(mid)) < 0){
                return recursiveBinarySearcher(searchItem, theList, first, mid -1);
}//Ends if it is out of order statement
             else if(searchItem.compareTo(theList.get(mid)) > 0){
                return recursiveBinarySearcher(searchItem, theList, mid + 1, last);
}//Ends else if is in order statement
            else{
                placeholder = mid;
}
} // Ends if first is greater than last statement
    return placeholder;
}
}