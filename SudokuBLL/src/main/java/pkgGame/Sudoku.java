package pkgGame;

import java.util.Arrays;
import pkgHelper.LatinSquare;


public class Sudoku extends LatinSquare {
	
	private int iSize;		//the length of the width/height of the Sudoku puzzle
	private int iSqrtSize;		//Square Root of the iSize
	
	//constructors
	public Sudoku(int iSize) throws java.lang.Exception {
		super();
		if (Math.sqrt((double) iSize) % 1 != 0) {
			throw new Exception("The size must be a square number");
		} 
		
		this.iSize = iSize;
		iSqrtSize = (int) Math.sqrt((double) iSize);
	}
	
	public Sudoku(int[][] puzzle) throws java.lang.Exception {
		super(puzzle);
		
		if (Math.sqrt((double) puzzle.length) % 1 != 0) {
			throw new Exception("The length of the puzzle must be a square number");
		} 
		
		this.iSize = puzzle.length;
		iSqrtSize = (int) Math.sqrt((double) iSize);
	}
 	
	//getters
	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
	public int[] getRegion(int iCol, int iRow) throws Exception{
		  int i = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
		  
		 return getRegion(i);
		  

	}
	
	public int[] getRegion(int r) throws Exception {
		int[] myRegion = new int[iSize];
		int[][] puzzle = getPuzzle();
		int idx = 0;
		
		if ((r+1) > iSize) {
			throw new Exception("Bad region call");
		}
		for (int iRow = (r/iSqrtSize)*iSqrtSize; iRow<((r/iSqrtSize) *iSqrtSize) + iSqrtSize; iRow++) {
			for(int iCol =  (r%iSqrtSize)*iSqrtSize; iCol<((r%iSqrtSize) *iSqrtSize) + iSqrtSize; iCol++) {
				myRegion[idx++] = puzzle[iRow][iCol];
			}	
		}
		return myRegion;
	}
	
	@Override
	public boolean hasDuplicates() {
		if (super.hasDuplicates()) {
			return true;
		}
		for (int iRegion = 0; iRegion < this.getLatinSquare().length; iRegion++) {
			
			try {
				if (super.hasDuplicates(getRegion(iRegion))) {
					return true;
				}
			}
			catch (Exception e) {
				System.out.print("Region index out of bounds");
			}
		} return false;
	}
	
	public boolean isPartialSudoku() throws Exception {
		int[] firstrow = super.getRow(0);
		
		if ((!super.isLatinSquare()) || (!super.containsZero())) {
			return false;
		}
		for (int iRegion = 0; iRegion < iSize; iRegion++) {
			if (super.hasDuplicates(getRegion(iRegion))) {
				return false;
			}
			for (int i : firstrow) {
				if (!super.doesElementExist(getRegion(iRegion),i)) {
					return false;
				}
			}	
		}
		return true;
	}
	//needs tests
	public boolean isSudoku() throws Exception {
		
		if (!isPartialSudoku()) {
			   return false;
		}
			if (super.containsZero()) {
			   return false;
			}
		for (int i = 0; i < iSize; i++) {
			int[] iRow = super.getRow(i);
			int[] iCol = super.getColumn(i);
			int[] iRegion = getRegion(i);
			
			for (int j : iRow) {
				if (super.doesElementExist(iCol,j)==false || super.doesElementExist(iRegion,j)==false ) {
					return false;
				}
			}
		}
			
			  return true;
	}
	
	public boolean isValidValue(int iCol, int iRow, int iValue) throws Exception {
		int[] Col = super.getColumn(iCol);
		int[] Row = super.getRow(iRow);
		int[] Region= getRegion(iCol,iRow);
		
		if (doesElementExist(Row,iValue)) {
			 return false;
		}
		 if (doesElementExist(Col,iValue)) {
			 return false;
		 }
		 if (doesElementExist(Region,iValue)) {
			 return false;
		 }
		 for (int i = 0;i < iSize; i++) {
			 if (i != iRow) {
				 if (!super.doesElementExist(getRow(i),iValue)) {
					 return false;
				 }
			 }
			 
		 }
		 return true;
	}
	
	
}
