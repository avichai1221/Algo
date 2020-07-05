package power;
public class power {
	private static final int[][] F = {{1,1},{1,0}};

		/**
		 * returns x^n
		 * Complexity: O(log n)
		 */
		public static double powInd(double x, int n) {
			double ans = 1;
			while(n != 0) {
				if(n % 2 == 1) ans *= x;
				x = x*x;
				n /=2;
			}
			return ans;
		}
		
		/**
		 * returns x^n - recursive
		 * Complexity: O(log n)
		 */
		public static double powRec(double x, int n) {
			if(n == 0) return 1;
			if(n % 2 == 1) return powRec(x*x,n/2)*x;
			return powRec(x*x,n/2);
		}
		
		public static double powUsingBinary(double x, int n) {
			double ans = 1;
			while(n != 0) {
				ans *= ((n & 1) != 0) ? x : 1;
				x *= x;
				n >>= 1;
			}
			return ans;
		}
		public static int fibo(int n) {
			int[][] ans = F;
			int[][] A = F;
			n=n-2;
			while(n != 0) {
				if(n % 2 == 1) ans = mulMat(ans,A);
				A = mulMat(A,A);
				n /=2;
			}
			return ans[0][0];
		}
		public static int[][] mulMat(int[][] m1, int[][] m2) {
			int[][] ans = new int[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					ans[i][j] = m1[i][0]*m2[0][j] + m1[i][1]*m2[1][j];
				}
			}
			return ans;
		}
	
	
	public static void main(String[] args) {
		System.out.println(fibo(7));
	}

	}
