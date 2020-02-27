package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class SimpleListTester {
	private SimpleList myList = new SimpleList();
	
	@Test
	void testConstructor() {
		SimpleList aList = new SimpleList(); //testing to make sure it is not null
		assertNotNull(aList);
	}

	@Test
	void testaddOneElement() //adding one element, testing for correct array
	{
		myList.add(5);
		assertEquals("5", myList.toString());
	}
	
	@Test
	void testAddTwoElements() //adding two elements, testing for correct array
	{
		myList.add(5);
		myList.add(4);
		assertEquals("4 5", myList.toString());
	}
	
	@Test
	void testAddMoreThanTenElements() //adding more than 10 elements, testing for
	{								  //correct "fall off" of last elements
		myList.add(7);	//1
		myList.add(4);	//2
		myList.add(2);	//3
		myList.add(9);	//4
		myList.add(13);	//5
		myList.add(32);	//6
		myList.add(2);	//7
		myList.add(61);	//8
		myList.add(42);	//9
		myList.add(91); //10
		assertEquals("91 42 61 2 32 13 9 2 4 7", myList.toString());
		myList.add(31);
		assertEquals("31 91 42 61 2 32 13 9 2 4 7", myList.toString());
		myList.add(53);
		assertEquals("53 31 91 42 61 2 32 13 9 2 4 7", myList.toString());	
	}
	
	@Test
	void testRemove() //testing remove method
	{
		myList.add(7);	//1
		myList.remove(7);
		myList.add(7);	//1
		myList.add(4);	//2
		myList.add(2);	//3
		myList.add(9);	//4
		myList.add(13);	//5
		myList.add(32);	//6
		myList.add(2);	//7
		myList.remove(9);//6
		assertEquals("2 32 13 2 4 7", myList.toString()); //testing with multiple elements
		myList.add(68);	//7
		myList.add(71);	//8
		myList.add(53);	//9
		myList.add(39);	//10
		myList.add(56);	//11
		myList.add(81);	//12
		myList.add(19);	//13
		myList.add(32);	//14
		myList.add(45);	//15
		myList.remove(81);
		assertEquals("45 32 19 56 39 53 71 68 2 32 13 2 4 7", myList.toString());
	}
	
	@Test
	void testCount() //testing the count method, with different amount of elements
	{
		assertEquals(0, myList.count());
		myList.add(4);	//1
		assertEquals(1, myList.count());
		myList.add(2);	//2
		assertEquals(2, myList.count());
		myList.add(2);	//3
		myList.add(9);	//4
		myList.add(13);	//5
		myList.add(26);	//6
		myList.add(2);	//7
		myList.add(9);	//8
		myList.add(13);	//9
		assertEquals(9, myList.count());
		myList.add(43);	//10
		assertEquals(10, myList.count());
		myList.add(98); //11
		assertEquals(11, myList.count());
	}
	
	@Test
	void testSearch() //testing search method with different numbers of elements
	{
		myList.add(3);
		assertEquals("0", myList.search(3)+"");
		myList.add(6);
		assertEquals("0", myList.search(6)+"");
		assertEquals("1", myList.search(3)+"");
		myList.add(9);
		myList.add(12);
		myList.add(15);
		myList.add(18);
		myList.add(21);
		assertEquals("2", myList.search(15)+"");
		myList.add(24);
		myList.add(27);
		myList.add(30);
		myList.add(33);
		myList.add(36);
		myList.add(39);
		assertEquals("9", myList.search(12)+"");
		assertEquals("-1", myList.search(23)+"");
	}
}
