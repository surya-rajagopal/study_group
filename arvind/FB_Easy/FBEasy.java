import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FBEasy {
	
	
	// 10 12 12 13
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		List<Integer> no_nodes = new ArrayList<Integer>();

		average(root, 0, res, no_nodes);

		for (int i = 0; i < res.size(); i++)
			res.set(i, res.get(i) / no_nodes.get(i));
		return res;
	}

	private void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
		if (t == null)
			return;
		if (i < sum.size()) {
			sum.add((double) t.val);
			count.add(1);
		} else {
			count.add(count.get(i) + 1);
			sum.add(i, sum.get(i) + (double) t.val);
		}
		average(t.left, i + 1, sum, count);
		average(t.right, i + 1, sum, count);
	}

	// begin = "hit" end ="cog" [hot,dot,dog,lot,log,cog]
	public int ladder(String begin, String end, List<String> wordList) {
		Queue<String> bfs = new LinkedList<String>();
		List<String> temp = new ArrayList<String>();
		bfs.add(begin);
		int min = Integer.MAX_VALUE;
		while (!bfs.isEmpty()) {
			String w1 = bfs.poll();
			for (int j = 0; j < wordList.size(); j++) {
				String w2 = wordList.get(j);
				temp.add(w2);
				if (end.equals(w2)) {
					min = Math.min(min, temp.size());
					temp.remove(w2);
				}
				if (isOneWord(w1, w2)) {
					bfs.add(w2);
				} else {
					continue;
				}
			}
		}
		return min;
	}

	public static List<String> letterCasePermutation_iteration(String S) {
		List<String> res = new ArrayList<String>();
		res.add("");

		for (char c : S.toCharArray()) {
			if (Character.isLetter(c)) {

			}
		}
		return res;
	}

	/// plain recursion 784. Letter Case Permutation//
	public static List<String> letterCasePermutation(String S) {
		String temp = "";
		List<String> res = new ArrayList<String>();

		letterCasePermutation(S, temp, 0, res);
		return res;
	}

	public static void letterCasePermutation(String S, String temp, int i, List<String> res) {
		if (i == S.length()) {
			res.add(temp);
			temp = "";
			return;
		}
		if (Character.isAlphabetic(S.charAt(i))) {
			letterCasePermutation(S, temp + S.charAt(i), i + 1, res);
			letterCasePermutation(S, temp + Character.toUpperCase(S.charAt(i)), i + 1, res);
		} else {
			letterCasePermutation(S, temp + S.charAt(i), i + 1, res);
		}
	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int len;
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	/** intersection of two arrays with no dups with sorting**/
	public static List<Integer> intersection_nodups(int[] nums1,int[] nums2){
        List<Integer> result = new ArrayList<Integer>();
    	Set<Integer> hashSet1 =new HashSet<Integer>();
    	for(int i=0;i<nums1.length;i++){
    		hashSet1.add(nums1[i]);
    	} //0(m)
    	for(int j=0;j<nums2.length;j++)
    	{
    		if(hashSet1.contains(nums2[j]) && 
    				!result.contains(nums2[j]))
    			result.add(nums2[j]);
    		//assumption is intersection should not have duplicates
    	}//0(n)     	
        return result; 	    	
    }

	//intersection of two arrays dups allowed**/
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;

			} else if (nums1[i] > nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		int[] result = new int[set.size()];
		int k = 0;
		for (int x : set) {
			result[k++] = x;
		}
		return result;
	}
	
	
    public static int[] intersection1(int[] nums1, int[] nums2) {
        int k=0;
        Set<Integer> hashSet = new  HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            hashSet.add(nums1[i]);
        }
        Set<Integer> set2 = new  HashSet<Integer>();

        for(int i=0;i<nums2.length;i++){
            if(!hashSet.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] result = new int[set2.size()];
        for (int x : set2) {
			result[k++] = x;
		}
        return result;
    }

    //Trade
    public int maxProfit(int[] prices) {
      int min = Integer.MAX_VALUE;
      int result =0;
    	  for(int i=1;i<prices.length;i++){
    		   if(prices[i+1] > prices[i])
    			   result += prices[i]- prices[i-1];
    	  }
    	  return result;
      }
	// 1. X||
	public static int romanToInt(String s) {
		int res = 0;
		int lastSeen = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (lastSeen > map.get(c)) {
				res = res - map.get(c);
			} else {
				res += map.get(c);
			}
			lastSeen = map.get(c);
		}
		return res;
	}

	/**
	 * peri = 6
	 * 
	 * [0,4 4,1]
	 * 
	 * 
	 * [
	 * 
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter(int[][] grid) {

		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0)
					continue;
				if (check(grid, i, j + 1)) {
					ans = ans + 1;
				}
				if (check(grid, i, j - 1)) {
					ans = ans + 1;
				}
				if (check(grid, i + 1, j)) {
					ans = ans + 1;
				}
				if (check(grid, i - 1, j)) {
					ans = ans + 1;
				}
			}
		}
		return ans;
	}

	private static boolean check(int[][] grid, int row, int col) {
		return row < 0 || col >= grid[0].length || row >= grid.length || col < 0 || grid[row][col] == 0;
	}

	/** Ransom note **/
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] rans = new int[26];
		for (Character ch : ransomNote.toCharArray()) {
			rans[ch - 'a']++;
		}

		for (Character ch : magazine.toCharArray()) {
			rans[ch - 'a']--;
		}
		for (int i = 0; i < rans.length; i++) {
			if (rans[i] > 0)
				return false;
		}
		return true;
	}

	/** Flood fill **/
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		if (color != newColor)
			helperFill(image, sr, sc, color, newColor);
		return image;
	}

	static void helperFill(int[][] image, int row, int col, int color, int newColor) {
		if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != color)
			return;
		else
			image[row][col] = newColor;
		helperFill(image, row - 1, col, color, newColor);
		helperFill(image, row + 1, col, color, newColor);
		helperFill(image, row, col - 1, color, newColor);
		helperFill(image, row, col + 1, color, newColor);

	}

	boolean isOneWord(String w1, String w2) {
		int count = 0;
		for (int i = 0; i < w1.length(); i++) {
			if (w1.charAt(i) != w2.charAt(i) && count == 0) {
				count++;
			}
		}
		return count <= 1;
	}
	
	public static void main(String args[]) {
		System.out.println(intersection1(new int[] { 1, 2, 2 ,1}, new int[] {2,2}));
	}
}
