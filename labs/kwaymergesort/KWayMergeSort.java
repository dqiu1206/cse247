package kwaymergesort;

import java.util.Random;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		Integer[] ans = new Integer[n];
		
		
		if(n<=1){
			return input;
		}
		else{
			ticker.tick();
			Integer[][] split = new Integer[K][n/K];
			split = split(K, input, ticker);

				
		
			for(int i =0; i<K; i++){
					split[i] = kwaymergesort(K, split[i],ticker);
					ticker.tick();
				}
				ticker.tick();
				ans = merge(split, ticker);
			}
		
		return ans;
		}
		
		
	public static Integer[][] split(int K, Integer[] input, Ticker ticker){
		int n = input.length;
		Integer[][] split = new Integer[K][n/K];
		int counter = 0;
		for(int i =0;i <K;i++){
			for(int j = 0; j<(n/K); j++){
				split[i][j] = input[counter];
				counter++;
			}
		}
		return split;
	}
		
		
		
	
	
		
	public static Integer[] merges(Integer[][] array, Ticker ticker){
		int n = array.length;
		int n2 = array[0].length;
		int k = n/2;
		Integer[][] merge = new Integer[k][n2*2];
		Integer[] res = new Integer[n*n2];
		int counter = 0;
		if(n==1){
			return array[0];
		}
	for(int i =0; i< n; i=i+2){
		int left = 0;
		int right = 0;
		int counter2 = 0;
		
		while(left<=n2 && right<=n2){
			if(left<n2&&right<n2){
			if(array[i][left]!=null && array[i+1][right]!=null){
				if(array[i][left]<=array[i+1][right]){
					right++;
					}
				else if(array[i][left]>array[i+1][right]){
					left++;
					}
			}
			else if(array[i][left]==null){
				left++;
			}
			else if(array[i+1][right]==null){
				right++;
			}
			
			}
			else if(left==n2){
				if(right<n2&&array[i][right]!=null){
				merge[counter][counter2] = array[i+1][right];
				array[i+1][right] = null;
				counter2++;
				left = 0;
				right=0;
				}
				else{
					right++;
				}
			}
			else if(right ==n2){
				
				if(left<n2&&array[i][left]!=null){
				merge[counter][counter2] = array[i][left];
				array[i][left] = null;
				counter2++;
				right = 0;
				left=0;
				}
				else{
					left++;
				}
			}
		}
		
			
			counter++;
		}
		merges(merge,ticker);
		return res;
	

	}
	public static Integer[] merge(Integer[][] array, Ticker ticker){
		
		int n = array.length;
		int n2 = array[0].length;
		
		
		int counter = 0;
		int[] temp = new int[n];
		Integer[] res = new Integer[n*n2];
		
		
		ticker.tick(5);
		while(counter<(n*n2)){
			ticker.tick(3);
			int min = Integer.MAX_VALUE;
			int counter2 = 0;
			
			for(int i =0;i < n; i++){
				ticker.tick();
				
				if(temp[i]<n2){
					
					ticker.tick();
					if(array[i][temp[i]] <min){
						min = array[i][temp[i]];
						counter2 = i;
						
						ticker.tick();
					}
				}
			}
			temp[counter2]++;
			res[counter] = min;
			counter++;
			ticker.tick();
			
			
		}
		
		return res;
		
		
	}
	public static void main(String arg[]){
		Random r = new Random();
		Integer[] ans = new Integer[16];
		for (int i=0; i < 16; ++i) {
			ans[i] = r.nextInt();
		}
		Integer[] merged = new Integer[16];
		Ticker t = new Ticker();
		merged = kwaymergesort(4, merged, t);
		System.out.println(merged);
		
	}
	
}
