package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EletronicTest {

	@Mock
	private ElectronicRepository er;
	
	@InjectMocks
//	private ElectronicService es;
	private ElectronicDao ed;
	
	
	@BeforeEach
	void setUp() {//this will executed before every test case run
		MockitoAnnotations.openMocks(this); //Initialize mock in the case
	}
	
	@Test
	void testAddEletronic() throws InvalidProduct {
		
		Electronic e1=new Electronic(1, "Sony", 1200, 2024, 4);
		when(er.save(e1)).thenReturn(e1);
		Electronic result=ed.saveE(e1);
		assertEquals(e1, result);

	}
    @Test
    public void testNotNull() throws InvalidProduct {
        Electronic electronic = new Electronic(1, "Sony", 1200, 2024, 4);
        when(er.save(electronic)).thenReturn(electronic);
        Electronic savedElectronic = ed.saveE(electronic);
        assertNotNull(savedElectronic);
    }
	@Test
	void TestAddException() {
		Electronic e1=new Electronic(1, "Sony", 2200, 2024, 4);
//		assertThrows(InvalidProduct.class, ()->ed.saveE(e1));
		InvalidProduct thrown = assertThrows(InvalidProduct.class, () -> ed.saveE(e1));
        assertEquals("Price exceeds the maximum limit.", thrown.getMessage());
	}
}
