package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestCalculator {
	
	Calculator c=new Calculator();
//	@BeforeEach
//	public void print1() {
//		System.out.println("Hi");
//	}
	@Test
	public void testAdd() {
		System.out.println(c.add(10, 20));
	}
//	@Test
//	public void testDiv() {
//		c.div();
//	}
//	@Test
//	public void testsub() {
//		c.sub();
//	}
//	@Test
//	public void testmul() {
//		c.mul(5, 40);
//	}
//	@AfterEach
//	public void print2() {
//		System.out.println("Thanks");
//	}

	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
	    spiedList.add("one");
	    spiedList.add("two");

	    Mockito.verify(spiedList).add("one");
	    Mockito.verify(spiedList).add("two");

	    assertEquals(2, spiedList.size());

	    Mockito.doReturn(100).when(spiedList).size();
	    assertEquals(100, spiedList.size());
	}
	
//	@Mock
//	List<String> mockedList;
//
//	 @Test
//	    public void whenUseMockAnnotation_thenMockIsInjected() {
//	        // Interact with the mock object
//	        mockedList.add("one");
//
//	        // Verify that the add method was called with the argument "one"
//	        Mockito.verify(mockedList).add("one");
//
//	        // Print statements for debugging
//
//	        // Initially, the size of the mock list will be the default value for int (0)
//	        System.out.println(mockedList.size());
//	        assertEquals(0, mockedList.size());
//
//	        // Stubbing the size method to return 100
////	        Mockito.when(mockedList).thenReturn(100);
//	        
//	        System.out.println(mockedList.size());
//	        assertEquals(100, mockedList.size());
//
//	        // Using doReturn to stub the size method to return 200
//	        doReturn(200).when(mockedList).size(); // Correct syntax
//	        System.out.println(mockedList.size());
//	        assertEquals(200, mockedList.size());
//	    }
	 @Test
	 public void StringTest() {
		 Calculator c1=spy(Calculator.class);
		 String s=c1.methodUnderTest();
		 assertEquals("one",s);
	 }
	 @Test
	 public void Stringt() {
		 Calculator ac = mock(Calculator.class);  
	        when(ac.sayMock()).thenCallRealMethod();  
	        assertEquals("Hii.. !!", ac.sayMock());    
	 }
	 @Mock
	 HashMap<String, Integer> mockHashMap;
	  
	 @Test
	 public void saveTest() {

	   mockHashMap.put("A", 1);
	  
	   Mockito.verify(mockHashMap, times(1)).put("A", 1);
       mockHashMap.forEach((x, y) -> System.out.println(x + ": " + y));
	   Mockito.verify(mockHashMap, times(0)).get("A");
	   assertEquals(0, mockHashMap.size());
	 }
}
