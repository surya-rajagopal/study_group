import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//**https://leetcode.com/problems/remove-invalid-parentheses/description/
/**
 * Approach: DFS 1. Take the input String and start removing one by one
 * brackets. 2.Check for the modified string 3.if 2 is true add it to the set
 * (using sets since we can avoid duplicates).
 * 
 * @author amadhavan
 *
 */

public class RemoveInvalidParentheses {
	int max = 0;
	List<String> result = new ArrayList<String>();
	Set<String> visited = new HashSet<>();
	Set<String> set = new HashSet<>();
	
	public List<String> removeInvalidParentheses(String s) {
		  removeInvalidParenthesesHelper(s, set, visited);
		  for (String str : set) {
		      max = Math.max(str.length(), max);
		  }
		  for (String str : set) {
		      if (str.length() == max) result.add(str);
		  }
		return result;
	}

	void removeInvalidParenthesesHelper(String s,Set<String> set, Set<String> visited) {
		if(set.contains(s)|| visited.contains(s)){
			return;
		}
		if (isValid(s)){
				 set.add(s);
				 return;
		}
		visited.add(s);
		// result add if its valid
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)))
				continue;
			String var = s.substring(0, i) + s.substring(i + 1);
			removeInvalidParenthesesHelper(var, set, visited);
		}
	}

	// (())(
	boolean isValid(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				continue;
			}
			if(c =='(') {
					count++;
				}
			else if (c == ')') {
				count--;
	            if (count < 0) return false;
			}
		}
		return count ==0;
	}
	
	public static void main(String args[]){
		RemoveInvalidParentheses r = new RemoveInvalidParentheses();
		System.out.println(r.removeInvalidParentheses("()())()"));	
	}
}
