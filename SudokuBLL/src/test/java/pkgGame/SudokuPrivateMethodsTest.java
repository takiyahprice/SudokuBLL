package pkgGame;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.HashMap;

import org.junit.Test;

public class SudokuPrivateMethodsTest {

	private void PrintStars() {
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		System.out.println();
	}

	@Test
	public void Sudoku_Test_SetRegion() {

		Sudoku s1 = null;
		int iPuzzleSize = 9;
		int[] iExpectedRegion = new int[iPuzzleSize];
		for (int i = 0; i < iPuzzleSize; i++) {
			iExpectedRegion[i] = i + 1;
		}
		int[] iActualRegion;

		try {
			Class<?> c = Class.forName("pkgGame.Sudoku");
			Constructor constructor = c.getConstructor(new Class[] { int.class });
			constructor.setAccessible(true);
			s1 = (Sudoku) constructor.newInstance(iPuzzleSize);

			Method mSetRegion = c.getDeclaredMethod("SetRegion", new Class[] { int.class });

			PrintStars();
			System.out.println("Testing method: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Original Puzzle:");
			s1.PrintPuzzle();
			System.out.println("Original Region 0:");
			System.out.println(Arrays.toString(s1.getRegion(0)));

			System.out.println("Set Puzzle:");
			mSetRegion.setAccessible(true);
			mSetRegion.invoke(s1, 0);
			iActualRegion = s1.getRegion(0);

			s1.PrintPuzzle();
			System.out.println(Arrays.toString(s1.getRegion(0)));

			assertTrue(Arrays.equals(iExpectedRegion, iActualRegion));

			PrintStars();

		} catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			fail("NoSuchMethodException");
		} catch (SecurityException e) {

			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		}

