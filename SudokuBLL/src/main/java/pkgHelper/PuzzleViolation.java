package pkgHelper;

import pkgEnum.ePuzzleViolation;

public class PuzzleViolation {
	private ePuzzleViolation ePuzzleViolation;
	private int iValue;
	
	public PuzzleViolation(ePuzzleViolation ePuzzleViolation, int iValue) {
		this.ePuzzleViolation = ePuzzleViolation;	//enum resolved to the type of violation
		this.iValue = iValue;		//int value (row number, col number, etc) of the violation
	}
	public ePuzzleViolation getePuzzleViolation() {
		return ePuzzleViolation;
	}
	public int getiValue() {
		return iValue;
	}
}
