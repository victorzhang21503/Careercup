package Others;
import java.util.*;

/*
 * Single Or Double
 * 
 * Difficulty: $$$
 * Type: general
 * 
 * Description:
 * 题目是给你一个byte array, 一个byte如果大于127那么就是double byte, 
 * 否则是single byte。问你最后一个char 是1位还是2位的
 * 举个例子：
 * 100, 200, 123 
 * 100是single, 200是double，所以123不用看，最后就是double
 * 200，10，20
 * 200是double, 10不用看，最后一个byte是20，所以是single
 * 
 * */
public class SingleOrDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int checkByte(int[] nums){
		//return 1 for single byte, 2 for 2 bytes
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < 128){
				res = 1;
			}
			else{
				res = 2;
				i++;
			}
		}
		
		return res;
	}
	
	// follow up: optimize the solution above
	public int checkByte_Optimized(int[] nums){
		int len = nums.length - 1;
		if(nums[len] >=128){
			return 2;
		}
		else{
			len--;
			int cnt = 0;
			while(len >= 0 && nums[len] >= 128){
				cnt++;
				len--;
			}
			
			return cnt % 2 ==1 ? 2 : 1;
		}
	}
}
