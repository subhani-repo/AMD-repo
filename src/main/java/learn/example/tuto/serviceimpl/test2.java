package learn.example.tuto.serviceimpl;

public class test2 {

	public static boolean isPresent(String s, String s1) {
		boolean sol1 = false;
		for (int i = 0; i < s.length(); i++) {
			int sol = 0;
			if (s.charAt(i) == s1.charAt(0)) {
				for (int j = 0; j < s1.length(); j++) {
					if (s1.charAt(j) == s.charAt(i + j)) {
						sol++;
					}
				}
				if (sol == s1.length()) {
					sol1 = true;
				}
			}
		}
		return sol1;
	}

	public static boolean joinstring(String a, String b) {
		boolean s1 = false;
		for (int i = 0; i < a.length(); i++) {
			int sol = 0;
			if (a.charAt(i) == b.charAt(0)) {
				for (int j = 0; j < b.length(); j++) {
					if (a.charAt(j) == b.charAt(i + j)) {
						sol++;
					}
				}
				if (sol == b.length()) {
					s1 = true;
				}
			}
		}
		return s1;
	}

	
}
