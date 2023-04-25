//Author: Samuel Casto
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Q5SamuelCastoTestCases{

	@Test
	void TC17() {
		//setup
		Q5Class q5 = new Q5Class();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		list.add(-2);
		list.add(-3);
		list.add(-4);
		list.add(-5);
		q5.processList(list);
		assertTrue(q5.getAverage() == 0 && q5.getTotal() == 0);
	}
	
	@Test
	void TC19() {
		//setup
		Q5Class q5 = new Q5Class();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add (100000000);
		list.add(200000000);
		list.add(300000000);
		list.add(400000000);	
		list.add(500000000);
		q5.processList(list);
		assertTrue(q5.getAverage() == 300000000 && q5.getTotal() == 1500000000);
	}
	
	@Test
	void TC18() {
		//setup
		Q5Class q5 = new Q5Class();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(2);
		q5.processList(list);
		assertTrue(q5.getTotal() == 4 && q5.getAverage() == 2);
	}
	
	@Test
	void TC20() {
		//setup
		Q5Class q5 = new Q5Class();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		q5.processList(list);
		assertTrue(q5.getAverage() == 0);
		
	}
	
}
