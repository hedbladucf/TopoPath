// Sean Szumlanski
// COP 3503, Fall 2013

// TestCases.java
// ==============
// When you have your TopoPath class implemented properly, you should be able to
// run this program and produce the following output:
//
//   Test Case #1: PASS
//   Test Case #2: PASS
//   Test Case #3: PASS
//
// Keep in mind that these test cases are by no means comprehensive! You need to
// create some of your own.


import java.io.*;

public class TestCases
{
	public static void main(String [] args) throws IOException
	{
		System.out.print("Test Case #1: ");
		System.out.println((TopoPath.hasTopoPath("g1.txt") == false) ? "PASS" : "FAIL");

		System.out.print("Test Case #2: ");
		System.out.println((TopoPath.hasTopoPath("g2.txt") == false) ? "PASS" : "FAIL");

		System.out.print("Test Case #3: ");
		System.out.println((TopoPath.hasTopoPath("g3.txt") == true) ? "PASS" : "FAIL");
	}
}
