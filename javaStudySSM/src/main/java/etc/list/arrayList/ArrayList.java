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
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public E get(int index) {
		if (index >= length) {
			throw new IllegalArgumentException("Out of the index");
		}
		return elements[index];
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
