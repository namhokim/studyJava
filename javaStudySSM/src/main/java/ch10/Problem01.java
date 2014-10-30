package ch10;

public class Problem01 {

	public static void merge(int[] a, int lenA, int[] b) {
		// B의 크기만큼 A를 뒤로 민다
		int lenB = b.length;	// not length()
		shiftRight(a, lenA, lenB);
		
		// A의 앞에 병합 정렬
		int w = 0;
		int pA = lenB;
		int pB = 0;
		int eoA = lenA + lenB; 
		while (pA < eoA  && pB < lenB) {
			if (a[pA] < b[pB]) {
				a[w++] = a[pA++];
			} else {
				a[w++] = b[pB++];
			}
		}
		
		// 남은 것 복사
		while (pA < eoA) {
			a[w++] = a[pA++];
		}
		while (pB < lenB) {
			a[w++] = b[pB++];
		}
	}

	static void shiftRight(int[] a, int size, int how) {
		if (how == 0) return;
		
		int pos = size;
		// 뒤로 옮긴다면 뒤에서부터 옮겨야 한다!
		while (pos > 0) {
			a[pos + how - 1] = a[pos - 1];
			a[pos-1] = 0;
			--pos;
		}
	}
	
	public static void merge2(int[] a, int lenA, int[] b) {
		// 뒤에부터 정렬한다.
		int lenB = b.length;
		int w = lenA + lenB - 1;	// 실수하기 좋음 
		int pA = lenA - 1;
		int pB = lenB - 1; 
		while (pA >= 0  && pB >= 0) {
			if (a[pA] > b[pB]) {
				a[w--] = a[pA--];
			} else {
				a[w--] = b[pB--];
			}
		}
		
		// 남은 것 복사
		while (pA >= 0) {
			a[w--] = a[pA--];
		}
		while (pB >= 0) {
			a[w--] = b[pB--];
		}
	}
	

}
