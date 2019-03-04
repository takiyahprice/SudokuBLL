package pkgHelper;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class LatinSquareTest {

	@Test
	public void hasDuplicates_test1() {
		
		int[] arr = {1,2,3,4,5};
		
		LatinSquare lq = new LatinSquare();
	
		assertFalse(lq.hasDuplicates(arr));
	}
	@Test
	public void hasDuplicates_test2() {
		
		int[] arr = {1,1,3,4,5};
		
		LatinSquare lq = new LatinSquare();
	
		assertTrue(lq.hasDuplicates(arr));
	}
	@Test
	public void hasDuplicates_test3() {
		
		int[] arr = {1,2,3,4,1};
		
		LatinSquare lq = new LatinSquare();
	
		assertTrue(lq.hasDuplicates(arr));
	}
	@Test
	public void hasDuplicates_test4() {
		
		int[] arr = null;
		
		LatinSquare lq = new LatinSquare();
	
		assertFalse(lq.hasDuplicates(arr));
	}

	@Test
	public void doesElementExist_test1() {
		int[] arr = {1,2,3,4,5};
		int iValue = 3;
		
		LatinSquare lq = new LatinSquare();
		
		assertTrue(lq.doesElementExist(arr, iValue));
	}
	@Test
	public void doesElementExist_test2() {
		int[] arr = {1,2,3,4,5};
		int iValue = 7;
		
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.doesElementExist(arr, iValue));
	}
	@Test
	public void doesElementExist_test3() {
		int[] arr = null;
		int iValue = 1;
		
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.doesElementExist(arr, iValue));
	}
	@Test
	public void hasAllValues_test1() {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,3,5};
		
		LatinSquare lq = new LatinSquare();
		
		assertTrue(lq.hasAllValues(arr1, arr2));
	}
	@Test
	public void hasAllValues_test2() {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {3,8,1,2,3,4};
		
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.hasAllValues(arr1, arr2));
	}
	@Test
	public void hasAllValues_test3() {
		int[] arr1 = null;
		int[] arr2 = {1,3,5};
		
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.hasAllValues(arr1, arr2));
	}
	@Test
	public void getRow_test1() {
		int[][] puzzle = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		int[] test_row = {3,4,1,2};
		
		assertTrue(Arrays.equals(lq.getRow(2),test_row));	
	}
	@Test
	public void getRow_test2() {
		int[][] puzzle = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		int[] test_row = {3,4,1,2};
		
		assertFalse(Arrays.equals(lq.getRow(0),test_row));
	}
	@Test
	public void getColumn_test1() {
		int[][] puzzle = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		int[] test_column = {3,4,2,2};
	
	assertTrue(Arrays.equals(lq.getColumn(3),test_column));
	}
	@Test
	public void getColumn_test2() {
		int[][] puzzle = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		int[] test_column = {3,4,2,2};
	
	assertFalse(Arrays.equals(lq.getColumn(0),test_column));
	}
	@Test
	public void ContainsZero_test1() {
		int[][] puzzle = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		
		assertTrue(lq.ContainsZero());
	}
	@Test
	public void ContainsZero_test2() {
		int[][] puzzle = {{1,2,3},{1,3,2},{3,1,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		
		assertFalse(lq.ContainsZero());
	}
	@Test
	public void isLatinSquare_test1() {
		int[][] puzzle = {{1,2,3},{2,3,1},{3,1,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		
		assertTrue(lq.isLatinSquare());
	}
	@Test
	public void isLatinSquare_test2() {
		int[][] puzzle = {{1,2,3},{2,3,2},{3,1,2}};
		LatinSquare lq = new LatinSquare(puzzle);
		
		assertFalse(lq.isLatinSquare());
	}
	public void isLatinSquare_test3() {
	int[][] puzzle = {{1,2,3},{2,3,4},{3,1,2}};
	LatinSquare lq = new LatinSquare(puzzle);
	
	assertFalse(lq.isLatinSquare());
	}
}