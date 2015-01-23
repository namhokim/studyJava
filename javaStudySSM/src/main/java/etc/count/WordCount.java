package etc.count;

import java.util.*;

public class WordCount {
	
	class Count implements Comparable<Count> {
		private int count;
		private String word;
		
		public Count(String word) {
			this.word = word;
			this.count = 1;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
		public void incrementCount() {
			count++;
		}
		@Override
		public String toString() {
			return "[" + word + ", " + count + "]";
		}
		// implements Comparable<Count>
		public int compareTo(Count o) {
			return (o.count - this.count);
		}
		
	}
	
	
	

	public static void main(String[] args) {
		String str = "하나 문서 있다 가정 문서 가장 많이 카운팅 된 단어 n번 순위 구하라";
		WordCount counter = new WordCount();
		List<Count> cnt = counter.count(str, 4);
		System.out.println(cnt);
	}
	
	public List<Count> count(String str, int n) {
		List<Count> cnt = process(str);
		return cnt.subList(0, n);
	}

	private List<Count> process(String str) {
		Map<String, Integer> ref = new HashMap<String, Integer>();
		List<Count> cnt = new ArrayList<Count>();
		
		for (String word : str.split(" ")) {
			System.out.println(word);
			if (ref.containsKey(word)) {
				int index = ref.get(word);
				cnt.get(index).incrementCount();
			} else {
				ref.put(word, cnt.size());
				Count count = new Count(word);
				cnt.add(count);
			}
		}
		Collections.sort(cnt);
		return cnt;
	}

}
