//time complexity => O(n^2)
//space complexity => O(n) 

class HelloWorld {
    public static void selectionSort(int arr[], int N) {
    int minIdx;
    for(int i = 0; i < N - 1; i++) {
        minIdx = i;
        for(int j = i + 1; j < N; j++) {
            if(arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        if(minIdx != i) {
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
    
    public static void display(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 2};
        System.out.println("Before sorting");
        display(arr);
        selectionSort(arr, arr.length);
        System.out.println("After sorting");
        display(arr);
    }
}
