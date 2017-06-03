package Others;
import java.util.*;

/*
 * Chemical formula parser
 * 
 * A chemical element could contains multiple characters with 
 * initial upper case and the rest lower case
 * A chemical formula contains with one or more chemical element
 * just like what we learned in the high school
 * 
 *  Comment:
 *  this question is similar to the calculation with the bracket and multiply operator
 *  Though, the key of this question is that we have to traverse the String 
 *  from the end to start it is the number behind govern the element String 
 * */
public class ChemicalFormulaParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChemicalFormulaParser solution = new ChemicalFormulaParser();
        String[] strs = {"C", "CuO", "H2O", "Fe3O4", 
                         "C6H2(NO2)3CH3", "KAl(SO4)2", 
                         "(C(OP2)2O)3", "(H3UuoK)2"};
        for(String str : strs){
            solution.decodeString(str);
        }
	}
	public void decodeString(String input){
		Map<String, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		String element = "";
		int mul = 1;
		
		for(int i = input.length() - 1; i >= 0; i--){
			char ch = input.charAt(i);
			if(Character.isLowerCase(ch) || Character.isUpperCase(ch)){
				element += ch;
				int j = i - 1;
				if(Character.isLowerCase(ch)){
					while(j >= 0 && Character.isLowerCase(input.charAt(j))){
						element = input.charAt(j) + element;
						j--;
					}
					element = input.charAt(j) + element;
					i = j;
				}
				
				if(!map.containsKey(element)){
					map.put(element, 0);
				}
				
				map.put(element, map.get(element) + mul * stack.peek());
				mul = 1;
				element = "";
			}
			
			else if(Character.isDigit(ch)){
				mul = ch - '0';
			}
			else if(ch == ')'){
				stack.push(mul * stack.peek());
				mul = 1;
			}
			else if(ch == '('){
				stack.pop();
			}
		}
		
		System.out.println(map);
	}
}
