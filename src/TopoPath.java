/* 
 * Oscar Hedblad
 * PID: o3415424
 * COP3503 - TopoPath.java
 * 
 * 
 * DESCRIPTION: Program that reads in file(s) and determines if a topological path
 * exists. It orders the graph's vertices in a way such that it simultaneously correspond
 * to a valid path in the graph and a valid topological sort. The solution to this 
 * problem is executed in O(n*n) time.
 * */

//Import necessaries
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class TopoPath {
	
	public static boolean hasTopoPath(String filename) throws FileNotFoundException {
		
		// Declaring Scanner
		Scanner input = new Scanner(new File(filename));
		
		// Declaration of variables. Reads in the number of nodes.
		int nodes = input.nextInt();
		int neighbour;
		
		// Creates 2D true-false matrix
		boolean [][] matrix2D = new boolean[nodes][nodes];
		
		for(int i = 0; i < nodes; i++){
			neighbour = input.nextInt();
			while(neighbour > 0){
				matrix2D[i][input.nextInt() - 1] = true;
				neighbour--;
			}
		}
		/* Dr. Szumlanski's code found on Webcourses follows below. I used a large portion of 
		 * Toposort.java */
		int [] incoming = new int[matrix2D.length];
		int cnt = 0;
		
		// Count the number of incoming edges incident to each vertex. For sparse
		// graphs, this could be made more efficient by using an adjacency list.
		for (int i = 0; i < matrix2D.length; i++){
			for (int j = 0; j < matrix2D.length; j++){
				incoming[j] += (matrix2D[i][j] ? 1 : 0);
			}
		}
	
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		// Any vertex with zero incoming edges is ready to be visited, so add it to
		// the queue.
		for (int i = 0; i < matrix2D.length; i++)
			if (incoming[i] == 0)
				q.add(i);
		
		while (!q.isEmpty())
		{
			// Pull a vertex out of the queue and add it to the topological sort.
			int node = q.remove();
			//System.out.println(node);
			
			if((q.peek() != null) && (matrix2D[node][q.peek()] == false)){
				break;
			}
			
			
			// Count the number of unique vertices we see.
			++cnt;
			
			// All vertices we can reach via an edge from the current vertex should
			// have their incoming edge counts decremented. If one of these hits
			// zero, add it to the queue, as it's ready to be included in our
			// topological sort.
			for (int i = 0; i < matrix2D.length; i++)
				if (matrix2D[node][i] && --incoming[i] == 0)
					q.add(i);
		}
		
		// If we pass out of the loop without including each vertex in our
		// topological sort, we must have a cycle in the graph.
		if (cnt != matrix2D.length){
			return false;
		}
			//System.out.println("Error: Graph contains a cycle!");
		return true;
	}
	
	// Difficulty rating method. I found this assignment quite conceptually challenging..
	public static double difficultyRating(){
		return 4.0;
	}
	// Number of hours spent on assignment. 
	public static double hoursSpent(){
		return 7.2;
	}
	
}