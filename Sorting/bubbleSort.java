class HelloWorld {
    public static void bubbleSort(int arr[], int N) {
        for(int i = 0; i < N - 1; i++) {  
            for(int j = 0; j < N - i - 1; j++) {  
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];  
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void display(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");   inline display
        }
        System.out.println();  
    }
    
    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 2};
        System.out.println("Before sorting");
        display(arr);
        bubbleSort(arr, arr.length);
        System.out.println("After sorting");
        display(arr);
    }
}
