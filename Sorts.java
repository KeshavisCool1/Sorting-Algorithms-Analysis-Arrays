public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        steps = 0;
        for (int outer = 0; outer < list.length - 1; outer++){
            for (int inner = 0; inner < list.length-outer-1; inner++){
                steps += 3;//count one compare and 2 gets
                if (list[inner]>(list[inner + 1])){
                    steps += 4;//count 2 gets and 2 sets
                    int temp = list[inner];
                    list[inner] = list[inner + 1];
                    list[inner + 1] = temp;
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();

        steps = 0;
        
        for (int outer = 0; outer < list.length - 1; outer++) {
            int minIndex = outer;
            for (int inner = outer + 1; inner < list.length; inner++) {
                steps += 1;
                if (list[inner] < list[minIndex]) {
                    minIndex = inner;
                }
            }
            // swap
            if (minIndex != outer) {
                steps += 4;
                int temp = list[outer];
                list[outer] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        steps = 0;
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            steps += 1; 
            int j = i - 1;
            
            while (j >= 0 && list[j] > key) {
                steps += 2; 
                list[j + 1] = list[j];
                steps += 2; 
                j--;
            }
            
            list[j + 1] = key;
            steps += 2;
        }
    }

     /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void mergeSort(int [] list, int n){
        //replace these lines with your code
        // System.out.println();
        // System.out.println("Merge Sort");
        // System.out.println();
        
        steps = 0;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        steps += 2; 

        int[] l = new int[mid];
        int[] r = new int[n - mid];
        steps += 2; 

        for (int i = 0; i < mid; i++) {
            l[i] = list[i];
            steps += 2; 
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = list[i];
            steps += 2; 
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(list, l, r, mid, n - mid);

    }

    public void merge(int[] a, int[] l, int[] r, int left, int right) {
      int i = 0, j = 0, k = 0;
      while (i < left && j < right) {
        steps += 1; 
        if (l[i] <= r[j])
        {
          a[k++] = l[i++];
          steps += 3; 
        }
        else
        {
          a[k++] = r[j++];
          steps += 3; 
        }
      }
        
      while (i < left)
      {
        a[k++] = l[i++];
        steps += 3; 
      }
      while (j < right)
      {
        a[k++] = r[j++];
        steps += 3; 
      }
    }    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}
