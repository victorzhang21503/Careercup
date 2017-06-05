package Others;
import java.util.*;

/*
 * Generate Four Digit Even
 *
 * Difficulty: $$$
 * Type: Probability
 * 
 * Description:
 * generate random 4 digit number，要求相邻两个digit不同，follow up要求number是偶数
 * 
 * */
public class GenerateFourDigitEven {
	public static void main(String[] args){
		GenerateFourDigitEven solution = new GenerateFourDigitEven();
		System.out.println(solution.getFourdigitEven());
	}
	
	public int getFourdigitEven(){
		int digit1 = 0;
		int digit2 = 0;
		int digit3 = 0;
		int digit4 = 0;
		
		Random random = new Random();
		int tmp = random.nextInt(10);
		if(tmp % 2 == 1){
			tmp--;
		}
		digit1 = tmp;
		
		tmp  = random.nextInt(10);
		while(tmp == digit1){
			tmp = random.nextInt(10);
		}
		digit2 = tmp;
		
		tmp  = random.nextInt(10);
		while(tmp == digit2){
			tmp = random.nextInt(10);
		}
		digit3 = tmp;
		
		tmp  = random.nextInt(9) + 1;
		if(digit3 != 0 && digit3 == tmp){
			return getFourdigitEven();
		} 
		digit4 = tmp;
		int res = digit1 + digit2 * 10 + digit3 * 100 + digit4 * 1000;
		return res;
	}
}
