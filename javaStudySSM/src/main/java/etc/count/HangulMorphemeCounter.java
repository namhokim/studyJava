package etc.count;

import java.util.*;

public class HangulMorphemeCounter {
	
	final static int HangulSyllablesBegin = 0xac00;
	final static int HangulSyllablesEnd = 0xd7af;
	final static int HangulSyllablesCount = 0xd7af - 0xac00 + 1;
	private int count[] = new int[HangulSyllablesCount];
	
	private String _string;
	
	/**
	 * 빈생성자
	 */
	public HangulMorphemeCounter() {}
	
	/**
	 * 생성자 인자로 문자열을 받는다.
	 */
    public HangulMorphemeCounter(String something) {
    	_string = something;
	}
    
    public void setString(String words) {
    	this._string = words;
    }

    /**
     * 최소 카운터 집합을 획득한다.
     */
	public Set<Character> getMinSet() {
		int len = _string.length();

		int i = 0;
		while (i < len) {
			int cp = _string.codePointAt(i);
			if (isHangul(cp)) {
				int pos = cp-HangulSyllablesBegin;
				count[pos]++;
			}
			++i;
		}
		
		int minCount = getMinCount();
		
		return getCountSet(minCount);
	}
	
	private Set<Character> getCountSet(int minCount) {
		Set<Character> set = new HashSet<Character>();
		int i = 0;
		while (i < HangulSyllablesCount) {
			if (count[i] == minCount) {
				set.add(Character.toChars(i + HangulSyllablesBegin)[0]);
			}
			i++;
		}
		return set;
	}

	private boolean isHangul(int codePoint) {
		return (HangulSyllablesBegin <= codePoint) && (codePoint <= HangulSyllablesEnd);
	}
	
	private int getMinCount() {
		int min = Integer.MAX_VALUE;
		int i = 0;
		while (i < HangulSyllablesCount) {
			if (count[i]!=0 && count[i] < min) {
				min = count[i];
			}
			i++;
		}
		return min;
	}

}
