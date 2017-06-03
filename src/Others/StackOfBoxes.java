package Others;
import java.util.*;

/*
 * Stack of Boxes: 
 * 
 * Type: DP
 * Difficulty: $$$
 * 
 * You have a stack of n boxes, with widths w1 , 
 * heights h i, and depths di . 
 * The boxes cannot be rotated and can only be stacked on top of one another 
 * if each box in the stack is strictly
 * larger than the box above it in width, height, and depth. 
 * Implement a method to compute the
 * height of the tallest possible stack. The height of a stack
 * is the sum of the heights of each box.
 * */
public class StackOfBoxes {
	public static void main(String[] args){
		StackOfBoxes solution = new StackOfBoxes();
		int[][] boxes = new int[][]{{3,3,8},{1,1,2},{2,2,4}};
		System.out.println(solution.getHighest(boxes));
	}
	
	public int getHighest(int[][] boxes){
		if(boxes == null || boxes.length == 0 || boxes[0].length == 0){
			return 0;
		}
		
		int len = boxes.length;
		Arrays.sort(boxes, new Comparator<int[]>(){
			public int compare(int[] box1, int[] box2){
				if(box1[0] != box2[0]){
					return Integer.compare(box1[0], box2[0]);
				}
				else if(box1[1] != box2[1]){
					return Integer.compare(box1[1], box2[1]);
				}
				else{
					return Integer.compare(box1[2], box2[2]);
				}
			}
		});
		int[] dp = new int[len];
		dp[0] = boxes[0][2];
		int max = 0;
		
		for(int i = 1; i < boxes.length; i++){
			for(int j = 0; j < i; j++){
				if(boxes[j][0] < boxes[i][0] && boxes[j][1] < boxes[i][1] && boxes[j][2] < boxes[i][2]){
					dp[i] = Math.max(dp[i], dp[j] + boxes[i][2]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
