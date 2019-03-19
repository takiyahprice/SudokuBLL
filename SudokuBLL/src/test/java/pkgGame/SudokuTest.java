package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {

	
	@Test
	public void getPuzzle_test1() throws Exception {
		int[][] puzzle = { { 1, 2, 3,4 }, { 3,4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
	
		assertTrue(Arrays.equals(sudoku.getPuzzle(),puzzle));
	}
	
	@Test
	public void getRegion_int_test1() throws Exception {
		int[][] puzzle = { {5,3,4,6 }, { 3,4, 1, 2 }, { 4,2,5,1 },{8,4,3,2} };
		Sudoku sudoku = new Sudoku(puzzle);
		int[] expectedRegion = {4,2,8,4};
		int region = 2;
		
		assertTrue(Arrays.equals(sudoku.getRegion(region),expectedRegion));
	}
	@Test
	public void getRegion_int_test2() throws Exception {
		int[][] puzzle = { {5,3,4,6 }, { 3,4, 1, 2 }, { 4,2,5,1 },{8,4,3,2} };
		Sudoku sudoku = new Sudoku(puzzle);
		int[] unexpectedRegion = {4,6,1,2};
		int region = 2;
		
		assertFalse(Arrays.equals(sudoku.getRegion(region),unexpectedRegion));
	}
	@Test
	public void getRegion_int_test3() throws Exception {
		int[][] puzzle = { {5,3,4,6 }, { 3,4, 1, 2 }, { 4,2,5,1 },{8,4,3,2} };
		Sudoku sudoku = new Sudoku(puzzle);
		int invalidRegion = 9;
		
		try {
			sudoku.getRegion(invalidRegion);
		}
		catch (Exception e) {
			String errormessage = "Bad region call";
			assertEquals(e.getMessage(),errormessage);
		}
	}
	@Test 
	public void hasDuplicates_Test1() throws Exception {
		int[][] puzzle = { { 1, 2, 3,4 }, { 3,4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertFalse(sudoku.hasDuplicates());
	}
	@Test 
	public void hasDuplicates_Test2() throws Exception {
		//duplicates in row
		int[][] puzzle = { { 1, 5, 3,4 }, { 3,4, 1, 2 }, { 4,1,2,3 },{2,2,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertTrue(sudoku.hasDuplicates());
	}
	@Test 
	public void hasDuplicates_Test3() throws Exception {
		//duplicate in column
		int[][] puzzle = { { 1, 2, 3,4 }, { 3,4, 1, 2 }, { 4,1,2,3 },{2,3,5,4} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertTrue(sudoku.hasDuplicates());
	}
	@Test 
	public void hasDuplicates_Test4() throws Exception {
		//duplicate region
		int[][] puzzle = { { 1, 2, 3,4 }, { 5,1, 7, 8 }, { 9,10,11,12 },{13,14,15,16} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertTrue(sudoku.hasDuplicates());
	}
	@Test
	public void isPartialSudoku_Test1() throws Exception {
		int[][] puzzle = { { 1, 0, 3,4 }, { 3,4, 1, 0 }, { 4,1,0,3 },{0,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertTrue(sudoku.isPartialSudoku());
	}
	@Test
	public void isPartialSudoku_Test2() throws Exception {
		//puzzle doesn't have zeros
		int[][] puzzle = { { 1, 2, 3,4 }, { 3,4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertFalse(sudoku.isPartialSudoku());
	}
	public void isPartialSudoku_Test3() throws Exception {
		//puzzle has duplicates in region
		int[][] puzzle = { { 1, 0, 3,4 }, { 3,1, 1, 0 }, { 4,1,0,3 },{0,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertFalse(sudoku.isPartialSudoku());
	}
	public void isPartialSudoku_Test4() throws Exception {
		//element in first row not present in all regions
		int[][] puzzle = { { 1, 2, 3,4 }, { 5,4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		
		assertFalse(sudoku.isPartialSudoku());
	}
	@Test
	public void isValidValue_Test1() throws Exception {
		int[][] puzzle = { { 1, 0, 3,4 }, { 3, 4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		assertTrue(sudoku.isValidValue(1,0, 2));
	}

	@Test
	public void isValidValue_Test2() throws Exception {
		int[][] puzzle = { { 1, 2, 3,4 }, { 3, 4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		assertFalse(sudoku.isValidValue(1,0,2));
	}
	@Test
	public void isValidValue_Test3() throws Exception {
		int[][] puzzle = { { 1, 0, 3,4 }, { 3, 4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		assertFalse(sudoku.isValidValue(1,0,5));
	}
	@Test
	public void getRegion2Arg_Test1() throws Exception {
		int[][] puzzle = { { 1, 2, 3,4 }, { 3,4, 1, 2 }, { 4,1,2,3 },{2,3,4,1} };
		Sudoku sudoku = new Sudoku(puzzle);
		int[] expectedRegion = {4,1,2,3};
	
		assertTrue(Arrays.equals(sudoku.getRegion(1,2),expectedRegion));		
	}


}
