package ch01;

/**
 * 두 문자열이 애너그램인지 여부 찾기
 * 
 * 조건
 * 1. 문자열의 길이는 자바에서 지원하는 범위
 * 2. 문자의 범위는 a~z (소문자)
 * 3. 입력은 두 문자열(인자)
 * 4. 리턴 타입은 참/거짓
 * @author namo
 *
 */
public class Problem02 {
	
	private String stringA, stringB;
	private static final int MAX_LENGTH = 26;
	
	public Problem02(String stringA, String stringB) {
		this.stringA = stringA;
		this.stringB = stringB;
	}
	
	public boolean determine() {
		int lenA = stringA.length();
		int lenB = stringB.length();
		if (lenA != lenB) return false;
		
		int[] countA = getCount(stringA, lenA);
		int[] countB = getCount(stringB, lenB);
		
		return isSame(countA, countB);
	}

	private int[] getCount(String s, int length) {
		int[] count = new int[MAX_LENGTH];
		for (int i=0; i<length; i++) {
			int offset = ((int)s.charAt(i) - (int)'a');
			if (offset<0 || offset>=MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid range:" + s.charAt(i));
			} else {
				count[offset]++;
			}
		}
		return count;
	}
	
	private boolean isSame(int[] a, int[] b) {
		for (int i=0; i<MAX_LENGTH; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	
}
