package secretaryProblem;

import java.util.Arrays;

public class secretaryProblem {

	public static void main(String[] args) {
		int times[]= {10,1,8};
		System.out.println(getAvarageTime(times));

	}
	
		public static double getAvarageTime(int[] times) {
			Arrays.sort(times);
			System.out.println(Arrays.toString(times));
			double avg = 0;
			for(int x=0;x<times.length;x++) avg = avg + avg + times[x];
			return avg/times.length;
		}
	
}