		PrintStars();

	}

	@Test
	public void FillDiagonalRegions() {
		
		Sudoku s1 = null;
		int iPuzzleSize = 9;
		
		try {
			Class<?> c = Class.forName("pkgGame.Sudoku");
			Constructor constructor = c.getConstructor(new Class[] { int.class });
			constructor.setAccessible(true);
			s1 = (Sudoku) constructor.newInstance(iPuzzleSize);

			Method mFillDiagonalRegions = c.getDeclaredMethod("FillDiagonalRegions", null);

			PrintStars();
			System.out.println("Testing method: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Original Puzzle:");
			s1.PrintPuzzle();
			System.out.println("Original Region 0:");
			System.out.println(Arrays.toString(s1.getRegion(0)));

			System.out.println("Set Puzzle:");
			mFillDiagonalRegions.setAccessible(true);
			mFillDiagonalRegions.invoke(s1, null);

			s1.PrintPuzzle();
			System.out.println(Arrays.toString(s1.getRegion(0)));

			PrintStars();

		} catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			fail("NoSuchMethodException");
		} catch (SecurityException e) {

			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		}

	}
	
	//new tests
	@Test
	public void getAllValidCellValues_Test1() {
		
		int[][] puzzle = {	{ 5, 3, 4, 0, 0, 0, 0, 0, 0 }, 
							{ 6, 7, 2, 0, 0, 0, 0, 0, 0 }, 
							{ 1, 9, 8, 0, 0, 0, 0, 0, 0 },
							{ 0, 0, 0, 7, 6, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 8, 5, 3, 0, 0, 0 }, 
							{ 0, 0, 0, 9, 2, 4, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 2, 8, 4 }, 
							{ 0, 0, 0, 0, 0, 0, 6, 3, 5 }, 
							{ 0, 0, 0, 0, 0, 0, 1, 7, 9 } };
		
		Sudoku s1 = null;
		try {
			Class<?> c = Class.forName("pkgGame.Sudoku");
			Constructor constructor = c.getConstructor(new Class[] { int[][].class });
			constructor.setAccessible(true);
			s1 = (Sudoku) constructor.newInstance(puzzle);
			
			Method mGetAllValidCellValues = c.getDeclaredMethod("getAllValidCellValues",int.class,int.class );
			mGetAllValidCellValues.setAccessible(true);
			HashSet<Integer> actualValues = (HashSet<Integer>) mGetAllValidCellValues.invoke(s1, 0,0);
			
			HashSet<Integer> expectedValues = new HashSet<Integer>();
			expectedValues.add(5);
			
			assertTrue(expectedValues.equals(actualValues));
		} 
		catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			fail("NoSuchMethodException");
		} catch (SecurityException e) {
			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		}
		
	}
	@Test
	public void getAllValidCellValues_Test2() {
		
		int[][] puzzle = {	{ 5, 3, 4, 0, 0, 0, 0, 0, 0 }, 
							{ 6, 7, 2, 0, 0, 0, 0, 0, 0 }, 
							{ 1, 9, 8, 0, 0, 0, 0, 0, 0 },
							{ 0, 0, 0, 7, 6, 1, 0, 0, 0 }, 
							{ 0, 0, 0, 8, 5, 3, 0, 0, 0 }, 
							{ 0, 0, 0, 9, 2, 4, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 2, 8, 4 }, 
							{ 0, 0, 0, 0, 0, 0, 6, 3, 5 }, 
							{ 0, 0, 0, 0, 0, 0, 1, 7, 9 } };
		
		Sudoku s1 = null;
		try {
			Class<?> c = Class.forName("pkgGame.Sudoku");
			Constructor constructor = c.getConstructor(new Class[] { int[][].class });
			constructor.setAccessible(true);
			s1 = (Sudoku) constructor.newInstance(puzzle);
			
			Method mGetAllValidCellValues = c.getDeclaredMethod("getAllValidCellValues",int.class,int.class );
			mGetAllValidCellValues.setAccessible(true);
			HashSet<Integer> actualValues = (HashSet<Integer>) mGetAllValidCellValues.invoke(s1, 3,0);
			
			HashSet<Integer> expectedValues = new HashSet<Integer>();
			expectedValues.add(1);
			expectedValues.add(2);
			expectedValues.add(6);
			
			assertTrue(expectedValues.equals(actualValues));
		} 
		catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			fail("NoSuchMethodException");
		} catch (SecurityException e) {
			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		}
		
	}
	
	@Test
	public void GetNextCell_Test1() {

		Sudoku s1 = null;
		try {
			
			Sudoku s2 = new Sudoku(9);
			Class<?> Cell = Sudoku.class.getDeclaredClasses()[0];
			Constructor<?> constructor = Cell.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			
			Object cell = constructor.newInstance(s2,0,0);
			
			Method mGetNextCell = Cell.getMethod("GetNextCell", Cell);
			Object nextCell = mGetNextCell.invoke(cell, cell);
			
			Method mgetiRow = Cell.getMethod("getiRow",null);
			int row = (int) mgetiRow.invoke(nextCell,null);
			
			Method mgetiCol = Cell.getMethod("getiCol", null);
			int col = (int) mgetiCol.invoke(nextCell, null);
			
			assertEquals(row,0);
			assertEquals(col,1);
		} 
		catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail("NoSuchMethodException");
		} catch (SecurityException e) {
			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		} catch (Exception e) {
			fail("Exception caught");
		}
		
	}
	@Test
	public void GetNextCell_Test2() {

		Sudoku s1 = null;
		try {
			
			Sudoku s2 = new Sudoku(9);
			Class<?> Cell = Sudoku.class.getDeclaredClasses()[0];
			Constructor<?> constructor = Cell.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			
			Object cell = constructor.newInstance(s2,0,8);
			
			Method mGetNextCell = Cell.getMethod("GetNextCell", Cell);
			Object nextCell = mGetNextCell.invoke(cell, cell);
			
			Method mgetiRow = Cell.getMethod("getiRow",null);
			int row = (int) mgetiRow.invoke(nextCell,null);
			
			Method mgetiCol = Cell.getMethod("getiCol", null);
			int col = (int) mgetiCol.invoke(nextCell, null);
			
			assertEquals(row,1);
			assertEquals(col,0);
		} 
		catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail("NoSuchMethodException");
		} catch (SecurityException e) {
			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		} catch (Exception e) {
			fail("Exception caught");
		}
		
	}
	@Test
	public void GetNextCell_Test3() {

		try {
			
			Sudoku s2 = new Sudoku(9);
			Class<?> Cell = Sudoku.class.getDeclaredClasses()[0];
			Constructor<?> constructor = Cell.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			
			Object cell = constructor.newInstance(s2,8,8);
			
			Method mGetNextCell = Cell.getMethod("GetNextCell", Cell);
			Object nextCell = mGetNextCell.invoke(cell, cell);
			
			assertTrue(nextCell == null);
		} 
		catch (ClassNotFoundException e1) {
			fail("ClassNotFoundException");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail("NoSuchMethodException");
		} catch (SecurityException e) {
			fail("SecurityException");
		} catch (InstantiationException e) {
			fail("InstantiationException");
		} catch (IllegalAccessException e) {
			fail("IllegalAccessException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail("IllegalArgumentException");
		} catch (InvocationTargetException e) {
			fail("InvocationTargetException, Invalid size");
		} catch (Exception e) {
			fail("Exception caught");
		}
		
	}
	
	
}