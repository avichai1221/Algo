package lis;

import java.util.Arrays;

public class lis {
	
		// binary search between in diagonal of matrix
		public static int binarySearchBetween(int [][]arr, int end, int value){
			/**
		if value<arr[0] the function returns zero
		if value>arr[end] the function returns  end+1
		if arr[index-1] < value < arr[index]
		the function returns index,
			 */
			int low = 0, high = end;
			if (value<arr[0][0]) return 0;
			if (value>arr[end][end])  return end+1;
			while (low <=high){
				int middle = (low + high)/2;
				if (low == high) {// stop search
					return low;
				}
				else {
					if (arr[middle][middle] == value){//value was found
						return middle;
					}
					if (value < arr[middle][middle]){// value suppose to be left
						high = middle;
					}
					else{// value suppose to be right
						low = middle+1;
					}
				}
			}
			return -1;
		}
		
		public static int[] LIS2(int [] arr){
			int size = arr.length;
			int mat [][] = new int[size][size];
			mat [0][0] = arr[0];
			int end = 0;
			for (int i=1; i<size; i++){
				int index = binarySearchBetween(mat, end, arr[i]);
				//System.out.println("i = "+i+", index = "+index + ", element = "+arr[i]);
				for(int j=0; j<index; j++){
					mat[index][j]=mat[index-1][j];
					System.out.println(Arrays.deepToString(mat));

				}
				mat[index][index] = arr[i];
				System.out.println(Arrays.deepToString(mat));
				if (index>end)
					{
					
					end++;
					}
				//MyLibrary.printIntMatrix(mat);
				//System.out.println();
			}
			int ans[] = new int[end+1];
			for(int j=0; j<=end; j++) ans[j]=mat[end][j];
			return ans;
		}
		
	
		
		public static void main(String[] args) {
			int arr[]= {1,11,2,10,4,5,2,1,0,3};
			
			System.out.println("----"+(Arrays.toString(LIS2(arr))));
		}
	}

