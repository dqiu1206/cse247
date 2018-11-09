package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> 
{

	public T[] array;
	private int size;
	private int cont;
	public T[] arrayNew;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) 
	{
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(array == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public void insert(T thing) 
	{
		T nextB;
		T nextO = thing;
		T lister = array[0];
		for(int i = 1; i < array.length; i++)
		{
			if(lister.compareTo(thing) < 0)
			{
				lister = array[i];
			}
			else
			{
				cont = i;
				i = array.length + 1;
			}
		}
		for(int i = cont; i < array.length; i++)
		{
			nextB = array[i];
			array[i] = nextO;
			nextO = nextB;
		}
	}
	
	@Override
	public T extractMin() 
	{
		return array[0];
	}

}
