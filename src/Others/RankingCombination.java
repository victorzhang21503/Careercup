package Others;
/*
 * Raking combination
 * 
 * Type: DP, Math
 * Difficulty: $$$$$
 * 
 *  Description:
 *  There are n people participating a game, they can play the game as individual or make team of any size.
 *  Write a function to compute the number of different combination to get the ranks
 *  
 *  Example
 *  There are two people A and B: it comes 3 possible combination:
 *  
 *  1： [A, B]
 *  2： [B, A]
 *  3: [(AB)]
 *  
 *  when n = 3, the output is 13
 * */
public class RankingCombination {
	double[] stairProduct;
	public static void main(String[] args) {
		RankingCombination solution = new RankingCombination();
	    System.out.println(solution.getRankingNumber(4));
	  }
	  
	public double getRankingNumber(int n) {
	    double res = 0;
	    stairProduct = new double[n + 1];
	    
	    stairProduct[0] = 1;
	    stairProduct[1] = 1;
	    
	    for(int i = 2; i <= n; i++){
	      stairProduct[i] = i * stairProduct[i - 1];
	    }
	    
	    for(int i = 1; i <= n; i++) {
	      double teamNum = getTeams(n, i, 1);
	      //System.out.println(teamNum);
	      res += teamNum;
	    }
	    return res;
	  }
	  
	  public double getTeams(int n, int teams, double mul) {
	    
	    if(n == teams) {
	      return mul * stairProduct[teams];
	    }
	    if(teams == 0) {
	      return 0;
	    }
	    
	    double res = 0;
	    for(int i = 1;  i <= n - teams + 1; i++) {
	        double tmp = mul * C(n, i);
	        res += getTeams(n - i, teams - 1, tmp);
	    }
	    
	    return res;
	  }
	  
	  public double C(int n, int k) {
	    return stairProduct[n] / stairProduct[n - k] / stairProduct[k];
	  }
	  
	 
	  
	  
	  
	  // dp[4] = C(4,1) * dp[3] + C(4, 2) * dp[2] + C(4,3) * dp[1] + C(4,4) * dp[0]
	  
	  public static long findTotalCount(int n){
	        long[] dp = new long[n + 1];
	        if(n <= 1){
	          return n;
	        }
	        dp[0] = 1;
	        dp[1] = 1;
	        for(int i = 2; i <= n; i++){
	          for(int k = 0; k < i; k++){
	            dp[i] += helper(i, i - k) * dp[k];
	          }
	        }
	        return dp[n];
	  }
	  
	  public static long helper(int n, int k){
	    long res = 1;
	    
	    for(int i = n - k + 1; i <= n; i++){
	        res *= i;
	    }
	    
	    for(int i = 1; i <= k; i++){
	        res /= i;
	    }
	    
	    return res;
	  }
}
