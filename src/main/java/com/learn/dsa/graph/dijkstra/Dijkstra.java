package com.learn.dsa.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Dijkstra {
	public static void main(String[] args) {
		int V = 3;
		int[][] edges = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } };
		int src = 2;
		Solution solution = new Solution();
		int[] ans = solution.dijkstra(V, edges, src);
		for (int an : ans)
			System.out.println(an);
	}
}

class Solution {
	public int[] dijkstra(int V, int[][] edges, int src) {
		List<List<Node>> list = adjList(edges, V);
		Set<Node> set = new TreeSet<>(getComparator());
		int[] ans = new int[V];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[src] = 0;
		set.add(new Node(src, 0));
		set.add(new Node(1, 0));
		set.add(new Node(4, 0));

		set.forEach(System.out::println);

//		while (!set.isEmpty()) {
//			Node node = set.poll(;
//			if (node.dist > ans[node.item])
//				continue;
//			for (Node next : list.get(node.item)) {
//				int dist = next.dist + node.dist;
//				if(dist < ans[next.item]){
//					ans[next.item] = dist;
//					pq.add(new Node(next.item,dist));
//				}
//			}
//		}
		for (int i = 0; i < V; i++) {
			if (ans[i] == Integer.MAX_VALUE) {
				ans[i] = -1;
			}
		}
		return ans;
	}

	private Comparator<Node> getComparator() {
		return (a, b) -> {
			if (a.dist == b.dist)
				return a.item - b.item;
			return a.dist - b.dist;
		};
	}

	private List<List<Node>> adjList(int[][] edges, int V) {
		List<List<Node>> list = new ArrayList<>();
		for (int i = 0; i < V; i++)
			list.add(new ArrayList<>());
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int d = edge[2];
			list.get(u)
					.add(new Node(v, d));
			list.get(v)
					.add(new Node(u, d));
		}
		return list;
	}

	private static class Node {
		int item;
		int dist;

		Node(int item, int dist) {
			this.item = item;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return super.toString();
		}
	}
}