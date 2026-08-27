package com.learn.dsa.graph.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;

public class Prims {
	public int Prims(int V, int[][] edges) {
		int sum = 0;
		List<List<Item>> adjList = buildAdj(V, edges);
		boolean[] vis = new boolean[V];
		List<List<Integer>> mst = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(getComparator());
		pq.add(new Node(0, 0, -1));
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int parent = node.parent;
			int child = node.node;
			int wt = node.wt;
			if (vis[child])
				continue;
			vis[child] = true;
			if (parent != -1) {
				sum += wt;
				mst.add(new ArrayList<>(asList(child, parent)));
			}
			for (Item next : adjList.get(child)) {
				if (!vis[next.node]) {
					pq.add(new Node(next.wt, next.node, child));
				}
			}
		}
		return sum;
	}

	private List<List<Item>> buildAdj(int V, int[][] edges) {
		List<List<Item>> list = new ArrayList<>();
		for (int i = 0; i < V; i++)
			list.add(new ArrayList<>());
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];
			list.get(u)
					.add(new Item(v, wt));
			list.get(v)
					.add(new Item(u, wt));
		}
		return list;
	}

	private Comparator<Node> getComparator() {
		return (a, b) -> {
			return Integer.compare(a.wt, b.wt);
		};
	}

	static class Item {
		int node;
		int wt;

		Item(int node, int wt) {
			this.node = node;
			this.wt = wt;
		}
	}

	static class Node {
		int wt;
		int node;
		int parent;

		Node(int wt, int node, int parent) {
			this.wt = wt;
			this.node = node;
			this.parent = parent;
		}
	}
}
