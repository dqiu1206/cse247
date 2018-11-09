package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> 
{
	int less;
	public List<T> list;
	
	public UnorderedList() 
	{
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(list == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public void insert(T thing) 
	{
		list.add(thing);
	}

	@Override
	public T extractMin() 
	{
		T lister = list.get(0);
		for(int i = 1; i < list.size(); i++)
		{
			less = lister.compareTo(list.get(i));
			if(less > 0)
			{
				lister = list.get(i);
			}
		}
		list.remove(lister);
		return lister;
	}

}
