package a1p2tests;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import a1p2.P2_methods;


public class a1p2tests {
	
	//test program 1 with given test case that fails
	@Test
	public void test1() {
		P2_methods temp = new P2_methods();
		
		int[] x = {2, 3, 5};
		assertEquals(0, temp.findLast(x, 2));
	}
	
	//test case for program 1 part c
	@Test
	public void test1_c() {
		P2_methods temp = new P2_methods();
		
		int[] x = {1, 2, 3, 4};
		assertEquals(3, temp.findLast(x, 4));
	}
	
	
	
	//test program 2 with given test case that fails
	@Test
	public void test2() {
		P2_methods temp = new P2_methods();
		
		int[] x = {0, 1, 0};
		assertEquals(2, temp.lastZero(x));
	}
	
	//test case for program 2 part b
	@Test
	public void test2_b() {
		P2_methods temp = new P2_methods();
		
		int[] x = {1, 2, 3, 4};
		assertEquals(-1, temp.lastZero(x));
	}
	
	//test case for program 2 part c
	@Test
	public void test2_c() {
		P2_methods temp = new P2_methods();
		
		int[] x = {1, 2, 0};
		assertEquals(2, temp.lastZero(x));
	}
	
	
	
	//test program 3 with given test case that fails
	@Test
	public void test3() {
		P2_methods temp = new P2_methods();
		
		int[] x = {-4, 2, 0, 2};
		assertEquals(2, temp.countPositive(x));
	}
	
	//test case for program 3 part c
	@Test
	public void test3_c() {
		P2_methods temp = new P2_methods();
		
		int[] x = {-1, -2, 1, 3};
		assertEquals(2, temp.countPositive(x));
	}
		
	

	//test program 4 with given test case that fails
	@Test
	public void test4() {
		P2_methods temp = new P2_methods();
		
		int[] x = {-3, -2, 0, 1, 4};
		assertEquals(3, temp.oddOrPos(x));
	}
	
	//test case for program 4 part c
	@Test
	public void test4_c() {
		P2_methods temp = new P2_methods();
		
		int[] x = {-2, 0, 1, 3};
		assertEquals(2, temp.oddOrPos(x));
	}

}





