package cse360assign2;

public class SimpleList {
	/**
	 * This is a class that represents a list that stores 10 integers
	 * and can manipulate the entries
	 */
	private int[] list;
	private int count;
	
	/**
	 * Default constructor, creates array of 10 integers
	 * and sets the count to 0
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * this method will an integer to the list
	 * @param k, number to be added
	 */
	public void add(int k) 
	{
		/**
		 * if there are no elements in the array, then we can add 
		 * the new element directly into the first part of the array
		 */
		if(count == 0) 
		{                  
			count++;
			list[0] = k;
		}
		/**
		 * if there is more than one element in the array then all elements
		 * should be shifted over one unit and the number is thrown into the 
		 * first element of the array
		 */
		else {
			if(count == list.length) 
			{         
				int[] newList = new int[(int) Math.floor(1.5*list.length)];
				for(int i = 0; i<count; i++)
				{
					newList[i] = list[i];
				}
				
				list = null;
				list = newList;
			}
			for(int i = count; i > 0; i--)
			{
				list[i]= list[i-1];
			}
			list[0] = k;
			count++;
		}
	}

	/**
	 * the method remove is designed to remove the first instance 
	 * of an element of the array
	 * @param k, element to be removed
	 */
	public void remove(int k) 
	{
		int i = 0;
		boolean removed = false;

		while(removed == false && i < count)
		{
			if(list[i] == k) //bring elements back starting at element to be removed
			{
				for(int j = i; j < count-1; j++)
				{
					list[j] = list[j+1]; //element is the element in front
				}
				list[count-1] = 0;
				removed = true;
				count--;
			}
			i++;
		}

		if((double)count < (0.75 * list.length))
		{
			int[] newList = new int[(int)Math.floor(0.75*list.length)];
			for(int j = 0; j<count; j++)
			{
				newList[j] = list[j];
			}
			list = newList;
		}
		
	}
	/**
	 * count method returns the amount of elements in the array
	 * similar to a "getter" method for the variable count
	 * @return count, the number of elements in the list
	 */
	public int count() 
	{
		return count;
	}
	
	/**
	 * toString overrides Java's built in toString method, in this case
	 * returning each element with a space in between
	 * @return String of Array
	 */
	public String toString() 
	{
			String str = "";
		for(int i = 0; i < count - 1; i++)
		{
			str = str + list[i] + " "; //adding each element to the string
		}
		if(count > 0)
			str = str + list[count-1];//adding the last elements, without a space
		return str;
	}
	
	/**
	 * search method will return the first instance of the
	 * number asked to be searched, if there is no search result found
	 * it will return -1
	 * @param k, number to be searched
	 * @return element position of k
	 */
	public int search(int k)
	{
		boolean found = false;
		int location = -1;		//setting default to -1, should it not be found
		for(int i = 0; i < count && found == false; i++) 
		{
			if(list[i] == k) //looking for the element
			{
				location = i;
				found = true;
			}
		}
		return location; //returning where the element is
	}
	
	/**
	 * append method will add the element to the 
	 * end of the list and increase the size of the
	 * array by 50% if needed
	 * @param k, int to be appended
	 */
	public void append(int k)
	{
		if(count == list.length)
		{
			int[] newList = new int[(int) Math.floor(1.5*list.length)];
			for(int i = 0; i<count; i++)
			{
				newList[i] = list[i];
			}
			
			list = null;
			list = newList;
		}
		list[count] = k;
		count++;
	}
	
	/**
	 * first method will return the 
	 * first element, if there is none
	 * it will return -1
	 * @param void
	 * @return first, element at pos 0
	 */
	public int first()
	{
		int first = -1;
		if(count>0)
		{
			first = list[0];
		}
		return first;
	}
	
	/**
	 * lest method will return the
	 * last element, and should there
	 * be none, it will return -1
	 * @param void
	 * @return last, last element
	 */
	public int last()
	{
		int last = -1;
		if(count > 0)
		{
			last = list[count-1];
		}
		return last;
	}
	
	/**
	 * size method will return how 
	 * many elements the array can hold
	 * @param void
	 * @return size
	 */
	public int size()
	{
		return list.length;
	}  
}
