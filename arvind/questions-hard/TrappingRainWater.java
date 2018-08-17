
public class TrappingRainWater {

	//Brute force method is to find out the individual volume units on top of each unit.
	//Total time 0(n^2 ) complexity  Space: 0(1)
    public int trap_bruteforce(int[] height) {
        int ans = 0;
        //0(n)
    	for(int i=0;i<height.length;i++){
    		int max_left = 0, max_right =0;
    		for(int j=i;j >=0;j--){
    			max_left = Math.max(max_left, height[j]);
    		}//0(n)
    		for(int j=i;j <height.length;j++){
    			max_right = Math.max(max_right, height[j]);
    		}
    		
    		ans+=Math.min(max_left, max_right) - height[i];
    	}
    	return ans; 
    }
	//dp solution with only one array, one extra variable.
    public static int trap_dp(int[] height){
	    	if(height.length <= 2) return 0;
			int[] ans = new int[height.length];
			ans[0] = height[0];
			for(int i=1;i<height.length;i++){
			   ans[i]= Math.max(ans[i-1], height[i]);
			} //0(n)
			
	    	int res =0;
	    	int rightmax = height[height.length - 1];
			for(int i=height.length-2;i>=0;i--){
				rightmax = Math.max(rightmax, height[i]) ;
				res+= Math.min(ans[i], rightmax) - height[i];
			}//0(n)
			return res; 
    }
}
