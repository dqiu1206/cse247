package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public List<T> list;
	
	
	public UnorderedList() {
		list = new LinkedList<T>();
		
	}
	
	@Override
	public boolean isEmpty() {
		
		if (list==null){
			return true;
		}
		return false;
	}

	@Override
	public void insert(T thing) {
		list.add(thing);
	}

	@Override
	public T extractMin() {
		T min = list.get(0);
		
		
		for(int i = 0; i< list.size()-1;i++){
			if(min.compareTo(list.get(i))>=0){
				min=list.get(i);
				
			}
			
		}
		list.remove(min);
		return min;
	}

}
