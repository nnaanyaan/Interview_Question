import java.util.*;
public class Solution {
	public static void main(String args[]) {
		System.out.println("Hello World");
		String[] email = { "a@example.com", 
		"a.b@example.com", 
		"dupli......cate@example.com", 
		"d.u.p.l.i.c.a.t.e@example.com",
		"d.u.p.l.i.c.a.t.e+eeeeeee@example.com"};
		int res = emailAdress(email);
		System.out.println(res);
	}
	public static int emailAdress(String[] email) {
		if (email == null || email.length == 0) return 0;
		int res = 0;
		// count is for counting the # of same email address.
		HashMap<String, Integer> count = new HashMap<>();
		for (String e : email) {
			String temp = helper(e);
			count.put(temp, count.getOrDefault(temp, 0) + 1);
		}
		for (int cnt : count.values()) {
			if (cnt > 1) res++;
		}
		for (String s : count.keySet()) {
			System.out.println(s);
		}
		return res;
	}
	// email = local@domain
	// helper method is for 1.local:delete dots('.') between some characters 
	// 2.local:delete '+' and all the things after '+'
	private static String helper(String s) {
		String ans = "";
		int i = 0;
		while (i < s.length()) {
			if (i == 0) {
				ans += s.charAt(i++);
			} else if (s.charAt(i) == '@') {
				ans += s.substring(i);
				break;
			} else if (s.charAt(i) == '+') {
				while (s.charAt(i) != '@') {
					i++;
				}
			} else if (s.charAt(i) != '.') {
				ans += s.charAt(i++);
			} else {
				i++;
			}
		}
		System.out.println(ans);
		return ans;
	}
}
