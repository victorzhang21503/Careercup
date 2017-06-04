package Others;
import java.util.*;
/*
 * Generate Odd Number
 * 
 * Difficulty: $$$$
 * Type: general
 * 
 * Description:
 * give a range [min, max), generate a one of all odd numbers in the range with the same probability
 * 
 * 分析：
 * Java 8 没有接口函数： random.nextLong
 * 考虑越界， 极端情况：[Integer.MIN_VALUE, Integer.Min_VALUE);
 * 
 * */
public class GenerateOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int getOddNumber(int min, int max){
		Random r = new Random();
		if(min % 2 == 0){
			min++;  // make min odd;
		}
		if(max % 2 == 1){
			max--; // make max even;
		}
		
		return min + 2 * r.nextInt(max / 2 - min / 2 + 1); 
	}

}
