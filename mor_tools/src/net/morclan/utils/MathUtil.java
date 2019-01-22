package net.morclan.utils;

public class MathUtil {

	public static String calcKDR(int k, int d) {		
		double kdr=(double)k/d;
		return String.format( "%.2f", kdr );
	}
	
}
