package lis;

import java.util.Arrays;
public class lisCicle {

	public static void main(String[] args) {
		int arr[]= {9,10,8,0,1,4,3,7};
System.out.println(Arrays.toString(LIS2(arr)));
	}


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

	public static int[] LIS2(int [] arr)
	{
		int size = arr.length;
		int mat [][] = new int[size][size];
		mat [0][0] = arr[0];
		int maxend = 0;
		for (int k=0; k<size; k++)
		{
			int l=k+1;
			int end=0;
			mat[0][0]=arr[k];
			for (int i = 0; i < size; i++) 
			{
				if(l==size)	
					l=0;
				int index = binarySearchBetween(mat, end, arr[l]);
				for(int j=0; j<index; j++){
					mat[index][j]=mat[index-1][j];
					System.out.println(Arrays.deepToString(mat));
				}

				mat[index][index] = arr[l];
				if (index>end) end++;
				l++;
			}
if(end>maxend)
	maxend =end;
		}
		int ans[] = new int[maxend+1];
		for(int j=0; j<=maxend; j++)
			ans[j]=mat[maxend][j];
	//	System.out.println(Arrays.deepToString(mat));
		return ans;
	}


}
