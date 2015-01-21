package etc.string;

import java.util.HashSet;
import java.util.Set;

// http://www.cs.umd.edu/class/fall2013/cmsc132h/slides/Week7/EffectiveJava.pdf
public class NameInSet {

	private String myName;

	public NameInSet(String n) {
		myName = n;
	}

	public boolean equals(Object o) {
		if (!(o instanceof NameInSet))
			return false;
		NameInSet n = (NameInSet) o;
		return myName.equals(n.myName);
	}

	public static void main(String[] args) {
		Set<NameInSet> s = new HashSet<NameInSet>();
		s.add(new NameInSet("Donald"));
		System.out.println(s.contains(new NameInSet("Donald")));
	}

}
