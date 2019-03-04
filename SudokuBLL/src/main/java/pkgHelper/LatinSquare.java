package pkgHelper;

import java.util.Arrays;

public class LatinSquare {

	private int[][] LatinSquare;

	public LatinSquare() {		//no argument constructor
		
	}
	
	public LatinSquare(int[][] puzzle) {		//constructor with 2D array argument passed to it
		super();
		LatinSquare = puzzle;
	}
	
	public int[][] getLatinSquare() {		//getter method
		return LatinSquare;
	}
	
	public void setLatinSquare(int[][] latinSquare) {		//setter method
		LatinSquare = latinSquare;
	}
	
	public boolean hasDuplicates(int[] arr) {		//returns true if 1D array passed to it has duplicate elements
		boolean hasDuplicates = false;
		
		if (arr == null) {
			return false;
		}
		int[] sortedArr = Arrays.copyOf(arr, arr.length);
		
		Arrays.sort(sortedArr);
		
		for (int i = 0; i < sortedArr.length - 1; i++) {
			if (sortedArr[i]==sortedArr[i+1]) {
				hasDuplicates = true;
				break;
			}
		}
		return hasDuplicates;
	}

	public boolean doesElementExist(int[] arr, int iValue) {		//returns true if array contains given value
		boolean doesElementExist = false;
		
		if (arr==null) {
			return false;
		}
		for (int i: arr) {
			if (i==iValue) {
				doesElementExist = true;
				break;
			}
		}
		return doesElementExist;
	}
	
	public boolean hasAllValues(int[] arr1, int[] arr2) {		//returns true if if every element in 2nd array is in 1st array
		boolean hasValue = false;
		
		if (arr1==null || arr2==null) {
			return false;
		}
		
		for (int i: arr2) {
			for (int j: arr1) {
				hasValue = false;
				if (j==i) {
					hasValue = true;
					break;
				}
			}
			if (hasValue == false) {
				break;
			}
		}
		return hasValue;
	}
	
	public int[] getRow(int iRow) {							//returns 1D array from given row of Latin Square
		int[] lsRow = new int[LatinSquare[iRow].length];
		
		for (int idx = 0; idx < lsRow.length; idx++) {
			lsRow[idx] = LatinSquare[iRow][idx];
		}
		
		return lsRow;
	}
	
	public int[] getColumn(int iCol) {				//returns 1D array from given column of Latin Square
		int[] lsCol = new int[LatinSquare.length];
		
		for (int idx = 0; idx < lsCol.length; idx++) {
			lsCol[idx] = LatinSquare[idx][iCol];
		}
		return lsCol;
	}
	
	public boolean ContainsZero() {		//returns true if any element in the Latin Square is 0
		
		for (int row_idx = 0; row_idx < LatinSquare.length; row_idx++) {
			for (int col_idx = 0; col_idx < LatinSquare.length; col_idx++) {
				if (LatinSquare[row_idx][col_idx] == 0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isLatinSquare() {		//returns true if 2D array is a Latin Square
		boolean isLatinSquare = false;
		
		for (int i = 0; i < LatinSquare.length; i++) {
			if (hasDuplicates(getRow(i))== true || hasDuplicates(getColumn(i))==true) {
				return isLatinSquare;
			}
		}
		for (int j=0; j < LatinSquare.length - 1; j++) {
			if ((hasAllValues(getRow(j+1),getRow(0)) == false) || (hasAllValues(getColumn(j+1),getColumn(0))== false)) {
				return isLatinSquare;
			}
		}
		return true;
	}
}






