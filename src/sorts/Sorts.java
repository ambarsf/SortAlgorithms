package sorts;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author AmbarSuarez
 */
public class Sorts {

    
    public static void main(String[] args) {
        //////////////////seleccionar tamano de la lista 
        int [] list =  new int [10];
        //int [] list = new int [100];
        //int [] list = new int [1000];
        //int [] list = new int [10000];
        //int [] list = new int [100000];
        //int [] list = new int [1000000];
        
        /////////////////llena la lista de numeros random
        fill(list);//llena la lista de numeros random
        
        ///////////////// printing stuff 
        System.out.println("Running Heap Sort list with "+list.length);
        System.out.println("Lista desordenada: ");
        print(list);
        System.out.println("Lista ordenada: ");
        
        long start = System.currentTimeMillis(); // empieza calculo de tiempo
        
        //////////// seleccionar metodo de ordenamiento 
        //BubbleSort(list);
        //InsertSort(list);
        //SelectionSort(list);
        //list=mergeSort(list);
        //RadixSort(list);
        //quickSort(list);
        //heapsort(list);
        
        
        long end = System.currentTimeMillis(); // fin de calculo de tiempo
        
        ///// printing more stuff 
        print(list);
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
    
    public static void fill (int [ ] list){
        Random  rnd = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i]= rnd.nextInt(list.length);
        }
    }
    
    public static void print (int [] list){
        for (int i = 0; i < list.length; i++) {
            System.out.print("["+list[i]+"] ");
        }
        System.out.println("");
    }
    
    public static void BubbleSort( int [ ] num ){
     int j;
     boolean flag = true;   // set flag to true to begin first pass
     int temp;   //holding variable

     while ( flag )
     {
        flag= false;    //set flag to false awaiting a possible swap
        for( j=0;  j < num.length -1;  j++ )
        {
            if ( num[ j ] > num[j+1] )   // change to > for ascending sort
            {
                    temp = num[ j ];                //swap elements
                    num[ j ] = num[ j+1 ];
                    num[ j+1 ] = temp;
                   flag = true;              //shows a swap occurred  
           } 
        } 
      } 
    } 
     
    public static void InsertSort (int [] num){
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int j;
            for (j=i-1; j>=0 && temp < num[j]; j--) {
                num[j+1]=num[j];               
            }
            num[j+1]=temp;           
        }
    }
    
    public static void SelectionSort ( int [ ] num ){
     for ( int i = num.length - 1; i > 0; i-- )  
     {
          int first = 0;   //initialize to subscript of first element
          for(int  j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
          {
               if( num[ j ] > num[ first ] )         
                 first = j;
          }
          int temp = num[ first ];   //swap smallest found with element in position i.
          num[ first ] = num[ i ];
          num[ i ] = temp; 
      }           
    }
    
    public static int[] mergeSort(int array[]){
	if(array.length > 1)
	{
            int elementsInA1 = array.length/2;
            int elementsInA2 = elementsInA1;
            if((array.length % 2) == 1)
                    elementsInA2 += 1;
            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];
            for(int i = 0; i < elementsInA1; i++)
                    arr1[i] = array[i];
            for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                    arr2[i - elementsInA1] = array[i];
            arr1 = mergeSort(arr1);
            arr2 = mergeSort(arr2);

            int i = 0, j = 0, k = 0;
            while(arr1.length != j && arr2.length != k)
            {
                if(arr1[j] < arr2[k])
                {
                    array[i] = arr1[j];
                    i++;
                    j++;
                }
                else
                {
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }
            while(arr1.length != j)
            {
                    array[i] = arr1[j];
                    i++;
                    j++;
            }
            while(arr2.length != k)
            {
                    array[i] = arr2[k];
                    i++;
                    k++;
            }
	}

	return array;
    }
    
    public static void RadixSort(int[] input) {
        final int RADIX = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
          bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
          maxLength = true;
          // split input between lists
          for (Integer i : input) {
            tmp = i / placement;
            bucket[tmp % RADIX].add(i);
            if (maxLength && tmp > 0) {
              maxLength = false;
            }
          }
          // empty lists into input array
          int a = 0;
          for (int b = 0; b < RADIX; b++) {
            for (Integer i : bucket[b]) {
              input[a++] = i;
            }
            bucket[b].clear();
          }
          // move to next digit
          placement *= RADIX;
    }
  }
    
    public static void quickSort(int array[]){
	quickSort(array, 0, array.length - 1);              // quicksort all the elements in the array
}

    public static void quickSort(int array[], int start, int end){
        int i = start;                          // index of left-to-right scan
        int k = end;                            // index of right-to-left scan

        if (end - start >= 1)                   // check that there are at least two elements to sort
        {
                int pivot = array[start];       // set the pivot as the first element in the partition

                while (k > i)                   // while the scan indices from left and right have not met,
                {
                        while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
                                i++;                                    // element greater than the pivot
                        while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
                            k--;                                        // element not greater than the pivot
                        if (k > i)                                       // if the left seekindex is still smaller than
                                swap(array, i, k);                      // the right index, swap the corresponding elements
                }
                swap(array, start, k);          // after the indices have crossed, swap the last element in
                                                // the left partition with the pivot 
                quickSort(array, start, k - 1); // quicksort the left partition
                quickSort(array, k + 1, end);   // quicksort the right partition
        }
        else    // if there is only one element in the partition, do not do any sorting
        {
                return;                     // the array is sorted, so exit
        }
    }

    public static void swap(int array[], int index1, int index2){
	int temp = array[index1];           // store the first value in a temp
	array[index1] = array[index2];      // copy the value of the second into the first
	array[index2] = temp;               // copy the value of the temp into the second
}
    
    public static void heapsort(int arr[]){
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int arr[], int n, int i){
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
