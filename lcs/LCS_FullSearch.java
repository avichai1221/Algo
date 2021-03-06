package lcs;

import java.util.Arrays;

public class LCS_FullSearch {
	public static void plus1(int[] arr){
		int i=arr.length-1;
		while( i>=0 && arr[i]==1){
			arr[i--] = 0;
		}
		if (i>=0) arr[i] = 1;
	}
	public static void checkPlus1(){//O(n)
		int n = 4, count = (int)Math.pow(2, n);
		int arr[] = new int[n];
		System.out.println(Arrays.toString(arr)); 
		for (int i=0; i<count; i++){
			plus1(arr);
			System.out.println(Arrays.toString(arr)); 
		}
	}
	public static String[] allCombinations(String X){//O(2^n) n=X.length()
		int count = (int)Math.pow(2, X.length())-1;
		String [] list = new String[count];
		int bin[] = new int[X.length()];
		for (int i=0; i<count; i++){
			plus1(bin);
			String t = "";
			for (int j=0; j<X.length(); j++){
				if (bin[j] == 1) t = t + X.charAt(j); 
			}
			list[i] = t;
		}
		return list;
	}
	public static void checkAllCombinations(){
		String[] list = allCombinations("ab");
		System.out.println(Arrays.toString(list));
		list = allCombinations("abc");
		System.out.println(Arrays.toString(list));
		list = allCombinations("abcd");
		System.out.println(Arrays.toString(list));
	}
	public static String fullSearch(String X, String Y){//O(2^n * 2^m *min(m,n)) = O(2^(m+n) *min(m,n))
		String ans = "", sShort = X, sLong = Y;
		if (X.length() > Y.length()){
			sShort = Y;
			sLong = X;
		}
		int maxLen = 0;
		String [] tshort = allCombinations(sShort);
		String [] tlong = allCombinations(sLong);
		for (int i=0; i<tshort.length; i++) {//2^m
			for (int j = 0; j < tlong.length; j++) {//2^n
				int len = tshort[i].length();
				if (tshort[i].equals(tlong[j]) && len > maxLen){//m
					maxLen = len;
					ans = tshort[i];
				}
			}
		}
		return ans;
	}
	public static void checkFullSearch(){
		String X = "abcbdab", Y = "bdcaba";
		String X1 = "abcd", Y1 = "acd";
		String X2 = "cdbac", Y2 = "abdbb";
		String X3 = "abcabdc", Y3 = "abcbdcbad";
		System.out.println(fullSearch(X, Y));
		System.out.println(fullSearch(Y, X));
		System.out.println(fullSearch(X1, Y1));
		System.out.println(fullSearch(Y1, X1));
		System.out.println(fullSearch(X2, Y2));
		System.out.println(fullSearch(Y2, X2));
		System.out.println(fullSearch(X3, Y3));
		System.out.println(fullSearch(Y3, X3));
	}
	public static void main(String[] args) {
		//checkPlus1();
		checkAllCombinations();
		//checkFullSearch();
	}

}
/**
bcba
bcba
acd
acd
db
db
abcbdc
abcbdc
*/