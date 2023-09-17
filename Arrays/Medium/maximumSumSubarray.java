public class maximumSumSubarray {
    
    public static long maxSubArr(int[] arr, int n) {
        long sum=0, maxi=arr[0];

		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			maxi = Math.max(maxi, sum);

			if(sum < 0) {
				sum = 0;
			}
		}
		if(maxi < 0){            
			maxi = 0;        
		}        
		return maxi;     
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = -2;
        arr[2] = 4;
        arr[3] = 68;
        arr[4] = 33;

        long ans;
        ans = maxSubArr(arr, n);
        System.out.println("The maximum sum subarray's sum is: " + ans);
    }
}
