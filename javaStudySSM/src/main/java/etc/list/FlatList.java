package etc.list;

import java.util.*;

public class FlatList {

	public static void main(String[] args) {
		List<Object> list2 = new ArrayList<Object>();
		list2.add(2);
		list2.add(1);
		
		List<Object> list3 = new ArrayList<Object>();
		list3.add(10);
		list3.add(1);
		
		List<Object> list = new ArrayList<Object>();
		list.add(3);
		list.add(list2);
		list.add(4);
		list.add(list3);
		
		List<Integer> flattenList = flat(list);
		System.out.println("original: " + list);
		System.out.println("flatten: " + flattenList);
	}

	private static List<Integer> flat(List<Object> list) {
		Set<Integer> set = new TreeSet<Integer>();
		flat(list, set);
		return new ArrayList<Integer>(set);
	}
	
	@SuppressWarnings("unchecked")
	private static void flat(List<Object> list, Set<Integer> set) {
		for (Object o : list) {
			if (o instanceof List) {
				flat((List<Object>)o, set);
			} else {
				set.add((Integer)o);
			}
		}
	}

}
