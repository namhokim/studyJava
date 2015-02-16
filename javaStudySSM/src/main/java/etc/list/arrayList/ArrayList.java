package etc.list.arrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {
	
	private E elements[];
	private int length;
	
	public ArrayList() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		// http://www.javadom.com/tutorial/maso_tech_column/generics.html
		this.elements = (E[])new Object[capacity];
//		new E[capacity];
		this.length = 0;
	}

	public int size() {
		return this.length;
	}

	public boolean isEmpty() {
		return (this.length == 0);
	}

	public boolean contains(Object o) {
		return false;
	}

	public Iterator<E> iterator() {
		return null;
	}

	public Object[] toArray() {
		return null;
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

	public boolean add(E e) {
		if (elements.length == this.length) {
			int newLength = length * 2;
			elements = Arrays.copyOf(elements, newLength);
		}
		elements[length++] = e;
		return true;
	}

	public boolean remove(Object o) {
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		return false;
	}

	public void clear() {
	}

	public E get(int index) {
		if (index >= length) {
			throw new IllegalArgumentException("Out of the index");
		}
		return elements[index];
	}

	public E set(int index, E element) {
		return null;
	}

	public void add(int index, E element) {
		
	}

	public E remove(int index) {
		return null;
	}

	public int indexOf(Object o) {
		return 0;
	}

	public int lastIndexOf(Object o) {
		return 0;
	}

	public ListIterator<E> listIterator() {
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

}
