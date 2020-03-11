package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

class DecisionBasedSearch {
	static Map<Integer, List<Integer>> nodeList = new HashMap<Integer, List<Integer>>();

	public static String printListAsString(Integer node) {
		String output = "";
		List<Integer> list = DecisionBasedSearch.nodeList.get(node);
		ListIterator<Integer> li = list.listIterator();
		while (li.hasNext()) {
			output += " " + li.next();
		}
		return output;
	}

	public void printBFS(int startNode) {
		if (DecisionBasedSearch.nodeList.containsKey(startNode)) {
			System.out.print(startNode + " " + DecisionBasedSearch.printListAsString(startNode));
		}
	}

	public void addNodes() {
		// keyvalue pair
		nodeList.put(0, new ArrayList<Integer>() {
			{
				add(1);
				add(2);
			}
		});

		nodeList.put(1, new ArrayList<Integer>() {
			{
				add(2);
				add(3);
			}
		});

		nodeList.put(2, new ArrayList<Integer>() {
			{
				add(3);
			}
		});

		nodeList.put(3, new ArrayList<Integer>() {
			{
				add(4);
			}
		});

		nodeList.put(4, new ArrayList<Integer>() {
			{
				add(0);
				add(1);
				add(5);
			}
		});
	}

	public void printNode(int nodeValue) {
		System.out.println(nodeValue + " --> " + nodeList.get(nodeValue));
	}

	public static void main(String args[]) {
		DecisionBasedSearch dbsObj = new DecisionBasedSearch();
		Scanner s = new Scanner(System.in);
		dbsObj.addNodes();
		Integer nodes;
		do {
			System.out.println("Please enter the node");
			nodes = s.nextInt();
			dbsObj.printNode(nodes);
			System.out.println("Enter any node to continue or -1 to exit");
		} while (DecisionBasedSearch.nodeList.containsKey(nodes) && nodes >= 0);
	}
}
