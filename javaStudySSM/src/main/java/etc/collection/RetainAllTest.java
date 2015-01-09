package etc.collection;

import java.util.*;

public class RetainAllTest {

	public static void main(String[] args) {
		putNullToMap();
		//arraListTest();
	}
	
	protected static void putNullToMap() {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map.put(null, "abc"));
		System.out.println(map.put(null, "def"));
		System.out.println(map.get(null));
	}
	
	protected static void arraListTest() {
		List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
         
        List<String> b = new ArrayList<String>();
        b.add("b");
        b.add("c");
         
        a.retainAll(b);
         
        System.out.println("a size : "+ a.size());
         
		for (String result : a) {
			System.out.println(result);
		}
	}

}
