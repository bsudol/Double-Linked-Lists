import static org.junit.Assert.*;

import org.junit.Test;

public class DLLTest {

	@Test
	public void testConstructor() {
		DLL<Integer> b= new DLL<Integer>(); 
		assertEquals("[]", b.toString()); 
		assertEquals("[]", b.toStringRev()); 
		assertEquals(0, b.size());
	}
	
	@Test
	public void testOneParameterAdd() {
		DLL<Integer> c= new DLL<Integer>(); 
		c.add(5);
		assertEquals("[5]", c.toString());
		assertEquals("[5]", c.toStringRev()); 
		assertEquals(1, c.size());
	}
	
	@Test 
	public void testSecondParameterAdd() {
		DLL<Integer> d= new DLL<Integer>(); 
		d.add(5);
		d.add(4);
		assertEquals("[5, 4]", d.toString());
		assertEquals("[4, 5]", d.toStringRev()); 
		assertEquals(2, d.size());
	}
	
	@Test 
	public void testThirdParameterAdd() {
		DLL<Integer> e= new DLL<Integer>(); 
		e.add(5);
		e.add(4);
		e.add(6);;
		assertEquals("[5, 4, 6]", e.toString());
		assertEquals("[6, 4, 5]", e.toStringRev()); 
		assertEquals(3, e.size());
	}
	
	@Test 
	public void testFourthParameterAdd() {
		DLL<Integer> f= new DLL<Integer>(); 
		f.add(1);
		f.add(2);
		f.add(3);
		f.add(4);
		assertEquals("[1, 2, 3, 4]", f.toString());
		assertEquals("[4, 3, 2, 1]", f.toStringRev()); 
		assertEquals(4, f.size());
	}
	
	@Test
	public void testGet() {
		DLL<Integer> g = new DLL<Integer>();
		g.add(5);
		g.add(4);
		g.add(3);
		g.add(2);
		assertEquals(5, g.get(0).intValue());
		assertEquals(4, g.get(1).intValue());
		assertEquals(3, g.get(2).intValue());
		assertEquals(2, g.get(3).intValue());
	}
	
	@Test
	public void testSet() {
		DLL<Integer> h = new DLL<Integer>();
		h.add(10);
		h.add(11);
		h.add(12);
		h.add(13);
		assertEquals(4, h.set(0, 4).intValue());
		assertEquals(4, h.get(0).intValue());
		assertEquals(1, h.set(1, 1).intValue());
		assertEquals(1, h.get(1).intValue());
		assertEquals(1, h.set(3, 1).intValue());
		assertEquals(1, h.get(3).intValue());
	}
	
	@Test
	public void testAdd() {
		DLL<Integer> i = new DLL<Integer>();
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(1, 5);
		assertEquals("[1, 5, 2, 3]", i.toString());
		assertEquals(1, i.get(0).intValue());
		assertEquals(5, i.get(1).intValue());
		assertEquals(4, i.size());
		i.add(0, 4);
		assertEquals("[4, 1, 5, 2, 3]", i.toString());
		assertEquals(4, i.get(0).intValue());
		assertEquals(1, i.get(1).intValue());
		assertEquals(5, i.size());
		i.add(5, 0);
		assertEquals("[4, 1, 5, 2, 3, 0]", i.toString());
		assertEquals(3, i.get(4).intValue());
		assertEquals(0, i.get(5).intValue());
		assertEquals(6, i.size());
	}
	
	@Test
	public void testRemove() {
		DLL<Integer> j = new DLL<Integer>();
		j.add(1);
		j.add(2);
		j.add(3);
		j.add(4);
		j.add(5);
		assertEquals(5, j.size());
		j.remove(2);
		assertEquals("[1, 2, 4, 5]", j.toString());
		assertEquals(1, j.get(0).intValue());
		assertEquals(4, j.get(2).intValue());
		assertEquals(4, j.size());
		j.remove(0);
		assertEquals(2, j.get(0).intValue());
		assertEquals(3, j.size());
		j.remove(2);
		assertEquals("[2, 4]", j.toString());
		assertEquals(4, j.get(1).intValue());
		assertEquals(2, j.size());
	}
}