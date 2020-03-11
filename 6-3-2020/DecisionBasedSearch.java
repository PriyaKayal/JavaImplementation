package main.java;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
	private int noOfVertices;
	private LinkedList<Integer> adjacencyList[];

	Graph(int v) {
		noOfVertices = v;
		adjacencyList = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adjacencyList[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[noOfVertices];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adjacencyList[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
//				System.out.print(n+ " ");
				if (!visited[n]) {
					
					visited[n] = true;
					
					queue.add(n);
				}
			}
		}
	}

	void userInterface(Graph g, Scanner s) {
		boolean firstLoop = true;
		int node = -1;
		while (firstLoop || node >= 0) {
			firstLoop = false;
			System.out
					.println("Please enter a node from 0 to " + (g.noOfVertices - 1) + " or any other number to exit");
			try {
				node = s.nextInt();
			} catch (InputMismatchException e) {
				node = -1;
			}
			boolean contains = false;
//			for (int i = 0; i < g.adjacencyList.length; i++) {
			if (node >= 0 && node < g.noOfVertices) {
				contains = true;
			}
//			}
			if (!contains) {
				break;
			} else {

				System.out.println("The Vertices from " + node + " are as below : ");
//				System.out.println(node + " --> " + g.adjacencyList[node]);
				for (int i = 0; i < g.adjacencyList[node].size(); i++) {
					System.out.println("(" + node + "," + g.adjacencyList[node].get(i) + ")");
				}
			}

		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(4, 5);
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < g.adjacencyList.length; i++) {
			System.out.println(i + "-->" + g.adjacencyList[i]);
		}
		g.userInterface(g, s);
		int traverseNode;
		System.out.print("Enter traverse start node : ");
		try {
			traverseNode = s.nextInt();
		} catch (InputMismatchException e) {
			traverseNode = 0;
		}
		System.out.println("Following is Breadth First Traversal" + "(starting from vertex " + traverseNode + ")");
		if (traverseNode >= g.noOfVertices) {
			System.out.println(
					"The given input is greater than the number of vertices so, displaying for traversal from zero");
			traverseNode = 0;
		}
		g.BFS(traverseNode);
		s.close();
	}
}
