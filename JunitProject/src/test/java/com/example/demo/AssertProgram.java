package com.example.demo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertProgram {

	
	@Test
	public void testEquals() {
		assertEquals("santhosh","santhosh");
	}
	@Test
	public void testTrue() {
		assertTrue(10>7);
	}
	@Test
	public void testNull() {
		assertNull(null,null);
	}
	@Test
	public void tstSame() {
		assertSame(5, 5);
	}
	@Test
	public void testArray() { 
		int[]a= {5,1,15};
		int[]b= {5,1,15};
		
		assertArrayEquals(a, b);
		
	}
}
