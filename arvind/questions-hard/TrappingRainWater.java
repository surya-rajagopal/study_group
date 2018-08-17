
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
	
    public int trap_dp(){
		return 0;
    	
    }
}
