package Facebook;
import java.util.*;
/*
 *  Given n1,n2 is the number after moving one digit from n1. Eg. n1 = 123, then n2 can be
 *  12, 13 or 23. if we know the sum of n1 + n2, and find the possible values of n1 and n2.
 *
 * */


public class N1N2Sum {
	public static void main(String[] args){
		N1N2Sum solution = new N1N2Sum();
	}
	
	private List<List<Integer>> getNumber(int sum){
		List<List<Integer>> res = new ArrayList<>();
		if(sum < 10){
			return res;
		}
		
		String numStr = String.valueOf(sum); 
		int len = numStr.length();
		
		int min = (int)Math.pow(10, len - 1) - (int)Math.pow(10, len - 2);
		int max = sum - (int)Math.pow(10, len - 2) - (int)Math.pow(10, len - 3 );
		
		
		
	}
}
