package pkgHelper;

import pkgEnum.ePuzzleViolation;

import static org.junit.Assert.*;

import java.util.*;


import org.junit.Test;

public class LatinSquareTest {

	@Test
	public void hasDuplicates_Test1() {

		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 4 };

		boolean bHasDuplicates = LS.hasDuplicates(arr);

		assertEquals(bHasDuplicates, false);

	}

	@Test
	public void hasDuplicates_Test2() {

		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 3 };

		boolean bHasDuplicates = LS.hasDuplicates(arr);

		assertEquals(bHasDuplicates, true);

	}

	@Test
	public void doesElementExist_Test1() {
		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 4 };
		int iValue = 3;
		boolean bdoesElementExist = LS.doesElementExist(arr, iValue);

		assertEquals(bdoesElementExist, true);
	}

	@Test
	public void doesElementExist_Test2() {
		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 4 };
		int iValue = 99;
		boolean bdoesElementExist = LS.doesElementExist(arr, iValue);

		assertEquals(bdoesElementExist, false);
	}

	@Test
	public void hasAllValues_Test1() {
		LatinSquare LS = new LatinSquare();
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 3, 2, 1 };

		boolean bhasAllValues = LS.hasAllValues(arr1, arr2);

		assertEquals(bhasAllValues, true);

	}

	@Test
	public void hasAllValues_Test2() {
		LatinSquare LS = new LatinSquare();
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 3, 2, 99 };

		boolean bhasAllValues = LS.hasAllValues(arr1, arr2);

		assertEquals(bhasAllValues, false);

	}

	@Test
	public void getColumn_Test1() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

		LatinSquare LS = new LatinSquare(MySquare);
		int [] ExpectedCol = {2,1,3};
		int [] Col = LS.getColumn(1);
		
		assertTrue(Arrays.equals(ExpectedCol, Col));
		System.out.println(Arrays.toString(Col));
	}
	
	@Test
	public void getRow_Test1() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

		LatinSquare LS = new LatinSquare(MySquare);
		int [] ExpectedRow = {3,1,2};
		int [] Row = LS.getRow(1);
		
		assertTrue(Arrays.equals(ExpectedRow, Row));
		System.out.println(Arrays.toString(Row));
	}
	
	@Test
	public void isLatinSquare_Test1() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

		LatinSquare LS = new LatinSquare(MySquare);
		
		assertTrue(LS.isLatinSquare());
	}
	
	@Test
	public void isLatinSquare_Test2() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 4, 5, 6 } };

		LatinSquare LS = new LatinSquare(MySquare);
		
		assertFalse(LS.isLatinSquare());
	}
	
	@Test
	public void noArghasDuplicates_Test1() {
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 4, 5, 6 } };
		LatinSquare LS = new LatinSquare(MySquare);
		
		assertFalse(LS.hasDuplicates());
	}
	@Test
	public void noArghasDuplicates_Test2() {
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 1, 5, 6 } };
		LatinSquare LS = new LatinSquare(MySquare);
	
		assertTrue(LS.hasDuplicates());
	}
	@Test
	public void RemoveZeros_Test1() {
		int[] beforeArr = {0,2,3,0,5,6};
		int[] afterArr = {2,3,5,6};
		
		LatinSquare LS = new LatinSquare();
		
		assertTrue(Arrays.equals(LS.RemoveZeros(beforeArr),afterArr));
	}
	@Test
	public void RemoveZeros_Test2() {
		int[] beforeArr = {1,3,5,6};
		int[] afterArr = {1,3,5,6};
		
		LatinSquare LS = new LatinSquare();
		
		assertTrue(Arrays.equals(LS.RemoveZeros(beforeArr),afterArr));
	}
	@Test
	public void ePuzzleViolationTest() {
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 4, 5, 6 } };
		LatinSquare LS = new LatinSquare(MySquare);
		PuzzleViolation pv = new PuzzleViolation(ePuzzleViolation.InvalidValue,0);
		ArrayList<PuzzleViolation> expectedarrlist = new ArrayList<PuzzleViolation>();
		expectedarrlist.add(pv);
		LS.AddPuzzleViolation(pv);
		
		assertTrue(LS.getPV().equals(expectedarrlist));
		
		LS.ClearPuzzleViolation();
		
		assertEquals(LS.getPV().size(),0);
	}
}
