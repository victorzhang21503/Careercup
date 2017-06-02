package Others;

public class RankingCombination {
	public static void main(String[] args) {
		RankingCombination solution = new RankingCombination();
	    System.out.println(solution.getRankingNumber(4));
	  }
	  
	  public int getRankingNumber(int n) {
	    int res = 0;
	    for(int i = 1; i <= n; i++) {
	      int teamNum = getTeams(n, i, 2, 1, 1);
	      //System.out.println(teamNum);
	      res += stairProduct(i, i) * teamNum;
	    }
	    return res;
	  }
	  
	  public int getTeams(int n, int teams, int pre, int cnt, int mul) {
	    
	    if(n == teams) {
	      return mul;
	    }
	    if(teams == 0) {
	      return 0;
	    }
	    
	    int res = 0;
	    for(int i = pre;  i <= n - teams + 1; i++) {
	      if(i == pre) {
	        int tmp = mul / cnt * C(n, i);
	        res += getTeams(n - i, teams - 1,  i, cnt + 1, tmp);
	      }else {
	        int tmp = mul * C(n, i);
	        res += getTeams(n - i, teams - 1, i, 1, tmp);
	      } 
	    }
	    
	    return res;
	  }
	  
	  public int C(int n, int k) {
	    return stairProduct(n, k) / stairProduct(k, k);
	  }
	  
	  
	  public int stairProduct(int n, int len){
	    int mul = 1;
	    for(int i = n; i > n - len; i--) {
	      mul *= i;
	    }
	    return mul;
	  }
}
